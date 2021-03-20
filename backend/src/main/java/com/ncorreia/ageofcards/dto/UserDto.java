package com.ncorreia.ageofcards.dto;

import java.util.ArrayList;
import java.util.List;

import com.ncorreia.ageofcards.entities.Achievement;
import com.ncorreia.ageofcards.entities.User;

public class UserDto {
	private Long id;
	private String name;
	private String lastName;
	private String email;
	
	private List<AchievementDto>  achievementDto = new ArrayList<>();
	
	public UserDto() {}

	public UserDto(Long id, String name, String lastName, String email) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
	};
	
	public UserDto(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
	}
	
	public UserDto(User user, List<Achievement> achievements) {
		this(user);
		achievements.forEach(ach -> this.achievementDto.add(new AchievementDto(ach)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<AchievementDto> getAchievementDto() {
		return achievementDto;
	}
}
