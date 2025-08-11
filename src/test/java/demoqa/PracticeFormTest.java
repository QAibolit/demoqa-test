package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

    public String email = "test123@test.ru";
    public String phone = "1234567891";
    public String address = "Lenin street, 1";

    @BeforeAll
    public static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    public void fillUpPracticeForm() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue(email);
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue(phone);

        // Заполнение календаря
        $("#dateOfBirthInput").click();
        $("[class$=month-container]").shouldBe(visible);
        $("[class$=month-select]").selectOption("January");
        $("[class$=year-select]").selectOption("2000");
        $(".react-datepicker__month").shouldBe(visible);
        $("[class*=day--001]").click();

        $("#subjectsInput").setValue("Design");
        $("#hobbies-checkbox-2").parent().click();
        $("#uploadPicture").uploadFromClasspath("uploadFiles/hedgehog.jpg");
        $("#currentAddress").setValue(address);
        $("#state").scrollTo().click();
        $(byText("Uttar Pradesh")).shouldBe(visible).click();
        $("#city").click();
        $(byText("Merrut")).shouldBe(visible).click();
        $("#submit").click();

        // Проверка итоговой модалки(не всегда сохраняется поле Subjects, поэтому его не проверяю)
        $(".modal-content").shouldBe(visible);
        $(byText("Student Name")).parent().shouldHave(text("Ivan Petrov"));
        $(byText("Student Email")).parent().shouldHave(text(email));
        $("table").$(byText("Gender")).parent().shouldHave(text("Male"));
        $("table").$(byText("Mobile")).parent().shouldHave(text(phone));
        $("table").$(byText("Date of Birth")).parent().shouldHave(text("01 January,2000"));
        $("table").$(byText("Hobbies")).parent().shouldHave(text("Reading"));
        $("table").$(byText("Picture")).parent().shouldHave(text("hedgehog.jpg"));
        $(byText("Address")).parent().shouldHave(text(address));
        $("table").$(byText("State and City")).parent().shouldHave(text("Uttar Pradesh Merrut"));
    }
}
