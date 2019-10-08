package com.safewire.definations;

import org.junit.Assert;
import com.safewire.page.SafewirePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;

public class SafewireStepDefination extends PageObject {
	SafewirePage safewirePage;
	String Parent_Window;

	@Given("^User is on google page$")
	public void user_is_on_google_page() {
		safewirePage.open();
		getDriver().manage().window().maximize();
	}

	@When("^User search \"([^\"]*)\"$")
	public void user_search(String searchText) {
		safewirePage.enterGoogleSearchText(searchText);
		safewirePage.clickOnGoogleSearchBtn();
	}

	@When("^Click on Safewire website$")
	public void click_on_Safewire_website() {
		safewirePage.clickOnsafeWireSite();
	}

	@Then("^\"([^\"]*)\" website should open$")
	public void safewire_website_should_open(String expectedPageTitle) {
		Assert.assertTrue("The expected page has not opened", getDriver().getTitle().equals(expectedPageTitle));
	}

	@When("^user clicks on View PDF button$")
	public void user_clicks_on_View_PDF_button() {
		safewirePage.clickViewPDFBtn();
		Parent_Window = getDriver().getWindowHandle();
		for (String Child_Window : getDriver().getWindowHandles()) {
			getDriver().switchTo().window(Child_Window);
		}
	}

	@When("^Search for \"([^\"]*)\" and display his full name$")
	public void search_for(String searchName) throws InterruptedException {
		String fullName = safewirePage.verifyNames(searchName);
		System.out.println("The full name of " + searchName + " is: " + fullName);

	}

	@When("^click on About$")
	public void click_on_About() throws InterruptedException {
		getDriver().switchTo().window(Parent_Window);
		safewirePage.clickAboutBtn();
		for (String Child_Window : getDriver().getWindowHandles()) {
			getDriver().switchTo().window(Child_Window);
		}
	}

	@Then("^\"([^\"]*)\" page should display$")
	public void page_should_display(String expectedPageTitle) {
		Assert.assertTrue("The expected page has not opened", getDriver().getTitle().equals(expectedPageTitle));
	}
}
