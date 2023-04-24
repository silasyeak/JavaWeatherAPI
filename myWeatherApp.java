/*
 * Name: Silas Yeak 
 * ID: 202337225
 * Date: 10/20/22
 */

package Project_2;


import java.util.Scanner;

public class myWeatherApp {

	//over here i'm defining the static variables, zoom mapType, weatherObject, and 
	//city to be used later on in the code.
	static int zoom;
	static String mapType;
	static Weather211 weatherObject;
	static String city;
	
	//To introduce the program and to call the inputCityName() function
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to Weather 211 - Fall 2022");
		System.out.println();
		inputCityName();
		
	}

	//this takes the boolean from the Weather211 code, to accept or reject the name
	//this is the main function used to get inputs and write out the HTML code.
	public static void inputCityName() throws Exception{
		boolean validCityName = false;
		
		//this is the while loop to get the input from the validCityName
		//refer to validCityName function for more details
		while(!validCityName) {
			System.out.println("Input a city name:");
			Scanner console = new Scanner(System.in);
			city = console.nextLine();
			System.out.println();
		
			//if the boolean is valid, it will take in the user inputs for what settings they want.
			boolean valid = Weather211.CityWeather(city);
			if(valid) {
				Scanner input = new Scanner(System.in);
				System.out.println("\nMap type 1) roadmap 2) satellite) ?:");
				int mapType_int = input.nextInt();
				//I just wrote this if statement in 2 lines so it's much more concise than spreading it out.
				if(mapType_int == 1) {mapType = "roadmap";}
				else if(mapType_int == 2) {mapType = "satellite";};
				
				Scanner input_2 = new Scanner(System.in);
				System.out.println("Zoom level (0-21):");
				zoom = input.nextInt();
				
				System.out.println("\nCurrent Weather [" + city + "]\n");
			
				//runs the for loop so that it can print out to the console for the user to see
				//in case the HTML wasn't enough
				for(int i = 0; i < weatherObject.weatherInfo.size(); i++) {
					System.out.println(weatherObject.weatherInfo.get(i));
				}
				//it grabs the weather information array from the Weather211 class
				//puts it into the writeHTML() function as mentioned earlier, and runs it.
				new Map211(Weather211.getCityWeatherNow(), mapType, zoom);
				Map211.writeHTML();
				
				
				break;
			} else {
				System.out.println("Invalid city name. Type again.\n");
			}
		}
	}

	
	
	
	

	


}
