package codekata;

public class DeviceDriver {

    private final DataReader reader;
    private final DataWriter writer;

    public DeviceDriver(DataReader reader, DataWriter writer) {

        this.reader = reader;
        this.writer = writer;
    }

    public byte read() {
        return reader.read();
    }

    public void write(byte data) {
        this.writer.write(data);
    }
}
