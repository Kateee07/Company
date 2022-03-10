package com.company.demo.Repositories;

import com.company.demo.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Address, Integer> {

}
