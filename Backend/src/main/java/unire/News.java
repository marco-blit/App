package unire;

public class News
{
	String title;
	String description;
	String image;
	String date;
	public News(String title, String description, String image, String date) {
		super();
		this.title = title;
		this.description = description;
		this.image = image;
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String getImage() {
		return image;
	}
	public String getDate() {
		return date;
	}
	
}
