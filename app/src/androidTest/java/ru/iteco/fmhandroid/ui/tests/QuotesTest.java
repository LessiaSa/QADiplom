package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
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
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.page.AuthorizationPage;
import ru.iteco.fmhandroid.ui.page.QuotePage;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.PageQuotesSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class QuotesTest {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    MainSteps mainSteps = new MainSteps();
    QuotePage quotePage = new QuotePage();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    PageQuotesSteps pageQuotesSteps = new PageQuotesSteps();
    DataHelper dataHelper = new DataHelper();
    private View decorView;

    @Before
    public void setUp() {
        try {
            authorizationSteps.applicationHomeScreen();
            authorizationPage.titleAuthorizationText();
            authorizationSteps.authorizWithValidData();
            mainSteps.loadingTheMainPage();
            mainSteps.buttonQuotesOfTheMainPage();
        } catch (Exception e) {
            mainSteps.buttonLogOutProfile();
            mainSteps.logOutPopUpOfTheProfile();
            authorizationPage.titleAuthorizationText();
            authorizationSteps.authorizWithValidData();
            mainSteps.loadingTheMainPage();
            mainSteps.buttonQuotesOfTheMainPage();
        }
        mActivityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    @After
    public void tearDown() {
        try {
            mainSteps.buttonLogOutProfile();
            mainSteps.logOutPopUpOfTheProfile();
        } catch (Exception ignored) {
        }
    }

    @Epic(value = "Тест-кейс №71")
    @Test
    public void abilityExpandDetailedDescriptionQuote() {
        Allure.step("Возможность развернуть подробное описание цитаты");
        pageQuotesSteps.vizibilityOfTheBlockWithQuotes();
        pageQuotesSteps.vizibilityOneBlockQuote();
        quotePage.buttonUnwrapRollUpQuotes.perform(click());
        pageQuotesSteps.vizibilityDescriptionQuotes();
        quotePage.checkingIsDisplayedDescriptionQuite();
    }

    @Epic(value = "Тест-кейс №72")
    @Test
    public void abilityToCollapseBlockWithQuotes() {
        Allure.step("Возможность свернуть описание блока с цитатами");
        pageQuotesSteps.vizibilityOfTheBlockWithQuotes();
        pageQuotesSteps.vizibilityOneBlockQuote();
        quotePage.buttonUnwrapRollUpQuotes.perform(click());
        pageQuotesSteps.vizibilityDescriptionQuotes();
        onView(dataHelper.withItemText(quotePage.descriptionQuote)).perform(click());
        quotePage.checkingNotIsDisplayedDescriptionQuote();
    }
}