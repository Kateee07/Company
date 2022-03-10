package com.company.demo.Entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class WorkPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private int id;
    @Column(name = "position")
    private String position;


    public double getBonusToPosition() {
        double prime = 0.0;
        if (position.equals("Worker")) {
            prime = 0.1;
        } else if (position.equals("Manager")) {
            prime = 0.4;
        } else if (position.equals("Director")) {
            prime = 0.6;
        }
        return prime;
    }
}
