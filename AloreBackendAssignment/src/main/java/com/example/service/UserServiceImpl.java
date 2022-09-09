package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.FacilitiesRepository;
import com.example.repository.HotelRepository;
import com.example.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	HotelRepository hotelRepository;
	@Autowired
	FacilitiesRepository facilitiesRepository;

	@Override
	public User saveUser(User user) {
		log.info("user {}", user);
		user.getHotel().stream().forEach(hotel -> hotel.setUser(user));
		userRepository.save(user);
		return user;
	}
}
