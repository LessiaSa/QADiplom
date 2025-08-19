package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Epic;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.page.AuthorizationPage;
import ru.iteco.fmhandroid.ui.page.NewsPage;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class MainTest {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    MainSteps mainSteps = new MainSteps();
    NewsPage newsPage = new NewsPage();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    private View decorView;

    @Before
    public void setUp() {
        try {
            authorizationSteps.applicationHomeScreen();
            authorizationPage.titleAuthorizationText();
            authorizationSteps.authorizWithValidData();
            mainSteps.loadingTheMainPage();
        } catch (Exception e) {
            mainSteps.buttonLogOutProfile();
            mainSteps.logOutPopUpOfTheProfile();
            authorizationPage.titleAuthorizationText();
            authorizationSteps.authorizWithValidData();
            mainSteps.loadingTheMainPage();
        }
        mActivityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    @After
    public void tearDown() {
        try {
            mainSteps.buttonLogOutProfile();
            mainSteps.logOutPopUpOfTheProfile();
        } catch (Exception ignored) {

        }
    }

    @Epic(value = "Тест-кейс №7")
    @Test
    public void buttonCollapseToHideNewsBlock() {
        Allure.step("Кнопка 'Свернуть' для скрытия блоков с новостями");
        ViewInteraction textView = newsPage.newsButton;
        textView.check(matches(isDisplayed()));
        textView.check(matches(withText("ВСЕ НОВОСТИ")));
        newsPage.buttonCollapse.perform(click());
        newsPage.newsButton.check(matches(not(isDisplayed())));
    }

    @Epic(value = "Тест-кейс №8")
    @Test
    public void buttonExpandToExpandNewsBlock() {
        Allure.step("Кнопка'Развернуть' для разворачивания блоков с новостями");
        newsPage.buttonCollapse.perform(click());
        newsPage.newsButton.check(matches(not(isDisplayed())));
        newsPage.buttonCollapse.perform(click());
        ViewInteraction textView = newsPage.newsButton;
        textView.check(matches(isDisplayed()));
        textView.check(matches(withText("ВСЕ НОВОСТИ")));
    }

}
