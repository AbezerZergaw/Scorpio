package com.example.demo.security;

import com.example.demo.Flight;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
  // User findByFlightId()
 //   List<User> findAllFlightsIn(ArrayList<Flight> flights);


}
