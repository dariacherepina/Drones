package drones.groupe_12.fra.uas;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HelloRest {


    private static final String USER_AGENT = "XYZ";
    private static final String ENDPOINT_URL = "http://dronesim.facets-labs.com/api/drones/?format=json";
    private static final String TOKEN = "Token 1586b43740b3c8b3686b31e2dc1cf1b4273b838f";
    private static final String DroneID = null;
    private static final String BASE_URL = null;


    // Function, um auf einfandel Drone zu zugreifen
    private static final String BASE_URL1 = "http://dronesim.facets-labs.com/api/";

    public String getAllDrones() {
        return fetchDataFromApi("drones/?format=json");
    }

    public String retrieveDroneID(int DroneID) {
        return fetchDataFromApi("drones/"+ DroneID+"?/format=json");
    }

    public String retrieveDroneTypes () {
        return fetchDataFromApi("dronetypes/?format=json");
    }

    public String retrieveDroneTypesID(int DroneTypesID) {
        return fetchDataFromApi("dronetypes/"+ DroneTypesID+"?/format=json");
    }

    public String getDroneDynamics() {
        return fetchDataFromApi("dronedynamics/?format=json");
    }

    public String getDroneDynamics(int droneDynamicID) {
        return fetchDataFromApi("dronedynamics/"+ droneDynamicID+"?/format=json");
    }





    private String fetchDataFromApi(String endpoint) {
        try {
            URL url = new URL(BASE_URL + endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", TOKEN);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = connection.getResponseCode();


            System.out.println("Response Code " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString()); // Process your response
            test(response.toString());

            return response.toString(); // Gibt die API Antwort als Text zurück
        } catch(Exception ex){
            ex.printStackTrace();}


        return null;
    }

    public static void main(String[] args) {
        System.out.println("Test started...");

        URL url;
        try {
            url = new URL(ENDPOINT_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", TOKEN);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", USER_AGENT);
            int responseCode = connection.getResponseCode();


            System.out.println("Response Code " + responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString()); // Process your response
            test(response.toString());
        } catch(Exception ex){
            ex.getMessage();}

    }

    public static void test(String input) {
        JSONObject wholeFile = new JSONObject(input);
        JSONArray jsonFile = wholeFile.getJSONArray("results");
        for (int i = 0; i < jsonFile.length(); i++) {
            JSONObject o = jsonFile.getJSONObject(i);
            if(o.has("carriage_type") && o.has("carriage_weight")){
                String a = o.getString("carriage_type");
                int b = o.getInt("carriage_weight");
                int id = o.getInt("id");
                System.out.println("Drone " + id + ": carriage type " + a + " (weight: " + b + "g)");
            }
        }

    }

    public static String formatJson(String input) {
        final int indentSpaces = 4;
        Object json = new JSONTokener(input).nextValue();

        if (json instanceof JSONObject) {
            JSONObject o = (JSONObject) json;

            return o.toString(indentSpaces);
        } else if (json instanceof JSONArray) {
            return ((JSONArray) json).toString(indentSpaces);
        } else {
            throw new IllegalArgumentException("Input string is not a valid JSON");
        }
    }

    public static String getBaseUrl1() {
        return BASE_URL1;
    }

    public static String getDroneid() {
        return DroneID;
    }
}