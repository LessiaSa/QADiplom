package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.data.FieldIDs;


public class AuthorizationPage {
    public static ViewInteraction titleAuthoriz;
    public static ViewInteraction loginField;
    public static ViewInteraction passwordField;
    static DataHelper dataHelper = new DataHelper();
    static FieldIDs fieldIDs = new FieldIDs();

    public AuthorizationPage() {
        titleAuthoriz = onView(withText("Авторизация"));

//        loginField.check(matches(isDisplayed()));
//        loginField.perform(replaceText("Логин"));
        loginField = onView(withHint("Логин"));
        passwordField = onView(withHint("Пароль"));
    }
}