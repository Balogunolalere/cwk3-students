import java.util.*;

/**
 * An island is part of a FIRE resort.Each island has a name, a luxury rating
 * and a capacity which represents the maximum number of people(passes) who can
 * be on the
 * island at any one time. Each island must maintain a list of all people
 * (passes)
 * currently on the island. These lists are updated whenever passes enter or
 * leave
 * an island,so that it is always possible to say which passes are on the island
 * 
 * 
 * @author (your name)
 * @version (a version number or a date)
 */

public class Island {
    // properties of the Island class
    /**
     * The id is a unique number that identifies the island
     */
    private int id;
    /**
     * The name is the name of the island
     */
    private String name;
    /**
     * The rating is the luxury rating of the island
     */
    private int rating;
    /**
     * The capacity is the maximum number of people who can be on the island at
     * any one time
     */
    private int capacity;
    /**
     * The passes is a list of all the people currently on the island
     */
    private List<Pass> passes;

    // constructor for the Island class
    public Island(int id, String name, int rating, int capacity) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.capacity = capacity;
        this.passes = new ArrayList<>();
    }

    // getters and setters for the Island class properties
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /*
     * @param for getting the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @param for the rating to set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /*
     * @return the passes
     */
    public List<Pass> getPasses() {
        return passes;
    }

    /**
     * @param passes the passes to set
     */
    public void setPasses(List<Pass> passes) {
        this.passes = passes;
    }

    // methods for the Island class
    public String toString() {
        return "Island " + this.id + " " + this.name + " " + this.rating + " "
                + this.capacity;
    }

    /**
     * @param luxuryRating
     * @return true if the island is allowed for the given luxury rating
     */
    public boolean isAllowed(int luxuryRating) {
        return luxuryRating <= this.rating;
    }

    /**
     * @return true if the island is at capacity
     */
    public boolean isAtCapacity() {
        return this.passes.size() >= this.capacity;
    }

    /**
     * @param pass
     * @return true if the pass is on the island
     */
    public void addPass(Pass pass) {
        this.passes.add(pass);
    }

    /**
     * @param pass
     * @return true if the pass is on the island
     */
    public void removePass(Pass pass) {
        this.passes.remove(pass);
    }

    /**
     * @param pass
     * @return true if the pass is on the island
     */
    public boolean isOnIsland(Pass pass) {
        return this.passes.contains(pass);
    }
}
