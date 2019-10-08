package com.safewire.page;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://jira.mycompany.org")
public class SafewirePage extends PageObject {
	@FindBy(xpath = "//*[@title='Search']")
	private WebElementFacade googleSearchTextBox;

	@FindBy(xpath = "(//h3//div[contains(text(),'SafeWire')])[1]")
	private WebElementFacade safeWireSite;

	@FindBy(xpath = "//input[@value='Google Search']")
	private WebElementFacade googleSearchbutton;

	@FindBy(xpath = "(//a[contains(text(),'View PDF')])[1]")
	private WebElementFacade viewPDFButton;

	@FindBy(xpath = "(//a[@href='https://www.safechain.io/about/'])[2]")
	private WebElementFacade aboutBtn;

	@FindBy(xpath = "//p[@class]")
	private List<WebElementFacade> listOfNames;

	@FindBy(xpath = "//h2[text()='Our Team']")
	private WebElementFacade ourTeam;

	public void enterGoogleSearchText(String searchText) {
		googleSearchTextBox.sendKeys(searchText);
	}

	public void clickOnsafeWireSite() {
		safeWireSite.click();
	}

	public void clickOnGoogleSearchBtn() {
		googleSearchbutton.click();
	}

	public void clickViewPDFBtn() {
		withAction().moveToElement(viewPDFButton).build().perform();
		viewPDFButton.click();
	}

	public void clickAboutBtn() {
		withAction().moveToElement(aboutBtn).build().perform();
		aboutBtn.click();
	}

	public String verifyNames(String name) {
		String fullName = null;
		List<String> listNamesText = new ArrayList<String>();
		ourTeam.withTimeoutOf(Duration.ofSeconds(15)).waitUntilVisible();
		for (WebElementFacade ele : listOfNames) {
			withAction().moveToElement(ele).build().perform();
			listNamesText.add(ele.getText().trim());
		}
		for (int i = 0; i < listNamesText.size(); i++) {
			if ((listNamesText.get(i)).contains(name))
				fullName = listNamesText.get(i);
		}
		return fullName;
	}
}
