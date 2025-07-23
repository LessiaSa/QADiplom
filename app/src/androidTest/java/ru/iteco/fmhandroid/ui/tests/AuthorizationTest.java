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

import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.DataHelper;
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
    DataHelper dataHelper = new DataHelper();
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    private View decorView;


    @Before
    public void setUp() {
        try {
            authorizationSteps.applicationHomeScreen();
            //onView(withId(R.id.enter_button)).perform(typeText("Войти"));
            //dataHelper.elementWaiting(authorizationPage.titleAuthoriz, 10000);
        } catch (Exception e) {
            mainSteps.buttonLogOutProfile();
            mainSteps.logOutPopUpOfTheProfile();
            //dataHelper.elementWaiting(withId(R.id.enter_button), 5000);
        }
        mActivityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());

    }

    @After
    public void tearDown() {
        try {
            mainSteps.buttonLogOutProfile();
            mainSteps.logOutPopUpOfTheProfile();
        } catch (Exception ignored) {
            //onView(allOf(withId(R.id.authorization_logout_menu_item), isDisplayingAtLeast(40))).perform(click());
            //buttonExitPopUpWindow.inRoot(withDecorView(Matchers.not(decorView))).check(matches(isDisplayed())).perform(click());
//        onView(withText(R.id.authorization_logout_menu_item)).inRoot(RootMatchers.
//                withDecorView(not(decorView))).check(matches(isDisplayed())).perform(click());
            //onView(withText(endsWith("Выйти"))).check(matches(isDisplayed()));
        }
    }

    @Test
    public void verifyingAuthorizWithValidData() {
        authorizationSteps.authorizWithValidData();
        mainSteps.loadingTheMainPage();
        ViewInteraction textView = fieldIDs.newsButton;
        textView.check(matches(isDisplayed()));
        textView.check(matches(withText("ВСЕ НОВОСТИ")));

//        mainSteps.buttonLogOutProfile();
//        mainSteps.logOutPopUpOfTheProfile();
    }

}