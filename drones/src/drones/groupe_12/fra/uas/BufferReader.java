// Import necessary libraries
package drones.groupe_12.fra.uas;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

// Define the class
public class BufferReader {

	// Define constants
	private static final String USER_AGENT = "MOzilla FIrefox Awesome version";
	private static final String ENDPOINT_URL = "https://dronesim.facets-labs.com/api/drones/?format=json";
	private static final String TOKEN = "Token 1586b43740b3c8b3686b31e2dc1cf1b4273b838f";
	
	// Main method
	public static void main(String[] args) {
		System.out.println("Test started...");
		
       // Define URL
       URL url;
		try {
			// Create URL object
			url = new URL(ENDPOINT_URL);
			// Open connection to the URL
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			// Set request properties
			connection.setRequestProperty("Authorization", TOKEN);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("User-Agent", USER_AGENT);
			// Get response code
			int responseCode = connection.getResponseCode();
		
			System.out.println("Response Code " + responseCode);
			// Create BufferedReader to read the response
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			// Read the response line by line
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			// Close the BufferedReader
			in.close();
			// Print the response
			System.out.println(response.toString()); // Process your response
			// Call the test method with the response as argument
			test(response.toString());
		} catch (MalformedURLException e) {
			// Handle MalformedURLException
			System.err.println("Malformed URL: " + e.getLocalizedMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// Handle IOException
			System.out.println("General IO Exception: " + e.getLocalizedMessage());
			e.printStackTrace();
		}
	}
	
	// Method to test the response
	public static void test(String input) {
		// Create a JSONObject from the input
		JSONObject wholeFile = new JSONObject(input);
		// Get the JSONArray from the JSONObject
		JSONArray jsonFile = wholeFile.getJSONArray("results");
		// Loop through the JSONArray
		for (int i = 0; i < jsonFile.length(); i++) {
			// Get the JSONObject at index i
			JSONObject o = jsonFile.getJSONObject(i);
			// Check if the JSONObject has "carriage_type" and "carriage_weight"
			if(o.has("carriage_type") && o.has("carriage_weight")){
				// Get the values of "carriage_type" and "carriage_weight"
				String a = o.getString("carriage_type");
				int b = o.getInt("carriage_weight");
				int id = o.getInt("id");
				// Print the values
				System.out.println("Drone " + id + ": carriage type " + a + " (weight: " + b + "g)");
			}
		}
		
	}

	// Method to format JSON
	public static String formatJson(String input) {
		// Define the number of spaces for indentation
		final int indentSpaces = 4;
		// Create a JSONTokener from the input
		Object json = new JSONTokener(input).nextValue();

		// Check if the JSON is a JSONObject or a JSONArray
		if (json instanceof JSONObject) {
			JSONObject o = (JSONObject) json;
			
			// Return the JSONObject as a string with indentation
			return o.toString(indentSpaces);
		} else if (json instanceof JSONArray) {
			// Return the JSONArray as a string with indentation
			return ((JSONArray) json).toString(indentSpaces);
		} else {
			// Throw an exception if the input is not a valid JSON
			throw new IllegalArgumentException("Input string is not a valid JSON");
		}
	}
}
