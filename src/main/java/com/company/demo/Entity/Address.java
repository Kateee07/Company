package com.company.demo.Entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Address {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;
    private String city;
    private String street;
    private String houseNumber;
    private String postCode;
    @NotNull
    @OneToOne(cascade = {CascadeType.DETACH,
    CascadeType.MERGE, CascadeType.PERSIST, CascadeType.PERSIST})
    private Employee employee;

    public Address( String city, String street, String houseNumber, String postCode) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postCode = postCode;
    }
}

