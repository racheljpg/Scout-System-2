import java.util.ArrayList;

public class CubScout extends Scout {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //1. Attributes / Fields

    private String cubPhoneNumber;

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //2. Constructor

    public CubScout(String name, String county, String dateOfBirth, String address,
                    String phoneNumber, String cubPhoneNumber, ArrayList<SpecialInterest> specialInterests)
    {
        super(name, county, dateOfBirth, address, phoneNumber, specialInterests);
        this.cubPhoneNumber = cubPhoneNumber;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //3. Getters

    public String getCubPhoneNumber()
    {
        return cubPhoneNumber;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //4. Setters

    public void setCubPhoneNumber(String cubPhoneNumber)
    {
        this.cubPhoneNumber = cubPhoneNumber;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public String toString()
    {
        return "Cub Scout " + super.getName() + ". They are from county " +
                super.getCounty() + ". Date of birth is: " +
                super.getDateOfBirth() + ". Address is " + super.getAddress()
                + ". Contact number is " + super.getPhoneNumber() +
                " and Cub's phone number is " + cubPhoneNumber +
                super.toString();
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @Override
    public double calcMembership() {

        int cubFees = 150;
        return cubFees;

    }

}
