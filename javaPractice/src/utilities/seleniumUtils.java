package utilities;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumUtils {
    public static Actions action;
    public static WebDriver driver;
    public WebDriver setUp(String browserName,String appurl) {
        if(browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();

        } else if(browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }else if(browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver=new edgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(appurl);
        return driver;
    }

    public void mouseHover(String hoverOp, WebElement element, Integer x, Integer y) {
        Actions action = new Actions(driver);

        if (hoverOp.equalsIgnoreCase("target")) {
            action.moveToElement(element).perform();
        } else if (hoverOp.equalsIgnoreCase("targetWithCords")) {
            action.moveToElement(element, x, y).perform();
        } else {
            action.moveByOffset(x, y).perform();
        }
    }

    public void getScreenShot(String fileName) {

        TakesScreenshot ts=(TakesScreenshot)driver;
        File file=ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void performMouseOverOperation(WebElement element) {
        action.moveToElement(element).perform();
    }
    public void performRightClickOperation(WebElement element) {
        action.moveToElement(element).contextClick().build().perform();
    }
    public void performDragAndDrop(WebElement source,WebElement target) {
        action.dragAndDrop(source, target).build().perform();
    }
    public void cleanUp() {
        driver.close();
    }
}