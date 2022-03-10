package com.company.demo.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Priority {
    @Id
    @GeneratedValue
    private int id;
    private String status;
}
