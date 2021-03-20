package com.ncorreia.ageofcards.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncorreia.ageofcards.entities.Achievement;

public interface AchievementRepository extends JpaRepository<Achievement, Long>{
	
}
