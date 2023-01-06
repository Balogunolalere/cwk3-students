public class BusinessPass extends Pass {
    private int loyaltyPoints;

    public BusinessPass(int id, String name, int luxuryRating, int credits, int loyaltyPoints) {
        super(id, name, luxuryRating, credits, loyaltyPoints);
        this.loyaltyPoints = loyaltyPoints;
    }

    public void makeJourney() {
        // Deduct 3 credits and add 2 loyalty points whenever a ferry journey is made
        setCredits(getCredits() - 3);
        loyaltyPoints += 2;
    }

    public void convertLoyaltyPointsToCredits(int points) {
        int credits = points / 3;
        setCredits(getCredits() + credits);
        loyaltyPoints -= points;
    }

    @Override
    public String toString() {
        return super.toString() + ", Loyalty Points: " + loyaltyPoints;
    }
}
