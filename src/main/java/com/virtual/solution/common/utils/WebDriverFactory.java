package com.virtual.solution.common.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class WebDriverFactory {

    public WebDriver getDriver() {
            setupChromeDriverManager();
            return new ChromeDriver();
    }

    private void setupChromeDriverManager() {
        ChromeDriverManager chromeDriverManager = ChromeDriverManager.getInstance();
        chromeDriverManager.setup();
    }

}
