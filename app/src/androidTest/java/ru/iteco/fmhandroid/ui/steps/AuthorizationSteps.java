package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.action.ViewActions.click;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.page.AuthorizationPage;

public class AuthorizationSteps {
    static DataHelper dataHelper = new DataHelper();
    static AuthorizationPage authorizationPage = new AuthorizationPage();


    public static void authorizWithValidData() {
        Allure.step("Авторизация с валидными данными");
        authorizationPage.vizibilityLoginFieldsForPage();
        authorizationPage.enteringDataLoginField(dataHelper.getValidLogin());
        authorizationPage.vizibilityPasswordFieldForPage();
        authorizationPage.enteringDataPasswordField(dataHelper.getValidPassword());
        authorizationPage.enterButton.perform(click());
    }

    public static void authorizationInvalidLogin() {
        Allure.step("Авторизация с невалидным логином");
        authorizationPage.vizibilityLoginFieldsForPage();
        authorizationPage.enteringDataLoginField(dataHelper.getInvalidLogin());
        authorizationPage.vizibilityPasswordFieldForPage();
        authorizationPage.enteringDataPasswordField(dataHelper.getValidPassword());
        authorizationPage.enterButton.perform(click());
    }

    public static void authorizationInvalidPassword() {
        Allure.step("Авторизация с невалидным паролем");
        authorizationPage.vizibilityLoginFieldsForPage();
        authorizationPage.enteringDataLoginField(dataHelper.getValidLogin());
        authorizationPage.vizibilityPasswordFieldForPage();
        authorizationPage.enteringDataPasswordField(dataHelper.getInvalidPassword());
        authorizationPage.enterButton.perform(click());
    }

    public static void authorizationWithInvalidData() {
        Allure.step("Авторизация с невалидными и логином и паролем");
        authorizationPage.vizibilityLoginFieldsForPage();
        authorizationPage.enteringDataLoginField(dataHelper.getInvalidLogin());
        authorizationPage.vizibilityPasswordFieldForPage();
        authorizationPage.enteringDataPasswordField(dataHelper.getInvalidPassword());
        authorizationPage.enterButton.perform(click());
    }

    public static void authorizationClickingLogInButtonSeveralTimesWithInvalidData() {
        Allure.step("Попытка авторизации с невалидным логином и паролем, несколько раз нажав кнопку 'Войти'");
        authorizationPage.vizibilityLoginFieldsForPage();
        authorizationPage.enteringDataLoginField(dataHelper.getInvalidLogin());
        authorizationPage.vizibilityPasswordFieldForPage();
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
