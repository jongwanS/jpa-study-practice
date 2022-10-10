package jpabook.ch9;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PhoneServiceProvier {
    @Id
    String name;
}
