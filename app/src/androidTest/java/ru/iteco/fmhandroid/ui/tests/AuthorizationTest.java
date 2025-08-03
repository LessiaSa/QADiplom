package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.FieldIDs;
import ru.iteco.fmhandroid.ui.page.AuthorizationPage;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@LargeTest
@RunWith(AndroidJUnit4.class)

public class AuthorizationTest {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    MainSteps mainSteps = new MainSteps();
    FieldIDs fieldIDs = new FieldIDs();
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    private View decorView;


    @Before
    public void setUp() {
        try {
            authorizationSteps.applicationHomeScreen();
            authorizationPage.titleAuthorizationText();
        } catch (Exception e) {
            mainSteps.buttonLogOutProfile();
            mainSteps.logOutPopUpOfTheProfile();
            authorizationPage.titleAuthorizationText();
            authorizationSteps.authorizWithValidData();
            mainSteps.loadingTheMainPage();
        }
        //mActivityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    @After
    public void tearDown() {
        try {
            mainSteps.buttonLogOutProfile();
            mainSteps.logOutPopUpOfTheProfile();
        } catch (Exception ignored) {

        }
    }

    @Test
    public void verifyingAuthorizWithValidData() {
        Allure.step("Авторизация с валидными данными");
        authorizationSteps.authorizWithValidData();
        mainSteps.loadingTheMainPage();
        ViewInteraction textView = fieldIDs.newsButton;
        textView.check(matches(isDisplayed()));
        textView.check(matches(withText("ВСЕ НОВОСТИ")));
    }

    @Test
    public void authorizationWithValidLoginAndInvalidPassword() {
        Allure.step("Авторизация с валидным логином и невалидным паролем");
        authorizationSteps.authorizationInvalidPassword();
        ViewInteraction textViewAuthoriz = fieldIDs.enterButton;
        textViewAuthoriz.check(matches(isDisplayed()));
        textViewAuthoriz.check(matches(withText("Войти")));
    }

    @Test
    public  void authorizationWithInvalidLoginAndValidPassword() {
        Allure.step("Авторизация с невалидным логином и валидным паролем");
        authorizationSteps.authorizationInvalidLogin();
        ViewInteraction textViewAuthoriz = fieldIDs.enterButton;
        textViewAuthoriz.check(matches(isDisplayed()));
        textViewAuthoriz.check(matches(withText("Войти")));


    }
    @Test
    public void authorizationWithInvalidLoginAndInvalidPassword() {
        Allure.step("Авторизация с невалидными логином и паролем");
        authorizationSteps.authorizationWithInvalidData();
        ViewInteraction textViewAuthoriz = fieldIDs.enterButton;
        textViewAuthoriz.check(matches(isDisplayed()));
        textViewAuthoriz.check(matches(withText("Войти")));
    }
    @Test
    public void loggingInWithInvalidLoginAndPasswordByClickingSeverialTimesButton() {
        Allure.step("Авторизация с невалидными логином и паролем, несколько раз нажав кнопку 'Войти'");
        authorizationSteps.authorizationClickingLogInButtonSeveralTimesWithInvalidData();
        ViewInteraction textViewAuthoriz = fieldIDs.enterButton;
        textViewAuthoriz.check(matches(isDisplayed()));
        textViewAuthoriz.check(matches(withText("Войти")));
    }
    @Test
    public void authorizationWithEmptyLoginAndPassword() {
        Allure.step("Авторизация с пустыми полями логина и пароля");
        authorizationSteps.authorizationWithEmptyLoginAndPasswordFields();
        ViewInteraction textViewAuthoriz = fieldIDs.enterButton;
        textViewAuthoriz.check(matches(isDisplayed()));
        textViewAuthoriz.check(matches(withText("Войти")));
    }

}
