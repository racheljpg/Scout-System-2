import java.util.ArrayList;

public abstract class Scout implements iScoutMember {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //1. Attributes / Fields

    private String name;
    private String county;
    private String dateOfBirth;
    private String address;
    private String phoneNumber;
    private ArrayList<SpecialInterest> specialInterests;

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //2. Constructors

    public Scout(String name, String county, String dateOfBirth, String address,
                 String phoneNumber, ArrayList<SpecialInterest> specialInterests)
    {
        this.name = name;
        this.county = county;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.specialInterests = specialInterests;
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //3. Getters

    public String getName()
    {
        return name;
    }

    public String getCounty()
    {
        return county;
    }

    public String getDateOfBirth()
    {
        return dateOfBirth;
    }

    public String getAddress()
    {
        return address;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //4. Setters

    public void setName(String name)
    {
        this.name = name;
    }

    public void setCounty(String county)
    {
        this.county = county;
    }

    public void setDateOfBirth(String dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    //old toString
    //Didn't want to use it like this as it doesn't include the extra attributes for
    //each subclass.
    /*public String toString()
    {
        return "Scout's name is: " + name + ", they are from " + county +
                ". Their date of birth is " + dateOfBirth + ". Their address is"
                + address + ", and phone number is " + phoneNumber +
                specialInterests.toString();
    }*/

    //Replacing with this one as I could not figure out how to call specialInterest's
    //toString or getters from the subclasses. So adding this toString to the end of
    //subclasses toString instead.
    public String toString(){
        return specialInterests.toString();
    }

}
