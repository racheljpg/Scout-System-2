import java.util.ArrayList;

public class BeaverScout extends Scout {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //1. Attributes / Fields

    private String parentPhone;

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //2. Constructor

    public BeaverScout(String name, String county, String dateOfBirth, String address,
                       String phoneNumber, String parentPhone, ArrayList<SpecialInterest> specialInterests){
        super(name, county, dateOfBirth, address, phoneNumber, specialInterests);
        this.parentPhone = parentPhone;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //3. Getters

    public String getParentPhone()
    {
        return parentPhone;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //4. Setters

    public void setParentPhone(String parentPhone)
    {
        this.parentPhone = parentPhone;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public String toString()
    {
        return "Beaver Scout: " + super.getName() + ", from county "
                + super.getCounty() + ". Their date of birth is " +
                super.getDateOfBirth() + ". Address is " + super.getAddress() +
                ", and contact number is " + super.getPhoneNumber()
                + ". Parent's contact number is: " + parentPhone +
                super.toString();
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @Override
    public double calcMembership() {

        int beaverFees = 100;
        return beaverFees;

    }

}
