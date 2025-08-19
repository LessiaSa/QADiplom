package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.page.QuotePage;

public class PageQuotesSteps {
    QuotePage quotePage = new QuotePage();

    public void vizibilityOfTheBlockWithQuotes() {
        Allure.step("Видимость блока со всеми цитатами");
        onView(isRoot()).perform(waitDisplayed(quotePage.quoteBlockAllQuotes, 5000));
    }

    public void vizibilityOneBlockQuote() {
        Allure.step("Видимость одного блока цитаты");
        onView(isRoot()).perform(waitDisplayed(quotePage.quoteBlock, 5000));
    }

    public void vizibilityDescriptionQuotes() {
        Allure.step("Видимость описания в блоке цитаты");
        onView(isRoot()).perform(waitDisplayed(quotePage.descriptionQuoteBlock, 5000));
    }
}
