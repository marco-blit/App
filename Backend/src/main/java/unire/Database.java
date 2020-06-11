package unire;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;

public class Database {
	DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	
	public boolean AddUser(String username, String password)
	{
		Entity e = new Entity("Users", username);
		e.setProperty("password", password);
		ds.put(e);
		return true;
	}
	public boolean AddNews(String title, String description, String image, String date)
	{
		Entity e = new Entity("News");
		e.setProperty("title", title);
		e.setProperty("description", description);
		e.setProperty("image", image);
		e.setProperty("date", date);
		ds.put(e);
		return true;
	}
	public List<User> ListUsers()
	{
		List<User> users = new ArrayList<User>();
		
		Query q = new Query("Users");
		PreparedQuery pq = ds.prepare(q);
	    for (Entity result : pq.asIterable())
	    {  
	       User u = new User(result.getKey().getName(), (String)result.getProperty("password"));
	       users.add(u);
		}
		
		return users;		
	}
	public List<News> ListNews()
	{
		List<News> news = new ArrayList<News>();
		
		Query q = new Query("News");
		PreparedQuery pq = ds.prepare(q);
	    for (Entity result : pq.asIterable())
	    {  
	       News n = new News((String)result.getProperty("title"), (String)result.getProperty("description"), (String)result.getProperty("image"), (String)result.getProperty("date"));
	       news.add(n);
		}
		
		return news;		
	}
	public boolean CheckCredentials(String username, String password)
	{
		if(username == null || username.equals("") || password == null)
		{
			return false;
		}
		Filter propertyFilter =
				new Query.FilterPredicate("password", FilterOperator.EQUAL, password);
		Filter keyFilter =
			    new Query.FilterPredicate(Entity.KEY_RESERVED_PROPERTY, FilterOperator.EQUAL, KeyFactory.createKey("Users", username));
		ArrayList<Filter> filters = new ArrayList<Filter>();
		filters.add(propertyFilter);
		filters.add(keyFilter);
		Filter filter = new Query.CompositeFilter(Query.CompositeFilterOperator.AND, filters);
		Query q = new Query("Users");
		q.setFilter(filter);
		PreparedQuery pq = ds.prepare(q);
	    if(pq.countEntities(FetchOptions.Builder.withDefaults()) > 0)
	    {
	    	return true;
	    }
	    return false;
	}
}
