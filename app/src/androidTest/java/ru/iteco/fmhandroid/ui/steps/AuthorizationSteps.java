package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.page.AuthorizationPage;

public class AuthorizationSteps {
    static DataHelper dataHelper = new DataHelper();
    static AuthorizationPage authorizationPage = new AuthorizationPage();


    public static void applicationHomeScreen() {
        Allure.step("Начальный экран приложения");
        onView(isRoot()).perform(waitDisplayed(ru.iteco.fmhandroid.R.id.splashscreen_image_view, 5000));
    }


    public static void authorizWithValidData() {
        Allure.step("Авторизация с валидными данными");
        onView(isRoot()).perform(waitDisplayed(authorizationPage.getLoginLayout(), 5000));
        authorizationPage.enteringDataLoginField(dataHelper.getValidLogin());
        onView(isRoot()).perform(waitDisplayed(authorizationPage.getPasswordLayout(), 5000));
        authorizationPage.enteringDataPasswordField(dataHelper.getValidPassword());
        authorizationPage.enterButton.perform(click());
    }

    public static void authorizationInvalidLogin() {
        Allure.step("Авторизация с невалидным логином");
        onView(isRoot()).perform(waitDisplayed(authorizationPage.getLoginLayout(), 5000));
        authorizationPage.enteringDataLoginField(dataHelper.getInvalidLogin());
        onView(isRoot()).perform(waitDisplayed(authorizationPage.getPasswordLayout(), 5000));
        authorizationPage.enteringDataPasswordField(dataHelper.getValidPassword());
        authorizationPage.enterButton.perform(click());
    }

    public static void authorizationInvalidPassword() {
        Allure.step("Авторизация с невалидным паролем");
        onView(isRoot()).perform(waitDisplayed(authorizationPage.getLoginLayout(), 5000));
        authorizationPage.enteringDataLoginField(dataHelper.getValidLogin());
        onView(isRoot()).perform(waitDisplayed(authorizationPage.getPasswordLayout(), 5000));
        authorizationPage.enteringDataPasswordField(dataHelper.getInvalidPassword());
        authorizationPage.enterButton.perform(click());
    }

    public static void authorizationWithInvalidData() {
        Allure.step("Авторизация с невалидными и логином и паролем");
        onView(isRoot()).perform(waitDisplayed(authorizationPage.getLoginLayout(), 5000));
        authorizationPage.enteringDataLoginField(dataHelper.getInvalidLogin());
        onView(isRoot()).perform(waitDisplayed(authorizationPage.getPasswordLayout(), 5000));
        authorizationPage.enteringDataPasswordField(dataHelper.getInvalidPassword());
        authorizationPage.enterButton.perform(click());
    }

    public static void authorizationClickingLogInButtonSeveralTimesWithInvalidData() {
        Allure.step("Попытка авторизации с невалидным логином и паролем, несколько раз нажав кнопку 'Войти'");
        onView(isRoot()).perform(waitDisplayed(authorizationPage.getLoginLayout(), 5000));
        authorizationPage.enteringDataLoginField(dataHelper.getInvalidLogin());
        onView(isRoot()).perform(waitDisplayed(authorizationPage.getPasswordLayout(), 5000));
        authorizationPage.enteringDataPasswordField(dataHelper.getInvalidPassword());
        authorizationPage.enterButton.perform(click());
        authorizationPage.enterButton.perform(click());
        authorizationPage.enterButton.perform(click());
    }

    public static void authorizationWithEmptyLoginAndPasswordFields() {
        Allure.step("Авторизация с незаполненными полями логина и пароля");
        authorizationPage.enterButton.perform(click());
    }
}
