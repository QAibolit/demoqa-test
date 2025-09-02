package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class OutputFormComponent extends BaseComponent{

    private SelenideElement root = $("#output"),
            name = $("#name"),
            email = $("#email"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress");

    public void checkEnteredData(String name, String email, String currentAddress, String permanentAddress) {
        this.name.shouldHave(text(name));
        this.email.shouldHave(text(email));
        this.currentAddress.shouldHave(text(currentAddress));
        this.permanentAddress.shouldHave(text(permanentAddress));
    }
}
