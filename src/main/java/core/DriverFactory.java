package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null){
            try {
                String runMode = System.getProperty("runMode", "local");

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--window-size=1920,1080");

                if (runMode.equalsIgnoreCase("docker")) {
                    options.addArguments("--headless=new");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");

                    driver = new RemoteWebDriver(
                            new URL("http://localhost:4444/wd/hub"),
                            options
                    );
                } else {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return driver;
    }

    public static void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
