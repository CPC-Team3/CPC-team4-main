package capstone;

import java.util.ArrayList;
import capstone.exception_handler.assigningException;
import capstone.exception_handler.listeningException;
import charging_station.Charger;

// exceptions
public class ChargeStation {
	
	
	public ArrayList<Charger> chargers = new ArrayList<Charger>(); // list of charger in the charging station
	int requestCar[]; // list of vehicle (id) that request to charge on the spot
	String bookFilePath; // list of booking

	public int availability() {
		/* 
		 * return  id of free charger
		 */
		
		// Logging
		
		return 0;
	}
	
	public int listening( String bookFilePath) throws listeningException{
		/* 
		 * return  id of waiting vehicle from requestCar and bookFile
		 */
		boolean file_exist = false;
		// read booking file
		if (file_exist) {
			
		}else {
			throw new listeningException("could not found booking file");
		}
			
		
		// Logging
		
		return 0;
	}
	
	public void assigning(int carID, int chargerID) throws assigningException {
		/* car id as the input
		 * assign the vehicle to a specific charger
		 */
		int vehicle_id = -1;
		// get vehicle id 
		if (vehicle_id < 0) {
			throw new assigningException("vehicle is not exist");
		}
		
		
		// Logging
		
	}
	
	void book(int id, double timeSlot) {
		/* 
		 * book a time slot by any car to charge
		 */
		
		// Logging
		
	}
	

	
	
	// setters and getters

	public int[] getRequestCar() {
		return requestCar;
	}

	public void setRequestCar(int[] requestCar) {
		this.requestCar = requestCar;
	}

	public String getBookFilePath() {
		return bookFilePath;
	}

	public void setBookFilePath(String bookFilePath) {
		this.bookFilePath = bookFilePath;
	}

}
