package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.FieldIDs;

public class NewsPageSteps {
    FieldIDs fieldIDs = new FieldIDs();

    public void clickOnTheFilterNews() {
        Allure.step("Клик по кнопке 'Фильтровать новости' на странице 'Новости'");
        fieldIDs.filterNewsButton.check(matches(isDisplayed())).perform(click());
    }

    public void vizibilityControlPanelButton() {
        Allure.step("Видимость кнопки 'Панель управления'");
        onView(isRoot()).perform(waitDisplayed(fieldIDs.buttonControlPanelVizibility, 5000));
    }

    public void clickOnTheControlPanel() {
        Allure.step("Клик по кнопке 'Панель управления'");
        FieldIDs.buttonControlPanel.check(matches(isDisplayed())).perform(click());
    }

    public void vizibilityOfAllNewsBlocksOnTheNewsPage() {
        Allure.step("Видимость всех блоков с новостями на странице 'Новости'");
        onView(isRoot()).perform(waitDisplayed(fieldIDs.newsBlock, 5000));
    }

    public void vizibilityOfOneNewsBlock() {
        Allure.step("Видимость одного блока новости");
        onView(isRoot()).perform(waitDisplayed(fieldIDs.blockNews, 5000));
    }

    public void vizibilityDescriptionNews() {
        Allure.step("Видимость описания в одном блоке новости");
        onView(isRoot()).perform(waitDisplayed(fieldIDs.descriptionNewsBlockNews, 5000));
    }
}
