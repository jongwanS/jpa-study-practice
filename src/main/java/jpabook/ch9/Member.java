package jpabook.ch9;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int age;

    @Embedded Period workPeriod;
    @Embedded Address homeAddress;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city", column = @Column(name = "COMPANY_CITY")),
            @AttributeOverride(name="street", column = @Column(name = "COMPANY_STREET")),
            @AttributeOverride(name="zipcode", column = @Column(name = "COMPANY_ZIPCODE")),
            @AttributeOverride(name="state", column = @Column(name = "COMPANY_STATE")),
            @AttributeOverride(name="zipcode.zip", column = @Column(name = "COMPANY_ZIP")),
            @AttributeOverride(name="zipcode.plusFour", column = @Column(name = "COMPANY_PLUSFOUR"))
    })
    Address compnayAddress;
    @Embedded PhoneNumber phoneNumber;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOODS", joinColumns = @JoinColumn(name = "MEMBER_ID"))
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "ADDRESS", joinColumns = @JoinColumn(name = "MEMBER_ID"))
    private List<Address> addressHistory = new ArrayList<>();

}
