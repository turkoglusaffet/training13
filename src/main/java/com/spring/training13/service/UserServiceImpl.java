package com.spring.training13.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.training13.entity.TblUser;
import com.spring.training13.jpa.UserRepository;


@Service("userRmiService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	public TblUser getUser(int id) {
		return userRepository.findById(id);
	}

}
