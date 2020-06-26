import java.util.ArrayList;
import java.util.Scanner;

public class ScoutSystem {

    private Scanner input = new Scanner(System.in);
    private ScoutList scoutList;

    public ScoutSystem()
    {
        scoutList = new ScoutList();
        runMenu();
    }

    public static void main(String[] args)
    {
        new ScoutSystem();
    }

    private int mainMenu()
    {
        System.out.println("Welcome to the Scouting System!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1) Load all Scouts from file");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Scout Management: ");
        System.out.println("2) Register a new Scout");
        System.out.println("3) List all Scouts");
        System.out.println("4) Delete a Scout");
        System.out.println("5) Update a Scout");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Scout Information:  ");
        System.out.println("6) List Scouts by Group (Beaver, Cub, and Scouter)");
        System.out.println("7) Calculate Total Annual Fees");
        System.out.println("8) View total number of Scouts by Group (Beaver/Cub/Scouter)");
        System.out.println("9 Summary of all Scout Membership numbers");
        System.out.println("10) Search Scout's by name");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("11) Save Scouts");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("0) To Exit");
        System.out.println("===: ");

        int option = input.nextInt();
        return option;
    }

    private void runMenu() {
        int option = mainMenu();
        while (option !=0) {
            switch (option) {
                case 1:
                        try{
                            scoutList.load();
                        }
                        catch(Exception e){
                            System.out.println("Error reading from file: " + e);
                        }
                        break;
                case 2: addScout();
                        break;
                case 3: listAllScouts();
                        break;
                case 4: deleteScout();
                        break;
                case 5: updateScout();
                        break;
                case 6: listScoutsByGroup();
                        break;
                case 7: totalFees();
                        break;
                case 8: listNumberOfScoutsInGroup();
                        break;
                case 9: membershipSummary();
                        break;
                case 10: scoutByName();
                        break;
                case 11: try{
                    scoutList.save();
                }
                catch(Exception e){
                    System.out.println("Error loading from file: " + e);
                }

                default:
                    System.out.println("Invalid option entered: " + option);
                    break;
            }

            System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine(); //fixing bug
            option = mainMenu();
        }

        System.out.println("Exiting Scout System... bye!");
        System.exit(0);
    }

    //2
    private void addScout()
    {
        char choice;
        System.out.println("What kind of Scout do you want to add?");
        System.out.println("\t 1. Beaver Scout");
        System.out.println("\t 2. Cub Scout");
        System.out.println("\t 3. Scouter");
        System.out.println();
        System.out.println("Enter choice [1-3]");

        choice = input.next().charAt(0);
        System.out.println();

        input.nextLine();

        System.out.println("Enter the Scout's name: ");
        System.out.println("    Scout's Name:   ");
        String name = input.nextLine();

        System.out.println("What county is the Scout from?");
        System.out.println("    County:   ");
        String county = input.nextLine();

        System.out.println("What is their date of birth?");
        System.out.println("    Date of birth:   ");
        String dateOfBirth = input.nextLine();

        System.out.println("What is the Scout's address?");
        System.out.println("    Scout's address:   ");
        String address = input.nextLine();

        System.out.println("Best number to contact the Scout on?");
        System.out.println("    Contact number:   ");
        String phoneNumber = input.nextLine();

        //building the local ArrayList
        ArrayList<SpecialInterest> specialInterests = new ArrayList<>();

        //alternative to while loop
        System.out.println("How many Special Interests would you like to add?");
        int specialInterestAmount = input.nextInt();

        //looping that amount
        for(int i = 0; i < specialInterestAmount; i++) {

            System.out.println("Special Interest Category:    ");
            String interestCategory = input.nextLine();

            System.out.println("Details:    ");
            String details = input.nextLine();

            System.out.println("Date Badge Received:    ");
            String dateBadgeReceived = input.nextLine();

            //adding to local ArrayList
            specialInterests.add(new SpecialInterest(interestCategory, details, dateBadgeReceived));
        }

            //cannot get while loop to work :(
            /*//String userans = input.nextLine();
            //System.out.println("Would you like to add another Special Interest? y/n");
            //while (userans == "y")
                System.out.println("Special Interest Category:    ");
                interestCategory = input.nextLine();

                System.out.println("Details:    ");
                details = input.nextLine();

                System.out.println("Date Badge Received:    ");
                dateBadgeReceived = input.nextLine();

                //adding to local ArrayList
                specialInterests.add(new SpecialInterest(interestCategory, details, dateBadgeReceived));*/


            if (choice == '1')
            {
                System.out.println("    Parent's contact number:   ");
                String parentPhone = input.nextLine();

                System.out.println("    Beaver Scout Added.");

                BeaverScout b1 = new BeaverScout(name, county, dateOfBirth, address,
                        phoneNumber, parentPhone, specialInterests);
                scoutList.addScout(b1);

            } else if (choice == '2')
            {
                System.out.println("    Cub's Phone Number:   ");
                String cubPhoneNumber = input.nextLine();

                System.out.println("    Cub Scout Added.");

                CubScout c1 = new CubScout(name, county, dateOfBirth, address,
                        phoneNumber, cubPhoneNumber, specialInterests);
                scoutList.addScout(c1);
            } else if (choice == '3')
            {
                System.out.println("    Date of Garda Vetting:   ");
                String dateOfVetting = input.nextLine();

                System.out.println("    Scouter Added.");

                Scouter s1 = new Scouter(name, county, dateOfBirth, address,
                        phoneNumber, dateOfVetting, specialInterests);
                scoutList.addScout(s1);
            }
    }

    //3
    private void listAllScouts()
    {
        System.out.println(scoutList.listOfScouts());
    }

    //4
    private void deleteScout()
    {
        String scoutDetails = scoutList.listOfScouts();
        System.out.println(scoutDetails);

        int size = scoutList.getSize();

        if(!scoutDetails.equals("No scouts."))
        {
            System.out.println("Enter the index of the scout to Delete ==> ");
            int index = input.nextInt();
            if (size > 0 && (index < size))
            {
                scoutList.deleteScout(index);
                System.out.println("Scout successfully removed.");
            }
            else {
                System.out.println("Incorrect Index - no scouts exist for this index.");
            }
        }
    }

    //5
    private void updateScout() {

        String scoutDetails = scoutList.listOfScouts();
        System.out.println(scoutDetails);

        int size = scoutList.getSize();

        if(!scoutDetails.equals("No scouts.")) {
            System.out.println("Enter the index of the scout to delete ==> ");
            int index = input.nextInt();
            if (size > 0 && (index < size)) {

                input.nextLine();
                System.out.println("Enter the Scout's first name: ");
                String name = input.nextLine();
                System.out.println("What county is the Scout from? ");
                String county = input.nextLine();
                System.out.println("What is the Scout's date of birth?");
                String dateOfBirth = input.nextLine();
                System.out.println("What is the Scout's address?");
                String address = input.nextLine();
                System.out.println("What is the Scout's contact number?");
                String phoneNumber = input.nextLine();

                scoutList.updateScout(index, name, county, dateOfBirth, address, phoneNumber);
                System.out.println("Scout updated successfully.");

            } else
            {

                System.out.println("Incorrect Index - no Scout exists for that index.");

            }
        }
    }

    //6
    private void listScoutsByGroup(){
        System.out.println("Please choose a category of Scout to search.");
        System.out.println("\t 1. Beaver Scout");
        System.out.println("\t 2. Cub Scout");
        System.out.println("\t 3. Scouter");

        input.nextLine();
        char choice = input.next().charAt(0);
        System.out.println(scoutList.listScoutsBySpecificGroup(choice));

    }

    //7
    private void totalFees(){
        System.out.println("Total Fees for all Scouts are: ");
        System.out.println(scoutList.totalFees());
    }

    //8
    private void listNumberOfScoutsInGroup(){
        System.out.println("Please choose a category of Scout to search.");
        System.out.println("\t 1. Beaver Scout");
        System.out.println("\t 2. Cub Scout");
        System.out.println("\t 3. Scouter");

        input.nextLine();
        char choice = input.next().charAt(0);
        System.out.println(scoutList.listNumberOfScoutsInGroup(choice));
    }

    //9
    private void membershipSummary(){

        System.out.println(scoutList.membershipSummary());

    }

    //10
    private void scoutByName(){

        System.out.println("What is the name of the Scout you want to find?");
        input.nextLine();
        String name = input.nextLine();
        System.out.println(scoutList.listScoutsByName(name));

    }

    //Leaving this commented in but couldn't get it to work as I could not
    //figure out how to add to the ArrayList up in addScout, because it
    //is local to this method I am guessing.

/*    private SpecialInterest addSpecialInterest() {

        ArrayList<SpecialInterest> specialInterests = new ArrayList<>();

        input.nextLine();
        System.out.println("Special Interest Category:    ");
        String interestCategory = input.nextLine();

        System.out.println("Details:    ");
        String details = input.nextLine();

        System.out.println("Date Badge Received:    ");
        String dateBadgeReceived = input.nextLine();

        specialInterests.add(new SpecialInterest(interestCategory, details, dateBadgeReceived));
        return new SpecialInterest(interestCategory, details, dateBadgeReceived);

    }*/

}
