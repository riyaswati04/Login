package com.connection;

public class Conversion {
public String Title;
public String Year;
public String imdbID;
public String Type;
public String Poster;
public Conversion() {
	
}
public Conversion( String Title,String Year,String imdbID, String Type, String Poster ) {
	this.Title=Title;
	this.Year=Year;
	this.imdbID=imdbID;
	this.Type=Type;
	this.Poster=Poster;
}
public String toString() {
	return "[Title="+Title+" ,Year="+Year+" ,imdbID="+imdbID+" ,Type="+Type+" ,Poster="+Poster+"]";
	
}
public String getTitle() {
	return Title;
}
public String getYear() {
	return Year;
}
public String imdbID() {
	return imdbID;
}
public String getType() {
	return Type;
}
public String getPoster() {
	return Poster;
}

}

