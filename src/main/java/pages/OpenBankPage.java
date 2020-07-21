
package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;

@Name("Банк")
public class OpenBankPage extends AkitaPage {


    @FindBy(xpath = "(//span[@class='main-page-exchange__rate'])[1]")
    @Name("Курс покупки Usd")
    public SelenideElement buyUsd;

    @FindBy(xpath = "(//span[@class='main-page-exchange__rate'])[2]")
    @Name("Курс продажи Usd")
    public SelenideElement sellUsd;


    @FindBy(xpath = "(//span[@class='main-page-exchange__rate'])[3]")
    @Name("Курс покупки Евро")
    public SelenideElement buyEur;


    @FindBy(xpath = "(//span[@class='main-page-exchange__rate'])[4]")
    @Name("Курс продажи Евро")
    public SelenideElement sellEur;


    public float getBuyUsd() {
        return Float.parseFloat(buyUsd.getText().replaceAll(",","."));
    }

    public float getSellUsd() {
        return Float.parseFloat(sellUsd.getText().replaceAll(",","."));
    }

    public float getBuyEur() {
        return Float.parseFloat(buyEur.getText().replaceAll(",","."));
    }

    public float getSellEur() {
        return Float.parseFloat(sellEur.getText().replaceAll(",","."));
    }


}
