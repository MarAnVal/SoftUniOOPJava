package HotelReservation;

public enum Discount {
    //20% for VIP clients - VIP
    //· 10% for clients, visiting for a second time - SecondVisit
    //· 0% if there is no discount - None
    VIP(0.8), SecondVisit(0.9), None(1.0);
    private double multiplier;

    Discount(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }
}
