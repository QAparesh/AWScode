import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Test
public class newClass {

    public static void test1(){
        System.out.println("Hello World");
        System.setProperty("webdriver.chrome.driver","E:\\seleniumSoftware/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://stage.byjusweb.com/learn/account/login");
        System.out.println("Print");
        String password="2053";
        WebElement tfPhoneNumber= driver.findElement(By.xpath("//*[@type='text']"));
        tfPhoneNumber.click();
        tfPhoneNumber.sendKeys("1021032053");
        WebElement next= driver.findElement(By.xpath("//*[@type='submit']"));
        next.click();
        String otp[]=password.split("");
        for(int i=1;i<=password.length();i++){
            System.out.println(otp[i-1]);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebElement OTP= driver.findElement(By.xpath("(//input[@inputmode='numeric'])[" + i + "]"));
            OTP.click();
            OTP.sendKeys(otp[i-1]);
        }
        WebElement btnLogin=driver.findElement(By.xpath("//button[text()='Login']"));
        btnLogin.click();

        WebElement LoginLimitExceededPopUp=driver.findElement(By.xpath("//*[text()='Login limit exceeded']"));
        WebElement btnContinue=driver.findElement(By.xpath("//button[text()='Continue']"));
        if(LoginLimitExceededPopUp.isDisplayed() == true){
            btnContinue.click();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement btnDropDownProfile=driver.findElement(By.xpath("//*[@id='dropdown-profile']"));
        Boolean flag=btnDropDownProfile.isDisplayed();
        assert (flag == true);
        System.out.println(flag);
        try {
            Thread.sleep(3000);
        }
        catch(InterruptedException ie){
        }
        btnDropDownProfile.click();

        WebElement myProfile=driver.findElement(By.xpath("//*[@class='dropdown-item notify-item']/span[text()='My profile']"));
        myProfile.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement gradeInput=driver.findElement(By.xpath("//*[@class='grade-width__input']"));
        gradeInput.sendKeys("7th grade");
        gradeInput.sendKeys(Keys.TAB);

        WebElement exploreTitle=driver.findElement(By.xpath("//h3[contains(text(),'Explore')]"));
        assert(exploreTitle.isDisplayed() == true);

        WebElement btnHamburgerMenu=driver.findElement(By.xpath("//*[@class='topnav-hamburger menu_guidetour_mobile']"));
        btnHamburgerMenu.click();

        WebElement btnAPQ=driver.findElement(By.xpath("//li[@class='side-nav-item']//span[text()='Adaptive Practice Questions']"));
        btnAPQ.click();

        WebElement practiceTitle=driver.findElement(By.xpath("//*[@class='css-17wwswp']"));
        assert(practiceTitle.isDisplayed() == true);
        
    }

}
