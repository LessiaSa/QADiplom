package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.action.ViewActions.click;

import android.view.View;

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
import ru.iteco.fmhandroid.ui.page.ControlPanelPage;
import ru.iteco.fmhandroid.ui.page.MainPage;
import ru.iteco.fmhandroid.ui.page.NewsPage;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsPageTest {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    MainSteps mainSteps = new MainSteps();
    ControlPanelPage controlPanelPage = new ControlPanelPage();
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MainPage mainPage = new MainPage();
    NewsPage newsPage = new NewsPage();
    private View decorView;


    @Before
    public void setUp() {
        try {
            authorizationPage.applicationHomeScreen();
            authorizationPage.titleAuthorizationText();
            authorizationSteps.authorizWithValidData();
            mainPage.loadingTheMainPage();
        } catch (Exception e) {
            mainPage.buttonLogOutProfile();
            mainSteps.logOutPopUpOfTheProfile();
            authorizationPage.titleAuthorizationText();
            authorizationSteps.authorizWithValidData();
            mainPage.loadingTheMainPage();
        }
        mActivityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    @After
    public void tearDown() {
        try {
            mainPage.buttonLogOutProfile();
            mainSteps.logOutPopUpOfTheProfile();
        } catch (Exception ignored) {

        }
    }

    @Epic(value = "Тест-кейс №309")
    @Test
    public void blockNewsExpandButton() {
        Allure.step("Кнопка 'Развернуть' для разворачивания блока новости");
        mainSteps.allNewsButtonOnTheAppsHomePage(); //нажала кнопку "Все новости" на главной
        newsPage.vizibilityOfAllNewsBlocksOnTheNewsPage();
        newsPage.vizibilityOfOneNewsBlock();
        controlPanelPage.buttonExpandNews.perform(click());
        newsPage.vizibilityDescriptionNews();
    }
}
