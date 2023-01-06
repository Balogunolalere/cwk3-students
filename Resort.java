import java.util.*;

/**
 * This class implements the FIRE interface
 *
 * @author A.A.Marczyk
 * @version 05/11/22
 **/
public class Resort implements FIRE // do not change this header
{

    private List<Island> islands;
    private List<Ferry> ferries;
    private List<Pass> passes;
    private String location;
    // Other fields (including collections)

    /**
     * constructor
     * Some code has been provided
     */
    public Resort(String loc) {
        islands = new ArrayList<Island>();
        ferries = new ArrayList<Ferry>();
        passes = new ArrayList<Pass>();
        location = loc;
        loadIslandsAndFerries();
        loadPasses();
        // Ensure all passes are added to Base Island
        // you may do this here or in one of the above method
    }

    /**
     * Returns information about the resort including its location/name and all
     * passes currently on each island, or "No passes" (if no pass on that island
     * 
     * @return all of the details of all islands including location
     *         and all passes currently on each island, or "No passes" if island has
     *         no passes
     */
    public String toString() {
        String s = "";

        for (Island island : islands) {
            if (island.getPasses().size() == 0) {
                s += island.getName() + ": No passes\n";
            } else {
                s += island.getName() + ": " + island.getPasses() + "\n";
            }
        }

        return s;
    }

    /**
     * Returns a String representation of all the passes on all islands
     * with "No passes" if there are no passes on an island
     * 
     * @return a String representation of all passes on all islands
     **/
    public String getAllPassesOnAllIslands() {
        String s = "\nLocation of Passes\n";

        for (Island island : islands) {
            s += island.getName() + ": ";
            if (island.getPasses().size() > 0) {
                for (Pass pass : island.getPasses()) {
                    s += pass.getId() + " ";
                }
            } else {
                s += "No passes";
            }
            s += "\n";
        }

        return s;
    }

    /**
     * Returns the name of the island which contains the specified pass or "Not
     * found"
     * 
     * @param cd -the id of the pass
     * @return the name of the Island which contains the pass, or "Not found"
     **/
    public String findPassLocation(int cd) {
        // loop through all islands
        for (Island island : islands) {
            // loop through all passes on the island
            for (Pass pass : island.getPasses()) {
                // if the pass has the same id as the input id
                if (pass.getId() == cd) {
                    // return the name of the island
                    return island.getName();
                }
            }
        }
        // if no pass with the given id is found, return "Not found"
        return "Not found";
    }

    /**
     * Returns details of the pass with the specified id or "Not found"
     * 
     * @param cd - the id of the pass
     * @return the details of the pass, or "Not found"
     **/
    public String viewAPass(int cd) {
        {
            // loop through all passes to find one with matching id
            for (Pass pass : passes) {
                if (pass.getId() == cd) {
                    // return details of pass if found
                    return pass.toString();
                }
            }
            // return "Not found" if pass with matching id is not found
            return "Not found";
        }
    }

    /**
     * Given the name of a island, returns the island id number
     * or -1 if island does not exist
     * 
     * @param island is the name of island
     * @return id number of island
     */
    public int getIslandNumber(Island isl) {
        for (Island island : islands) {
            if (island.getName().equals(isl.getName())) {
                return island.getId();
            }
        }
        return -1;
    }

    /**
     * Returns a String representation of all passes on a specified island
     * 
     * @param isl - the name of the island
     * @return a String representation of all passes on specified island
     **/
    public String getAllPassesOnIsland(String isl) {
        String s = "\nPasses on \n";
        for (Island island : islands) {
            if (island.getName().equals(isl)) {
                List<Pass> passes = island.getPasses();
                if (passes.size() == 0) {
                    s += "No passes\n";
                } else {
                    for (Pass pass : passes) {
                        s += pass.toString() + "\n";
                    }
                }
            }
        }

        return s;
    }

    /**
     * Returns true if a Pass is allowed to journey using a ferry, false otherwise
     * A journey can be made if:
     * the rating of the pass >= the rating of the destination island
     * AND the destination island is not full
     * AND the pass has sufficient credits (a journey costs 3 credits)
     * AND the pass is currently in the source island
     * AND the pass id and ferry code represent objects in the system
     * 
     * @param cdId    is the id of the pass requesting the move
     * @param ferCode is the code of the ferry journey by which the pass wants to
     *                move
     * @return true if the pass is allowed on the ferry journey, false otherwise
     **/
    public boolean canTravel(int cdId, String ferCode) {

        if (getIslandNumber(findPassLocation(cdId)) == -1) {
            return false;
        }
        Pass pass = getPass(cdId);
        Ferry ferry = getFerry(ferCode);
        Island sourceIsland = getIsland(getIslandNumber(findPassLocation(cdId)));
        Island destinationIsland = getIsland(getIslandNumber(ferry.getDestination()));
        if (pass.getLuxuryRating() >= destinationIsland.getRating()
                && destinationIsland.getPasses().size() < destinationIsland.getCapacity() && pass.getCredits() >= 3
                && sourceIsland.getPasses().contains(pass) && passes.contains(pass) && ferries.contains(ferry)) {
            return true;
        }
        return false;

    }

    /**
     * Returns the result of a pass requesting to journey by Ferry.
     * A journey will be successful if:
     * the luxury rating of the pass >= the luxury rating of the destination island
     * AND the destination island is not full
     * AND the pass has sufficient credits
     * AND the pass is currently in the source island
     * AND both the pass id and the ferry code is on the system
     * If the ferry journey can be made, the pass is removed from the source island,
     * added to the destination island and a suitable message returned. Pass
     * information should be updated (A journey costs 3 credits and journey points
     * incremented by 1)
     * If the ferry journey cannot be made, the state of the system remains
     * unchanged
     * and a message specifying the reason is returned.
     * 
     * @param pPassId is the id of the pass requesting the move
     * @param ferCode is the code of the ferry by which the pass wants to travel
     * @return a String giving the result of the request
     **/
    public String travel(int pPassId, String ferCode) { // other checks optional

        String s = "";
        if (!canTravel(pPassId, ferCode)) {
            s += "Pass " + pPassId + " cannot travel by ferry " + ferCode;
        } else {
            Pass pass = getPass(pPassId);
            Ferry ferry = getFerry(ferCode);
            Island sourceIsland = getIsland(getIslandNumber(findPassLocation(pPassId)));
            Island destinationIsland = getIsland(getIslandNumber(ferry.getDestination()));
            sourceIsland.removePass(pass);
            destinationIsland.addPass(pass);
            pass.setCredits(pass.getCredits() - 3);
            pass.setJourneyPoints(pass.getJourneyPoints() + 1);
            s += "Pass " + pPassId + " travelled by ferry " + ferCode + " from " + sourceIsland.getName() + " to "
                    + destinationIsland.getName();
        }
        return s;
    }

    /**
     * Allows credits to be added to a pass.
     * 
     * @param id    the id of the pass toping up their credits
     * @param creds the number of credits to be added to pass
     */
    public void topUpCredits(int id, int creds) {
        if (passes.contains(getPass(id))) {
            getPass(id).addCredits(creds);
        }

    
    }

    /**
     * Converts a pass's journey points into credits
     * 
     * @param id the id of the pass whose points are to be converted
     */
    public void convertPoints(int id) {
        if (passes.contains(getPass(id))) {
            getPass(id).convertJourneyPoints();
        }
    }

    // ***************private methods**************
    private void loadPasses() {
        Pass pass1 = new Pass(1, "John", 1, 10, 15);
        Pass pass2 = new Pass(2, "Mary", 2, 20, 10);
        Pass pass3 = new Pass(3, "Peter", 3, 30, 5);
        Pass pass4 = new Pass(4, "Paul", 4, 40, 10);
        Pass pass5 = new Pass(5, "Sarah", 5, 50, 15);    

        // add all Passes to the collection of Passes
        passes.add(pass1);
        passes.add(pass2);
        passes.add(pass3);
        passes.add(pass4);
        passes.add(pass5);

        // add all Passes to the Base Island
        islands.get(0).addPass(pass1);
        islands.get(1).addPass(pass2);
        islands.get(2).addPass(pass3);
        islands.get(3).addPass(pass4);
        islands.get(4).addPass(pass5);
    }

    private void loadIslandsAndFerries() {
        // create all Islands
        Island baseIsland = new Island(0, "Base", 0, 0);
        Island island1 = new Island(1, "Island1", 1, 10);
        Island island2 = new Island(2, "Island2", 2, 20);   
        Island island3 = new Island(3, "Island3", 3, 30);
        Island island4 = new Island(4, "Island4", 4, 40);


        // add all Islands to the collection of Islands
        islands.add(baseIsland);
        islands.add(island1);
        islands.add(island2);
        islands.add(island3);
        islands.add(island4);

        // create all ferries
        Ferry ferry1 = new Ferry(1, baseIsland, island1, 3);
        Ferry ferry2 = new Ferry(2, baseIsland, island2, 3);
        Ferry ferry3 = new Ferry(3, baseIsland, island3, 3);
        Ferry ferry4 = new Ferry(4, baseIsland, island4, 3);
        Ferry ferry5 = new Ferry(5, island1, baseIsland, 3);
        Ferry ferry6 = new Ferry(6, island2, baseIsland, 3);
        Ferry ferry7 = new Ferry(7, island3, baseIsland, 3);
        Ferry ferry8 = new Ferry(8, island4, baseIsland, 3);

        // add all ferries to the collection of ferries
        ferries.add(ferry1);
        ferries.add(ferry2);
        ferries.add(ferry3);
        ferries.add(ferry4);
        ferries.add(ferry5);
        ferries.add(ferry6);
        ferries.add(ferry7);
        ferries.add(ferry8);
    }

    /**
     * Returns the pass with the pass id specified by the parameter
     * 
     * @param id pass id
     * @return the pass with the specified name
     **/
    private Pass getPass(int id) {
        if (passes.contains(getPass(id))) {
            return getPass(id);
        } else {
            return null;
        }
    }

    /**
     * Returns the island with the name specified by the parameter
     * 
     * @param i the island name
     * @return the island with the specified name
     **/
    private Island getIsland(int i) {
        if (islands.contains(getIsland(i))) {
            return getIsland(i);
        } else {
            return null;
        }
    }

    /**
     * Returns the ferry with the ferry code specified by the parameter
     * 
     * @param fer the ferry code
     * @return the island with the specified name
     **/
    private Ferry getFerry(String fer) {
        if (ferries.contains(getFerry(fer))) {
            return getFerry(fer);
        } else {
            return null;
        }
    }

    @Override
    public int getIslandNumber(String isl) {
        int i = -1;
        for (Island island : islands) {
            if (island.getName().equals(isl)) {
                i = island.getId();
            }
        }
        return i;
    }
}