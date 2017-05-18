package com.gcd.dao;

import javax.persistence.*;

@Entity
public class GCDEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GCD_SEQ")
    @SequenceGenerator(sequenceName = "gcd_seq", allocationSize = 1, name = "GCD_SEQ")
    Long id;

    @Column(name = "FirstValue")
    int number1;

    @Column(name = "SecondValue")
    int number2;

    @Column(name = "GCD")
    int gcd;

    public GCDEntity(int integer1, int integer2) {
        this.number1 = integer1;
        this.number2 = integer2;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public int getGcd() {
        return gcd;
    }

    public void setGcd(int gcd) {
        this.gcd = gcd;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj == null || obj.getClass() != getClass()) {
            result = result;
        } else {
            GCDEntity gcd = (GCDEntity)obj;
          if (this.number1 == gcd.number1 && this.number2 == gcd.number2){
              result= true;
          }
        }
        return result;
    }


}
