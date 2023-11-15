/*
 * Course: CSC1110 - 111
 * Fall 2023
 * Lab 11 - Interfaces
 * Name: Adrian Manchado
 * Created: 11/14/2023
 */
package manchadoa;
/**
 * The class SimpleIngredient creates a simple ingredient and implements
 * the Ingredient interface
 */
public class SimpleIngredient implements Ingredient {
    private final double calories;
    private final double cups;
    private final boolean isDry;
    private final String name;
    /**
     * Initializes the variables calories, cups, isDry and name, to what we pass into
     * @param calories the calories of the simple ingredient
     * @param cups the volume of the simple ingredient
     *@param isDry the state of the simple ingredient
     * @param name the name of the simple ingredient
     */
    public SimpleIngredient(double calories, double cups, boolean isDry, String name){
        this.calories = calories;
        this.cups = cups;
        this.isDry = isDry;
        this.name = name;
    }
    @Override
    public double getCalories() {
        return calories;
    }
    @Override
    public double getCups() {
        return cups;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public boolean isDry() {
        return isDry;
    }
    @Override
    public void printRecipe(){
        System.out.println("====================================================");
        System.out.println(getName());
        System.out.println("====================================================");
        System.out.println("Cups: " + CUP_FORMAT.format(getCups()) + " Cups");
        System.out.println("Energy: " + Math.round(getCalories())+ " Calories\n");
    }
}
