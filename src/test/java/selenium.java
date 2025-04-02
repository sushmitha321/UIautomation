import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class selenium {
    public static void main(String[] args) throws InterruptedException, IOException {
      System.out.println( "my world");

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("./src/test/resources/staging.properties");
        prop.load(fis);

        String vaa = prop.getProperty("username");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        driver.get("https://uat-bp.buenofinanceinc.com/login");
        String Ex=driver.getCurrentUrl();
        System.out.println(Ex+"get current url");
        String TIT=driver.getTitle();
        System.out.println(TIT+"page title");

        WebElement text=driver.findElement(By.xpath("//span[@class='MuiButton-label']"));
        String submittext = text.getText();
        WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
username.sendKeys(prop.getProperty("username"));
Thread.sleep(2000);
username.clear();
username.sendKeys("raghu");

      TakesScreenshot screenshot = ((TakesScreenshot) driver);
      File scfile = screenshot.getScreenshotAs(OutputType.FILE);

      FileUtils.copyFile(scfile, new File("./src/test/resources/screenshot.png"));

System.out.println("testing");
System.out.println("abc");

    }}
