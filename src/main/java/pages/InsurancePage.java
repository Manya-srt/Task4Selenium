package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;


public class InsurancePage {
    //Название заголовка
    @FindBy(xpath = "//div[@class='sbrf-rich-outer']/h3[contains(text(),'Страхование путешественников')]")
    public WebElement title;

    //Кнопка оформить онлайн
    @FindBy(xpath = "//div[@data-pid='SBRF-TEXT-2247407']//a[contains(text(),'Оформить онлайн')]")
    public WebElement issueButtonClick;

    public InsurancePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 40, 1000);
        wait.until(ExpectedConditions.visibilityOf(title));
        wait.until(ExpectedConditions.visibilityOf(issueButtonClick));
    }
    public void switchWindow() {
        for (String handle : BaseSteps.getDriver().getWindowHandles()){
            BaseSteps.getDriver().switchTo().window(handle);
        }
    }
}
