package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.FieldIDs;

public class PageQuotesSteps {
    FieldIDs fieldIDs = new FieldIDs();

    public void vizibilityOfTheBlockWithQuotes() {
        Allure.step("Видимость блока со всеми цитатами");
        onView(isRoot()).perform(waitDisplayed(fieldIDs.quoteBlockAllQuotes, 5000));
    }

    public void vizibilityOneBlockQuote() {
        Allure.step("Видимость одного блока цитаты");
        onView(isRoot()).perform(waitDisplayed(fieldIDs.quoteBlock, 5000));
    }

    public void vizibilityDescriptionQuotes() {
        Allure.step("Видимость описания в блоке цитаты");
        onView(isRoot()).perform(waitDisplayed(fieldIDs.descriptionQuoteBlock, 5000));
    }
}
