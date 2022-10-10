package jpabook.ch9;

import javax.persistence.Embeddable;

@Embeddable
public class Zipcode {
    String zip;
    String plusFour;

    public Zipcode() {
    }

    public Zipcode(String zip) {
        this.zip = zip;
    }

}
