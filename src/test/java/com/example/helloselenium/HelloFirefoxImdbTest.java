package com.example.helloselenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HelloFirefoxImdbTest {
    private WebDriver driver;
    JavascriptExecutor js;

    @BeforeAll
    public void setUp() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void helloImdb() {
        // Test name: HelloImdb
        // Step # | name | target | value
        // 1 | open | https://www.imdb.com/ |
        driver.get("https://www.imdb.com/");
        // 2 | setWindowSize | 1024x859 |
        driver.manage().window().setSize(new Dimension(1024, 859));
        // 3 | type | id=suggestion-search | el juego del calamar
        driver.findElement(By.id("suggestion-search")).sendKeys("el juego del calamar");
        // 4 | runScript | window.scrollTo(0,0) |
        js.executeScript("window.scrollTo(0,0)");
        // 5 | sendKeys | id=suggestion-search | ${KEY_ENTER}
        driver.findElement(By.id("suggestion-search")).sendKeys(Keys.ENTER);

        // 6 | Wait
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Squid Game")));

        // 7 | click | linkText=Squid Game |
        driver.findElement(By.linkText("Squid Game")).click();

        // 8 | Wait
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(By.linkText("User reviews")));

        // 9 | assertText | xpath=//h1 | Squid Game
        assertThat(driver.findElement(By.xpath("//h1")).getText(), is("Squid Game"));
    }
}
