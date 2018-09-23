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
import hotel.entities.ServiceCharge;
import hotel.entities.ServiceType;
//import hotel.entities.Booking.State;

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
	//public enum State {PENDING, CHECKED_IN, CHECKED_OUT};
	@Before 
	

    public void setUp() throws Exception {

		

		hotel = new Hotel();

		hotel.addRoom(RoomType.DOUBLE, 101);

		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

		date = format.parse("02-11-2019");

		

		room = hotel.findAvailableRoom(RoomType.DOUBLE, date, stayLength);

		guest = new Guest("Harry", "kaur", 075673337);

		card = new CreditCard(CreditCardType.VISA, 2, 123);
		book =  new Booking( guest, room, date,2, 2, card);
		

	}

	

	@After 

    public void tearDown() throws Exception {

		card = null;

		guest = null;

		room = null;

		hotel = null;

	}

	

	@Test 

    public void testCheckin() { 

		long confirmationNumber = hotel.book(room, guest, date, stayLength, 1, card);

		

		hotel.checkin(confirmationNumber);

		

		Booking booking = hotel.findActiveBookingByRoomId(room.getId());

		

		boolean bookingExist = (booking != null);

		assertEquals(bookingExist, true);

		

		boolean isCheckedIn = (booking.isCheckedIn());

		assertEquals(isCheckedIn, true);

	}

	

}



 