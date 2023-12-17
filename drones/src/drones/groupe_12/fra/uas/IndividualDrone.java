package drones.groupe_12.fra.uas;


public class IndividualDrone extends APIConnection {

	IndividualDrone(){}
	
	
	public String getDronesIndivData(int droneId) {
		return getResponse("drones/" + droneId + "/?format=json");
	}
	public String getDroneTypesIndivData(int droneId) {
		return getResponse("dronetypes/" + droneId + "/?format=json");
	}
	public String getDroneDynamicsIndivData(int droneId) { 
		return getResponse(droneId + "/dynamics/?format=json");
	}
	public String getDrones() {
		return getResponse("drones/?format=json&limit=20&offset=0");
	}
	public String getDroneTypes() {
		return getResponse("dronetypes/?format=json&limit=20&offset=0");
	}
	public String getDroneDynamics() {
		return getResponse("dronedynamics/?format=json&limit=30&offset=0"); // what limits ?
	}


}