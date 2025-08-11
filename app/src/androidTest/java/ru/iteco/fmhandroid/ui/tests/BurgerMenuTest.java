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
import ru.iteco.fmhandroid.ui.steps.NewsPageSteps;
import ru.iteco.fmhandroid.ui.steps.PageQuotesSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class BurgerMenuTest {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    MainSteps mainSteps = new MainSteps();
    FieldIDs fieldIDs = new FieldIDs();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    PageQuotesSteps pageQuotesSteps = new PageQuotesSteps();
    NewsPageSteps newsPageSteps = new NewsPageSteps();
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
        } catch (Exception e) {
            mainSteps.buttonLogOutProfile();
            mainSteps.logOutPopUpOfTheProfile();
            authorizationPage.titleAuthorizationText();
            authorizationSteps.authorizWithValidData();
            mainSteps.loadingTheMainPage();
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

    @Epic(value = "Тест-кейс №75")
    @Test
    public void goToNewsFromTheMainPage() {
        Allure.step("Переход на страницу 'Новости' с главной");
        mainSteps.buttonBurgerMenuOfTheDifferentPages();
        burgerMenuSteps.selectingNewsPageInBurgerMenu();
        newsPageSteps.vizibilityOfAllNewsBlocksOnTheNewsPage();
        fieldIDs.newsBlockDop.check(matches(isDisplayed()));
    }

    @Epic(value = "Тест-кейс №76")
    @Test
    public void goToAboutAppPageFromTheMainPage() {
        Allure.step("Переход на страницу 'О приложении' с главной");
        mainSteps.buttonBurgerMenuOfTheDifferentPages();
        burgerMenuSteps.selectingAboutAppPageInBurgerMenu();
        aboutTheAppSteps.vizibilityAboutTheAppPage();
        fieldIDs.titleAboutTheApp.check(matches(isDisplayed()));
    }

    @Epic(value = "Тест-кейс №83")
    @Test
    public void goToMainPageFromTheNewsPage() {
        Allure.step("Переход на главную страницу со страницы 'Новости'");
        mainSteps.allNewsButtonOnTheAppsHomePage(); //нажала кнопку "Все новости" на главной
        newsPageSteps.vizibilityOfAllNewsBlocksOnTheNewsPage();
        mainSteps.buttonBurgerMenuOfTheDifferentPages();
        burgerMenuSteps.selectingHomePageInBurgerMenu();
        mainSteps.loadingTheMainPage();
        ViewInteraction textView = fieldIDs.newsButton;
        textView.check(matches(isDisplayed()));
        textView.check(matches(withText("ВСЕ НОВОСТИ")));
    }

    @Epic(value = "Тест-кейс №85")
    @Test
    public void goToAboutAppPageFromTheNewsPage() {
        Allure.step("Переход на страницу 'О приложении' со страницы 'Новости'.ТЕСТ УПАДЕТ");
        mainSteps.allNewsButtonOnTheAppsHomePage(); //нажала кнопку "Все новости" на главной
        newsPageSteps.vizibilityOfAllNewsBlocksOnTheNewsPage();
        mainSteps.buttonBurgerMenuOfTheDifferentPages();
        burgerMenuSteps.selectingAboutAppPageInBurgerMenu();
        fieldIDs.titleAboutTheApp.check(matches(isDisplayed()));
    }

    @Epic(value = "Тест-кейс №80")
    @Test
    public void navigatingToTheMainPageFromTheControlPanelPage() {
        Allure.step("Переход на главную страницу со страницы 'Панель управления'");
        mainSteps.allNewsButtonOnTheAppsHomePage(); //нажала кнопку "Все новости" на главной
        newsPageSteps.vizibilityControlPanelButton();
        newsPageSteps.clickOnTheControlPanel();
        mainSteps.buttonBurgerMenuOfTheDifferentPages();
        burgerMenuSteps.selectingHomePageInBurgerMenu();
        mainSteps.loadingTheMainPage();
        ViewInteraction textView = fieldIDs.newsButton;
        textView.check(matches(isDisplayed()));
        textView.check(matches(withText("ВСЕ НОВОСТИ")));
    }

    @Epic(value = "Тест-кейс №81")
    @Test
    public void navigatingToTheNewsPageFromTheControlPanelPage() {
        Allure.step("Переход на страницу 'Новости' со страницы 'Панель управления'");
        mainSteps.allNewsButtonOnTheAppsHomePage(); //нажала кнопку "Все новости" на главной
        newsPageSteps.vizibilityControlPanelButton();
        newsPageSteps.clickOnTheControlPanel();
        mainSteps.buttonBurgerMenuOfTheDifferentPages();
        burgerMenuSteps.selectingNewsPageInBurgerMenu();
        fieldIDs.newsBlockDop.check(matches(isDisplayed()));
    }

    @Epic(value = "Тест-кейс №82")
    @Test
    public void navigatingToTheAboutAppPageFronTheControlPanelPage() {
        Allure.step("Переход на страницу 'О приложении' со страницы 'Панель управления'");
        mainSteps.allNewsButtonOnTheAppsHomePage(); //нажала кнопку "Все новости" на главной
        newsPageSteps.vizibilityControlPanelButton();
        newsPageSteps.clickOnTheControlPanel();
        mainSteps.buttonBurgerMenuOfTheDifferentPages();
        burgerMenuSteps.selectingAboutAppPageInBurgerMenu();
        fieldIDs.titleAboutTheApp.check(matches(isDisplayed()));
    }

    @Epic(value = "Тест-кейс №77")
    @Test
    public void navigatingToTheMainPageFromTheQuotePage() {
        Allure.step("Переход на главную со страницы с цитатами");
        mainSteps.buttonQuotesOfTheMainPage();
        pageQuotesSteps.vizibilityOfTheBlockWithQuotes();
        mainSteps.buttonBurgerMenuOfTheDifferentPages();
        burgerMenuSteps.selectingHomePageInBurgerMenu();
        mainSteps.loadingTheMainPage();
        ViewInteraction textView = fieldIDs.newsButton;
        textView.check(matches(isDisplayed()));
        textView.check(matches(withText("ВСЕ НОВОСТИ")));
    }

    @Epic(value = "Тест-кейс №78")
    @Test
    public void navigatingToTheNewsPageFromTheQuotePage() {
        Allure.step("Переход на страницу 'Новости' со страницы с цитатами");
        mainSteps.buttonQuotesOfTheMainPage();
        pageQuotesSteps.vizibilityOfTheBlockWithQuotes();
        mainSteps.buttonBurgerMenuOfTheDifferentPages();
        burgerMenuSteps.selectingNewsPageInBurgerMenu();
        fieldIDs.newsBlockDop.check(matches(isDisplayed()));
    }

    @Epic(value = "Тест-кейс №79")
    @Test
    public void navigatingToTheAboutAppPageFromTheQuotePage() {
        Allure.step("Переход на страницу 'О приложении' со страницы с цитатами");
        mainSteps.buttonQuotesOfTheMainPage();
        pageQuotesSteps.vizibilityOfTheBlockWithQuotes();
        mainSteps.buttonBurgerMenuOfTheDifferentPages();
        burgerMenuSteps.selectingAboutAppPageInBurgerMenu();
        fieldIDs.titleAboutTheApp.check(matches(isDisplayed()));
    }

}
