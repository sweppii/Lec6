import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTest {

    WebDriver driver;

    @BeforeTest
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/validation/input-validation.html");
    }

    @Test
    public void myTest() throws InterruptedException {
        WebElement firstName = driver.findElement(By.xpath("//input[@id='firstname']"));
        firstName.sendKeys("TestFirstName");

        WebElement surname = driver.findElement(By.id("surname"));
        surname.sendKeys("TestSurname");

        WebElement age = driver.findElement(By.id("age"));
        age.sendKeys("18");

        WebElement country = driver.findElement(By.id("country"));
        Select select = new Select(country);
        select.selectByValue("Ukraine");

        WebElement notes = driver.findElement(By.xpath("//textarea[@id=\"notes\"]"));
        notes.sendKeys("Виконав Науменко Саша");

        WebElement submit = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        submit.click();

        Thread.sleep(3000);
    }


    @AfterTest
    public void closeDriver() {
        driver.quit();
    }
}
