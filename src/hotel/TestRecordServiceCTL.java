package hotel.test;



import static org.junit.Assert.assertEquals;



import java.text.SimpleDateFormat;

import java.util.Date;



import org.junit.After; 

import org.junit.Before; 

import org.junit.Test;

import hotel.HotelHelper;
import hotel.credit.CreditCard;

import hotel.credit.CreditCardType;

import hotel.entities.Booking;

import hotel.entities.Guest;

import hotel.entities.Hotel;

import hotel.entities.Room;

import hotel.entities.RoomType;

import hotel.entities.ServiceCharge;

import hotel.entities.ServiceType;
import hotel.service.RecordServiceCTL; 



public class TestRecordServiceCTL {

	

	Hotel hotel;

	

	
@Test
    public void testserviceDetailsEntered() throws Exception { 
	
	

		Hotel hotel = new Hotel();// creating object of Hotel class
		hotel= HotelHelper.loadHotel(); //load Helper class
		RecordServiceCTL ctl= new RecordServiceCTL(hotel);// passing hotel object  to RecordServiceCL class
		ctl.roomNumberEntered(301);// set roomnumber to 301
		
		hotel.addServiceCharge(201, ServiceType.BAR_FRIDGE, 7.00);// called addServiceCharge Method of hotel class
		 ctl.serviceDetailsEntered(ServiceType.ROOM_SERVICE, 150.00);// calling serviceDetailsEnetered Method of  RecordServiceCTL class
		 ctl.run(); // cal run mehod of RecordServiceUI class 
		
		
		

		
	}
	

}
