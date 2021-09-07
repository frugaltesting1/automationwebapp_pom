package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	public WebDriver driver;
	public WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,120);
	}

	private By emailAddressField = By.xpath("//*[@id=\"email\"]");
	private By passwordField = By.xpath("//*[@id=\"txtPassword\"]");
	private By loginButton = By.xpath("//*[@id=\"loginBtn\"]");
	private By facebookLink = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/form/div[4]/a[1]/button/i");
	private By gmailLink = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/form/div[4]/a[2]/button/img");
	private By signupTextLink = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/form/div[5]/a");
	private By forgetpasswordTextLink = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/form/div[2]/a");
	private By eyeButton = By.xpath("//*[@id=\"show_hide_password\"]/i");
	private By sgIcon = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[1]/div/img");

	private By selectCountryCode = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/form/div/div/select");

	private By selectPhoneNumber = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/form/div/div/input");
	
	private By WrongUsernameAndPasswordPopupText =By.xpath("//*[@id=\"exampleModal\"]/div/div/div[1]");

	private By submitButtonPhoneNumber = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/form/button");

	private By okPopUp = By.xpath("//a[text()='OK']");
	private By tryAgainPopUp =  By.xpath("//a[contains(text(),'Try again')]");

	private By otp1= (By.xpath("//*[@id=\"codeBox1\"]"));
	private By otp2= (By.xpath("//*[@id=\"codeBox2\"]"));
	private By otp3= (By.xpath("//*[@id=\"codeBox3\"]"));
	private By otp4= (By.xpath("//*[@id=\"codeBox4\"]"));

	private By newPassword = By.xpath("//*[@id=\"txtPassword\"]");
	private By repassword = By.xpath("//*[@id=\"txtRePassword\"]");

	public void enterEmailAddress(String email) {
		driver.findElement(emailAddressField).clear();
		driver.findElement(emailAddressField).sendKeys(email);
	}

	public void enterPasswordField(String password) {
		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(password);
	}

	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}

	public void clickSelectCountryButton(){
		driver.findElement(selectCountryCode).click();
	}

	public void selectCountryCode(String str){
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/form/div/div/select/optgroup/option[@value='"+str+"']")).click();
	}

	public void clickForgetPassword() {
		driver.findElement(forgetpasswordTextLink).click();
	}

	public void setPhoneNumber(String number){
		driver.findElement(selectPhoneNumber).sendKeys(number);
	}

	public void clickSubmitButton(){
		driver.findElement(submitButtonPhoneNumber).submit();
	}

	public void clickEyeButton() {
		driver.findElement(eyeButton).click();
	}

	public void clickGmailLink() {
		driver.findElement(gmailLink).click();
	}

	public void clickFacebookLink() {
		driver.findElement(facebookLink).click();
	}

	public void clickSignUpTextLink() {
		driver.findElement(signupTextLink).click();
	}

	public boolean isOkPopUpShown(){
		WebElement element = (new WebDriverWait(driver, 3))
				.until(ExpectedConditions.elementToBeClickable(okPopUp));
		return element.isDisplayed();
	}

	public void clickOkPopUp(){
		WebElement element = (new WebDriverWait(driver, 3))
				.until(ExpectedConditions.elementToBeClickable(okPopUp));
		 element.click();
	}

	public boolean isTryAgainShown(){
		WebElement element = (new WebDriverWait(driver, 5))
				.until(ExpectedConditions.elementToBeClickable(tryAgainPopUp));
		return element.isDisplayed();
	}

	public DashboardPage nativeLogin(String user, String pass) {
		enterEmailAddress(user);
		enterPasswordField(pass);
		clickLoginButton();
		return new DashboardPage(driver);
	}

	public void enterOtp(String otp){
		driver.findElement(otp1).sendKeys(otp.charAt(0)+"");
		driver.findElement(otp2).sendKeys(otp.charAt(1)+"");
		driver.findElement(otp3).sendKeys(otp.charAt(2)+"");
		driver.findElement(otp4).sendKeys(otp.charAt(3)+"");
	}

	public void enterNewPassword(String password){
		driver.findElement(newPassword).sendKeys(password);
	}

	public void enterRePassword(String password){
		driver.findElement(repassword).sendKeys(password);
	}

	public boolean verifyWrongUserNameOrPasswordPopup() {
		if(driver.findElement(WrongUsernameAndPasswordPopupText).isDisplayed()) {
			System.out.println("Wrong Username and password  and POPUP TEXT ="+driver.findElement(WrongUsernameAndPasswordPopupText).getText());
			return true;
		}
		return false;
	}


	
	

}