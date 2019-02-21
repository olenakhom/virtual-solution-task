package com.virtual.solution.pages;

import org.openqa.selenium.By;

import com.virtual.solution.common.services.ElementService;
import com.virtual.solution.common.utils.WebDriverWaitFactory;

import io.qameta.allure.Step;

public class HomePage {

    private static final By inputSearch = By.xpath("//input[@class='gLFyf gsfi']");

    private ElementService elementService;
    private WebDriverWaitFactory webDriverWait;

    public HomePage(WebDriverWaitFactory webDriverWait) {
        this.webDriverWait = webDriverWait;
        this.elementService = new ElementService(webDriverWait);
    }

    @Step("Search by text {0}")
    public void searchBy(String text) {
        elementService.fillText(inputSearch, text);
        elementService.pressEnter(inputSearch);
    }

    @Step("Open page {0}")
    public void open(String url) {
        webDriverWait.getWebDriver().get(url);
    }


}
