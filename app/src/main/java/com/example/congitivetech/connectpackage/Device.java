package com.example.congitivetech.connectpackage;

import androidx.annotation.NonNull;

public class Device {

    private String deviceName;
    private String deviceHardwareAddress;

    public Device(String deviceName, String deviceHardwareAddress) {
        this.deviceName = deviceName;
        this.deviceHardwareAddress = deviceHardwareAddress;
    }

    public Device() {
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceHardwareAddress() {
        return deviceHardwareAddress;
    }

    public void setDeviceHardwareAddress(String deviceHardwareAddress) {
        this.deviceHardwareAddress = deviceHardwareAddress;
    }

    @NonNull
    @Override
    public String toString() {
        return deviceName;
    }
}
