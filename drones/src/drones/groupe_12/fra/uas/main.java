package drones.groupe_12.fra.uas;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.net.MalformedURLException;

import org.json.JSONArray;

public class main {

	public static void main(String[] args){//ignore

		try {
		final String TOKEN = "Token 1586b43740b3c8b3686b31e2dc1cf1b4273b838f";
		 URL url;
		 url = new URL("http://dronesim.facets-labs.com/api/?format=json");
		 HttpURLConnection con ;
		 con = (HttpURLConnection)url.openConnection();
		 con.setRequestProperty("Authorization", TOKEN ) ;
		 con.setRequestMethod("GET") ;
		 con.setRequestProperty("User-Agent", "XYZ") ;
		 //int responseCode = con.getResponseCode() ;
		 //System.out.println("response code " + responseCode);
		// Get the response
		 BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		 String inputLine;
		 StringBuffer content = new StringBuffer();
		 while ((inputLine = in.readLine()) != null) {
		    content.append(inputLine);
		 }
		 in.close();
	
	    // Parse the JSON response
	   // ObjectMapper mapper = new ObjectMapper();
	   // YourDataClass data = mapper.readValue(content.toString(), YourDataClass.class);
	
	    // Now you can use the data...
	   // System.out.println("Data: " + data);
		 
		}
		catch(Exception ex){
			ex.getMessage();}
		//System.out.println("Das ist Daria!");
	
	
		}
}
	
		

