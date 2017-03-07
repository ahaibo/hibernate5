package com.hai.component;

import javax.persistence.Embeddable;

/**
 * Created by as on 2017/3/1.
 */
@Embeddable
public class Phone {

    private String phoneType;
    private String phoenNumber;

    public Phone() {
    }

    public static Phone newInstance(String phoneType, String phoenNumber) {
        return new Phone(phoneType, phoenNumber);
    }

    public Phone(String phoneType, String phoenNumber) {
        this.phoneType = phoneType;
        this.phoenNumber = phoenNumber;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhoenNumber() {
        return phoenNumber;
    }

    public void setPhoenNumber(String phoenNumber) {
        this.phoenNumber = phoenNumber;
    }
}
