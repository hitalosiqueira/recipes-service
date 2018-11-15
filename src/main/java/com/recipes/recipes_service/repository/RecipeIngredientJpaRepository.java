package com.recipes.recipes_service.repository;

import com.recipes.recipes_service.entity.RecipeIngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeIngredientJpaRepository extends JpaRepository<RecipeIngredientEntity, Long> {
    //List<RecipeIngredientEntity>
}
