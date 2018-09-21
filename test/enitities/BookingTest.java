/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.entities;

import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Malik
 */
public class BookingTest {
    
    
    public BookingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

 
    /**
     * Test of checkIn method, of class Booking.
     */
    @Test
    public void testCheckIn() {
        System.out.println("checkIn");
        Booking booking = new Booking(new Guest("Waqas Akbar", "2A Tucker St", 04205),
                          new Room(101, RoomType.SINGLE), new Date(), 1, 1,
                          new CreditCard(CreditCardType.VISA, 54673, 245));
        booking.checkIn();
        assertEquals(true, booking.isCheckedIn());
    }
	
	 /**
     * Test of addServiceCharge method, of class Booking.
     */
	
	@Test
    public void testAddServiceCharge() {System.out.println("addServiceCharge");
        ServiceType serviceType = null;
        double cost = 0.0;
        Booking booking = new Booking(new Guest("Waqas Akbar", "2A Tucker St", 042054),
                          new Room(101, RoomType.SINGLE), new Date(), 1, 1,
                          new CreditCard(CreditCardType.VISA, 5467433, 245));
        booking.checkIn();
        booking.addServiceCharge(serviceType, cost);
        assertEquals(true, booking.isCheckedIn());     
        
    }
	
	/**
     * Test of checkOut method, of class Booking.
     */
    @Test
    public void testCheckOut() {
        System.out.println("checkOut");
        Booking booking = new Booking(new Guest("Waqas Akbar", "2A Tucker St", 042054),
                          new Room(101, RoomType.SINGLE), new Date(), 1, 1,
                          new CreditCard(CreditCardType.VISA, 5467433, 245));
        booking.checkIn();
        booking.checkOut();
        assertEquals(true, booking.isCheckedOut());
    }
    
	
    
    
}

