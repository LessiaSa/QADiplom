package ru.iteco.fmhandroid.ui.page;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class AuthorizationPage {
    public static int authorizationButtonEnter = R.id.enter_button;
    public static ViewInteraction enterButton = onView(withId(R.id.enter_button));
    //Кнока "Выйти"
    public static ViewInteraction buttonLogOut = onView(withId(R.id.authorization_image_button));
    public static ViewInteraction buttonExitPopUpWindow = onView(allOf(withId(android.R.id.title), withText("Выйти")));

    public static ViewInteraction loginField;
    public static ViewInteraction passwordField;
    public int loginLayout;
    public int passwordLayout;


    public AuthorizationPage() {

        loginField = onView(allOf(withHint("Логин"), withParent(withParent(withId(R.id.login_text_input_layout)))));
        passwordField = onView(allOf(withHint("Пароль"), withParent(withParent(withId(R.id.password_text_input_layout)))));
        loginLayout = R.id.login_text_input_layout;
        passwordLayout = R.id.password_text_input_layout;
    }

    public int getLoginLayout() {
        return loginLayout;
    }

    public int getPasswordLayout() {
        return passwordLayout;
    }

    public void enteringDataLoginField(String text) {
        Allure.step("Вводим данные в поле 'Логин'" + text);
        loginField.perform(replaceText(text));
    }

    public void enteringDataPasswordField(String text) {
        Allure.step("Вводим данные в поле 'Пароль'" + text);
        passwordField.perform(replaceText(text));
    }

    public void titleAuthorizationText() {
        Allure.step("Отображается страница авторизации");
        onView(isRoot()).perform(waitDisplayed(authorizationButtonEnter, 5000));
    }
}
