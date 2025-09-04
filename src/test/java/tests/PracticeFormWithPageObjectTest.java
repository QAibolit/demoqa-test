package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

public class PracticeFormWithPageObjectTest extends BaseTest {

    String firstName = "Ivan",
            lastName = "Petrov",
            email = "test123@test.ru",
            gender = "Male",
            phone = "1234567891",
            fullName = "Ivan Petrov",
            subject = "English",
            hobby = "Reading",
            address = "Lenin street, 1",
            redColor = "rgb(220, 53, 69)";

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    @DisplayName("Проверка полного заполнения формы регистрации")
    public void fillInAllFieldsOfPracticeFormTest() {
        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(phone)
                .setBirthdayDate("3", "January", "2000")
                .setSubject(subject)
                .setHobbies(hobby)
                .uploadPicture("uploadFiles/hedgehog.jpg")
                .setCurrentAddress(address)
                .selectState("Uttar Pradesh")
                .selectCity("Merrut")
                .submit()
                .checkResultModalIsVisible()
                .checkNameInResultModal(fullName)
                .checkEmailInResultModal(email)
                .checkGenderInResultModal(gender)
                .checkPhoneInResultModal(phone)
                .checkBirthdayInResultModal("03 January,2000")
                .checkSubjectsInResultModal(subject)
                .checkHobbiesInResultModal(hobby)
                .checkPictureNameInResultModal("hedgehog.jpg")
                .checkAddressInResultModal(address)
                .checkStateAndCityInResultModal("Uttar Pradesh Merrut");
    }

    @Test
    @DisplayName("Проверка заполнения обязательных полей формы регистрации")
    public void fillInRequiredFieldsOfPracticeFormTest() {
        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setPhone(phone)
                .submit()
                .checkResultModalIsVisible()
                .checkNameInResultModal(fullName)
                .checkGenderInResultModal(gender)
                .checkPhoneInResultModal(phone);

    }

    @Test
    @DisplayName("Проверка частичного заполнения обязательных полей формы регистрации")
    public void fillInRequiredFieldsOfPracticeFormPartiallyTest() {
        practiceFormPage.openPage()
                .submit()
                .checkFirstNameFieldColor(redColor)
                .checkLastNameFieldColor(redColor)
                .checkPhoneFieldColor(redColor)
                .checkGenderRadiobuttonsColor(redColor);
    }
}
