package arvis.kernel.structures;

import arvis.kernel.control.ControlCode;
import arvis.kernel.structures.datatypes.CHARARRAY;

public final class KernelDebugStructure extends KernelStructure {
    public CHARARRAY debugMessage = new CHARARRAY(24);

    public KernelDebugStructure() {
        super(ControlCode.getControlCode(ControlCode.FILE_DEVICE_UNKNOWN,
                0x001,
                ControlCode.METHOD_BUFFERED,
                ControlCode.FILE_SPECIAL_ACCESS));
    }
}
