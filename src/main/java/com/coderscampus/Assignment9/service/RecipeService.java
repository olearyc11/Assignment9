package com.coderscampus.Assignment9.service;

import java.io.IOException;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment9.domain.Recipe;


@Service
public class RecipeService {

	@Autowired
	private FileService fileService;
	private List<Recipe> recipes;
	
	public List<Recipe> returnRecipes() throws IOException {
		recipes = fileService.readFile();
		return recipes;
			
	}
}
