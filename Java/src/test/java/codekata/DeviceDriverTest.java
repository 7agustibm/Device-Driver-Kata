package codekata;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;


public class DeviceDriverTest {

    private Mockery context;
    private DataReader reader;
    private DataWriter writer;
    private DeviceDriver driver;

    @Before
    public void setUp(){
        context = new Mockery();
        reader = context.mock(DataReader.class);
        writer = context.mock(DataWriter.class);
        driver = new DeviceDriver(reader, writer);
    }

    @Test
    public void read_From_Hardware() {
        final byte deviceData = 1;
        context.checking(new Expectations() {{
            oneOf(reader).read();
            will(returnValue(deviceData));
        }});

        byte driverData = driver.read();

        assertEquals(deviceData, driverData);

        context.assertIsSatisfied();
    }

    @Test
    public void write_To_Hardware() {
        final byte data = 0x0;
        context.checking(new Expectations() {{
            oneOf(writer).write(data);
        }});

        driver.write(data);

        context.assertIsSatisfied();
    }

    // Todd: Later add exceptions

}


