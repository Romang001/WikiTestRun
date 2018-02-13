import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.WebElement.*;

public class WikiTest {

    @Test
    public static void navigateTo() {

        //Chrome driver use and path
        if(System.getProperty("os.name").toUpperCase().equals("WINDOWS 10")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        }
        WebDriver driver = new ChromeDriver();

        // Go to Wiki page
        driver.get("https://www.wikipedia.org/");


        // verify element id on page
        WebElement el1 = (new WebDriverWait(driver, 4))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("searchInput")));

        // Click on the search box
        driver.findElement(By.id("searchInput")).click();

        // Type preferred search
        driver.findElement(By.id("searchInput")).sendKeys("Nile Perch");

        //Search with ENTER key
        driver.findElement(By.id("searchInput")).sendKeys(Keys.ENTER);

        Assert.assertTrue(driver.getPageSource().contains("Labrus"));

        //close Chrome browser
        //driver.close();

    }

}
