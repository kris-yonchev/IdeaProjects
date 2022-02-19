package workingWithAbstraction.hotelReservation;

public class PriceCalculator {
    public static double CalculatePrice(double pricePerDay, int numberOfDays, Season season, Discount discount) {
        int multiplier = season.getValue();
        double discountMultiplier = discount.getValue() / 100.0;
        double basePrice = numberOfDays * pricePerDay * multiplier;
        double discountAmount = basePrice * discountMultiplier;
        return basePrice - discountAmount;
    }
}
