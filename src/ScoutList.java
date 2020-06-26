import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * A class to build an ArrayList for the Scouts, and all methods.
 *
 * @author Rachel Ryan 20089534
 * @version 1.0
 * @since 27/04/2020
 */

public class ScoutList {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //1. Attributes / Fields
    /**
     * Creating an ArrayList for the scouts.
     */
    private ArrayList<Scout> scouts;

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //2. Constructor
    /**
     * Constructor - initializing ArrayList.
     */
    public ScoutList() {
        scouts = new ArrayList<Scout>();
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //3. Methods

    /**
     * Adding a Scout to the ArrayList.
     */
    public void addScout(Scout scout) {
        scouts.add(scout);
    }

    /**
     * Deleting a Scout from the ArrayList.
     */
    public void deleteScout(int index) {
        scouts.remove(index);
    }

    /**
     * Returning the size of the Scout ArrayList.
     */
    public int getSize() {
        return scouts.size();
    }

    /**
     * Updating a chosen Scout in the ArrayList.

     */
    public void updateScout(int index, String name, String county, String dateOfBirth,
                               String address, String phoneNumber)
    {

        Scout s = scouts.get(index);
        s.setName(name);
        s.setCounty(county);
        s.setDateOfBirth(dateOfBirth);
        s.setAddress(address);
        s.setPhoneNumber(phoneNumber);
    }

    /**
     * Building a String of all Scouts and returning it.
     */
    public String listOfScouts() {
        if (scouts.size() == 0) {
            return "No scouts.";
        } else {
            String listOfScouts = "";
            for (int i = 0; i < scouts.size(); i++) {
                listOfScouts = listOfScouts + i + ": " + scouts.get(i) + "\n";
            }
            return listOfScouts;
        }
    }

    /**
     * Saving the Scouts to the XML file scouts.xml.
     */
    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("scouts.xml"));
        out.writeObject(scouts);
        out.close();
    }

    /**
     * Loading the Scouts from the XML file scouts.xml.
     */
    public void load() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("scouts.xml"));
        scouts = (ArrayList<Scout>) is.readObject();
        is.close();
    }

    /**
     * A method to allow you to search the ArrayList by a Scout's name.
     */
    public String listScoutsByName(String name) {

        if(scouts.size() == 0) {
            return "There are no scouts in the list yet.";
        } else {

            String listOfScoutsByName = "";

            for (int i = 0; i < scouts.size(); i++) {

                if (scouts.get(i).getName().toUpperCase().contains(name.toUpperCase()))

                    listOfScoutsByName += scouts.toString() + "\n";
            }
            if (listOfScoutsByName.isEmpty()){
                listOfScoutsByName = "There are no scouts with the name " + name;
            }

            return listOfScoutsByName;
        }
    }

    /**
     * A method to allow you to list all Scouts in a specific group. (Beaver/Cub Scout/Scouter)
     */
    public String listScoutsBySpecificGroup(char choice) {
        String listOfScoutsByGroup = "";

        for (int i = 0; i < scouts.size(); i++) {
            if (choice == '1' && scouts.get(i) instanceof BeaverScout) {
                listOfScoutsByGroup += scouts.get(i) + "\n";
                } else if (choice == '2' && scouts.get(i) instanceof CubScout) {
                            listOfScoutsByGroup += scouts.get(i) + "\n";
                    } else if (choice == '3' && scouts.get(i) instanceof Scouter) {
                                listOfScoutsByGroup += scouts.get(i) + "\n";
                        }
                }

        if (choice == '1') {
            return "\nBeaver Scouts:\n" + listOfScoutsByGroup;
        } else if (choice == '2') {
            return "\nCub Scouts:\n" + listOfScoutsByGroup;
        } else {
            return "\nScouters:\n" + listOfScoutsByGroup;
        }
    }

    /**
     * A method that returns the number of Scouts in each of the 3 groups.
     */
    public String listNumberOfScoutsInGroup(char choice){
        int numberOfMembersInCategory = 0;

        for (int i = 0; i < scouts.size(); i++) {
            if(choice == '1' && scouts.get(i) instanceof BeaverScout) {
                numberOfMembersInCategory++;
                } else if(choice == '2' && scouts.get(i) instanceof CubScout) {
                    numberOfMembersInCategory++;
                    } else if(choice == '3' && scouts.get(i) instanceof Scouter) {
                        numberOfMembersInCategory++;
            }
        }

        if (choice == '1') {
            return "\nBeaver Scouts:\n" + numberOfMembersInCategory;
        } else if (choice == '2'){
            return "\nCub Scouts:\n" + numberOfMembersInCategory;
        } else {
            return "\nScouters:\n" + numberOfMembersInCategory;
        }
    }

    /**
     * A method to calculate the total fees for all Scouts depending on
     * Scout type and number of Scouts in each group.
     */
    public double totalFees() {

        double totalFees = 0;

        for (Scout scout : scouts) {

            totalFees = totalFees + scout.calcMembership();
        }

        return totalFees;

    }

    /**
     * A method showing the number of Scouts total, and how many
     * Scouts are in each separate group.
     */
    public String membershipSummary() {
        int totalScouts = scouts.size();
        int beavers = 0;
        int cubs = 0;
        int scouters = 0;

        for (int i = 0; i < scouts.size(); i++){
            if(scouts.get(i) instanceof BeaverScout) {
                beavers++;
            }
            else if(scouts.get(i) instanceof CubScout){
                cubs++;
            } else {
                scouters++;
            }
        }

        return "\nScout Member Summary Report: \n" +
                "\n    Total Number of Scout Members: " + totalScouts + "\n" +
                "\nBeaver Scout Report\n" +
                "    Number of Beaver Scouts: " + beavers + "\n" +
                "\nCub Scout Report: \n" +
                "    Number of Cub Scouts: " + cubs + "\n" +
                "\nScouter Report: \n" +
                "    Number of Scouters: " + scouters;
    }

}
