package codekata;

public interface MemoryDevice {
    byte read(long address);
    void write(long address, byte data);
}
