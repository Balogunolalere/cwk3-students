
/**
 * A ferry provides a one-way journey between two islands. It
 * has a ferry code and information about both the source and
 * the destination island
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ferry {
    // properties of the FerryJourney class
    /**
     *  The journey code is a unique number that identifies the ferry
     */
    private int journeyCode;
    /**
     *  The source island is the island from which the ferry departs
     */
    private Island source;
    /**
     *  The destination island is the island to which the ferry arrives
     */
    private Island destination;
    /**
     *  The price is the number of credits required to make the journey
     */
    private int price;

    // constructor for the FerryJourney class

    /**
     * Constructor for objects of class FerryJourney
     */
    public Ferry(int journeyCode, Island source, Island destination, int price) {
        this.journeyCode = journeyCode;
        this.source = source;
        this.destination = destination;
        this.price = price;
    }

    // getters and setters for the FerryJourney class properties
    /**
     * @return the journeyCode
     */
    public int getJourneyCode() {
        return journeyCode;
    }

    /**
     * @param journeyCode the journeyCode to set
     */
    public void setJourneyCode(int journeyCode) {
        this.journeyCode = journeyCode;
    }

    /**
     * @return the source
     */
    public Island getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(Island source) {
        this.source = source;
    }

    /**
     * @return the destination
     */
    public Island getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(Island destination) {
        this.destination = destination;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    // method to make a ferry journey
    /**
     * The makeJourney method makes a ferry journey from the source island to the destination island
     * 
     * @param pass the pass to be used to make the journey
     * @return a message indicating whether the journey was successful or not
     */
    public String makeJourney(Pass pass) {
        // check that the pass is allowed on the source island
        if (!this.source.isAllowed(pass.getLuxuryRating())) {
            return  "Sorry, the pass with ID " + pass.getId() + " is not allowed on the source island.";
        }
        // check that the pass is allowed on the destination island
        if (this.destination.isAtCapacity()) {
            return "Sorry, the destination island is at capacity.";
            
        }
        // check that the pass has enough credits to make the journey
        if (pass.getCredits() < this.price) {                    
            return "Sorry, the pass with ID " + pass.getId() + " does not have enough credits for this journey.";
        }
        // check that the pass is listed on the source island
        if (!this.source.getPasses().contains(pass)) {
            return "Sorry, the pass with ID " + pass.getId() + " is not listed on the source island.";
            
        }
        // make the journey
        this.source.removePass(pass);
        this.destination.addPass(pass);
        pass.setCredits(pass.getCredits() - this.price);
       return "The pass with ID " + pass.getId() + " has successfully made the ferry journey from " + this.source.getName() + " to " + this.destination.getName() + ".";
    }
}