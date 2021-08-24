package arvis.kernel.control;

public class ControlCode {

    public static long getControlCode(int deviceType,
                                      int functionCode,
                                      int method,
                                      int access) {
        // https://docs.microsoft.com/en-us/previous-versions/windows/embedded/ms904001
        return ((deviceType << 16) | ((access) << 14) | ((functionCode) << 2) | (method));
    }

    // ntifs.h
    public static int METHOD_BUFFERED = 0;
    public static int METHOD_IN_DIRECT = 1;
    public static int METHOD_OUT_DIRECT = 2;
    public static int METHOD_NEITHER = 3;

    // ntifs.h
    public static int FILE_ANY_ACCESS = 0;
    public static int FILE_SPECIAL_ACCESS = FILE_ANY_ACCESS;
    public static int FILE_READ_ACCESS = 0x0001;
    public static int FILE_WRITE_ACCESS = 0x0002;

    // ntifs.h
    public static int FILE_DEVICE_BEEP = 0x00000001;
    public static int FILE_DEVICE_CD_ROM = 0x00000002;
    public static int FILE_DEVICE_CD_ROM_FILE_SYSTEM = 0x00000003;
    public static int FILE_DEVICE_CONTROLLER = 0x00000004;
    public static int FILE_DEVICE_DATALINK = 0x00000005;
    public static int FILE_DEVICE_DFS = 0x00000006;
    public static int FILE_DEVICE_DISK = 0x00000007;
    public static int FILE_DEVICE_DISK_FILE_SYSTEM = 0x00000008;
    public static int FILE_DEVICE_FILE_SYSTEM = 0x00000009;
    public static int FILE_DEVICE_INPORT_PORT = 0x0000000a;
    public static int FILE_DEVICE_KEYBOARD = 0x0000000b;
    public static int FILE_DEVICE_MAILSLOT = 0x0000000c;
    public static int FILE_DEVICE_MIDI_IN = 0x0000000d;
    public static int FILE_DEVICE_MIDI_OUT = 0x0000000e;
    public static int FILE_DEVICE_MOUSE = 0x0000000f;
    public static int FILE_DEVICE_MULTI_UNC_PROVIDER = 0x00000010;
    public static int FILE_DEVICE_NAMED_PIPE = 0x00000011;
    public static int FILE_DEVICE_NETWORK = 0x00000012;
    public static int FILE_DEVICE_NETWORK_BROWSER = 0x00000013;
    public static int FILE_DEVICE_NETWORK_FILE_SYSTEM = 0x00000014;
    public static int FILE_DEVICE_NULL = 0x00000015;
    public static int FILE_DEVICE_PARALLEL_PORT = 0x00000016;
    public static int FILE_DEVICE_PHYSICAL_NETCARD = 0x00000017;
    public static int FILE_DEVICE_PRINTER = 0x00000018;
    public static int FILE_DEVICE_SCANNER = 0x00000019;
    public static int FILE_DEVICE_SERIAL_MOUSE_PORT = 0x0000001a;
    public static int FILE_DEVICE_SERIAL_PORT = 0x0000001b;
    public static int FILE_DEVICE_SCREEN = 0x0000001c;
    public static int FILE_DEVICE_SOUND = 0x0000001d;
    public static int FILE_DEVICE_STREAMS = 0x0000001e;
    public static int FILE_DEVICE_TAPE = 0x0000001f;
    public static int FILE_DEVICE_TAPE_FILE_SYSTEM = 0x00000020;
    public static int FILE_DEVICE_TRANSPORT = 0x00000021;
    public static int FILE_DEVICE_UNKNOWN = 0x00000022;
    public static int FILE_DEVICE_VIDEO = 0x00000023;
    public static int FILE_DEVICE_VIRTUAL_DISK = 0x00000024;
    public static int FILE_DEVICE_WAVE_IN = 0x00000025;
    public static int FILE_DEVICE_WAVE_OUT = 0x00000026;
    public static int FILE_DEVICE_8042_PORT = 0x00000027;
    public static int FILE_DEVICE_NETWORK_REDIRECTOR = 0x00000028;
    public static int FILE_DEVICE_BATTERY = 0x00000029;
    public static int FILE_DEVICE_BUS_EXTENDER = 0x0000002a;
    public static int FILE_DEVICE_MODEM = 0x0000002b;
    public static int FILE_DEVICE_VDM = 0x0000002c;
    public static int FILE_DEVICE_MASS_STORAGE = 0x0000002d;
    public static int FILE_DEVICE_SMB = 0x0000002e;
    public static int FILE_DEVICE_KS = 0x0000002f;
    public static int FILE_DEVICE_CHANGER = 0x00000030;
    public static int FILE_DEVICE_SMARTCARD = 0x00000031;
    public static int FILE_DEVICE_ACPI = 0x00000032;
    public static int FILE_DEVICE_DVD = 0x00000033;
    public static int FILE_DEVICE_FULLSCREEN_VIDEO = 0x00000034;
    public static int FILE_DEVICE_DFS_FILE_SYSTEM = 0x00000035;
    public static int FILE_DEVICE_DFS_VOLUME = 0x00000036;
    public static int FILE_DEVICE_SERENUM = 0x00000037;
    public static int FILE_DEVICE_TERMSRV = 0x00000038;
    public static int FILE_DEVICE_KSEC = 0x00000039;
    public static int FILE_DEVICE_FIPS = 0x0000003A;
    public static int FILE_DEVICE_INFINIBAND = 0x0000003B;
    public static int FILE_DEVICE_VMBUS = 0x0000003E;
    public static int FILE_DEVICE_CRYPT_PROVIDER = 0x0000003F;
    public static int FILE_DEVICE_WPD = 0x00000040;
    public static int FILE_DEVICE_BLUETOOTH = 0x00000041;
    public static int FILE_DEVICE_MT_COMPOSITE = 0x00000042;
    public static int FILE_DEVICE_MT_TRANSPORT = 0x00000043;
    public static int FILE_DEVICE_BIOMETRIC = 0x00000044;
    public static int FILE_DEVICE_PMI = 0x00000045;
    public static int FILE_DEVICE_EHSTOR = 0x00000046;
    public static int FILE_DEVICE_DEVAPI = 0x00000047;
    public static int FILE_DEVICE_GPIO = 0x00000048;
    public static int FILE_DEVICE_USBEX = 0x00000049;
    public static int FILE_DEVICE_CONSOLE = 0x00000050;
    public static int FILE_DEVICE_NFP = 0x00000051;
    public static int FILE_DEVICE_SYSENV = 0x00000052;
    public static int FILE_DEVICE_VIRTUAL_BLOCK = 0x00000053;
    public static int FILE_DEVICE_POINT_OF_SERVICE = 0x00000054;
    public static int FILE_DEVICE_STORAGE_REPLICATION = 0x00000055;
    public static int FILE_DEVICE_TRUST_ENV = 0x00000056;
    public static int FILE_DEVICE_UCM = 0x00000057;
    public static int FILE_DEVICE_UCMTCPCI = 0x00000058;
    public static int FILE_DEVICE_PERSISTENT_MEMORY = 0x00000059;
    public static int FILE_DEVICE_NVDIMM = 0x0000005a;
    public static int FILE_DEVICE_HOLOGRAPHIC = 0x0000005b;
    public static int FILE_DEVICE_SDFXHCI = 0x0000005c;
    public static int FILE_DEVICE_UCMUCSI = 0x0000005d;
}
