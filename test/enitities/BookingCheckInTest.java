
package hotel.entities;

import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Test;

/**
 *
 * @author Malik
 */
public class BookingCheckInTest {
    
     @Test
     public void testCheckIn() {
         System.out.println("checkIn");
        Booking booking = new Booking(new Guest("Waqas Akbar", "2A Tucker St", 042054),
                          new Room(101, RoomType.SINGLE), new Date(), 1, 1,
                          new CreditCard(CreditCardType.VISA, 5467433, 245));
        booking.checkIn();
        assertEquals(true, booking.isCheckedIn());
     }
    
 }
