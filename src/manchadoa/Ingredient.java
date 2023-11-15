/*
 * Course: CSC1110 - 111
 * Fall 2023
 * Lab 11 - Interfaces
 * Name: Adrian Manchado
 * Created: 11/14/2023
 */
package manchadoa;
import java.text.DecimalFormat;
/**
 * The interface Ingredient contains the methods of the different type of ingredients
 */
public interface Ingredient {
    /**
     * The constant contains the object for formatting the cup quantities
     */
    public final DecimalFormat CUP_FORMAT = new DecimalFormat("#.##");
    /**
     * getCalories return the calories of each ingredient
     * @return the calories of an Ingredient
     */
    double getCalories();
    /**
     * getCups return the volume in cups of each ingredient
     * @return the volume in cups of an Ingredient
     */
    double getCups();
    /**
     * getName return the name of each ingredient
     * @return the name of an Ingredient
     */
    String getName();
    /**
     * Checks if an ingredient is dry
     * @return whether is true or false if it is dry
     */
    boolean isDry();
    /**
     * Prints the recipe of each ingredient
     */
    void printRecipe();
}