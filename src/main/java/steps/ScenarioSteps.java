package steps;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.InsurancePage;

public class ScenarioSteps {
    MainPageSteps mainPageSteps = new MainPageSteps();
    InsurancePageSteps insurancePageSteps =new InsurancePageSteps();
    ProgramChoicePageSteps programChoicePageSteps = new ProgramChoicePageSteps();
    BlanckPageSteps blanckPageSteps = new BlanckPageSteps();


    @When("^выбран пункт меню \"(.*)\"$")
    public void selectMainMenuItem(String menuItem) {
        mainPageSteps.selectMainMenu(menuItem);
    }

    @When("^выбран вид страхования - \"(.*)\"$")
    public void selectSubMenuItem(String menuItem) {
        mainPageSteps.selectSubMenu(menuItem);
    }

    @When("^выполнена проверка заголовка - \"(.+)\"$")
    public void checkTitle(String title) {
        insurancePageSteps.stepCheckTitle(title);
    }

    @Then("^выполнено нажатие на кнопку - Оформить Онлайн$")
    public void clickSendButton() {
        insurancePageSteps.stepSendButton();
    }

    @When("^выполнен переход на другую вкладку")
    public void switchWindow() {
      insurancePageSteps.switchWindow();
    }

    @When("^выбрана минимальная сумма$")
    public void checkMinSum(String menuItem) {
        programChoicePageSteps.selectSum(menuItem);
    }

    @Then("^выполнено нажатие на кнопку - Оформить$")
    public void clickFormalizeButton() {
        programChoicePageSteps.stepIssueButton();
    }

    @When("^заполняются поля:$")
    public void stepFillFields(DataTable fields) {
        fields.asMap(String.class, String.class).forEach(
                (key, value) ->blanckPageSteps.stepFillField(key, value));
    }

    @Then("^значения полей равны:$")
    public void checkFields(DataTable fields) {
        fields.asMap(String.class, String.class).forEach(
                (field, value) -> blanckPageSteps.stepCheckFillField(field, value)
        );
    }

    @When("^выполнено нажатие на кнопку - Продолжить$")
    public void clickNext() {
        blanckPageSteps.continueButton();
    }

    @Then("^выполнена проверка ошибочного сообщения - \"(.+)\"$")
    public void checkMassage(String messageError) {
        blanckPageSteps.checkErrorMessageField(messageError);
    }

}