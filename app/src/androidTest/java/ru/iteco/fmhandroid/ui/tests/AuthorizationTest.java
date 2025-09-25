package ru.iteco.fmhandroid.ui.tests;


import android.view.View;

import androidx.test.core.app.ActivityScenario;
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
import ru.iteco.fmhandroid.ui.page.MainPage;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

public class AuthorizationTest {

    @Rule
    public ActivityScenarioRule<AppActivity> activityTestRule =
            new ActivityScenarioRule<>(AppActivity.class);
    MainSteps mainSteps = new MainSteps();
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MainPage mainPage = new MainPage();
    public View decorView;


    @Before
    public void setDecorView() {
        activityTestRule.getScenario().onActivity(new ActivityScenario.ActivityAction<AppActivity>() {
            @Override
            public void perform(AppActivity activity) {
                decorView = activity.getWindow().getDecorView();
            }
        });
    }

    public void setUp() {
        try {
            authorizationPage.applicationHomeScreen();
            authorizationPage.titleAuthorizationText();
        } catch (Exception e) {
            mainPage.buttonLogOutProfile();
            mainSteps.logOutPopUpOfTheProfile();
            authorizationPage.titleAuthorizationText();
            authorizationSteps.authorizWithValidData();
            mainPage.loadingTheMainPage();
        }

    }


    @Epic(value = "Тест-кейс №223")
    @Test
    public void verifyingAuthorizWithValidData() {
        Allure.step("Авторизация с валидными данными");
        authorizationSteps.authorizWithValidData();
        mainPage.loadingTheMainPage();
        mainSteps.vizibilityHomePage();
    }

    @Epic(value = "Тест-кейс №224")
    @Test
    public void authorizationWithValidLoginAndInvalidPassword() {
        Allure.step("Авторизация с валидным логином и невалидным паролем");
        authorizationSteps.authorizationInvalidPassword();
        authorizationPage.checkToastMessage(authorizationPage.errorMessage, decorView);

    }


    @Epic(value = "Тест-кейс №225")
    @Test
    public void authorizationWithInvalidLoginAndValidPassword() {
        Allure.step("Авторизация с невалидным логином и валидным паролем");
        authorizationSteps.authorizationInvalidLogin();
        authorizationPage.checkToastMessage(authorizationPage.errorMessage, decorView);
    }

    @Epic(value = "Тест-кейс №226")
    @Test
    public void authorizationWithInvalidLoginAndInvalidPassword() {
        Allure.step("Авторизация с невалидными логином и паролем");
        authorizationSteps.authorizationWithInvalidData();
        authorizationPage.checkToastMessage(authorizationPage.errorMessage, decorView);

    }

    @Epic(value = "Тест-кейс №227")
    @Test
    public void loggingInWithInvalidLoginAndPasswordByClickingSeverialTimesButton() {
        Allure.step("Авторизация с невалидными логином и паролем, несколько раз нажав кнопку 'Войти'");
        authorizationSteps.authorizationClickingLogInButtonSeveralTimesWithInvalidData();
        authorizationPage.checkToastMessage(authorizationPage.errorMessage, decorView);

    }

    @Epic(value = "Тест-кейс №228")
    @Test
    public void authorizationWithEmptyLoginAndPassword() {
        Allure.step("Авторизация с пустыми полями логина и пароля");
        authorizationSteps.authorizationWithEmptyLoginAndPasswordFields();
        authorizationPage.checkToastMessage(authorizationPage.errorMessage2, decorView);

    }

    @After
    public void tearDown() {
        try {
            mainPage.buttonLogOutProfile();
            mainSteps.logOutPopUpOfTheProfile();
        } catch (Exception ignored) {

        }
    }

}
