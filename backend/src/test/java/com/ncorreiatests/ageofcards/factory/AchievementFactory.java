package com.ncorreiatests.ageofcards.factory;

import java.time.Instant;

import com.ncorreia.ageofcards.dto.AchievementDto;
import com.ncorreia.ageofcards.entities.Achievement;
import com.ncorreia.ageofcards.entities.User;

public class AchievementFactory {
	
	public static Achievement createAchievement() {
		return new Achievement(1L, Instant.parse("2021-03-20T03:00:00Z"), 5, new User());
	}
	
	public static AchievementDto createAchievementDto() {
		return new AchievementDto(1L, Instant.parse("2021-03-20T03:00:00Z"), 5, 1L);
	}
}
