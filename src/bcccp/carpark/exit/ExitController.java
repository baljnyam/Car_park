package bcccp.carpark.exit;

import bcccp.carpark.Carpark;
import bcccp.carpark.ICarSensor;
import bcccp.carpark.ICarSensorResponder;
import bcccp.carpark.ICarpark;
import bcccp.carpark.IGate;
import bcccp.tickets.adhoc.IAdhocTicket;

public class ExitController 
		implements ICarSensorResponder,
		           IExitController {
	
	private IGate exitGate;
	private ICarSensor insideSensor;
	private ICarSensor outsideSensor; 
	private IExitUI ui;
	
	private ICarpark carpark;
	private IAdhocTicket  adhocTicket = null;
	private long exitTime;
	private String seasonTicketId = null;
	
	

	public ExitController(Carpark carpark, IGate exitGate, 
			ICarSensor is,
			ICarSensor os, 
			IExitUI ui) {
		//TODO Implement constructor
		this.carpark = carpark;
		this.exitGate = exitGate;
		this.is = is;
		this.os = os;
		this.ui = ui;
		/*
		Register the exit controller with both car sensors as a ICarEventResponder 
		Register the exit controller with the ui as and IExitController 
		Initialise the exit controller state to IDL
		*/
	}



	@Override
	public void ticketInserted(String ticketStr) {
		// TODO Auto-generated method stub
		/*
		if controller is in the WAITING state 
			check whether the barcode is a valid barcode 
			if the barcode starts with ‘A’ 
				find the adhoc ticket by barcode 
				if the adhoc exists and the ticket is current and has been paid 
					record the exit time for the adhoc ticket
					display ‘take processed ticket’ 
					transition controller to ‘PROCESSED’ state 
				otherwise
					display ‘take rejected ticket’ 
					transition controller to REJECTED state 
			else if barcode starts with ‘S’ 
				find the season ticket by barcode (ticketID) 
				if the season ticket is registered, and is valid, and is currently in use 
					finalise the season tickets current usage record
					display ‘take processed ticket’ 
					transition controller to ‘PROCESSED’ state 
				otherwise 
					display ‘take rejected ticket
					transition controller to REJECTED state 
			otherwise
				display ‘take rejected ticket’ 
				transition controller to REJECTED state 
				make the UI ‘beep’
		otherwise
			make the UI ‘beep’ 	
		*/
	}



	@Override
	public void ticketTaken() {
		// TODO Auto-generated method stub
		/*
		response depends on controller state 
		if controller is in the PROCESSED state 
			raise the exit gate 
			transition controller to TAKEN state 
		else if controller is in the REJECTED state 
			transition controller to WAITING state 
		otherwise 
			make the UI ‘beep’ 
		*/
	}



	@Override
	public void carEventDetected(String detectorId, boolean detected) {
		// TODO Auto-generated method stub
		/*
		IDLE  	– inside sensor detects car presence   Display ‘Insert Ticket’ message   Controller transitions to WAITING state 
			– outside sensor detects car presence  Controller transitions to BLOCKED state 
		WAITING, FULL, TICKET_ISSUED, TICKET_VALIDATED  
			– inside sensor detects car absence   Controller transitions to IDLE state  
			– outside sensor detects car presence  Controller transitions to BLOCKED state  
		BLOCKED – inside sensor detects car absence   Controller transitions to IDLE state 
			– outside sensor detects car absence  Controller transitions to previous state (display appropriate message)
		TAKEN 	– inside sensor detects car absence   Controller transitions to IDLE state 
			– outside sensor detects car presence  Controller transitions to EXITING state 
		EXITING – inside sensor detects car absence   Controller transitions to EXITED state 
			– outside sensor detects car absence  Controller transitions back to TAKEN state 
		EXITED 	– outside sensor detects car absence   Controller transitions to IDLE state  
			– inside sensor detects car presence  Controller transitions back to EXITING state 
		*/
	}

	
	
}
