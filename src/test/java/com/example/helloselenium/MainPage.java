package com.example.helloselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// https://www.jetbrains.com/
public class MainPage {
    @FindBy(css = "a.wt-button_mode_primary")
    public WebElement seeAllToolsButton;

    // Before
    // @FindBy(xpath = "//div[contains(@class, 'menu-main__item') and text() = 'Developer Tools']")

    // After
    @FindBy(xpath = "//div/div[2]/div[1]/div/nav/div[1]/button[contains(@class, 'main-menu-item') and text() = 'Developer Tools']")
    public WebElement toolsMenu;

    // Before
    //@FindBy(css = "[data-test='menu-main-icon-search']")

    // After
    @FindBy(css = "[data-test='site-header-search-action']")
    public WebElement searchButton;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
