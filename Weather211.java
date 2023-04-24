/*
 * Name: Silas Yeak 
 * ID: 202337225
 * Date: 10/20/22
 */


package Project_2;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Weather211 {
	
	//defining the main array for this whole project
	static ArrayList<String> weatherInfo = new ArrayList<>();
	//defining all the different variables: temp, temphigh, low, etc.
	static String tempNow, tempLow, tempHigh, windSpeed, weatherNow, humidity;

	public static boolean CityWeather (String cityName) throws Exception
	{
		
		boolean validCityName = false;
		//this code will change the Boolean to true if the API manages to pull a validCityName from google maps
		try {
			String firstPartURL = "https://api.openweathermap.org/data/2.5/weather?q=";
			String secondPartURL = "&appid=0165d8d3494d648e9314a9649095530e";
			String theURL = firstPartURL + cityName + secondPartURL;
			URL url = new URL(theURL);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			JSONParser jsonParser = new JSONParser();
			JSONObject myObject = (JSONObject)jsonParser.parse(br);
			 
			weatherInfo.add(cityName); 
			JSONArray weatherArray = (JSONArray)myObject.get("weather");
			JSONObject w = (JSONObject) weatherArray.get(0);
			weatherNow = (String)w.get("description");
			weatherInfo.add(weatherNow);	
			
			//This grabs the temperature, max, min, windspeed, humidity 
			//and puts it into an array called weatherInfo
			//I found it easier to write the 2 get statements instead of making an object with main/wind
			//did the conversions and stuff over here too.
		
			//looks at the JSON file and gets temp, within main, same for below
			double cityTemp = (double)((JSONObject) myObject.get("main")).get("temp");
			//converts from celsius to fahrenheit, same for all those below. 
			cityTemp = ((cityTemp - 273.15)*9)/5 + 32;
			tempNow = "temp: " + String.format("%.1f", cityTemp) + "\u00B0";
			weatherInfo.add(tempNow);
			
			double maxTemp = (double)((JSONObject) myObject.get("main")).get("temp_max");
			maxTemp = ((maxTemp - 273.15)*9)/5 + 32;
			tempHigh = "Max temp: " + String.format("%.1f", maxTemp)  + "\u00B0";
			
			weatherInfo.add(tempHigh);
			
			double minTemp = (double)((JSONObject) myObject.get("main")).get("temp_min");
			minTemp = ((minTemp - 273.15)*9)/5 + 32;
			tempLow = "Min temp: " + String.format("%.1f", minTemp) + "\u00B0";	
			weatherInfo.add(tempLow);
			//looks at the JSON file and gets speed from the wind 
			double speed = (double)((JSONObject) myObject.get("wind")).get("speed");
			windSpeed = "Wind speed: " + String.format("%.1f", speed) + "mph";			
			weatherInfo.add(windSpeed);
			
			
			long hum = (long)((JSONObject) myObject.get("main")).get("humidity");
			humidity = "Humidity: " + String.format("%d", hum) + "%";	
			weatherInfo.add(humidity);
			
			validCityName = true;
			
			
			//System.out.print(weatherInfo);
		}	
		catch (Exception ex) {
			//I used this to find out bugs in my code, I just left it in in case I need it later
			//if returned invalid, it will ask for a new city name
			//ex.printStackTrace();
			return validCityName = false;	
		}
		return validCityName;
		//return validCityName = true;
	}
	
	//this just returns the weatherInfo from this particular class.
	//useful later when feeding into the writeHTML()/runHTML() function.
	public static ArrayList<String> getCityWeatherNow() {
		return weatherInfo;
		
	}

}

