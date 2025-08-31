package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.page.AuthorizationPage;
import ru.iteco.fmhandroid.ui.page.ControlPanelPage;
import ru.iteco.fmhandroid.ui.page.MainPage;
import ru.iteco.fmhandroid.ui.page.NewsPage;
import ru.iteco.fmhandroid.ui.page.QuotePage;

public class MainSteps {
    NewsPage newsPage = new NewsPage();
    QuotePage quotePage = new QuotePage();
    ControlPanelPage controlPanelPage = new ControlPanelPage();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MainPage mainPage = new MainPage();


    public void allNewsButtonOnTheAppsHomePage() {
        Allure.step("кнопка 'Все новости' на главной странице приложения");
        newsPage.newsButton.perform(click());
    }

    public void buttonBurgerMenuOfTheDifferentPages() {
        Allure.step("Кнопка BurgerMenu");
        controlPanelPage.buttonBurgerMenu.check(matches(isDisplayed())).perform(click());
    }

    public void buttonQuotesOfTheMainPage() {
        Allure.step("Кнопка для перехода на страницу с цитатами");
        quotePage.buttonQuotes.check(matches(isDisplayed())).perform(click());
    }


    public void logOutPopUpOfTheProfile() {
        Allure.step("Всплывающая кнопка 'Выйти'");
        authorizationPage.buttonExitPopUpWindow.perform(click());
    }

    public void vizibilityHomePage() {
        ViewInteraction textView = newsPage.newsButton;
        textView.check(matches(isDisplayed()));
        textView.check(matches(withText(mainPage.allNews)));
    }

}
