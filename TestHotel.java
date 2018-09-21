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

public class TestHotel {
	Hotel hotel;
	Date date;
	int stayLength=3;
	Room room;
	Guest guest;
	CreditCard card;

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

	

	@Test 

    public void testBook() throws Exception { 

		

		long confirmationNumber = hotel.book(room, guest, date, stayLength, 2, card);

		long expectedConfirmationNumber = 2102019101L; //01012019101

		assertEquals(expectedConfirmationNumber, confirmationNumber);

		

		boolean bookingExist = (hotel.findBookingByConfirmationNumber(confirmationNumber) != null);

		assertEquals(bookingExist, true);

		

		boolean roomNotAvailable = room.isAvailable(date, stayLength);

		assertEquals(roomNotAvailable, false);

	}
@Test (expected =RuntimeException.class)
	public void testCheckin() {
	hotel.checkin(1);
}




   


}
