package edu.drexel.se320;

import edu.drexel.se320.Min;
import static org.junit.Assert.assertEquals;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
import org.junit.Test;

public class Exceptions {

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionsWithBrevity() {
        throw new IllegalArgumentException();
    }









    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testExceptionsWithStyle() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Bad Argument");
        
        throw new IllegalArgumentException("Bad jasdf;lkasdjlfk");
    }
}


