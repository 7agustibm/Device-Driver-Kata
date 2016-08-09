package codekata;

public class FlashDataReader implements DataReader {
    public static final int ADDRESS = 0x0;
    private final ReadinessChecker readinessChecker;
    private final MemoryDevice device;

    public FlashDataReader(ReadinessChecker readinessChecker, MemoryDevice device) {
        this.readinessChecker = readinessChecker;
        this.device = device;
    }

    public byte read() {
        if(readinessChecker.isReady()){
            return device.read(ADDRESS);
        }
        return 0;
    }
}
