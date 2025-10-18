package tech.ada;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GooglePageTest {

    @Test
    void testaTituloDoGoogle() {

        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://google.com");

        String title = webDriver.getTitle();

        System.out.println(title);

        webDriver.quit();
    }

}
