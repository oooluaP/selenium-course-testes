package tech.ada;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Google {

    @Test
    void test() {
        WebDriver chromeDriver = new FirefoxDriver();

        chromeDriver.get("https://www.google.com");

        String googlePageTitle = chromeDriver.getTitle();

        System.out.println(googlePageTitle);

//        chromeDriver.quit();
    }
}
