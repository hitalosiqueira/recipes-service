package com.recipes.recipes_service.repository;

import com.recipes.recipes_service.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientJpaRepository extends JpaRepository<IngredientEntity, Long> {

}
