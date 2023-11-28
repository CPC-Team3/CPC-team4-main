package charging_station;

import java.util.ArrayList;
import charging_station.ExceptionHandler.InitException;
import charging_station.ExceptionHandler.assigningException;
import charging_station.ExceptionHandler.listeningException;

import java.io.*;

// exceptions

public class ChargingStation {
	
	// Attributes	
	int id; // charging station id
	ArrayList<Charger> chargers = new ArrayList<Charger>(); // list of charger in the charging station
	String bookFilePath; // list of booking
	Log logger;
	
	// Constructor
	ChargingStation(int id){
		/*
		 * input : id of the charging station
		 */
		try {
			logger = new Log("charger"+String.valueOf(this.id),"Charger "+ String.valueOf(this.id));
			logger.init();
			this.id = id;
		}catch(InitException e) {
			System.out.print("Unable to initialize Charging Station "+ String.valueOf(id));
		}
		
	}


	// Functionalities
	String listening( String bookFilePath) throws listeningException{
		/* 
		 * read the booking file and return the information of waiting vehicle
		 */
			String vehicleInfo = null;
			// read booking file
			
			// get the vehicle information if available (the booking time >= current time))	
			
			// return car information
			if (vehicleInfo != null) {
				this.logger.log.info("Handling a vehicle - " + vehicleInfo);
			}
			return vehicleInfo;
	}
	
	int availability(int vehId) {
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

	// Method to write ChargingStation information to a byte stream
	public void writeToStream(OutputStream outputStream) throws IOException {
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
			objectOutputStream.writeInt(id);
			objectOutputStream.writeObject(chargers);
			objectOutputStream.writeObject(bookFilePath);
		}
	}

	// Method to read ChargingStation information from a byte stream
	public void readFromStream(InputStream inputStream) throws IOException, ClassNotFoundException {
		try (ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
			id = objectInputStream.readInt();
			chargers = (ArrayList<Charger>) objectInputStream.readObject();
			bookFilePath = (String) objectInputStream.readObject();
		}
	}

	// Method to write ChargingStation information to a character stream
	public void writeToFile(Writer writer) throws IOException {
		try (BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
			bufferedWriter.write(String.valueOf(id));
			bufferedWriter.newLine();
			for (Charger charger : chargers) {
				charger.writeToFile(bufferedWriter);
			}
			bufferedWriter.write(bookFilePath);
			bufferedWriter.newLine();
		}
	}

	// Method to read ChargingStation information from a character stream
	public void readFromFile(Reader reader) throws IOException {
		try (BufferedReader bufferedReader = new BufferedReader(reader)) {
			id = Integer.parseInt(bufferedReader.readLine());
			for (Charger charger : chargers) {
				charger.readFromFile(bufferedReader);
			}
			bookFilePath = bufferedReader.readLine();
		}
	}
	
	void assigning(int vehId, int chargerId) throws assigningException {
		this.logger.log.info("Assigning vehicle " + String.valueOf(vehId) + " to charger " + String.valueOf(chargerId));
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