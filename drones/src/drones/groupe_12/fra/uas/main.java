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
	// Define constants


	public static void main(String[] args){
		APIConnection apiClient = new APIConnection();
		String dronesResponse = apiClient.getResponse("drones/?format=json&limit=20&offset=0");
		System.out.println("Drones: " + dronesResponse);
		String droneTypesResponse = apiClient.getResponse("dronetypes/?format=json&limit=20&offset=0");
		System.out.println("Drone Types: " + droneTypesResponse);
		String droneDynamicsResponse = apiClient.getResponse("dronedynamics/?format=json&limit=20&offset=0");
		System.out.println("Drone Types: " + droneDynamicsResponse);
		//apiClient.test(dronesResponse.toString());
		//apiClient.formatJson(dronesResponse.toString());


		IndividualDrone droneIndivData = new IndividualDrone();
		System.out.println(droneIndivData.getDroneTypesIndivData(55));
		System.out.println(droneIndivData.getDroneTypesIndivData(65));
		System.out.println(droneIndivData.getDronesIndivData(65));
		System.out.println(droneIndivData.getDroneDynamicsIndivData(65));

	}
}

