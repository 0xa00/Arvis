package arvis;

import arvis.kernel.DeviceOpenException;
import arvis.kernel.KernelDriver;
import arvis.kernel.structures.KernelDebugStructure;

public final class Arvis {
    private final KernelDriver kernelDriver;

    public Arvis() throws DeviceOpenException {
        this.kernelDriver = KernelDriver.createKernelDriver("kArvisDevice");

        KernelDebugStructure kernelStructure = new KernelDebugStructure();

        kernelStructure.debugMessage.update("Hi from Java");

        this.kernelDriver.sendDeviceIoControl(kernelStructure);
    }

    public static void main(String[] args) {
        // Load the JNI library for driver control
        System.loadLibrary("Library.dll");

        try {
            ARVIS = new Arvis();
        } catch (DeviceOpenException e) {
            System.err.println("DeviceOpenException");
        }
    }

    public static Arvis ARVIS = null;
}
