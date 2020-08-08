package com.bucur.recap.relationships;

public class SmartPhone {

    Battery battery;    // aggregation
    IMEINumber imeiNumber;  // composition

    public SmartPhone() {
    }

    public SmartPhone(IMEINumber imeiNumber) {
        this.imeiNumber = imeiNumber;
    }

}
