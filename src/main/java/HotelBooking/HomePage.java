package HotelBooking;

public class HomePage {

    static String url ="http://hotel-test.equalexperts.io";
    static String title = "Hotel booking form";
    public void goTo(){
        Browser.goTo(url);
    }

    public boolean isAt()
    {
        return Browser.title().equals(title);
    }

    public boolean PerformBooking()
    {
        return Browser.performSaveandDelete();
    }

}
