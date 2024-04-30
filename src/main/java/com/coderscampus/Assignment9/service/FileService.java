package com.coderscampus.Assignment9.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment9.domain.Recipe;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

	@SuppressWarnings("deprecation")
	public List<Recipe> readFile() throws IOException{

		List<Recipe> recipes = new ArrayList<>();

		Reader in = new FileReader("recipes.txt");
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withIgnoreSurroundingSpaces().withFirstRecordAsHeader()
				.parse(in);
		for (CSVRecord record : records) {
			Integer cookingMin = Integer.parseInt(record.get("Cooking Minutes"));
			Boolean dairyFree = Boolean.parseBoolean(record.get("Dairy Free"));
			Boolean glutenFree = Boolean.parseBoolean(record.get("Gluten Free"));
			String instructions = record.get("Instructions");
			Double prepMin = Double.parseDouble(record.get("Preparation Minutes"));
			Double pricePerServing = Double.parseDouble(record.get("Price Per Serving"));
			Integer readyTime = Integer.parseInt(record.get("Ready In Minutes"));
			Integer servings = Integer.parseInt(record.get("Servings"));
			Double spoonacularScore = Double.parseDouble(record.get("Spoonacular Score"));
			String title = record.get("Title");
			Boolean vegan = Boolean.parseBoolean(record.get("Vegan"));
			Boolean vegetarian = Boolean.parseBoolean(record.get("Vegetarian"));

			Recipe recipe = new Recipe(cookingMin, dairyFree, glutenFree, instructions, prepMin, pricePerServing,
					readyTime, servings, spoonacularScore, title, vegan, vegetarian);
			recipes.add(recipe);
		}
		return recipes;
	}

}
