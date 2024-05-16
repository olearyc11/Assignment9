package com.coderscampus.Assignment9.web;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.Assignment9.domain.Recipe;
import com.coderscampus.Assignment9.service.RecipeService;

@RestController
public class RecipeController {

	@Autowired
	private RecipeService recipeService;

	@GetMapping("/all-recipes")
	public List<Recipe> getAllRecipes() {
		return recipeService.returnRecipes();
	}

	@GetMapping("/gluten-free")
	public List<Recipe> gfRecipes() {
		return recipeService.getGlutenFree();
	}

	@GetMapping("/vegan")
	public List<Recipe> veganRecipes() {
		return recipeService.getVegan();
	}

	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> veganAndGF() {
		return recipeService.getVeganAndGF();

	}

	@GetMapping("/vegetarian")
	public List<Recipe> vegetatian() {
		return recipeService.getVegetarian();
	}
}
