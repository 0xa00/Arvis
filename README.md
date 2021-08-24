# Arvis

Arvis is a Java application that can control a kernel mode device.

I made this for easier hacking of EAC and BattlEye protected games and decided to release it.

Please note that if you attempt to use this for an anti-cheat bypass, you may need to change the driver code.

## Features that are not implemented yet

- IOCTL output writing to Java
- Flexible data types
- Better control code processing

## Usage

Compiling the driver requires [WDK](https://docs.microsoft.com/en-us/windows-hardware/drivers/download-the-wdk).

To create a control code, you may use the `ControlCode` class as such:

```java
ControlCode.getControlCode(ControlCode.FILE_DEVICE_UNKNOWN,
                           0x001,
                           ControlCode.METHOD_BUFFERED,
                           ControlCode.FILE_SPECIAL_ACCESS)
```

To create a data type, see subclasses of `DataType`, such as `CHARARRAY`:

```java
public final class KernelDebugStructure extends KernelStructure {
    public CHARARRAY debugMessage = new CHARARRAY(24);
    ...
```

# Data types

`CHARARRAY`
A fixed size array of bytes (`char`).
```java
CHARARRAY str = new CHARARRAY(16);
...
str.update("Some String");
```
At the driver part:
```c
CHAR szChars[16];
```

## License

The Unlicense
