package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

    public String email = "test123@test.ru";
    public String phone = "1234567891";
    public String address = "Lenin street, 1";
    public String filePath = System.getProperty("user.dir") + "/src/test/resources/uploadFiles/hedgehog.jpg";

    @BeforeAll
    public static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    public void fillUpPracticeForm() {
        open("/automation-practice-form");
        $x(".//*[@id='firstName']").setValue("Ivan");
        $x(".//*[@id='lastName']").setValue("Petrov");
        $x(".//*[@id='userEmail']").setValue(email);
        $x(".//*[@id='gender-radio-1']/..").click();
        $x(".//*[@id='userNumber']").setValue(phone);

        // Заполнение календаря
        $x(".//*[@id='dateOfBirthInput']").click();
        $x(".//*[@class='react-datepicker__month-container']").shouldBe(visible);
        $x(".//*[contains(@class,'month-select')]").selectOption("January");
        $x(".//*[contains(@class,'year-select')]").selectOption("2000");
        $x(".//*[@class='react-datepicker__month']").shouldBe(visible);
        $x(".//*[contains(@class,'day--001')]").click();

        $x(".//*[@id='subjectsInput']").setValue("Design");
        $x(".//*[@id='hobbies-checkbox-2']/..").click();
        $x(".//*[@id='uploadPicture']").uploadFile(new File(filePath));
        $x(".//*[@id='currentAddress']").setValue(address);
        $x(".//*[@id='state']").scrollTo().click();
        $x(".//div[contains(text(),'Uttar Pradesh')]").shouldBe(visible).click();
        $x(".//*[@id='city']").click();
        $x(".//div[contains(text(),'Merrut')]").shouldBe(visible).click();
        $x(".//*[@id='submit']").click();

        // Проверка итоговой формы(не всегда сохраняются поля Gender, Subjects, Hobbies, поэтому их не проверяю)
        $x(".//*[@class='modal-content']").shouldBe(visible);
        $x(".//td[text()='Student Name']/following-sibling::td").shouldHave(text("Ivan Petrov"));
        $x(".//td[text()='Student Email']/following-sibling::td").shouldHave(text(email));
        $x(".//td[text()='Mobile']/following-sibling::td").shouldHave(text(phone));
        $x(".//td[text()='Date of Birth']/following-sibling::td").shouldHave(text("01 January,2000"));
        $x(".//td[text()='Picture']/following-sibling::td").shouldHave(text("hedgehog.jpg"));
        $x(".//td[text()='Address']/following-sibling::td").shouldHave(text(address));
        $x(".//td[text()='State and City']/following-sibling::td").shouldHave(text("Uttar Pradesh Merrut"));
    }
}
