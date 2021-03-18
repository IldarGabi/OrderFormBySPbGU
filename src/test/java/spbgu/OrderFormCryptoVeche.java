package spbgu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderFormCryptoVeche {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    //Задача №2
    @Test
    void OrderFormInCryptoVeche() throws InterruptedException {
        driver.get("https://admin.evote75.dltc.spbu.ru");
        driver.findElement((By.cssSelector("[id=auth_type_select]"))).click();
        driver.findElement((By.cssSelector("[data-type=\"/observer_login\"]"))).click();
        driver.findElement((By.cssSelector("[id=username]"))).sendKeys("ildargabi@gmail.com");
        driver.findElement((By.cssSelector("[id=password]"))).sendKeys("123456Qwertyu");
        driver.findElement((By.cssSelector("[id=auth-btn]"))).click();
        Thread.sleep(4000);
        driver.findElement((By.cssSelector(".user-menu-right-arrow"))).click();
        List<WebElement> elementList = driver.findElements(By.className("user_menu_link"));
        elementList.get(1).click();
        driver.findElement((By.cssSelector("[id=forgetPassword]"))).click();
        String checkText = driver.findElement(By.cssSelector("[id=\"entrance\"]")).getText();
        assertEquals(checkText, "Забыли пароль?");
    }

    //    Задача №4
    @Test
    void CreateNewVoteInCryptoVeche() throws InterruptedException {
        driver.get("https://admin.evote75.dltc.spbu.ru");
        driver.findElement((By.cssSelector("[id=auth_type_select]"))).click();
        driver.findElement((By.cssSelector("[data-type=\"/admin_login\"]"))).click();
        driver.findElement((By.cssSelector("[id=username]"))).sendKeys("ildargabi@gmail.com");
        driver.findElement((By.cssSelector("[id=password]"))).sendKeys("123456Qwertyu");
        driver.findElement((By.cssSelector("[id=auth-btn]"))).click();
        Thread.sleep(2_000);
        driver.findElement((By.cssSelector("[id=main-btn]"))).click();
        String name = "Test";
        driver.findElement((By.cssSelector("[id=feTitle]"))).sendKeys(name);
        driver.findElement((By.cssSelector("[id=is_voters_expandable]"))).click();
        List<WebElement> elementList1 = driver.findElements(By.cssSelector("[data-type=\"open\"]"));
        elementList1.get(1).click();
        driver.findElement((By.cssSelector(".add-agenda-add-question .add-question"))).click();
        List<WebElement> elementList2 = driver.findElements(By.cssSelector(".selectBtn"));
        elementList2.get(8).click();
        driver.findElement((By.cssSelector("[class=\"selectDropdown toggle\"]"))).click();
        driver.findElement((By.cssSelector(".add-agenda-question-name-container [type=\"text\"]")))
                .sendKeys("First or Second");
        driver.findElement((By.cssSelector("[id=\"add_event\"]"))).click();
        Thread.sleep(7_000);
        String checkText = driver.findElement(By.cssSelector(".row-item-title")).getText();
        assertEquals(name, checkText);
    }
}
