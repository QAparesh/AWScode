
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class FreshWorksTest {
    WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
//             driver =new ChromeDriver();
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("browserName", "chrome");
            try {
                driver = new RemoteWebDriver(new URL("http://52.66.236.194:4444/wd/hub"), cap);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
//             driver = new FirefoxDriver();
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("browserName", "firefox");
            try {
                driver = new RemoteWebDriver(new URL("http://52.66.236.194:4444/wd/hub"), cap);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
    }

    @Test
    public void freshWorksTitleTest() {
        System.out.println(driver.getTitle());
    }

    @Test
    public void getFooterLinksTest() {
        List<WebElement> languagesList =driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
        languagesList.forEach(ele -> System.out.println(ele.getText()));
        assertEquals(languagesList.size(), 9);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

