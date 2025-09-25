package ru.iteco.fmhandroid.ui.tests;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Epic;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.page.AuthorizationPage;
import ru.iteco.fmhandroid.ui.page.BurgerMenuPage;
import ru.iteco.fmhandroid.ui.page.MainPage;
import ru.iteco.fmhandroid.ui.steps.AboutTheAppSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AboutTheAppTest {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    MainSteps mainSteps = new MainSteps();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    AboutTheAppSteps aboutTheAppSteps = new AboutTheAppSteps();
    BurgerMenuPage burgerMenuPage = new BurgerMenuPage();
    MainPage mainPage = new MainPage();
    private View decorView;


    @Before
    public void setUp() {
        try {
            authorizationPage.applicationHomeScreen();
            authorizationPage.titleAuthorizationText();
            authorizationSteps.authorizWithValidData();
            mainPage.loadingTheMainPage();
            mainSteps.buttonBurgerMenuOfTheDifferentPages();
            burgerMenuPage.selectingAboutAppPageInBurgerMenu();
            aboutTheAppSteps.vizibilityAboutTheAppPage();
        } catch (Exception e) {
            mainPage.buttonLogOutProfile();
            mainSteps.logOutPopUpOfTheProfile();
            authorizationPage.titleAuthorizationText();
            authorizationSteps.authorizWithValidData();
            mainPage.loadingTheMainPage();
            mainSteps.buttonBurgerMenuOfTheDifferentPages();
            burgerMenuPage.selectingAboutAppPageInBurgerMenu();
            aboutTheAppSteps.vizibilityAboutTheAppPage();
        }
        mActivityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }


    @Epic(value = "Тест-кейс №88")
    @Test
    public void returnPreviousPageUsingTheBackButton() {
        Allure.step("Возвращение на предыдущую страницу по кнопке 'Назад'");
        aboutTheAppSteps.buttonToReturnPreviousPage();
        mainPage.loadingTheMainPage();
        mainSteps.vizibilityHomePage();
        mainPage.buttonLogOutProfile();
        mainSteps.logOutPopUpOfTheProfile();
    }

}
