package charging_station;

import capstone.Log;
import capstone.exception_handler.InitException;

public class Charger {
		
	// Attribute
	public int id;
	boolean occupied;
	int chargingStationId;
	Log logger;
	
	// Constructor
	public Charger(int id, int chargingStationId){
		/*
		 * input : id of the charger, id of charger station that this charger belong to
		 */
		logger = new Log("charger"+String.valueOf(this.id),"Charger "+ String.valueOf(this.id));
		logger.init();
		this.id = id;
		this.chargingStationId = chargingStationId;
		
	}
	
	// Functionality
	void start_charge() {
		this.logger.log.info("Charger " + String.valueOf(id) + "Start charging");
	}
	
	void stop_charge() {
		this.logger.log.info("Charger " + String.valueOf(id) + "Stop charging");
		// set the occupied to false
		this.occupied = false;
	}
	
	
	// setters and getter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isOccupied() {
		return occupied;
	}
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	
	// to strings
	@Override
	public String toString() {
		return "Charger [id=" + id + ", occupied=" + occupied + "]";
	}
	
}
