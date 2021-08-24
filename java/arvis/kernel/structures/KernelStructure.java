package arvis.kernel.structures;

import arvis.kernel.structures.datatypes.CHARARRAY;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;

public abstract class KernelStructure {
    public final long controlCode;

    protected KernelStructure(long controlCode) {
        this.controlCode = controlCode;
    }

    public final byte[] getStructureMemory() throws Exception {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        for (Field field : getClass().getFields()) {
            if (field.getType().equals(CHARARRAY.class)) {
                bytes.write(((CHARARRAY)field.get(this)).getMemory());
            }
        }
        return bytes.toByteArray();
    }
}
