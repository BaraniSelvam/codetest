package com.gcd.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class QueueObj {

    @XmlElement
    public int value1;
    @XmlElement
    public int value2;
    @XmlElement
    public int gcd;


    public QueueObj() {
    }

    public QueueObj(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public QueueObj(int value1, int value2, int gcd) {
        this.value1 = value1;
        this.value2 = value2;
        this.gcd = gcd;
    }

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }
}
