package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.page.ControlPanelPage;
import ru.iteco.fmhandroid.ui.page.FilterNewsPage;

public class NewsPageSteps {
    FilterNewsPage filterNewsPage = new FilterNewsPage();
    ControlPanelPage controlPanelPage = new ControlPanelPage();

    public void clickOnTheFilterNews() {
        Allure.step("Клик по кнопке 'Фильтровать новости' на странице 'Новости'");
        filterNewsPage.filterNewsButton.check(matches(isDisplayed())).perform(click());
    }


    public void clickOnTheControlPanel() {
        Allure.step("Клик по кнопке 'Панель управления'");
        controlPanelPage.buttonControlPanel.check(matches(isDisplayed())).perform(click());
    }

}
