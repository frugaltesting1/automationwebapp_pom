package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class DashboardPage {

	public WebDriver driver;
	public WebDriverWait wait;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,10);
	}
	
	//popup
	private By laterButtonInPendingGiftsPopup = By.xpath("//*[contains(text(),'Later')]");
	private By showButtonInPendingGiftsPopup = By.xpath("//*[contains(text(),'Show')]");
	private By pendingGiftsPopup = By.xpath("//*[contains(text(),'pending gifts')]");
	
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

	private By embeddedPlayButton = By.xpath("//*[@id=\"newOne\"]/div/div[2]/div/div/div/div/a/div");
	private By youtubeVideo = By.xpath("//iframe[contains(@src,'https://www.youtube.com/embed/gpQL1bJURs0')]");
	private By playButton = By.xpath("//button[@aria-label='Play']");


	public boolean isDashboardPage() {
		String currUrl = driver.getCurrentUrl();
		return currUrl.contains("dashboard") || currUrl.endsWith("/user");
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		}
		catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public void clickLaterOnPendingGiftsPopup() {
		if (isElementPresent(pendingGiftsPopup)){
			if (driver.findElement(laterButtonInPendingGiftsPopup).isDisplayed()) {
				driver.findElement(laterButtonInPendingGiftsPopup).click();
			} else {
				System.out.println("Pending Gifts Popup is not present");
			}
		}
	}

	public void clickShowOnPendingGiftsPopup(){
		driver.findElement(showButtonInPendingGiftsPopup).click();
	}

	public boolean isPendingGiftsPopupPresent(){
		return isElementPresent(pendingGiftsPopup);
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
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
		WebElement element = driver.findElement(firstBlog);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
		//driver.findElement(firstBlog).click();
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

	public void clickOnSacredGrovesVideo() throws InterruptedException{
		driver.findElement(embeddedPlayButton).click();
		WebElement frameElement = driver.findElement(youtubeVideo);
		driver.switchTo().frame(frameElement);
		Thread.sleep(10000);
		//WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(playButton));
		driver.findElement(playButton).click();
		//WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(playButton).click();

	}
}
