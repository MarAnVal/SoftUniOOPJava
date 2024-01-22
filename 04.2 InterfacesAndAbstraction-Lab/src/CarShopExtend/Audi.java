package CarShopExtend;

public class Audi extends CarImpl implements Rentable {
    private Integer minRentDay;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer minRentDay, Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }
    //+toString(): String

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        text.append(super.toString());
        text.append(System.lineSeparator());
        text.append(
         String.format("Minimum rental period of %d days. Price per day %f",
                this.getMinRentDay(),
                this.getPricePerDay()));
        return text.toString();
    }
}
