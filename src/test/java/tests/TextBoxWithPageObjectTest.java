package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxWithPageObjectTest extends BaseTest {

    String fullName = "Ivan Petrov",
            email = "test123@test.ru",
            currentAddress = "Moscow, Lenin street, 1",
            permanentAddress = "Moscow, Lenin street, 107";

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    @DisplayName("Проверка полного заполнения формы")
    public void fillInAllFieldsOfTextBoxFormTest() {
        textBoxPage.openPage()
                .closeBanners()
                .setFullName(fullName)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submit()
                .checkOutputFormIsVisible()
                .checkNameInOutputForm(fullName)
                .checkEmailInOutputForm(email)
                .checkCurrentAddressInOutputForm(currentAddress)
                .checkPermanentAddressInOutputForm(permanentAddress);
    }
}
