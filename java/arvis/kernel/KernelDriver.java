package arvis.kernel;

import arvis.kernel.structures.KernelStructure;

public final class KernelDriver {
    public boolean sendDeviceIoControl(KernelStructure kernelStructure) {
        byte[] structureMemory;
        try {
            structureMemory = kernelStructure.getStructureMemory();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return DeviceIoControl0(kernelStructure.controlCode, structureMemory);
    }

    public static native boolean DeviceIoControl0(long controlCode,
                                                  byte[] memoryBuffer);

    /**
     * @see KernelDriver#createKernelDriver0(String)
     * @throws DeviceOpenException If a handle couldn't be opened to the driver
     */
    public static KernelDriver createKernelDriver(String deviceName) throws DeviceOpenException {
        KernelDriver kernelDriver = createKernelDriver0(deviceName);
        if (kernelDriver == null) {
            throw new DeviceOpenException();
        }
        return kernelDriver;
    }

    /**
     * Opens a handle to the driver device control and returns a new {@link KernelDriver} object
     */
    public static native KernelDriver createKernelDriver0(String deviceName);

    private KernelDriver() {

    }
}
