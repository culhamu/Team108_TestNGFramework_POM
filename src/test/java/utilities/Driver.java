package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

    //Daha fazla kontrol imkanı ve extends kullanmadan driver'a ulaşmak için
    //webDriver objesini statik bir method ile oluşturacaz

    //Ancak getDriver() Method'u her kullanıldığında yeni bir driver oluşturuyor
    //bunu engellemek ve kodumuzun düzgün çalışmasını sağlamak için
    //ilk kullanımda driver=new ChromeDriver(); kodu çalışsın
    //sonraki kullanımlarda çalışmasın diye bir yntem geliştirmeliyiz
    public static WebDriver driver;

    public static WebDriver getDriver(){

        WebDriverManager.chromedriver().setup();
        if (driver==null){
            driver=new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        return driver;

    }

    public static void closeDriver(){

        if (driver!=null){
            driver.close();
            driver=null;
        }

    }
    public static void quitDriver(){

        if (driver!=null){
            driver.quit();
            driver=null;
        }

    }
}




