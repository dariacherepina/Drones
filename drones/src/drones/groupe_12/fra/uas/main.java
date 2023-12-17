package drones.groupe_12.fra.uas;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.net.MalformedURLException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class main {
	
	
	public static void main(String[] args){
		APIConnection apiClient = new APIConnection();
		String dronesResponse;
		String droneTypesResponse;
		String droneDynamicsResponse;
		dronesResponse = apiClient.getResponse("drones/?format=json&limit=20&offset=0");
		System.out.println("Drones: " + dronesResponse);
		droneTypesResponse = apiClient.getResponse("dronetypes/?format=json&limit=20&offset=0");
		System.out.println("Drone Types: " + droneTypesResponse);
		droneDynamicsResponse = apiClient.getResponse("dronedynamics/?format=json&limit=20&offset=0");
		System.out.println("Drone Types: " + droneDynamicsResponse);
		apiClient.test(dronesResponse.toString());
		//apiClient.formatJson(dronesResponse.toString());
		
        
	}
}
	
		