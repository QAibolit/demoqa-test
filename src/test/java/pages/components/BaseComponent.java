package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;

public class BaseComponent {

    SelenideElement root;

    public void shouldBeVisible() {
        this.root.shouldBe(visible);
    }
}
