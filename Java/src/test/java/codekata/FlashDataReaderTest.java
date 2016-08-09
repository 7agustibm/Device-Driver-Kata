package codekata;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlashDataReaderTest {
    private Mockery context;
    private DataReader reader;
    private ReadinessChecker readinessChecker;
    private MemoryDevice device;

    @Before
    public void setUp(){
        context = new Mockery();
        readinessChecker = context.mock(ReadinessChecker.class);
        device = context.mock(MemoryDevice.class);
        reader = new FlashDataReader(readinessChecker, device);
    }

    @Test
    public void read_data_when_device_is_ready() {
        final byte deviceData = 0;
        context.checking(new Expectations() {{
            oneOf(readinessChecker).isReady();
            will(returnValue(true));

            oneOf(device).read(0x0);
            will(returnValue(deviceData));
        }});

        byte driverData = reader.read();

        assertEquals(deviceData, driverData);

        context.assertIsSatisfied();
    }

}
