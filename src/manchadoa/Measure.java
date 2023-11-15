/*
 * Course: CSC1110 - 111
 * Fall 2023
 * Lab 11 - Interfaces
 * Name: Adrian Manchado
 * Created: 11/14/2023
 */
package manchadoa;
/**
 * The class Measure takes an Ingredient and maintains the energy density of
 * the original ingredient, but measures a different quantity of it. The new
 * quantity becomes part of the ingredient's name.
 * Implements the Ingredient interface
 */
public class Measure implements Ingredient {
    private final Ingredient baseIngredient;
    private final int numerator;
    private final int denominator;
    /**
     * Initializes the numerator, denominator and baseIngredient variables
     * @param numerator the number the volume is going to be multiplied by
     * @param denominator the number the volume is going to be divided by
     * @param baseIngredient the ingredient we are going to measure
     */
    public Measure(int numerator, int denominator, Ingredient baseIngredient) {
        this.baseIngredient = baseIngredient;
        this.numerator = numerator;
        this.denominator = denominator;
    }
    /**
     * Initializes the numerator, denominator and baseIngredient variables, when
     * denominator is not provided is assigned to 1
     * @param numerator the number the volume is going to be multiplied by
     * @param baseIngredient  the ingredient we are going to measure
     */
    public Measure(int numerator, Ingredient baseIngredient){
        this (numerator, 1, baseIngredient);
    }

    @Override
    public double getCalories() {
        return ((double)numerator/denominator) * baseIngredient.getCalories() /
                baseIngredient.getCups();
    }

    @Override
    public double getCups() {
        return ((double)numerator)/denominator;
    }

    @Override
    public String getName() {
        return formatQuantity() + this.baseIngredient.getName();
    }

    @Override
    public boolean isDry() {
        return this.baseIngredient.isDry();
    }

    @Override
    public void printRecipe() {
        System.out.println("====================================================");
        System.out.println(getName());
        System.out.println("====================================================");
        System.out.println("Measured ingredient: " + this.baseIngredient.getName());
        System.out.println("Quantity: " + formatQuantity() +"(" +
                CUP_FORMAT.format(getCups()) + " Cups)");
        System.out.println("Energy: " + Math.round(getCalories())+ " Calories\n");
        this.baseIngredient.printRecipe();
    }
    private String formatQuantity(){
        String x;
        if (getCups() <= 1){
            if (numerator % denominator == 0) {
                x = numerator + " Cup ";
            } else {
                x = numerator + "/" + denominator + " Cup ";
            }
        } else {
            if (numerator % denominator == 0) {
                x = numerator + " Cups ";
            } else {
                x = numerator + "/" + denominator + " Cups ";
            }
        }
        return x;
    }
}
