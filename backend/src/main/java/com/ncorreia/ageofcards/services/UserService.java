package com.ncorreia.ageofcards.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.ncorreia.ageofcards.dto.UserDto;
import com.ncorreia.ageofcards.entities.User;
import com.ncorreia.ageofcards.repositories.UserRepository;

public class UserService implements UserDetailsService{
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public Page<UserDto> findAllPaged(PageRequest pageRequest) {
		Page<User> list = userRepository.findAll(pageRequest);
		return list.map(user -> new UserDto(user));
	}
	
	/*@Transactional(readOnly = true)
	public UserDto findById(Long id) {
		
	}*/
	
	/*@Transactional
	public UserDto insert(UserInsertDto userDto) {
		
	}*/

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		
		if (user == null) {
			logger.error("User not found: " + username);
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		logger.info("User found: " + username);
		return user;
	}

}
