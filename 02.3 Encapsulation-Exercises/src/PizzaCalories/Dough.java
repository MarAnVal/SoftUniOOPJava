package PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        //the flour can be white or wholegrain
        if (!(flourType.equals("White") || flourType.equals("Wholegrain"))) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        //the bakingTechnique can be crispy, chewy, or homemade
        if (!(bakingTechnique.equals("Crispy") || bakingTechnique.equals("Homemade") || bakingTechnique.equals("Chewy"))) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public void setWeight(double weight) {
        //weight is outside of the range [1..200]
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    //+ calculateCalories (): double
    //base(2.0) * weight * flourType * bakingTechnique
    public double calculateCalories() {
        double flour = 0.0;
        switch (this.flourType) {
            //White – 1.5;
            case "White":
                flour = 1.5;
                break;
            //Wholegrain – 1.0;
            case "Wholegrain":
                flour = 1.0;
                break;
        }
        double technique = 0.0;
        switch (this.bakingTechnique) {
            //Crispy – 0.9;
            case "Crispy":
                technique = 0.9;
                break;
            //Chewy – 1.1;
            case "Chewy":
                technique = 1.1;
                break;
            //Homemade – 1.0
            case "Homemade":
                technique = 1.0;
                break;
        }
        double base = 2.0;
        double result = this.weight * base * flour * technique;
        return result;
    }
}
