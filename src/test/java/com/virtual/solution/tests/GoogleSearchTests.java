package com.virtual.solution.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class GoogleSearchTests extends Base {

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"Activesync"}
        };
    }

    @Test(description = "Test search in Google", dataProvider = "data")
    @Description("Search for 'Activesync' using Selenium in Google. Then the first link should be clicked.")
    public void testGoogleSearch(String searchText){
        homePage.open(siteUrl);
        homePage.searchBy(searchText);

        searchResultPage.verifySearchBoxContainsText(searchText);
        searchResultPage.verifyAtLeastOneSearchResultIsPresent();

        searchResultPage.clickFirstLink();
    }

}
