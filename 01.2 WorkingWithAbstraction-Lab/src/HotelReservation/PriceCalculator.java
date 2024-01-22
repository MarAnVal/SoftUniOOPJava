package HotelReservation;

public class PriceCalculator {
    public static double calculatePrice(double pricePerDay, int numberOfDays, Season season, Discount discountType){

        return pricePerDay * numberOfDays * season.getMultiplier() * discountType.getMultiplier();
    }
}
