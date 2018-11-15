package com.recipes.recipes_service.repository;

import com.recipes.recipes_service.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientJpaRepository extends JpaRepository<IngredientEntity, Long> {

    IngredientEntity findByIngredientName(String ingredientName);
    List<IngredientEntity> findAllByOrderByIngredientNameAsc();
}
