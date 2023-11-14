import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/*
BaseUrl = https://opensource-demo.orangehrmlive.com/
1. Setup Chrome browser.
2. Open URL.
3. Print the title of the page.
4. Print the current url.
5. Print the page source.
6. Click on ‘Forgot your password?’ link.
7. Print the current url.
8. Navigate back to the login page.
9. Refresh the page.
10. Enter the email to email field.
11. Enter the password to password field.
12. Click on Login Button.
13. Close the browser.
 */
public class MultiBrowserTest {
    //BaseUrl = https://opensource-demo.orangehrmlive.com/
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static String browser ="Chrome";
    public static void main(String[] args) throws InterruptedException {

       // 1. Setup Chrome browser
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver" , "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
       //WebDriver driver = new FirefoxDriver();
        //WebDriver driver = new EdgeDriver();
        //WebDriver driver = new SafariDriver();

        //2. Open URL
        driver.get(baseUrl);

        //3. Print the title of the page
        String title = driver.getTitle();
        System.out.println("Title of the Page :" +title);

       // 4. Print the current url
        System.out.println("The current Url: "+ driver.getCurrentUrl());

        //5. Print the page source
        System.out.println(driver.getPageSource());
        Thread.sleep(5000);

        //6. Click on ‘Forgot your password?’ link.
       WebElement clickLink = driver.findElement(By.className("orangehrm-login-forgot"));
        clickLink.click();
        Thread.sleep(3000);

        //7. Print the current url
        System.out.println("The current Url: "+ driver.getCurrentUrl());

        //8. Navigate back to the login page
        driver.navigate().back();
        Thread.sleep(3000);

        //9. Refresh the page.
        driver.navigate().refresh();

        //10. Enter the email to email field.
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Admin");

        //11. Enter the password to password field
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        Thread.sleep(3000);

        //12. Click on Login Button.
        WebElement loginClick = driver.findElement(By.xpath("(//button[@type='submit'])"));
        loginClick.click();
        Thread.sleep(5000);

        //13. Close the browser
        driver.quit();
    }
}
