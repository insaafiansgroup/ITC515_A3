
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
public class BookingCheckOutTest {
    
     @Test
     public void testCheckOut() {
        System.out.println("checkOut");
        Booking booking = new Booking(new Guest("Aamir Malik", "15 Auburn St", 040054),
                          new Room(301, RoomType.TWIN_SHARE), new Date(), 6, 3,
                          new CreditCard(CreditCardType.VISA, 5460003, 205));
        booking.checkIn();
        booking.checkOut();
        assertEquals(true, booking.isCheckedOut());
     }
    
     }
