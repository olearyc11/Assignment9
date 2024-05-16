package com.coderscampus.Assignment9.service;

import java.io.IOException;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment9.domain.Recipe;

import jakarta.annotation.PostConstruct;


@Service
public class RecipeService {

	@Autowired
	private FileService fileService;
	private List<Recipe> recipes;
	
	@PostConstruct
	private void loadRecipes() throws IOException {
		recipes = fileService.readFile();
	}
	
	public List<Recipe> returnRecipes() {
		return recipes;
	}
	
	public List<Recipe> getVegan() {
		return recipes.stream()
					  .filter(recipe -> recipe.getVegan() != false)
					  .collect(Collectors.toList());
		}
	
	public List<Recipe> getGlutenFree() {
		return recipes.stream()
					  .filter(recipe -> recipe.getGlutenFree() != false)
					  .collect(Collectors.toList());
		}
	
	public List<Recipe> getVeganAndGF() {
		return recipes.stream()
					  .filter(recipe -> recipe.getVegan() != false && recipe.getGlutenFree() != false)
					  .collect(Collectors.toList());
		}

	public List<Recipe> getVegetarian() {
		return recipes.stream()
					  .filter(recipe -> recipe.getVegetarian() != false)
					  .collect(Collectors.toList());
		}

}

