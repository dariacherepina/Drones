package drones.groupe_12.fra.uas;

import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
import java.net.URL;

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
		 int responseCode = con.getResponseCode() ;
		 System.out.println("response code " + responseCode);
		 JSONArray d;
		 
		}
		catch(Exception ex){
			ex.getMessage();}
		System.out.println("Das ist Daria");
	}
	
		

}
