package hotel.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import hotel.entities.Booking;
import hotel.entities.Guest;
import hotel.entities.Hotel;
import hotel.entities.Room;
import hotel.entities.RoomType;
import hotel.entities.ServiceType;

public class TestHotel {
	Hotel hotel;
	Date date;
	int stayLength=3;
	Room room;
	Guest guest;
	CreditCard card;
	Booking book;

	public Map<Long, Booking> bookingsByConfirmationNumber;
	public Map<Integer, Booking> activeBookingsByRoomId;
	public enum State {PENDING, CHECKED_IN, CHECKED_OUT};
	@Before 
	

    public void setUp() throws Exception {

		

		hotel = new Hotel();

		hotel.addRoom(RoomType.SINGLE, 101);

		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

		date = format.parse("02-11-2019");

		

		room = hotel.findAvailableRoom(RoomType.SINGLE, date, stayLength);

		guest = new Guest("Harry", "kaur", 075673337);

		card = new CreditCard(CreditCardType.VISA, 2, 123);

	}

	

	@After 

    public void tearDown() throws Exception {

		card = null;

		guest = null;

		room = null;

		hotel = null;

	}

	

	
	
@Test (expected =RuntimeException.class)
	public void testCheckin() {
	hotel.checkin(1);
}

@Test (expected =RuntimeException.class)
public void testAddServiceCharge() {
hotel.addServiceCharge(101,ServiceType.ROOM_SERVICE,7);
}

@Test (expected =RuntimeException.class)
public void testCheckout() {
hotel.checkout(101);
}






	
}




 