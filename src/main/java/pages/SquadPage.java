package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SquadPage {
	
	public WebDriver driver;
	public WebDriverWait wait;

	private By addParticipant = By.id("addBtn");
	private By enterEmail = By.xpath("//input[@name='guardianEmail']");
	private By addBtn = By.id("addParticipantBtn");

	private By noUserError = By.xpath("//*[text()='No Such User Exists']");
	private By emptyUserError = By.xpath("//*[text()='Invalid Email Format']");

	private By name = By.xpath("//input[@name='name']");

	private By randomClick = By.id("guardianModal");

	private By addicon = By.id("iconImg");
	private By firstIcon = By.xpath("//*[@id='iconModalBody']/div[1]/div");

	private By randomInterest = By.xpath("//label[@for='interests28']");

	private By submit = By.id("btnsubmit");

	private By okPopUp = By.xpath("//a[text()='OK']");

	private By interestError = By.xpath("//*[text()='Please select some interests for squad']");
	private By memberError = By.xpath("//*[text()='Please select members for squad']");

	private By firstSquad = By.xpath("//*[@id=\"listRooms\"]/div[1]/div");
	private By membersSection = By.xpath("//*[@id=\"nav-members\"]");

	public SquadPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,120);
	}


	public boolean isSquadCreatePage() {
		String currUrl = driver.getCurrentUrl();
		return currUrl.contains("squad/create");
	}

	public void clickAddParticipant(){
		driver.findElement(addParticipant).click();
	}

	public void addEmail(String email){
		WebElement element = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(enterEmail));
		element.sendKeys(email);
	}

	public void clickAddButton(){
		driver.findElement(addBtn).click();
	}

	public boolean isShownFakeError(){
		WebElement element = (new WebDriverWait(driver, 5))
				.until(ExpectedConditions.elementToBeClickable(noUserError));
		return element.isDisplayed();
	}
	public boolean isShownEmptyError(){
		WebElement element = (new WebDriverWait(driver, 5))
				.until(ExpectedConditions.elementToBeClickable(emptyUserError));
		return element.isDisplayed();
	}

	public boolean isInterestErrorShown(){
		WebElement element = (new WebDriverWait(driver, 5))
				.until(ExpectedConditions.elementToBeClickable(interestError));
		return element.isDisplayed();
	}

	public boolean isMemberErrorShown(){
		WebElement element = (new WebDriverWait(driver, 5))
				.until(ExpectedConditions.elementToBeClickable(memberError));
		return element.isDisplayed();
	}

	public void enterName(String text){
		driver.findElement(name).sendKeys(text);
	}

	public void randomClick(){
		driver.findElement(randomClick).click();
	}

	public void clickAddIcon(){
		driver.findElement(addicon).click();
	}

	public void clickRandomInterest(){
		driver.findElement(randomInterest).click();
	}

	public void clickFirstIcon(){
		WebElement element = (new WebDriverWait(driver, 5))
				.until(ExpectedConditions.elementToBeClickable(firstIcon));
		element.click();
	}

	public void clickSubmit(){
		driver.findElement(submit).submit();
	}

	public void clickOkPopUp(){
		WebElement element = (new WebDriverWait(driver, 5))
				.until(ExpectedConditions.elementToBeClickable(okPopUp));
		element.click();
	}

	public void clickFirstSquad(){
		WebElement element = (new WebDriverWait(driver, 5))
				.until(ExpectedConditions.elementToBeClickable(firstSquad));
		element.click();
	}

	public void clickMembers(){
		driver.findElement(membersSection).click();
	}
	
	
}
