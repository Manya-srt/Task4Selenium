package steps;

import org.openqa.selenium.WebElement;
import pages.BlanckPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BlanckPageSteps {

    @Step("Поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value) {
        new BlanckPage().fillField(field, value);
    }

    @Step("Заполняются поля:")
    public void stepFillFields(HashMap<String, String> fields) {
        fields.forEach(this::stepFillField);
    }

    @Step("Поле {0} заполнено значением {1}")
    public void stepCheckFillField(String field, String value) {
        String actual = new BlanckPage().getFillField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }


    @Step("Поля заполнены верно:")
    public void stepCheckFillFields(HashMap<String, String> fields) {
        fields.forEach(this::stepCheckFillField);
    }

    @Step("Пол заполнен верно")


    public void stepCheckMale(WebElement female){
        new BlanckPage().female.click();
        assertTrue("Неверно заполнен пол", female.isSelected());
    }

    @Step("Выполнено нажатие на кнопку - Продолжить")
    public void continueButton() {
        new BlanckPage().continueButton.click();
    }

    @Step("Выполнена проверка наличия ошибки на странице")
    public void checkErrorMessageField(String expecteErrorMessage) {
        String actualErrorMessage = new BlanckPage().errorMessage.getText();
        assertEquals(String.format("Заголовок равен [%s]. Ожидалось - [%s]", actualErrorMessage, expecteErrorMessage),
                expecteErrorMessage, actualErrorMessage);
    }
}