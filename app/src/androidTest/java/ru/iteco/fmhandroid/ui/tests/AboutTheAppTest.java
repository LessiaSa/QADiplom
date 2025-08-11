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

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Epic;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.FieldIDs;
import ru.iteco.fmhandroid.ui.page.AuthorizationPage;
import ru.iteco.fmhandroid.ui.steps.AboutTheAppSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.BurgerMenuSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AboutTheAppTest {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    MainSteps mainSteps = new MainSteps();
    FieldIDs fieldIDs = new FieldIDs();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    BurgerMenuSteps burgerMenuSteps = new BurgerMenuSteps();
    AboutTheAppSteps aboutTheAppSteps = new AboutTheAppSteps();
    private View decorView;


    @Before
    public void setUp() {
        try {
            authorizationSteps.applicationHomeScreen();
            authorizationPage.titleAuthorizationText();
            authorizationSteps.authorizWithValidData();
            mainSteps.loadingTheMainPage();
            mainSteps.buttonBurgerMenuOfTheDifferentPages();
            burgerMenuSteps.selectingAboutAppPageInBurgerMenu();
            aboutTheAppSteps.vizibilityAboutTheAppPage();
        } catch (Exception e) {
            mainSteps.buttonLogOutProfile();
            mainSteps.logOutPopUpOfTheProfile();
            authorizationPage.titleAuthorizationText();
            authorizationSteps.authorizWithValidData();
            mainSteps.loadingTheMainPage();
            mainSteps.buttonBurgerMenuOfTheDifferentPages();
            burgerMenuSteps.selectingAboutAppPageInBurgerMenu();
            aboutTheAppSteps.vizibilityAboutTheAppPage();
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

    //    //https://vhospice.org/#/privacy-policy/
//    @Test
//    public void gettingInformationAboutThePrivacyPolicy() {
//        Allure.step("Получение информации о политике конфиденциальности");
//        aboutTheAppSteps.linkPrivacyPolicyOnAboutTheApp();
//        try {
//            onWebView().withElement(findElement(Locator.ID, "vhospice"))
//                    .check(webMatches(getText(), containsString("Политика конфиденциальности")));
//        } catch (RuntimeException notExist) {
//            //good!
//        }
//    }
//    @Test
//    public void gettingInformationAboutTheUserAgreement() {
//        Allure.step("Получение информации о пользовательском сошлашении");
//        aboutTheAppSteps.linkUserAgreementOnAboutTheApp();
//        try {
//            onWebView().withElement(findElement(Locator.ID, "vhospice"))
//                    .check(webMatches(getText(), containsString("Пользовательское соглашение")));
//        } catch (RuntimeException notExist) {
//            //good!
//        }
//    }
    @Epic(value = "Тест-кейс №88")
    @Test
    public void returnPreviousPageUsingTheBackButton() {
        Allure.step("Возвращение на предыдущую страницу по кнопке 'Назад'");
        aboutTheAppSteps.buttonToReturnPreviousPage();
        mainSteps.loadingTheMainPage();
        ViewInteraction textView = fieldIDs.newsButton;
        textView.check(matches(isDisplayed()));
        textView.check(matches(withText("ВСЕ НОВОСТИ")));
    }

}
