
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
public class BookingAddServiceChargeTest {
    
     @Test
     public void testAddServiceCharge() {
        ServiceType serviceType = null;
        double cost = 0.0;
        Booking booking = new Booking(new Guest("Uzair Mahmood", "2C Tucker St", 047054),
                          new Room(201, RoomType.DOUBLE), new Date(), 1, 2,
                          new CreditCard(CreditCardType.MASTERCARD, 5667433, 265));
        booking.checkIn();
        booking.addServiceCharge(serviceType, cost);
        assertEquals(true, booking.isCheckedIn());  
     }
    
     }
