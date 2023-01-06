public class EmployeePass extends Pass {
    private int employeeNumber;
    private String jobDescription;
    private int journeyScore;

    public EmployeePass(int id, String name, int employeeNumber, String jobDescription) {
        super(id, name, 10, 0, employeeNumber); // Employees can visit all islands and have no credits
        this.employeeNumber = employeeNumber;
        this.jobDescription = jobDescription;
        this.journeyScore = 0;
    }

    public void makeJourney() {
        // Deduct zero credits for a journey, but add 1 to the journey score whenever a ferry journey is made
        journeyScore++;
    }

    @Override
    public String toString() {
        return super.toString() + ", Employee Number: " + employeeNumber + ", Job Description: " + jobDescription
                + ", Journey Score: " + journeyScore;
    }
}
