
/**
 * A Pass has an id number, name, a luxury rating,
 * number of credits and journey points
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pass 
{
   // fields
   private int passId;
   private String name;
   private int luxuryRating;
   private int credits;
   private int journeyPoints;
 
   public Pass(int id, String name, int luxuryRating, int credits, int journeyPoints) {
     this.passId = id;
     this.name = name;
     this.luxuryRating = luxuryRating;
     this.credits = credits;
     this.journeyPoints = journeyPoints;
   }
 
   // getId method
   public int getId() {
     return passId;
   }
   
   // setId method
   public void setId(int id) {
     this.passId = id;
   }
   
   // getName method
   public String getName() {
     return name;
   }
   
   // setName method
   public void setName(String name) {
     this.name = name;
   }
   
   // getLuxuryRating method
   public int getLuxuryRating() {
     return luxuryRating;
   }
   
   // setLuxuryRating method
   public void setLuxuryRating(int luxuryRating) {
     this.luxuryRating = luxuryRating;
   }
   
   // getCredits method
   public int getCredits() {
     return credits;
   }
   
   // setCredits method
   public void setCredits(int credits) {
     this.credits = credits;
   }
   
   // getJournerPoints method
   public int getJourneyPoints() {
     return journeyPoints;
   }
   
   // setJourneyPoints method
   public void setJourneyPoints(int journeyPoints) {
     this.journeyPoints = journeyPoints;
   }

   // useFerry method
   public void useFerry() {
     journeyPoints += 10;
   }

   // convertJourneyPoints method
   public void convertJourneyPoints() {
     credits += journeyPoints / 10;
     journeyPoints = 0;
   }

   // addCredits method
   public void addCredits(int credits) {
     this.credits += credits;
   }

   // deductCredits method
   public void deductCredits(int credits) {
     this.credits -= credits;
   }

   // toString method
   public String toString() {
     return "Pass [id=" + passId + ", name=" + name + ", luxuryRating=" + luxuryRating + ", credits=" + credits
         + ", journeyPoints=" + journeyPoints + "]";
   }
   
  

}

