package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {

    public WebDriver driver;
    public WebDriverWait wait;

//    private By continueButton = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/form/button");
  //  private By continueButton = By.xpath("//button[text()='Continue']");

    private By tryAgainPopUp = By.xpath("//button[contains(text(),'Try again')]");
    private By okPopUp = By.xpath("//button[contains(text(),'Ok')]");

    private By countryCodeSelector = By.xpath("//div[@class=\"selected-dial-code\"]");
    private By phoneNumberField = By.xpath("//input[@id='phone_number']");
    private By indiaOption = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/fieldset[1]/div[4]/div[1]/div[1]/div[1]/ul[1]/li[5]");
    private By usaOption = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/fieldset[1]/div[4]/div[1]/div[1]/div[1]/ul[1]/li[3]");

    private By emailField = By.xpath("//input[@id='email']");
    private By next1 = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/fieldset[1]/button[1]");
    private By next2 = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/fieldset[2]/div[2]/button[1]");

    private By sendAgain =By.xpath("//a[@id='sendAgain']");
    private By otp1= (By.xpath("//input[@id='codeBox1']"));
    private By otp2= (By.xpath("//input[@id='codeBox2']"));
    private By otp3= (By.xpath("//input[@id='codeBox3']"));
    private By otp4= (By.xpath("//input[@id='codeBox4']"));

    private By firstName = By.xpath("//input[@id='first_name']");
  //  private By middleName = By.xpath("//*[@id=\"txtMiddleName\"]");
    private By lastName = By.xpath("//input[@id='last_name']");
 //   private By dob = By.xpath("//*[@id=\"txtDob\"]");

  //  private By enterCity = By.xpath("//*[@id=\"locality\"]");
   // private By enterState = By.xpath("//*[@id=\"state\"]");
    //private By enterCountry = By.xpath("//*[@id=\"country\"]");
    private By signUpWithGoogle = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/a[1]/button[1]/img[1]");
    private By password = By.xpath("//input[@id='password']");
    private By rePassword = By.xpath("//input[@id='re_password']");

    private By userAgreement = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/fieldset[3]/div[3]/label[1]");
    private By finalSignUpButton = By.xpath("//button[contains(text(),'Sign Up')]");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,120);
    }

    public String getUrl(){
       return driver.getCurrentUrl();
    }

    public void clickNext1Button(){
        driver.findElement(next1).submit();
    }
    public void clickNext2Button(){
        driver.findElement(next2).submit();
    }

    public boolean isTryAgainPopUpShown(){
        try {
            WebElement element = (new WebDriverWait(driver, 3))
                    .until(ExpectedConditions.elementToBeClickable(tryAgainPopUp));
            return element.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public boolean isOkPopUpShown(){
        try {
            WebElement element = (new WebDriverWait(driver, 3))
                    .until(ExpectedConditions.elementToBeClickable(okPopUp));
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public void clickTryAgain(){
        WebElement element = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.elementToBeClickable(tryAgainPopUp));
        element.click();
    }

    public void clickOk(){
        driver.findElement(okPopUp).click();
    }

    public void clickCountryCodeSelector(){
        WebElement element = (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.elementToBeClickable(countryCodeSelector));
        element.click();
    }

    public void clickIndiaOption(){
        driver.findElement(indiaOption).click();

    }

    public void clickUsaOption(){
        driver.findElement(usaOption).click();

    }

    public void addPhoneNumber(String phoneNumber){
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void addGmailID(String text){
        driver.findElement(emailField).sendKeys(text);
    }

    public void enterOtp(String otp){
        driver.findElement(otp1).sendKeys(otp.charAt(0)+"");
        driver.findElement(otp2).sendKeys(otp.charAt(1)+"");
        driver.findElement(otp3).sendKeys(otp.charAt(2)+"");
        driver.findElement(otp4).sendKeys(otp.charAt(3)+"");
    }

    public void addFirstName(String name){
        driver.findElement(firstName).sendKeys(name);
    }

  /*  public void addMiddleName(String name){
        driver.findElement(middleName).sendKeys(name);
    }*/

    public void addLastName(String name){
        driver.findElement(lastName).sendKeys(name);
    }

  /*  public void setDob(String date){
        driver.findElement(dob).sendKeys(date);
    }

    public void setCity(String text){
        driver.findElement(enterCity).sendKeys(text);
    }

    public void setState(String text){
        driver.findElement(enterState).sendKeys(text);
    }

    public void setCountry(String text){
        driver.findElement(enterCountry).sendKeys(text);
    }
*/
    public void setPassword(String text){
        driver.findElement(password).sendKeys(text);
    }

    public void clickUserAgreement(){
        driver.findElement(userAgreement).click();
    }

    public void setRePassword(String text){
        driver.findElement(rePassword).sendKeys(text);
    }

}


