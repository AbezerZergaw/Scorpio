package com.example.demo;

import java.util.Arrays;

import com.example.demo.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	AirportRepository airportRepository;

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	UserService userService;


	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... strings) throws Exception {
		roleRepository.save(new Role("USER"));
		roleRepository.save(new Role("ADMIN"));

		Role adminRole = roleRepository.findByRole("ADMIN");
		Role userRole = roleRepository.findByRole("USER");

		User user = new User("JIM", "TOM", "2000-10-10", "Ethiopian", "3013698965", "hey@google.com",
				passwordEncoder.encode("password"), true, "admin");
		user.setRoles(Arrays.asList(adminRole));
		userRepository.save(user);

		user = new User("Tom", "seme", "2000-10-10", "Russian", "3013698965", "seme@gmail.com",
				passwordEncoder.encode("password"), true, "seme");
		user.setRoles(Arrays.asList(userRole));
		userRepository.save(user);

		// ---- initial flights data load

		Airport atl = new Airport("ATL", "Hartsfield–Jackson Atlanta International Airport", "Atlanta, GA", 50251962);
		airportRepository.save(atl);
		Airport lax = new Airport("LAX", "Los Angeles International Airport", "Los Angeles, CA", 41232416);
		airportRepository.save(lax);
		Airport ord = new Airport("ORD", "O'Hare International Airport", "Chicago, IL", 38593028);
		airportRepository.save(ord);
		Airport jfk = new Airport("JFK", "John F. Kennedy International Airport", "New York, NY", 29533154);
		airportRepository.save(jfk);
		Airport fll = new Airport("FLL", "Fort Lauderdale–Hollywood International Airport", "Fort Lauderdale, FL", 16216686);
		airportRepository.save(fll);
		Airport iad = new Airport("IAD", "Washington Dulles International Airport", "Washington, D.C.", 11407107);
		airportRepository.save(iad);

		// Inserting flight information data to the database

		flightRepository.save(new Flight("F2501", jfk, fll, "11:00", "2:00", 180, 120.2, 500.0, 550.0, "A321"));

		flightRepository.save(new Flight("F2501", fll, jfk, "13:00", "15:00", 181, 119.0, 481.2, 510.0, "A321"));

		Flight flight =flightRepository.save(new Flight("F2501", jfk, atl, "15:00", "18:00", 200, 150.0, 200.0, 410.0, "A323"));
		flight.addUser(user);
		flightRepository.save(flight);

		flightRepository.save(new Flight("F9011", jfk, fll, "1:00", "3:30", 195, 110.2, 494.0, 526.0, "A320"));
		flightRepository.save(new Flight("F9012", fll, jfk, "6:00", "9:00", 200, 110.2, 494.0, 560.0, "A320"));
		flightRepository.save(new Flight("F3513", atl, ord, "21:00", "22:30", 108, 90.9, 234.0, 300.0, "E757"));
		flightRepository.save(new Flight("F3514", ord, atl, "9:00", "10:30", 108, 90.9, 234.0, 300.0, "E777"));
		flightRepository.save(new Flight("F4979", ord, jfk, "12:30", "14:00", 180, 134.0, 515.8, 580.0, "E75L"));
		flightRepository.save(new Flight("F4978", jfk, ord, "12:30", "15:00", 180, 134.0, 515.8, 580.0, "E75L"));
		flightRepository.save(new Flight("F0570", jfk, lax, "9:00", "10:30", 200, 145.8, 634.0, 690.0, "B763"));
		flightRepository.save(new Flight("F0571", lax, jfk, "1:00", "3:30", 200, 150.8, 650.0, 710.0, "B767"));
		flightRepository.save(new Flight("F0574", lax, atl, "6:00", "9:00", 130, 200.8, 390.0, 450.0, "B787"));
		flightRepository.save(new Flight("F0577", atl, lax, "12:30", "3:00", 190, 250.5, 400.0, 500.0, "B777"));
		flightRepository.save(new Flight("F0579", iad, lax, "12:30", "15:00", 150, 350.5, 400.0, 500.0, "B787"));
		flightRepository.save(new Flight("F0578", lax, iad, "7:30", "9:00", 200, 250.5, 400.0, 600.0, "E767"));
		flightRepository.save(new Flight("F0578", iad, jfk, "19:30", "21:00", 200, 250.5, 400.0, 500.0, "E777"));
		flightRepository.save(new Flight("F0578", jfk, iad, "7:30", "9:00", 200, 250.5, 400.0, 650.0, "E787"));
		flightRepository.save(new Flight("F0571", fll, iad, "19:30", "21:00", 200, 250.5, 400.0, 500.0, "E777"));
		flightRepository.save(new Flight("F0571", atl, fll, "22:30", "23:55", 200, 250.5, 350.0, 500.0, "S800"));
		flightRepository.save(new Flight("F0571", fll, atl, "7:30", "9:55", 200, 250.5, 350.0, 550.0, "S767"));
		flightRepository.save(new Flight("F0571", ord, fll, "20:30", "22:55", 200, 250.5, 350.0, 500.0, "S787"));
		flightRepository.save(new Flight("F5001", fll, ord, "8:30", "10:55", 200, 250.5, 350.0, 500.0, "S787"));
		flightRepository.save(new Flight("F5002", iad, atl, "8:30", "10:55", 200, 250.5, 350.0, 500.0, "S787"));
		flightRepository.save(new Flight("F5003", atl, iad, "13:30", "15:55", 200, 250.5, 350.0, 700.0, "S787"));
		flightRepository.save(new Flight("F5003", ord, iad, "16:30", "18:55", 200, 250.5, 350.0, 700.0, "S787"));
		flightRepository.save(new Flight("F5003", iad, ord, "1:30", "3:55", 200, 250.5, 350.0, 700.0, "S787"));
	}
}
