package com.virtual.solution.common.services;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.virtual.solution.common.utils.WebDriverWaitFactory;

public class ElementService {

    protected WebDriverWaitFactory webDriverWait;

    public ElementService(WebDriverWaitFactory webDriverWait) {
        this.webDriverWait = webDriverWait;
    }

    public void click(By locator) {
        webDriverWait.waitUntilElementClickable(locator).click();
    }

    public void pressEnter(By locator) {
        WebElement element = webDriverWait.waitUntilElementVisible(locator);
        element.sendKeys(Keys.ENTER);
    }

    public void fillText(By textBox, String text) {
        WebElement element = webDriverWait.waitUntilElementVisible(textBox);
        element.clear();
        element.sendKeys(text);
    }

    public void click(WebElement element) {
        webDriverWait.waitUntilElementClickable(element).click();
    }

    public String getText(By locator) {
        return webDriverWait.waitUntilElementVisible(locator).getText();
    }

    public String getAttribute(By locator, String attribute) {
        return webDriverWait.waitUntilElementVisible(locator).getAttribute(attribute);
    }

}
