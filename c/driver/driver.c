#include <wdm.h>
#include "structures.h"

PDEVICE_OBJECT DeviceObject;
UNICODE_STRING dev, dos;

VOID DriverUnload(
        _In_ PDRIVER_OBJECT DriverObject
)
{
    IoDeleteSymbolicLink(&dos);
    IoDeleteDevice(DriverObject->DeviceObject);
}

NTSTATUS CreateCall(
        _In_ PDEVICE_OBJECT DeviceObject,
        _In_ PIRP Irp)
{
    Irp->IoStatus.Status = STATUS_SUCCESS;
    Irp->IoStatus.Information = 0;

    IoCompleteRequest(Irp, IO_NO_INCREMENT);
    return STATUS_SUCCESS;
}

NTSTATUS CloseCall(
        _In_ PDEVICE_OBJECT DeviceObject,
        _In_ PIRP Irp)
{
    Irp->IoStatus.Status = STATUS_SUCCESS;
    Irp->IoStatus.Information = 0;

    IoCompleteRequest(Irp, IO_NO_INCREMENT);
    return STATUS_SUCCESS;
}

NTSTATUS IoControl(
        _In_ PDEVICE_OBJECT DeviceObject,
        _In_ PIRP Irp)
{
    NTSTATUS Status;
    ULONG InformationSize;

    PIO_STACK_LOCATION IrpStack = IoGetCurrentIrpStackLocation(Irp);
    ULONG ControlCode = IrpStack->Parameters.DeviceIoControl.IoControlCode;
    if (ControlCode == IOCTL_KERNEL_DEBUG)
    {
        PKERNEL_DEBUG Structure = (PKERNEL_DEBUG)Irp->AssociatedIrp.SystemBuffer;
        DbgPrintEx(0, 0, "Arvis Kernel Debug: %s\n", Structure->szMessage);
        Status = STATUS_SUCCESS;
        InformationSize = sizeof(KERNEL_DEBUG);
    }
    else
    {
        Status = STATUS_INVALID_PARAMETER;
        InformationSize = 0ul;
    }

    // Complete the request
    Irp->IoStatus.Status = Status;
    Irp->IoStatus.Information = InformationSize;
    IoCompleteRequest(Irp, IO_NO_INCREMENT);

    return Status;
}

NTSTATUS DriverEntry(_In_ PDRIVER_OBJECT DriverObject,
                     _In_ PUNICODE_STRING RegistryPath)
{
    DriverObject->DriverUnload = (PDRIVER_UNLOAD) &DriverObject;

    RtlInitUnicodeString(&dev, L"\\Device\\kArvisDevice");
    RtlInitUnicodeString(&dos, L"\\DosDevices\\kArvisDevice");

    IoCreateDevice(DriverObject, 0, &dev, FILE_DEVICE_UNKNOWN, FILE_DEVICE_SECURE_OPEN, FALSE, &DeviceObject);
    IoCreateSymbolicLink(&dos, &dev);

    DriverObject->MajorFunction[IRP_MJ_CREATE] = CreateCall;
    DriverObject->MajorFunction[IRP_MJ_CLOSE] = CloseCall;
    DriverObject->MajorFunction[IRP_MJ_DEVICE_CONTROL] = IoControl;

    DeviceObject->Flags |= DO_DIRECT_IO;
    DeviceObject->Flags &= ~DO_DEVICE_INITIALIZING;

    return STATUS_SUCCESS;
}
