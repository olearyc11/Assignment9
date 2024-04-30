package com.coderscampus.Assignment9.web;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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
	public List<Recipe> getAllRecipes() throws IOException {
		return recipeService.returnRecipes();
	}

	@GetMapping("/gluten-free")
	public List<Recipe> gfRecipes() throws IOException {
		List<Recipe> recipeList = recipeService.returnRecipes();
		List<Recipe> gfList = recipeList.stream().filter(recipe -> recipe.getGlutenFree() != false)
				.collect(Collectors.toList());
		return gfList;
	}

	@GetMapping("/vegan")
	public List<Recipe> veganRecipes() throws IOException {
		List<Recipe> recipeList = recipeService.returnRecipes();
		List<Recipe> veganList = recipeList.stream().filter(recipe -> recipe.getVegan() != false)
				.collect(Collectors.toList());
		return veganList;
	}

	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> veganAndGF() throws IOException {
		List<Recipe> recipeList = recipeService.returnRecipes();
		List<Recipe> veganAndGF = recipeList.stream()
				.filter(recipe -> recipe.getVegan() != false && recipe.getGlutenFree() != false)
				.collect(Collectors.toList());
		return veganAndGF;

	}

	@GetMapping("/vegetarian")
	public List<Recipe> vegetatian() throws IOException {
		List<Recipe> recipeList = recipeService.returnRecipes();
		List<Recipe> vegetarianList = recipeList.stream().filter(recipe -> recipe.getVegetarian() != false)
				.collect(Collectors.toList());
		return vegetarianList;
	}
}
