#include <Windows.h>
#include "exports/KernelDriver.h"

HANDLE hDriver = NULL;

//
// Opens a handle to a device by it's name
//
HANDLE ArOpenDevice(
        _In_ _Null_terminated_ LPCSTR szDeviceName
)
{
    return CreateFileA(szDeviceName, GENERIC_READ | GENERIC_WRITE,
                       FILE_SHARE_READ | FILE_SHARE_WRITE,
                       0, OPEN_EXISTING, 0, 0);
}

JNIEXPORT jobject JNICALL Java_arvis_kernel_KernelDriver_initiateKernelDriver
        (JNIEnv *env, jclass clKernelDriver, jstring jsDeviceName)
{
    LPCSTR szDeviceName = (*env)->GetStringUTFChars(env, jsDeviceName, 0);
    HANDLE hNewDriver = ArOpenDevice(szDeviceName);
    (*env)->ReleaseStringUTFChars(env, jsDeviceName, szDeviceName);
    if (hNewDriver == NULL)
    {
        return NULL;
    }
    jmethodID constructorId = (*env)->GetMethodID(env, clKernelDriver, "<init>", "()V");
    jobject obj = (*env)->NewObject(env, clKernelDriver, constructorId);
    return obj;
}

JNIEXPORT jboolean JNICALL Java_arvis_kernel_KernelDriver_DeviceIoControl0
        (JNIEnv *env, jclass clKernelDriver, jlong jlControlCode, jbyteArray jbaMemoryBuffer)
{
    jbyte *Buffer = (jbyte *)(*env)->GetByteArrayElements(env, jbaMemoryBuffer, NULL);
    SIZE_T nLength = (*env)->GetArrayLength(env, jbaMemoryBuffer);
    BOOLEAN bStatus = DeviceIoControl(hDriver, jlControlCode, &Buffer, nLength, &Buffer, nLength, 0, 0));
    (*env)->ReleaseByteArrayElements(env, jbaMemoryBuffer, Buffer, 0 );
    return bStatus;
}
