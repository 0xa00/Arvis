cmake_minimum_required(VERSION 3.17)
project(Arvis C)

set(CMAKE_C_STANDARD 99)

list(APPEND CMAKE_MODULE_PATH "~/Arvis/cmakemodules")
find_package(WDK REQUIRED)

wdk_add_driver(Driver
        KMDF 1.15
        driver/driver.c
        )

find_package(JNI)

if (JNI_FOUND)
    message (STATUS "JNI_INCLUDE_DIRS=${JNI_INCLUDE_DIRS}")
    message (STATUS "JNI_LIBRARIES=${JNI_LIBRARIES}")
else()
    message (STATUS "Failed to find JNI, make sure you have Java installed then try compiling again.")
endif()

add_library(Library
        SHARED
        library/library.c
        library/exports/KernelDriver.h
        driver/driver.c driver/structures.h)

target_include_directories(Library PRIVATE ${JNI_INCLUDE_DIRS})