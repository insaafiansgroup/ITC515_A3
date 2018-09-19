package hotel.service;

import hotel.entities.Booking;
import hotel.entities.Hotel;
import hotel.entities.ServiceType;
import hotel.utils.IOUtils;

public class RecordServiceCTL {
	
	private static enum State {ROOM, SERVICE, CHARGE, CANCELLED, COMPLETED};
	
	private Hotel hotel;
	private RecordServiceUI recordServiceUI;
	private State state;
	
	private Booking booking;
	private int roomNumber;


	public RecordServiceCTL(Hotel hotel) {
		this.recordServiceUI = new RecordServiceUI(this);
		state = State.ROOM;
		this.hotel = hotel;
	}

	
	public void run() {		
		IOUtils.trace("PayForServiceCTL: run");
		recordServiceUI.run();
	}


	public void roomNumberEntered(int roomNumber) {
		if (state != State.ROOM) {
			String mesg = String.format("PayForServiceCTL: roomNumberEntered : bad state : %s", state);
			throw new RuntimeException(mesg);
		}
		booking = hotel.findActiveBookingByRoomId(roomNumber);
		if (booking == null) {
			String mesg = String.format("No active booking for room id: %d", roomNumber);
			recordServiceUI.displayMessage(mesg);
		}
		else {
			this.roomNumber = roomNumber;
			state = State.SERVICE;
			recordServiceUI.setState(RecordServiceUI.State.SERVICE);
		}
	}
	
	
	public void serviceDetailsEntered(ServiceType serviceType, double cost) {
		// TODO Auto-generated method stub
		if (state != State.SERVICE) // if condition check the service state
			{ 
			//if service is not set than it will show message to the user
		      String msg = "PayForServiceCTL: serviceDetailsEntered : bad state";
		      throw new RuntimeException(msg); // throw runtime error
		    }
		    hotel.addServiceCharge(roomNumber, serviceType, cost); // calling addServiceCharge method of hotel class with parameters
		    
		    recordServiceUI.displayServiceChargeMessage(roomNumber, cost, serviceType.getDescription()); //  it will provide description of room service
		    state = State.COMPLETED; // set the state to completed
		    recordServiceUI.setState(RecordServiceUI.State.COMPLETED); // call setState method of recordServiceUI class

	}


	public void cancel() {
		recordServiceUI.displayMessage("Pay for service cancelled");
		state = State.CANCELLED;
		recordServiceUI.setState(RecordServiceUI.State.CANCELLED);
	}


	public void completed() {
		recordServiceUI.displayMessage("Pay for service completed");
	}


	

}
