package snowfall;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for the SnowfallLogger
class SnowfallLoggerTest {
    SnowfallLogger loggera;
    SnowfallLogger loggerb;


    @BeforeEach
    void runBefore(){
    loggera = new SnowfallLogger();
    loggerb = new SnowfallLogger();


}

    @Test
    void testConstructor(){
        assertEquals(0,loggera.getNumSnowfallRecords());
    }

    @Test
    void testAddSingleSnowfallRecord() {
        loggera.addSnowfallRecord(10);
        assertEquals(1,loggera.getNumSnowfallRecords());
        assertEquals(10,loggera.getAverageSnowfall());
        assertEquals(0,loggera.getNumSnowDays());

    }

    @Test
    void testAddMultipleSnowfallRecords() {
        loggerb.addSnowfallRecord(1);
        loggerb.addSnowfallRecord(20);
        loggerb.addSnowfallRecord(29);
        loggerb.addSnowfallRecord(30);
        assertEquals(4,loggerb.getNumSnowfallRecords());
        assertEquals(20.0,loggerb.getAverageSnowfall());
        assertEquals(3,loggerb.getNumSnowDays());

    }

    @Test
    void testNumSnowDays() {
        loggerb.addSnowfallRecord(5);
        loggerb.addSnowfallRecord(16);
        assertEquals(1,loggerb.getNumSnowDays());
    }

    @Test
    void testReset() {
        loggerb.reset();
        assertEquals(0,loggerb.rec);
        assertEquals(0.0,loggerb.amount);
        assertEquals(0,loggerb.snowDay);

    }
}