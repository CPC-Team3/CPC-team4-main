package charging_station;

import java.util.ArrayList;

import capstone.Log;
import capstone.exception_handler.InitException;
import capstone.exception_handler.assigningException;
import capstone.exception_handler.listeningException;

// exceptions

public class ChargingStation {
	
	// Attributes	
	public int id; // charging station id
	public ArrayList<Charger> chargers = new ArrayList<Charger>(); // list of charger in the charging station
	String bookFilePath; // list of booking
	Log logger;
	
	// Constructor
	public ChargingStation(int id) {
		/*
		 * input : id of the charging station
		 */
		logger = new Log("charger"+String.valueOf(this.id),"Charger "+ String.valueOf(this.id));
		logger.init();
		this.id = id;
	
	}


	// Functionalities
	@SuppressWarnings("unused")
	public String listening( String bookFilePath) throws listeningException{
		/* 
		 * read the booking file and return the information of waiting vehicle
		 */
			String vehicleInfo = null;
			boolean file_exist = false;
			// read booking file
			if (file_exist) {
				
			}else {
				throw new listeningException("could not found booking file");
			}
			
			// get the vehicle information if available (the booking time >= current time))	
			
			// return car information
			if (vehicleInfo != null) {
				this.logger.log.info("Handling a vehicle - " + vehicleInfo);
			}
			return vehicleInfo;
	}
	
	public int availability(int vehId) {
		/* 
		 * return  id of free charger
		 */
		int idOfFreeCharger = -1;
		
		// check for available charger
		this.logger.log.info("Finding available charger for vehicle " + String.valueOf(vehId));
		for (Charger c:chargers) {
			if (!c.occupied) {
				this.logger.log.info("Charger " + String.valueOf(idOfFreeCharger) + " is available.");
				idOfFreeCharger = c.id;
				this.logger.log.info("Selecting charger " + String.valueOf(idOfFreeCharger));
			}
		}
		
		// return available charger		
		return idOfFreeCharger;
	}
	
	
	public void assigning(int vehId, int chargerId) throws assigningException {
		this.logger.log.info("Assigning vehicle " + String.valueOf(vehId) + " to charger " + String.valueOf(chargerId));
		// get vehicle id 
		if (vehId < 0) {
			throw new assigningException("vehicle is not exist");
		}
		
		
		// set the charger to occupied
		for (Charger c:chargers) {
			if (c.id == chargerId) {
				c.occupied = true;
			}
		}	
		
				
	}
	
	void book(int id, double timeSlot) {
		/* 
		 * book a time slot by any car to charge
		 */
		
		// Logging
		
	}
	
	
	// setters and getters
	public String getBookFilePath() {
		return bookFilePath;
	}

	public void setBookFilePath(String bookFilePath) {
		this.bookFilePath = bookFilePath;
	}
	
	// to strings
	@Override
	public String toString() {
		return "Charging Station [id=" + id +"]";
	}

}
