public class SpecialInterest {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //1. Attributes / Fields

    private String interestCategory;
    private String details;
    private String dateBadgeReceived;

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //2. Constructor

    public SpecialInterest(String interestCategory, String details,
                           String dateBadgeReceived)
    {
        this.interestCategory = interestCategory;
        this.details = details;
        this.dateBadgeReceived = dateBadgeReceived;
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //3. Getters

    public String getInterestCategory()
    {
        return interestCategory;
    }

    public String getDetails()
    {
        return details;
    }

    public String getDateBadgeReceived()
    {
        return dateBadgeReceived;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //4. Setters

    public void setInterestCategory(String interestCategory)
    {
        this.interestCategory = interestCategory;
    }

    public void setDetails(String details)
    {
        this.details = details;
    }

    public void setDateBadgeReceived(String dateBadgeReceived)
    {
        this.dateBadgeReceived = dateBadgeReceived;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public String toString()
    {
        return "The interest category is: " + interestCategory +
                ". The details are as follows: " + details +
                ". Date badge received: " + dateBadgeReceived;
    }

}
