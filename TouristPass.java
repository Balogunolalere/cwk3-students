public class TouristPass extends Pass {
    private String citizenship;

    public TouristPass(int id, String name, int luxuryRating, int credits, String citizenship) {
        super(id, name, luxuryRating, credits, credits);
        this.citizenship = citizenship;
    }

    public void makeJourney() {
        // Deduct 4 credits whenever a ferry journey is made
        setCredits(getCredits() - 4);
    }

    @Override
    public String toString() {
        return super.toString() + ", Citizenship: " + citizenship;
    }
}
