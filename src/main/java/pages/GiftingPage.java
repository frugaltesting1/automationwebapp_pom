package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GiftingPage {
	public WebDriver driver;
	public WebDriverWait wait;

	public GiftingPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,120);
	}
	
	private By selectCardButton = By.xpath("//*[@id=\"selectCardButton\"]");
	private By nameField = By.xpath("//*[@id=\"txtName\"]");
	private By emailField = By.xpath("//*[@id=\"txtEmail\"]");
	private By phoneField = By.xpath("//*[@id=\"txtPhone\"]");
	private By messageField = By.xpath("//*[@id=\"giftMessage\"]");
	private By clusterField = By.xpath("//*[@id=\"txtClusterAmt\"]");
	private By calculateButton = By.xpath("//*[@id=\"payNowSection\"]/div/div/div[1]/button");
	private By previewMessageField = By.xpath("//*[@id=\"preview-giftMessage\"]");
	private By previewGiftCard = By.xpath("//*[@id=\"preview-giftCard\"]");
	private By showGiftButton = By.id("giftShowBtn");
	private By giftAmountField = By.id("giftAmount");
	private By sendGiftButton = By.id("send-gift-button");

	private By tryAgainPopUp =  By.xpath("//a[contains(text(),'Try again')]");
	private By okPopUp = By.xpath("//a[text()='OK']");
	private By clusterAmount = By.id("txtClusterAmt");
	private By checkOutButton = By.id("checkout-button");

	private By checkOutCheckBox = By.xpath("//label[@for='customCheck1']");

	private By paymentSubmitButton = By.xpath("//button[@type='submit']");


	public boolean isGiftingPage() {
		String currUrl = driver.getCurrentUrl();
		return currUrl.contains("gifting");
	}

	public void enterGiftAmount(String amount){
		driver.findElement(giftAmountField).clear();
		driver.findElement(giftAmountField).sendKeys(amount);
	}
	
	public void enterInNameField(String name) {
		driver.findElement(nameField).clear();
		driver.findElement(nameField).sendKeys(name);
	}
	
	public void enterInEmailField(String email) {
		driver.findElement(emailField).clear();
		driver.findElement(emailField).sendKeys(email);
	}
	
	public void enterInPhoneField(String phone) {
		driver.findElement(phoneField).clear();
		driver.findElement(phoneField).sendKeys(phone);
	}
	
	public void enterInMessageField(String message) {
		driver.findElement(messageField).clear();
		driver.findElement(messageField).sendKeys(message);
	}

	public void  clickSendGiftButton(){
		driver.findElement(showGiftButton).click();
	}

	public void selectCard(){
		driver.findElement(selectCardButton).click();
	}

	public void clickSendGift(){
		driver.findElement(sendGiftButton).click();
	}

	public void clickOk(){
		WebElement okPopUpElement = driver.findElement(okPopUp);
		okPopUpElement.click();
	}

	public void addClusterAmount(String amount){
		driver.findElement(clusterAmount).clear();
		driver.findElement(clusterAmount).sendKeys(amount);
	}

	public void clickCheckOutButton(){
		driver.findElement(checkOutButton).click();
	}

	public void clickCheckOutCheckBox(){
		new WebDriverWait(driver, 1).until(ExpectedConditions.elementToBeClickable(checkOutCheckBox)).click();
	}

	public void clickTryAgain() throws Exception {
		WebElement tryAgainPopup = driver.findElement(tryAgainPopUp);
		Thread.sleep(1000);
		tryAgainPopup.click();
	}
	
}
