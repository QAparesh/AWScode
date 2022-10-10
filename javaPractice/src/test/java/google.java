import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
@Test
public class google {
    public static  void googleClass(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.google.com");
        DesiredCapabilities cap= new DesiredCapabilities();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        List<WebElement> languages=driver.findElements(By.xpath("//div[@id='SIvCob']/a"));

        for (WebElement lang : languages){
            System.out.println(lang.getText());
        }
    }
}
