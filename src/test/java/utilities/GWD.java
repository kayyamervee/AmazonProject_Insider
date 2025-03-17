package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class GWD {
    public static WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void setUp(){
        switch (ConfigReader.getProperty("browser").toLowerCase()){
            case "firefox":driver=new FirefoxDriver(); break;
            case "edge":driver=new EdgeDriver(); break;
            case "chrome":driver = new ChromeDriver();
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getIntProperty("explicit.wait")));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConfigReader.getIntProperty("pageLoadTimeout")));
    }

    @AfterClass
    public void tearDown() {
        ReusableMethods.Wait(4);
        driver.quit();
    }
}



