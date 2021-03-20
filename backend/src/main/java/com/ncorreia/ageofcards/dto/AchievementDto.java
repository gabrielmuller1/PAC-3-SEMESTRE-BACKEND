package com.ncorreia.ageofcards.dto;

import java.io.Serializable;
import java.time.Instant;

import com.ncorreia.ageofcards.entities.Achievement;

public class AchievementDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private Instant moment;
	private Integer points;
	private Long userDtoId;
	
	public AchievementDto() {}

	public AchievementDto(Long id, Instant moment, Integer points, Long userDtoId) {
		this.id = id;
		this.moment = moment;
		this.points = points;
		this.userDtoId = userDtoId;
	};
	
	public AchievementDto(Achievement achievement) {
		this.id = achievement.getId();
		this.moment = achievement.getMoment();
		this.points = achievement.getPoints();
		this.userDtoId = achievement.getUser().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Long getUserDtoId() {
		return userDtoId;
	}
}
