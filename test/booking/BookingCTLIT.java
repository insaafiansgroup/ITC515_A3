/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.booking;

import hotel.checkout.CheckoutCTL;
import hotel.credit.CreditCardType;
import hotel.entities.Hotel;
import hotel.entities.RoomType;
import java.util.Date;
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
public class BookingCTLIT {
    
    public BookingCTLIT() {
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
     * Test of creditDetailsEntered method, of class BookingCTL.
     */
    @Test
    public void testCreditDetailsEntered() { // Integration testing done
     
      System.out.println("creditDetailsEntered");
      BookingCTL controlBooking = new BookingCTL(new Hotel());
      controlBooking.creditDetailsEntered(CreditCardType.MASTERCARD, 35454333, 235);
        
       
    }
}

