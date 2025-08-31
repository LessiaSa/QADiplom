package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.page.AboutTheAppPage;

public class AboutTheAppSteps {
    AboutTheAppPage aboutTheAppPage = new AboutTheAppPage();

    public void buttonToReturnPreviousPage() {
        Allure.step("Кнопка возвращения на предыдущую страницу со страницы 'О приложении'");
        aboutTheAppPage.buttonBackAboutTheApp.check(matches(isDisplayed())).perform(click());
    }
}
