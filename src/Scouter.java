import java.util.ArrayList;

public class Scouter extends Scout {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //1. Attributes / Fields

    private String dateOfVetting;

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //2. Constructor

    public Scouter(String name, String county, String dateOfBirth, String address,
                   String phoneNumber, String dateOfVetting, ArrayList<SpecialInterest> specialInterests)
    {
        super(name, county, dateOfBirth, address, phoneNumber, specialInterests);
        this.dateOfVetting = dateOfVetting;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //3. Getters

    public String getDateOfVetting()
    {
        return dateOfVetting;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //4. Setters

    public void setDateOfVetting(String dateOfVetting)
    {
        this.dateOfVetting = dateOfVetting;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public String toString() {
        return "Scouter is named: " + super.getName() +
                ". County is " + super.getCounty() + ". Their DOB is "
                + super.getDateOfBirth() + ". Address: " + super.getAddress()
                + ". Phone number is " + super.getPhoneNumber() +
                ", Date of Garda Vetting: " + dateOfVetting + "."
                + super.toString();
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @Override
    public double calcMembership() {

        int scouterFees = 10;
        return scouterFees;

    }

}
