package HotelBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Browser {


    static WebDriver driver = new ChromeDriver();
    public static void goTo(String url)
    {
        driver.get(url);
    }

    public static String title()
    {
        return driver.getTitle();
    }

    public static void close()
    {
        driver.close();
    }

    public static boolean performSaveandDelete()
    {
        WebElement firstnameField = driver.findElement(By.id("firstname"));
        firstnameField.sendKeys("one");

        WebElement lastnameField = driver.findElement(By.id("lastname"));
        lastnameField.sendKeys("two");

        WebElement totalpriceField = driver.findElement(By.id("totalprice"));
        totalpriceField.sendKeys("101");

        driver.findElement(By.id("checkin")).click();
        List<WebElement> alldatesCheckin = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
        for (WebElement ele : alldatesCheckin) {
            String date = ele.getText();
            if (date.equalsIgnoreCase("28")) {
                ele.click();
                break;
            }
        }

        driver.findElement(By.id("checkout")).click();
        List<WebElement> alldatesCheckout = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
        for (WebElement ele : alldatesCheckout) {
            String date = ele.getText();
            if (date.equalsIgnoreCase("29")) {
                ele.click();
                break;
            }
        }

        driver.findElement(By.cssSelector("input[type='button'][value=' Save ']")).click();


        WebElement firstName = driver.findElements(By.className("row")).get(1);
        String name = firstName.getText();

        Boolean isPresent = driver.findElements(By.cssSelector("input[type='button'][value='Delete']")).size() > 0;

        if (!isPresent)
            return false;

        WebElement deleteButton = driver.findElements(By.cssSelector("input[type='button'][value='Delete']")).get(0);


        deleteButton.click();

        WebElement postDeletefirstName = driver.findElements(By.className("row")).get(1);
        String postDeletename = firstName.getText();

        return name.contentEquals(postDeletename);
    }

}
