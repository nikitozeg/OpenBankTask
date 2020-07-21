package steps;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import lombok.extern.slf4j.Slf4j;
import pages.OpenBankPage;
import ru.alfabank.alfatest.cucumber.api.AkitaScenario;
import ru.alfabank.steps.BaseMethods;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.alfabank.tests.core.helpers.PropertyLoader.getPropertyOrValue;

@Slf4j
public class TemplateSteps extends BaseMethods {
    AkitaScenario akitaScenario = AkitaScenario.getInstance();


    @И("^курс продажи больше курса покупки для USD и EUR")
    public void checkReposListOnPageCorrespondsToResponse() throws Throwable {
        OpenBankPage openPage = akitaScenario.getPage(OpenBankPage.class);

        assertThat(openPage.getBuyEur(), lessThan(openPage.getSellEur()));
        assertThat(openPage.getBuyUsd(), lessThan(openPage.getSellUsd()));
    }


    @Тогда("^элемент списка \"([^\"]*)\" содержит текст \"([^\"]*)\"$")
    public void checkListElementsNotContainsText(String listName, String expectedValue) {
        final String value = getPropertyOrValue(expectedValue);
        List<SelenideElement> listOfElementsFromPage = akitaScenario.getCurrentPage().getElementsList(listName);
        List<String> elementsListText = listOfElementsFromPage.stream()
                .map(element -> element.getText().trim().toLowerCase())
                .collect(toList());
        assertTrue(elementsListText.stream().anyMatch(item -> item.contains(value.toLowerCase())),
                String.format("Элементы списка %s: [%s] не содержат текст [%s] ", listName, elementsListText, value));
    }

}
