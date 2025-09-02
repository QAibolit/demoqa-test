package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultFormComponent extends BaseComponent {

    private SelenideElement root = $(".modal-content"),
            studentName = $(byText("Student Name")).sibling(0),
            studentEmail = $(byText("Student Email")).sibling(0),
            gender = $("tr").$(byText("Gender")).sibling(0),
            phoneNumber = $("tr").$(byText("Mobile")).sibling(0),
            birthdayDate = $("tr").$(byText("Date of Birth")).sibling(0),
            subjects = $("tr").$(byText("Subjects")).sibling(0),
            hobbies = $("tr").$(byText("Hobbies")).sibling(0),
            pictureName = $("tr").$(byText("Picture")).sibling(0),
            address = $(byText("Address")).sibling(0),
            stateAndCiry = $("tr").$(byText("State and City")).sibling(0);

    public void checkFullEnteredData(String name, String email, String gender, String phone, String birthday,
                                 String subjects, String hobbies, String pictureName, String address, String stateAndCity) {
        this.studentName.shouldHave(text(name));
        this.studentEmail.shouldHave(text(email));
        this.gender.shouldHave(text(gender));
        this.phoneNumber.shouldHave(text(phone));
        this.birthdayDate.shouldHave(text(birthday));
        this.subjects.shouldHave(text(subjects));
        this.hobbies.shouldHave(text(hobbies));
        this.pictureName.shouldHave(text(pictureName));
        this.address.shouldHave(text(address));
        this.stateAndCiry.shouldHave(text(stateAndCity));
    }
}
