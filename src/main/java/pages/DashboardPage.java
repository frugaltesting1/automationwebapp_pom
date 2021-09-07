package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class DashboardPage {
	
	public WebDriver driver;
	public WebDriverWait wait;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,120);
	}
	
	//popup
	private By laterButtonInPendingGiftsPopup = By.xpath("//*[contains(text(),'Later')]");
	
	//sections
	private By yourDashboardSection = By.xpath("//*[@id=\"yourDashboard\"]");
	
	
	//Squads
	private By findOutHowButton = By.xpath("//*[@id=\"six\"]/div/div/div/div/div/div[2]/a");
	
	//footer
	private By facebookIcon = By.xpath("//a[@href='https://www.facebook.com/oursacredgroves']/i");
	private By linkedinIcon = By.xpath("//a[@href='https://www.linkedin.com/company/the-sacred-groves/']/i");
	private By instagramIcon = By.xpath("//a[@href='https://www.instagram.com/oursacredgroves/']/i");
	private By youtubeIcon = By.xpath("//a[@href='https://www.youtube.com/channel/UCgJ1LVGadEXWQyVkEKohRTg']/i");

	private By amountField = By.xpath("//*[@id=\"txtClusterAmt\"]");
	private By purchaseAgreement = By.xpath("//*[@id=\"buysgcs\"]/div/div/form/div/div[2]/div[5]/label");
	private By checkout = By.xpath("//*[@id=\"checkout-button\"]");

	private By selectCurrency = By.xpath("//*[@id=\"txtCurrency\"]");
	private By gbd = By.xpath("//*[@id=\"txtCurrency\"]/option[1]");
	private By usd = By.xpath("//*[@id=\"txtCurrency\"]/option[2]");
	private By euro = By.xpath("//*[@id=\"txtCurrency\"]/option[3]");
	private By calculate = By.xpath("//*[@id=\"buysgcs\"]/div/div/form/div/div[1]/div/button");
	private By resultAmount = By.xpath("//*[@id=\"totalAmt\"]");

	private By firstBlog = By.xpath("//*[@id=\"blogs\"]/div/div/a[1]");
	private By firstGiftSection = By.xpath("//*[@id=\"slick-slide31\"]/a");


	public boolean isDashboardPage() {
		String currUrl = driver.getCurrentUrl();
		return currUrl.contains("dashboard") || currUrl.endsWith("/user");
	}
	
	public void clickLaterOnPendingGiftsPopup() {
		if(driver.findElement(laterButtonInPendingGiftsPopup).isDisplayed()) {
			driver.findElement(laterButtonInPendingGiftsPopup).click();
		} else {
			System.out.println("Pending Gifts Popup is not present");
		}
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public boolean visibilityOfYourDashboard() {
		clickLaterOnPendingGiftsPopup();
		return driver.findElement(yourDashboardSection).isDisplayed();
	}

	public SquadPage clickOnFindOutHowButton() {
		driver.findElement(findOutHowButton).click();
		return new SquadPage(driver);	
	}

	public void addAmount(String amount){
		driver.findElement(amountField).clear();
		driver.findElement(amountField).sendKeys(amount);
	}

	public void clickPurchaseAgreement(){
		driver.findElement(purchaseAgreement).click();
	}

	public void clickCheckOut(){
		driver.findElement(checkout).click();
	}

	public void clickSelectCurrency(){
		driver.findElement(selectCurrency).click();
	}

	public void clickUSD(){
		driver.findElement(usd).click();
	}

	public void clickGbd(){
		driver.findElement(gbd).click();
	}

	public void clickEURO(){
		driver.findElement(euro).click();
	}

	public String getResultAmount(){
	     return driver.findElement(resultAmount).getText();
	}

	public void clickCalculate(){
		driver.findElement(calculate).click();
	}

	public void clickFirstBlog(){
		driver.findElement(firstBlog).click();
	}

	public void clickFirstGiftCard(){
		WebElement element = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(firstGiftSection));
		element.click();
	}


	public String getNextTabUrl(){
		ArrayList<String> wins = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(wins.get(wins.size()-1));
		return driver.getCurrentUrl();
	}

	public void closeTab(){
		ArrayList<String> wins = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(wins.get(0));
	}

	public void clickOnFacebookIcon() {
		driver.findElement(facebookIcon).click();
	}
	
	public void clickOnInstagramIcon() {
		driver.findElement(instagramIcon).click();
	}
	
	public void clickOnLinkedinIcon() {
		driver.findElement(linkedinIcon).click();
	}
	
	public void clickOnYoutubeIcon() {
		driver.findElement(youtubeIcon).click();
	}

	
}
