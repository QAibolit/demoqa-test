package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.OutputFormComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage extends AbstractPage {

    private SelenideElement header = $(".text-center"),
            fullNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit");

    private OutputFormComponent outputForm = new OutputFormComponent();

    @Override
    public TextBoxPage openPage() {
        open("/text-box");
        this.header.shouldHave(text("Practice Form"));
        return this;
    }

    public TextBoxPage setFullName(String fullName) {
        this.fullNameInput.setValue(fullName);
        return this;
    }

    public TextBoxPage setEmail(String email) {
        this.emailInput.setValue(email);
        return this;
    }

    public TextBoxPage setCurrentAddress(String currentAddress) {
        this.currentAddressInput.setValue(currentAddress);
        return this;
    }

    public TextBoxPage setPermanentAddress(String permanentAddress) {
        this.permanentAddressInput.setValue(permanentAddress);
        return this;
    }

    public TextBoxPage submit() {
        this.submitButton.click();
        return this;
    }

    public void checkOutputForm(String fullName, String email, String currentAddress, String permanentAddress) {
        outputForm.shouldBeVisible();
        outputForm.checkEnteredData(fullName, email, currentAddress, permanentAddress);
    }
}
