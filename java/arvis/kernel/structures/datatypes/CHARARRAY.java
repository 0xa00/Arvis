package arvis.kernel.structures.datatypes;

public final class CHARARRAY extends DataType {
    public byte[] value;

    public CHARARRAY() {

    }

    public CHARARRAY(int size) {
        this.value = new byte[size];
    }

    public CHARARRAY(int size, String value) {
        this(size);
        this.update(value);
    }

    public void update(String value) {
        if (this.value == null || value == null)
            return;

        byte[] bytes = value.getBytes();
        for (int i = 0; i < bytes.length && i < this.value.length; i++) {
            byte b = bytes[i];
            this.value[i] = b;
        }
    }

    @Override
    public byte[] getMemory() {
        return value;
    }
}
