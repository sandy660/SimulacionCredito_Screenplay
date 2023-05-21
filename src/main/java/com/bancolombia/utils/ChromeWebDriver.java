package com.bancolombia.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeWebDriver {
    private static WebDriver chromeDriver;

    private ChromeWebDriver() {
    }

    public static WebDriver getDriver() {
        if (chromeDriver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = createChromeOptions();
            chromeDriver = new ChromeDriver(chromeOptions);
        }
        return chromeDriver;
    }

    private static ChromeOptions createChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-geolocation");
        chromeOptions.addArguments("--disable-save-password-bubble");
        return chromeOptions;
    }
}
