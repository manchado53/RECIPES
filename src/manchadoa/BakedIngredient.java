/*
 * Course: CSC1110 - 111
 * Fall 2023
 * Lab 11 - Interfaces
 * Name: Adrian Manchado
 * Created: 11/14/2023
 */
package manchadoa;
/**
 * The class BakedIngredient takes an Ingredient and bakes it, making it dry
 * and changing its volume by an expansion factor
 * Implements the Ingredient interface
 */
public class BakedIngredient implements Ingredient {
    private final Ingredient baseIngredient;
    private final double expansionFactor;
    /**
     * Initializes the base ingredient and expansion factor variables
     * @param ingredient the ingredient object that we want to bake
     * @param expansionFactor the factor by the volume is going to change
     */
    public BakedIngredient(Ingredient ingredient, double expansionFactor) {
        this.baseIngredient = ingredient;
        this.expansionFactor = expansionFactor;
    }

    @Override
    public double getCalories() {
        return baseIngredient.getCalories();
    }

    @Override
    public double getCups() {
        return baseIngredient.getCups()*this.expansionFactor;
    }

    @Override
    public String getName() {
        return "Baked " + this.baseIngredient.getName();
    }

    @Override
    public boolean isDry() {
        return true;
    }

    @Override
    public void printRecipe() {
        // Recipe baked
        System.out.println("====================================================");
        System.out.println(getName());
        System.out.println("====================================================");
        System.out.println("Ingredient to be baked: " + this.baseIngredient.getName());
        System.out.println("Cups: " + CUP_FORMAT.format(getCups()) + " Cups");
        System.out.println("Energy: " + Math.round(getCalories()) + " Calories\n");

        //Recipe not baked
        this.baseIngredient.printRecipe();
    }
}