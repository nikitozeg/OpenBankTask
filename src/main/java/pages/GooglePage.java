
package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.annotations.Optional;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;

import java.util.List;

@Name("Google поиск")
public class GooglePage extends AkitaPage {

    @FindBy(css = "[name=q]")
    @Name("Поиск")
    public SelenideElement searchField;

    @Optional
    @FindBy(css = "a cite")
    @Name("Ссылки")
    public List<SelenideElement> urlResults;




}
