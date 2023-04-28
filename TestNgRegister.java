import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class TestNgRegister {
    WebDriver driver;

    @Test(priority = 1)
    void openBrowser() {
        System.out.println("Open Browser");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test(priority = 2)
    void register() {

        driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")).click();
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Jaimini");
        driver.findElement(By.id("LastName")).sendKeys("Patel");
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("29");
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("November");
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("1992");
        driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("jaimini.patel029@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"Company\"]")).sendKeys("Unify Testing ");
        driver.findElement(By.id("Newsletter")).click();
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("Kathan@1206");
        driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]")).sendKeys("Kathan@1206");
        driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();



    }

    @Test(priority = 3)
    void logIn()
    {


        driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
        driver.findElement(By.id("Email")).sendKeys("jaimini.patel029@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Kathan1206");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();
    }

    @Test(priority = 4)
    void logout()
    {
        //validate homepage
        driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
        String ActualTitle=driver.getTitle();
        String ExpectedTitle= "nopCommerce demo store";

        if(ActualTitle.equals(ExpectedTitle))
        {
            System.out.println("Test is Passed");
        }
        else
        {
            System.out.println("Test is Failed");
}



    }
    @Test(priority = 5)
        void closeBrowser ()
        {
            System.out.println("Close Browser");
            driver.close();
        }
    }
