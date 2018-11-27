package com.example.demo;

import com.example.demo.security.User;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface FlightRepository extends CrudRepository<Flight, Long> {

     List<Flight> findByFrom_CodeAndTo_Code(String fromCode, String toCode);

    // List<Flight> findAllUsersIn(ArrayList<User> users);
    Iterable<Flight> findByUsersIn(ArrayList<User> users);

}
