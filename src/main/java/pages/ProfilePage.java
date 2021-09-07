package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ProfilePage {
	
	public WebDriver driver;
	public WebDriverWait wait;

	protected By profileSection = By.xpath("//div[@id='editProfileSection']");

	private By firstName = By.xpath("//input[@name='firstName']");
	private By middleName = By.xpath("//input[@name='middleName']");
	private By lastName = By.xpath("//input[ @name='lastName']");


	private By addressSection = By.xpath("//div[@id='editAddressSection']");

	private By city = By.xpath("//input[@name='city']");
	private By state = By.xpath("//input[@name='state']");
	private By country = By.xpath("//input[@name='country']");


	private By passwordSection = By.xpath("//div[@id='changePasswordSection']");

	private By currentPassword = By.xpath("//input[@id='currentPassword']");
	private By newPassword = By.xpath("//input[@id='txtPassword']");
	private By reEnterPassword = By.xpath("//input[@id='txtRePassword']");

	private By savePassword = By.xpath("(//button[@type='submit'])[3]");
	private By saveProfile = By.xpath("(//button[@type='submit'])[1]");
	private By saveAddress = By.xpath("(//button[@type='submit'])[2]");






	private By interestSection = By.xpath("//div[@id='interestsProfile']");
	private By interestSectionCol = By.id("interestsProfileCol");
	
	private By activitiesSection = By.xpath("//div[@id='activitiesProfile']");
	private By activitiesSectionCol = By.id("activitiesProfileCol");

	private By clusterHoldingSection = By.xpath("//div[@id='clusterHolding']");
	private By clusterHoldingSectionCol = By.xpath("//div[@id='clusterHoldingCol']");

	private By transactionSection = By.xpath("//div[@id='transaction']");
	private By transactionSectionCol = By.xpath("//div[@id='transactionCol']");

	private By emailPrefSection = By.xpath("//div[@id='emailpref']");
	private By emailPrefSectionCol = By.xpath("//div[@id='emailprefCol']");

	private By californiaSection = By.xpath("//div[@id='california']");
	private By californiaSectionCol = By.xpath("//div[@id='californiaCol']");

	private By disclosureSection = By.xpath("//div[@id='disclosures']");
	private By disclosureSectionCol = By.xpath("//div[@id='disclosuresCol']");

	private By okPopUp = By.xpath("//a[text()='OK']");
	private By tryAgainPopUp =  By.xpath("//a[contains(text(),'Try again')]");

	private By uploadProfile = By.id("editProfilePicture");

	private By alert = By.xpath("//div[@role='alert']");

	private By subscribe = By.xpath("//button[text()='Subscribe']");
	private By unSubscribe = By.xpath("//button[text()='Unsubscribe']");


	private By privacyPolicy = By.xpath("//*[text()='Privacy Policy']");
	private By cookiePolicy = By.xpath("//*[text()='Cookie Policy']");
	private By guardianTermsAndConditions = By.xpath("//*[text()='Guardian Terms and Conditions']");
	private By dataSources = By.xpath("//*[text()='Data Sources, Analytics & Technology']");
	private By financialStatements = By.xpath("//*[text()='Financial Statements - Dec 2020']");
	private By certificateIncorporation = By.xpath("//*[text()='Certificate of Incorporation']");
	private By incorporationDocuments = By.xpath("//*[text()='Incorporation Documents']");
	private By surveyorReport = By.xpath("//*[text()='Surveyor’s Report - Gigrin Prysg']");
	private By SurveyorCoed  = By.xpath("//*[text()='Surveyor’s Report - Coed Rhyal']");

	private By californiaYes  = By.xpath("//button[text()='Yes']");
	private By californiaNo  = By.xpath("//button[text()='I am not a California Resident']");

	private By saveInterest = By.xpath("//*[@id=\"interestsProfileCol\"]/div/form/button");
	private By saveActivities = By.xpath("//*[@id=\"activitiesProfileCol\"]/div/form/button");

	private By firstTransaction = By.xpath("//*[@id=\"transactionDetails\"]/div[1]");
	private By goBackTransaction = By.xpath("//*[@id=\"exampleModal0\"]/div/div/div/div[3]/button[1]");

	private By downloadTransactions = By.xpath("//*[@id=\"downloadTransactions\"]");

	private By firstCluster = By.xpath("//*[@id=\"holdingDetails\"]/div[1]");
	private By goBackClusture = By.xpath("//*[@id=\"holdingModal0\"]/div/div/div/button");

	private By downloadCluster = By.xpath("//*[@id=\"downloadHoldings\"]");
















	public ProfilePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,120);
	}

	public boolean isProfilePage() {
		String currUrl = driver.getCurrentUrl();
		return currUrl.contains("profile");
	}


	public String getFirstName(){
	   return driver.findElement(firstName).getAttribute("Value");
	}

	public void setFirstName(String text){
		driver.findElement(firstName).clear();
		driver.findElement(firstName).sendKeys(text);
	}

	public String getMiddleName(){
		String middleNameText = driver.findElement(middleName).getAttribute("Value");
		if(middleNameText==null){
			return "";
		}
		return middleNameText;
	}

	public void setMiddleName(String text){
		driver.findElement(middleName).clear();
		driver.findElement(middleName).sendKeys(text);
	}

	public String getLastName(){
		return driver.findElement(lastName).getAttribute("Value");
	}

	public void setLastName(String text){
		driver.findElement(lastName).clear();
		driver.findElement(lastName).sendKeys(text);
	}

	public String getCity(){
		return driver.findElement(city).getAttribute("Value");
	}

	public void setCity(String text){
		driver.findElement(city).clear();
		driver.findElement(city).sendKeys(text);
	}


	public String getState(){
		return driver.findElement(state).getAttribute("Value");
	}

	public void setState(String text){
		driver.findElement(state).clear();
		driver.findElement(state).sendKeys(text);
	}

	public String getCountry(){
		return driver.findElement(country).getAttribute("Value");
	}

	public void setCountry(String text){
		driver.findElement(country).clear();
		driver.findElement(country).sendKeys(text);
	}

	public void openProfileSection(){
		driver.findElement(profileSection).click();
	}
	public void openAddressSection(){
		driver.findElement(addressSection).click();
	}
	public void openInterestSection(){
		driver.findElement(interestSection).click();
	}
	public boolean isInterestSectionVisible(){
		return driver.findElement(interestSectionCol).isDisplayed();
	}
	public void openActivitySection(){
		driver.findElement(activitiesSection).click();
	}
	public boolean isActivitySectionVisible(){
		return driver.findElement(activitiesSectionCol).isDisplayed();
	}
	public void openClusterSection(){
		driver.findElement(clusterHoldingSection).click();
	}
	public boolean isClusterHoldingSectionVisible(){
		return driver.findElement(clusterHoldingSectionCol).isDisplayed();
	}
	public void openTransactionSection(){
		driver.findElement(transactionSection).click();
	}
	public boolean isTransactionSectionVisible(){
		return driver.findElement(transactionSectionCol).isDisplayed();
	}
	public void openEmailPrefSection(){
		driver.findElement(emailPrefSection).click();
	}
	public boolean isEmailPrefSectionVisible(){
		return driver.findElement(emailPrefSectionCol).isDisplayed();
	}
	public void openCaliforniaSection(){
		driver.findElement(californiaSection).click();
	}
	public boolean isCaliforniaSectionVisible(){
		return driver.findElement(californiaSectionCol).isDisplayed();
	}
	public void openDisclosureSection(){
		driver.findElement(disclosureSection).click();
	}
	public boolean isDisclosureSectionVisible(){
		return driver.findElement(disclosureSectionCol).isDisplayed();
	}
	public void openPasswordSection(){
		driver.findElement(passwordSection).click();
	}
	public void enterCurrentPassword(String password){
		driver.findElement(currentPassword).sendKeys(password);
	}
	public void enterNewPassword(String password){
		driver.findElement(newPassword).sendKeys(password);
	}
	public void reEnterNewtPassword(String password){
		driver.findElement(reEnterPassword).sendKeys(password);
	}

	public void clickSavePassword(){
		driver.findElement(savePassword).submit();
	}

	public void clickSaveProfile(){
		driver.findElement(saveProfile).submit();
	}

	public void clickSaveAddress(){
		driver.findElement(saveAddress).submit();
	}

	public void clickOk(){
		WebElement okPopUpElement = driver.findElement(okPopUp);
		okPopUpElement.click();
	}

	public void clickTryAgain(){
		WebElement element = (new WebDriverWait(driver, 5))
				.until(ExpectedConditions.elementToBeClickable(tryAgainPopUp));
		element.click();
	}

	public void uploadProfilePicture(String path){
		WebElement uploadElement = driver.findElement(uploadProfile);
		uploadElement.sendKeys(path);
	}

	public void clickAllInterestList(){
		for(int i = 28;i<=53;i++){
			driver.findElement(By.xpath("//label[@for='interests"+i+"']")).click();
		}
	}

	public void clickAllActivitiesList(){
		for(int i = 23;i<=44;i++){
			driver.findElement(By.xpath("//label[@for='activities"+i+"']")).click();
		}
	}

	public void toggleSubscribe(){
		WebElement subscribeElement = driver.findElement(subscribe);
		WebElement unsubscribeElement = driver.findElement(unSubscribe);

		if(subscribeElement.isDisplayed()){
			subscribeElement.click();
		}else{
			unsubscribeElement.isDisplayed();
		}
	}

	public void clickPrivacyPolicy(){
		driver.findElement(privacyPolicy).click();
	}

	public void clickCookiePolicy(){
		driver.findElement(cookiePolicy).click();
	}

	public void clickGuardianTermsAndConditions(){
		driver.findElement(guardianTermsAndConditions).click();
	}

	public void clickDataSources(){
		driver.findElement(dataSources).click();
	}

	public void clickFinancialStatements(){
		driver.findElement(financialStatements).click();
	}

	public void clickCertificateIncorporation(){
		driver.findElement(certificateIncorporation).click();
	}

	public void clickIncorporationDocuments(){
		driver.findElement(incorporationDocuments).click();
	}

	public void clickSurveyorReport(){
		driver.findElement(surveyorReport).click();
	}

	public void clickSurveyorCoed(){
		driver.findElement(SurveyorCoed).click();
	}

	public String getNextTabUrl(){
		ArrayList<String> wins = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(wins.get(wins.size()-1));
		return driver.getCurrentUrl();
	}


	public void closeTab(){
		ArrayList<String> wins = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(wins.get(0));
	}

	public void toggleCalifornia(){
		WebElement yes = driver.findElement(californiaYes);
		WebElement no = driver.findElement(californiaNo);

		if(yes.isDisplayed()){
			yes.click();
		}else{
			no.click();
		}
	}

	public void clickSaveInterest(){
		driver.findElement(saveInterest).click();
	}

	public void clickSaveActivities(){
		driver.findElement(saveActivities).click();
	}

	public void clickFirstTransaction(){
		WebElement element = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.elementToBeClickable(firstTransaction));
		element.click();
	}

	public void goBackTransaction(){
		WebElement element = (new WebDriverWait(driver, 3))
				.until(ExpectedConditions.elementToBeClickable(goBackTransaction));
		element.click();
	}

	public void clickDownloadTransactions(){
		WebElement element = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.elementToBeClickable(downloadTransactions));
		element.click();
	}

	public void clickFirstCluster(){
		WebElement element = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.elementToBeClickable(firstCluster));
		element.click();
	}

	public void goBackCluster(){
		WebElement element = (new WebDriverWait(driver, 3))
				.until(ExpectedConditions.elementToBeClickable(goBackClusture));
		element.click();
	}

	public void clickDownloadCluster(){
		WebElement element = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.elementToBeClickable(downloadCluster));
		element.click();
		driver.findElement(By.xpath("//*[@id=\"downloadHoldingsUL\"]/li[2]")).click();
	}

	public boolean isAlertVisible(){
	    return driver.findElement(alert).isDisplayed();
	}

}
