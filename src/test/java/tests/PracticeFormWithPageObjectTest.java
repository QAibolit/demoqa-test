package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

public class PracticeFormWithPageObjectTest extends BaseTest {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    @DisplayName("Проверка полного заполнения формы регистрации")
    public void fillInAllFieldsOfPracticeForm() {
        practiceFormPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Petrov")
                .setEmail("test123@test.ru")
                .setGender("Male")
                .setPhone("1234567891")
                .setBirthdayDate("3", "January", "2000")
                .setSubject("English")
                .setHobbies("Reading")
                .uploadPicture("uploadFiles/hedgehog.jpg")
                .setCurrentAddress("Lenin street, 1")
                .selectState("Uttar Pradesh")
                .selectCity("Merrut")
                .submit()
                .checkResultModalIsVisible()
                .checkNameInResultModal("Ivan Petrov")
                .checkEmailInResultModal("test123@test.ru")
                .checkGenderInResultModal("Male")
                .checkPhoneInResultModal("1234567891")
                .checkBirthdayInResultModal("03 January,2000")
                .checkSubjectsInResultModal("English")
                .checkHobbiesInResultModal("Reading")
                .checkPictureNameInResultModal("hedgehog.jpg")
                .checkAddressInResultModal("Lenin street, 1")
                .checkStateAndCityInResultModal("Uttar Pradesh Merrut");
    }

    @Test
    @DisplayName("Проверка заполнения обязательных полей формы регистрации")
    public void fillInRequiredFieldsOfPracticeForm() {
        practiceFormPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Petrov")
                .setGender("Male")
                .setPhone("1234567891")
                .submit()
                .checkResultModalIsVisible()
                .checkNameInResultModal("Ivan Petrov")
                .checkGenderInResultModal("Male")
                .checkPhoneInResultModal("1234567891");

    }

    @Test
    @DisplayName("Проверка частичного заполнения обязательных полей формы регистрации")
    public void fillInRequiredFieldsOfPracticeFormPartially() {
        practiceFormPage.openPage()
                .submit()
                .checkFirstNameFieldColor("rgb(220, 53, 69)")
                .checkLastNameFieldColor("rgb(220, 53, 69)")
                .checkPhoneFieldColor("rgb(220, 53, 69)")
                .checkGenderRadiobuttonsColor("rgb(220, 53, 69)");
    }
}
