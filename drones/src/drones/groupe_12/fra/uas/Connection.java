package drones.groupe_12.fra.uas;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;

public class Connection {
	// Define constants
	private static HttpURLConnection connection;
	private static final String USER_AGENT = "MOzilla FIrefox Awesome version";
	private static final String ENDPOINT_URL = "https://dronesim.facets-labs.com/api/drones/?format=json";
	private static final String TOKEN = "Token 1586b43740b3c8b3686b31e2dc1cf1b4273b838f";
	
	//Input stream reader wrapped inside of Bufferreader 
	//Defining necessery variables
	static BufferedReader reader;
	static String line;
	static StringBuffer responseContent = new StringBuffer();
	
	public static void main(String[] args) {
		// Method 1:java.net.HttpURLConnection(getting response from remote server)
		try {
			//define our URL 
			URL url = new URL(ENDPOINT_URL);
			//opening connection 
			connection = (HttpURLConnection) url.openConnection();
			
			// Request setup with a GET Method(fundamental part of the HTTP request)
			connection.setRequestMethod("GET");
			
			// Set request properties(additional details to the request)
			connection.setRequestProperty("Authorization", TOKEN);
			connection.setRequestProperty("User-Agent", USER_AGENT);
			
			//Connection timeout in miliseconds(not necessery)
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			//getting Response code from url
			int status = connection.getResponseCode();
			System.out.println("Response code " + status);
			
			//response from endpoint 
			//firstly Handle the unsuccessful response 
			//response from endpoint 
			//firstly Handle the unsuccessful response 
			if (status > 299) {
			   //read the message ?? why reader is red?? why should it be static ?
			   reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
			   while((line = reader.readLine()) != null) {
			       responseContent.append(line);
			   }
			   reader.close();
			} else {
				// same thing as before just for successful reponse 
			   reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			   while((line = reader.readLine()) != null) {
			       responseContent.append(line);
			   }
			   reader.close();
			}
			//check whether we have correct reponse 
			System.out.println(responseContent.toString());

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			connection.disconnect();
		}
		

	}

}