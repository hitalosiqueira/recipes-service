package com.recipes.recipes_service.repository;

import com.recipes.recipes_service.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeJpaRepository extends JpaRepository<RecipeEntity, Long> {

}
