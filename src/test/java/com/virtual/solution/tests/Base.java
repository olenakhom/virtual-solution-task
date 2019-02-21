package com.virtual.solution.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.virtual.solution.common.utils.WebDriverFactory;
import com.virtual.solution.common.utils.WebDriverWaitFactory;
import com.virtual.solution.config.MainConfig;
import com.virtual.solution.pages.HomePage;
import com.virtual.solution.pages.SearchResultPage;


@ContextConfiguration(classes = MainConfig.class, loader = AnnotationConfigContextLoader.class)
public abstract class Base extends AbstractTestNGSpringContextTests {

    private static final long IMPLICITLY_WAIT_TIMEOUT = 5;
    private static final long PAGE_LOAD_TIMEOUT = 45;

    @Value("${site.base.url}")
    protected String siteUrl;

    private WebDriverWaitFactory webDriverWait;

    protected HomePage homePage;
    protected SearchResultPage searchResultPage;

    private WebDriver webDriver;

    @BeforeMethod(description = "Browser and pages setup")
    protected void setUp() {
        initialize();
    }

    @AfterMethod(description = "Quit browser")
    protected void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    protected WebDriver getDriver(){
        return webDriver;
    }

    protected void initialize() {
        setDriver();
        webDriverWait = new WebDriverWaitFactory(getDriver());
        homePage = new HomePage(webDriverWait);
        searchResultPage = new SearchResultPage(webDriverWait);
    }

    private void setDriver() {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        webDriver = webDriverFactory.getDriver();
        webDriver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_TIMEOUT, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);;
    }


}
