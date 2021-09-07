package utility;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;

public class AllureReport {
    public static void DelPreviousReport() throws Exception {
        try {
            String filePath = System.getProperty("user.dir") + "\\allure-results";
            File file = new File(filePath);
            FileUtils.deleteDirectory(file);
            System.out.println(filePath);
            System.out.println("Files deleted........");
        } catch (Exception e) {
            saveTextLog("ERR: " +e.getMessage());
            throw e;
        }
    }

    public static void changeStepName(String name)
    {
        AllureLifecycle lifecycle = Allure.getLifecycle();
        lifecycle.updateStep(testStep -> testStep.setName(name));
    }

    @Attachment(value = "Page Screenshot",type = "image/png")
    public static byte[] Screenshot(WebDriver driver, String message) {
        saveTextLog(message);
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        System.out.println(message);
        return message;
    }
}