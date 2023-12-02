package system;

import java.util.ArrayList;

import capstone.Log;
import charging_station.ChargingStation;
import energy_controller.Controller;
import energy_controller.Energy;
import energy_controller.Weather;

public class ChargingSystem extends Thread{
	/*
	 *  combine everything as a system
	 */
	
	// Attribute
	private String bookFilePath;
	private ChargingStation station1; // main charging station
	private Controller energyController1;
	Log logger;
	int id;
	
	
	// constructor
	public ChargingSystem(String bookFilePath) {
		this.bookFilePath = bookFilePath;
		logger = new Log("system\\system"+String.valueOf(getId_()),"System "+ String.valueOf(getId_()));
		
	}
	
	

	// functionalities
	public void init(){
		/*
		 * this function is to initialize each component
		 */
		
		// initialize charging station
		logger.info("Initialize charging station");
		station1 = new ChargingStation(0,bookFilePath);
		station1.addCharger(0);
		station1.addCharger(1);
		logger.info("Charging station is ready");
		
		// initialize energy controller
		logger.info("Initialize energy controller");
		energyController1 = new Controller(0, new ArrayList<Weather>());
		energyController1.addEnergy(new Energy("solar","renewable"));
		energyController1.addEnergy(new Energy("wind","renewable"));
		//add energy source
		logger.info("energy controller is ready");
	}
	
	public void run() {
		
		logger.info("starting system1");
		init();
		
		logger.info("starting all the component");
		station1.start();
		energyController1.start();
		
		try {
			station1.join();
			energyController1.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		logger.info("system1 finish");
	}
	
	// setters and getters
	private int getId_() {
		return id;
	}
	
	//simulation
	public static void main(String[] args) {
		ChargingSystem sys1 = new ChargingSystem("bookingFilePath");
		sys1.start();
		
	}
}
