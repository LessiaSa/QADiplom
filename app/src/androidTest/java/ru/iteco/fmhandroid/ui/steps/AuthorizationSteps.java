package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.FieldIDs.authorizLog;
import static ru.iteco.fmhandroid.ui.data.FieldIDs.authorizPass;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.data.FieldIDs;
import ru.iteco.fmhandroid.ui.page.AuthorizationPage;

public class AuthorizationSteps {
    static DataHelper dataHelper = new DataHelper();
    static MainSteps mainSteps = new MainSteps();
    static FieldIDs fieldIDs = new FieldIDs();
    static AuthorizationPage authorizationPage = new AuthorizationPage();
    public static ViewInteraction autLog;




    public static void applicationHomeScreen() {
        Allure.step("Начальный экран приложения");
        onView(allOf(withId(R.id.splashscreen_image_view), isDisplayed()));
    }



    public static void authorizWithValidData() {
        Allure.step("Авторизация с валидными данными");
        authorizationPage.loginField.perform(typeText(dataHelper.getValidUser().getLogin()), closeSoftKeyboard());
        authorizationPage.passwordField.perform(typeText(dataHelper.getValidUser().getPassword()), closeSoftKeyboard());
        //fieldIDs.authorizationButtonEnter.check(matches(isDisplayed()));
        fieldIDs.authorizationButtonEnter.perform(click());
    }

    public void authorizationInvalidLogin() {
        Allure.step("Авторизация с невалидным логином");
        authorizLog.matches(click());
        AuthorizationPage.loginField.perform(typeText(dataHelper.getInvalidUser().getInvalidLogin()));
        authorizPass.perform(click());
        AuthorizationPage.passwordField.perform(typeText(dataHelper.getValidPassword()), closeSoftKeyboard());
    }
    public void authorizationInvalidPassword() {
        Allure.step("Авторизация с невалидным паролем");
        authorizLog.matches(click());
        AuthorizationPage.loginField.perform(typeText(dataHelper.getValidUser().getLogin()));
        authorizPass.perform(click());
        AuthorizationPage.passwordField.perform(typeText(dataHelper.getInvalidPassword()), closeSoftKeyboard());
    }

    public void authorizationWithInvalidData() {
        Allure.step("Авторизация с невалидными и логином и паролем");
        authorizLog.matches(click());
        AuthorizationPage.loginField.perform(typeText(dataHelper.getInvalidUser().getInvalidLogin()));
        authorizPass.perform(click());
        AuthorizationPage.passwordField.perform(typeText(dataHelper.getInvalidPassword()), closeSoftKeyboard());
    }
    public void authorizationClickingLogInButtonSeveralTimesWithInvalidData() {
        Allure.step("Попытка авторизации, несколько раз нажав кнопку 'Войти'");
        authorizLog.matches(click());
        AuthorizationPage.loginField.perform(typeText(dataHelper.getInvalidUser().getInvalidLogin()));
        authorizPass.perform(click());
        AuthorizationPage.passwordField.perform(typeText(dataHelper.getInvalidPassword()), closeSoftKeyboard());
    }
    public void authorizationWithEmptyLoginAndPasswordFields() {
        Allure.step("Авторизация с незаполненными полями логина и пароля");
    }
}