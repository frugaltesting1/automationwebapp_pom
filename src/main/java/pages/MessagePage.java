package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePage {

		public WebDriver driver;
		public WebDriverWait wait;

		private By firstChat = By.xpath("//*[@id=\"listRooms\"]/div[1]/div");
		private By messageField = By.xpath("//*[@id=\"chatBox\"]/div[4]/div/div/input");
		private By sendMessage = By.xpath("//*[@id=\"button-addon2\"]");

		private By newMessage = By.xpath("//*[@id=\"addBtn\"]/button");
		private By emailIDField = By.xpath("//*[@id=\"guardianModalBody\"]/div/input");
		private By addButton = By.xpath("//*[@id=\"addParticipantBtn\"]");

		private By noUserError = By.xpath("//*[@id=\"guardianModalBody\"]/div/span");
		private By selfInviteError = By.xpath("//*[@id=\"guardianModalBody\"]/div/span");

		public MessagePage(WebDriver driver) {
			this.driver = driver;
			wait = new WebDriverWait(driver,120);
		}

		
		
		public boolean isMessagePage() {
			String currUrl = driver.getCurrentUrl();
			return currUrl.contains("chat");
		}

		public void clickFirstChat(){
			WebElement element = (new WebDriverWait(driver, 30))
					.until(ExpectedConditions.elementToBeClickable(firstChat));
			element.click();
		}

		public void enterMessage(String message){
			driver.findElement(messageField).sendKeys(message);
		}

		public void clickSendMessage(){
			driver.findElement(sendMessage).click();
		}

		public void clickAddNewMessage(){
			driver.findElement(newMessage).click();
		}

		public void enterEmailID(String emailID){
			WebElement element = (new WebDriverWait(driver, 30))
					.until(ExpectedConditions.elementToBeClickable(emailIDField));
			element.sendKeys(emailID);
		}

		public void clickAddButton(){
			driver.findElement(addButton).click();
		}

		public boolean isNoUserErrorShown(){
			WebElement element = (new WebDriverWait(driver, 30))
					.until(ExpectedConditions.elementToBeClickable(noUserError));
		   return element.isDisplayed();
		}

	public boolean isSelfInviteErrorShown(){
		WebElement element = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.elementToBeClickable(selfInviteError));
		return element.isDisplayed();
	}
	}

