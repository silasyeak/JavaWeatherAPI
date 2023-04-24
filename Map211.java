/*
 * Name: Silas Yeak 
 * ID: 202337225
 * Date: 10/20/22
 */




package Project_2;

import java.util.ArrayList;
import java.awt.Desktop;
import java.io.*;

public class Map211 {

	//static variables used here like html, the filename, API key, etc. 
	static String mapFileName = "myMap.html";
	static String html;
	static String weather;
	static String APIKey= "AIzaSyB273iKkrgK2dptFnp7WAsmyEIzMVzMceE";
	

	//defining the class here using ArrayList from Weather211
	//the mapType and Zoom fed in from the weather app.
	public Map211(ArrayList<String> weatherInfo, String mapType, int zoom) throws IOException {
					
			//this just creates a string fed into the HTML file later on in the header.
				weather = weatherInfo.get(0).toUpperCase()  
						+ " | " + weatherInfo.get(1)
						+ " | " + weatherInfo.get(2)
						+ " | " + weatherInfo.get(3)
						+ " | " + weatherInfo.get(4)
						+ " | " + weatherInfo.get(5)
						+ " | " + weatherInfo.get(6);
						
				html = "<!DOCTYPE html>"
						+ "<html>"
						+ "<body>"
						+ "<h2>"
						+ weather 
						+ "</h2>"
						+ "<iframe"
						+ "  width=1200"
						+ "  height=900"
						+ "  style=border:0"
						+ "  loading=lazy"
						+ "  allowfullscreen"
						+ "  referrerpolicy=\"no-referrer-when-downgrade\""
						+ "src=\"https://www.google.com/maps/embed/v1/place?key="+ APIKey + "&q="+ weatherInfo.get(0) +"&zoom="+ zoom +"&maptype=" + mapType+"\""
						+ "</iframe>"
						+ "</body>"
						+ "</html>";
		}
	
	//this writes the HTML file 
	//public static void writeHTML(ArrayList<String> weatherInfo, String mapType, int zoom) {
	public static void writeHTML() {
		File f= new File ("myMap.html");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write(html);
			bw.close();
			runHTML();
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
	
	//this runs the HTML code, I put into the writeHTML() function 
	private static void runHTML() throws IOException{
		   String url = "myMap.html";   // keyTest.html is in your project folder
		   File htmlFile = new File(url);
		   Desktop.getDesktop().browse(htmlFile.toURI());
		 }
	
}
