package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxWithPageObjectTest extends BaseTest {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    @DisplayName("Проверка полного заполнения формы")
    public void fillInAllFieldsOfTextBoxForm() {
        textBoxPage.openPage()
                .setFullName("Ivan Petrov")
                .setEmail("test1@test.ru")
                .setCurrentAddress("Moscow, Lenin street, 1")
                .setPermanentAddress("Moscow, Lenin street, 107")
                .submit()
                .checkOutputFormIsVisible()
                .checkNameInOutputForm("Ivan Petrov")
                .checkEmailInOutputForm("test1@test.ru")
                .checkCurrentAddressInOutputForm("Moscow, Lenin street, 1")
                .checkPermanentAddressInOutputForm("Moscow, Lenin street, 107");
    }
}
