package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultFormComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage extends AbstractPage {

    private SelenideElement header = $(".text-center"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            phoneInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            uploadPictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateSelect = $("#state"),
            citySelect = $("#city");


    private ElementsCollection genderRadioButtons = $$(".custom-radio"),
            hobbiesCheckboxes = $$("custom-checkbox"),
            stateOptions = $$("[id*= select-3-option]"),
            cityOptions = $$("[id*= select-4-option]");

    private CalendarComponent calendar = new CalendarComponent();
    private ResultFormComponent resultForm = new ResultFormComponent();

    @Override
    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        this.header.shouldHave(text("Practice Form"));
        return this;
    }

    public PracticeFormPage setFirstName(String firstName) {
        this.firstNameInput.setValue(firstName);
        return this;
    }

    public PracticeFormPage setLastName(String lastName) {
        this.lastNameInput.setValue(lastName);
        return this;
    }

    public PracticeFormPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public PracticeFormPage setGender(String gender) {
        genderRadioButtons.findBy(text(gender)).click();
        return this;
    }

    public PracticeFormPage setPhone(String phone) {
        phoneInput.setValue(phone);
        return this;
    }

    public PracticeFormPage setBirthdayDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.shouldBeVisible();
        calendar.setDate("January", "2000", "1");
        return this;
    }

    public PracticeFormPage setSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public PracticeFormPage setHobbies(String... hobbies) {
        for (String hobby : hobbies) {
            hobbiesCheckboxes.findBy(text(hobby)).click();
        }
        return this;
    }

    public PracticeFormPage uploadPicture(String pathToPicture) {
        uploadPictureInput.uploadFromClasspath(pathToPicture);
        return this;
    }

    public PracticeFormPage setCurrentAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    public PracticeFormPage selectState(String state) {
        stateSelect.scrollTo().click();
        stateOptions.findBy(text(state)).click();
        return this;
    }

    public PracticeFormPage selectCity(String city) {
        citySelect.click();
        cityOptions.findBy(text(city)).click();
        return this;
    }

    public void checkResultForm(String name, String email, String gender, String phone, String birthday,
                                String subjects, String hobbies, String pictureName, String address, String stateAndCity) {
        resultForm.shouldBeVisible();
        resultForm.checkFullEnteredData(name, email, gender, phone, birthday, subjects, hobbies, pictureName, address, stateAndCity);
    }
}
