package com.virtual.solution.common.utils;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("test")
public class WebDriverWaitFactory {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private Logger log = LoggerFactory.getLogger(WebDriverWaitFactory.class);
    private static final int TIME_OUT = 50;
    private static final long SLEEP_TIME_OUT = 100L;

    @Autowired
    public WebDriverWaitFactory(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, TIME_OUT, SLEEP_TIME_OUT);

    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebElement waitUntilElementVisible(By locator) {
        return getWebDriverWait().until(visibilityOfElementLocated(locator));
    }

    public WebElement waitUntilElementClickable(By locator) {
        return getWebDriverWait().until(elementToBeClickable(locator));
    }

    public WebElement waitUntilElementClickable(WebElement webElement) {
        return getWebDriverWait().until(elementToBeClickable(webElement));
    }

    public List<WebElement> waitUntilAllElementsPresent(By locator) {
        List<WebElement> elements = new ArrayList<>();
        try {
            return getWebDriverWait().until(presenceOfAllElementsLocatedBy(locator));
        } catch (TimeoutException e) {
            return elements;
        }
    }

}
