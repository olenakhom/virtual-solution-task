package com.virtual.solution.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.virtual.solution.common.services.ElementService;
import com.virtual.solution.common.utils.WebDriverWaitFactory;

import io.qameta.allure.Step;

public class SearchResultPage {

    private static final By inputSearch = By.xpath("//input[@class='gLFyf gsfi']");
    private static final By links = By.xpath("//div[@class='g']//div[@class='r']/a");

    private ElementService elementService;
    private WebDriverWaitFactory webDriverWait;

    public SearchResultPage(WebDriverWaitFactory webDriverWait) {
        this.webDriverWait = webDriverWait;
        this.elementService = new ElementService(webDriverWait);
    }

    @Step("Get all result links")
    private List<WebElement> getAllResultLinks(){
        return webDriverWait.waitUntilAllElementsPresent(links);
    }

    @Step("Verify at least 1 search result is present")
    public void verifyAtLeastOneSearchResultIsPresent(){
        Assert.assertTrue(!getAllResultLinks().isEmpty(), "Search results are absent: ");
    }

    @Step("Verify search text in search box is {0}")
    public void verifySearchBoxContainsText(String expectedSearchText){
        String actualSearchText = elementService.getAttribute(inputSearch, "value");
        Assert.assertEquals(actualSearchText, expectedSearchText, "Search text in search box");
    }

    @Step("Click on first link")
    public void clickFirstLink(){
        elementService.click(getAllResultLinks().get(0));
    }


}
