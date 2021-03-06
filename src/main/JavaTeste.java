import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class JavaTeste {
    private WebDriver driver;
    private String baseUrl;


    @Before
    public void setUp() throws Exception {
       // driver = new FirefoxDriver();
        //driver = new HtmlUnitDriver();
        // Optional, if not specified, WebDriver will search your path for chromedriver.
        System.setProperty("webdriver.chrome.driver", "/Users/arturcosta/Documents/Mestrado/chromedriver");
        driver= new ChromeDriver();
        baseUrl = "http://www.imdb.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testJavaTeste() throws Exception {
        driver.get(baseUrl + "/");
        String searchTerm = "Blade Runner";
        driver.findElement(By.id("navbar-query")).clear();
        driver.findElement(By.id("navbar-query")).sendKeys(searchTerm);
        driver.findElement(By.id("navbar-submit-button")).click();
        driver.findElement(By.xpath("//td[2]/a")).click();
        //assertTrue(driver.getTitle().matches("^regexpi:\\.[\\s\\S]*\\$\\{searchTem\\}\\.[\\s\\S]*$"));
        assertTrue(driver.getTitle().matches(".*" + searchTerm + ".*"));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();

    }


}
