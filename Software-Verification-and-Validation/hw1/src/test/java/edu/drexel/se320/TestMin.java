package edu.drexel.se320;

import edu.drexel.se320.Min;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestMin {

    @Test
    public void testmin1() {
        assertEquals(Min.min(0,1), 0);
    }

    @Test
    public void testshouldfail() {
        assertEquals(Min.min(0,1), 34);
    }
}

