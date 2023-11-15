/*
 * Course: CSC1110 - 111
 * Fall 2023
 * Lab 11 - Interfaces
 * Name: Adrian Manchado
 * Created: 11/14/2023
 */
package manchadoa;

import java.util.ArrayList;
import java.util.List;
/**
 * The class Mix makes a combination of several existing ingredients.
 * It stores them in a List of Ingredient type. It prints the recipe for the mix first
 * and then for each ingredient. The mix is wet if any of the ingredients is wet
 * Implements the Ingredient interface
 */
public class Mix implements Ingredient {
    private final List<Ingredient> ingredients;
    private final String name;
    /**
     * Initializes the name of the mix and the ArrayList that we are using
     * @param name the name of the mix
     */
    public Mix(String name) {
        this.name = name;
        this.ingredients = new ArrayList<>();
    }
    /**
     * Adds an ingredient to the List
     * @param ingredient the ingredient that we want to add
     */
    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }
    /**
     * Checks if any of the ingredient is dry by looping through the list
     * @return whether is true or false that has a dry ingredient
     */
    public boolean hasDryIngredient(){
        boolean hasDry = false;
        for (Ingredient x: this.ingredients){
            if (x.isDry()){
                hasDry = true;
            }
        }
        return hasDry;
    }
    /**
     * Checks if any of the ingredient is wet by looping through the list
     * @return whether is true or false that has a wet ingredient
     */
    public boolean hasWetIngredient() {
        boolean hasWet = false;
        for (Ingredient x: this.ingredients){
            if (!x.isDry()){
                hasWet = true;
            }
        }
        return hasWet;
    }
    @Override
    public double getCalories() {
        double calories = 0;
        for (Ingredient ingredient: this.ingredients){
            calories += ingredient.getCalories();
        }
        return calories;
    }

    @Override
    public double getCups() {
        double volume = 0;
        for (Ingredient ingredient: this.ingredients){
            volume += ingredient.getCups();
        }
        return volume;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isDry() {
        return !hasWetIngredient();
    }

    @Override
    public void printRecipe() {
        System.out.println("====================================================");
        System.out.println(this.name);
        System.out.println("====================================================");
        if (hasDryIngredient()){
            System.out.println("Dry Ingredients:");
            for (Ingredient ingredient: this.ingredients) {
                if (ingredient.isDry()) {
                    System.out.println("  "+ ingredient.getName());
                }
            }
            System.out.println();
        }
        if (hasWetIngredient()){
            System.out.println("Wet Ingredients:");
            for (Ingredient ingredient: this.ingredients){
                if (!ingredient.isDry()){
                    System.out.println("  " + ingredient.getName());
                }
            }
            System.out.println();
        }
        System.out.println("Cups: " + CUP_FORMAT.format(getCups()) + " Cups");
        System.out.println("Energy: " + Math.round(getCalories()) + " Calories\n");
        for (Ingredient ingredient: this.ingredients){
            ingredient.printRecipe();
        }
    }
}