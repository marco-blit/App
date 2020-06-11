function IsLoggedIn()
{
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:8080/IsLoggedIn", false);
    xhttp.send();
    console.log(xhttp.responseText.trim());
    return (xhttp.responseText.trim() == "true");
}
function GetNewsList(callback)
{
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function()
    {
        if (this.readyState == 4 && this.status == 200)
        {
            callback(this.responseText);
        }
    };
    xhttp.open("GET", "http://localhost:8080/NewsList.jsp", true);
    xhttp.send();
    return  true;

}
function SubmitFormAjax(url, fields, callback)
{
    console.log(fields);
    let xmlhttp= window.XMLHttpRequest ?
        new XMLHttpRequest() : new ActiveXObject("Microsoft.XMLHTTP");

    xmlhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200)
            callback(this.responseText.trim()); // Here is the response
    }

    xmlhttp.open("POST",url,true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    let string = "";
    let first = true;
    for (const [key, value] of Object.entries(fields))
    {
        if(first)
        {
            first = false;
        }
        else
        {
            string += "&";
        }
        string += key + "=" + value;
    }
    xmlhttp.send(string);
}
