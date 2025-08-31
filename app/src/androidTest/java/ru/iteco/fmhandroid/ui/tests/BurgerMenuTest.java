package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

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
import ru.iteco.fmhandroid.ui.page.AboutTheAppPage;
import ru.iteco.fmhandroid.ui.page.AuthorizationPage;
import ru.iteco.fmhandroid.ui.page.BurgerMenuPage;
import ru.iteco.fmhandroid.ui.page.MainPage;
import ru.iteco.fmhandroid.ui.page.NewsPage;
import ru.iteco.fmhandroid.ui.page.QuotePage;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsPageSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class BurgerMenuTest {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    MainSteps mainSteps = new MainSteps();
    NewsPage newsPage = new NewsPage();
    AboutTheAppPage aboutTheAppPage = new AboutTheAppPage();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    NewsPageSteps newsPageSteps = new NewsPageSteps();
    BurgerMenuPage burgerMenuPage = new BurgerMenuPage();
    MainPage mainPage = new MainPage();
    QuotePage quotePage = new QuotePage();
    private View decorView;

    @Before
    public void setUp() {
        try {
            authorizationPage.applicationHomeScreen();
            authorizationPage.titleAuthorizationText();
            authorizationSteps.authorizWithValidData();
            mainPage.loadingTheMainPage();
        } catch (Exception e) {
            mainPage.buttonLogOutProfile();
            mainSteps.logOutPopUpOfTheProfile();
            authorizationPage.titleAuthorizationText();
            authorizationSteps.authorizWithValidData();
            mainPage.loadingTheMainPage();
        }
        mActivityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    @After
    public void tearDown() {
        try {
            mainPage.buttonLogOutProfile();
            mainSteps.logOutPopUpOfTheProfile();
        } catch (Exception ignored) {
        }
    }

    @Epic(value = "Тест-кейс №75")
    @Test
    public void goToNewsFromTheMainPage() {
        Allure.step("Переход на страницу 'Новости' с главной");
        mainSteps.buttonBurgerMenuOfTheDifferentPages();
        burgerMenuPage.selectingNewsPageInBurgerMenu();
        newsPage.vizibilityOfAllNewsBlocksOnTheNewsPage();
        newsPage.newsBlockDop.check(matches(isDisplayed()));
    }

    @Epic(value = "Тест-кейс №76")
    @Test
    public void goToAboutAppPageFromTheMainPage() {
        Allure.step("Переход на страницу 'О приложении' с главной");
        mainSteps.buttonBurgerMenuOfTheDifferentPages();
        burgerMenuPage.selectingAboutAppPageInBurgerMenu();
        aboutTheAppPage.vizibilityAboutTheAppPage();
        aboutTheAppPage.titleAboutTheApp.check(matches(isDisplayed()));
    }

    @Epic(value = "Тест-кейс №83")
    @Test
    public void goToMainPageFromTheNewsPage() {
        Allure.step("Переход на главную страницу со страницы 'Новости'");
        mainSteps.allNewsButtonOnTheAppsHomePage(); //нажала кнопку "Все новости" на главной
        newsPage.vizibilityOfAllNewsBlocksOnTheNewsPage();
        mainSteps.buttonBurgerMenuOfTheDifferentPages();
        burgerMenuPage.selectingHomePageInBurgerMenu();
        mainPage.loadingTheMainPage();
        mainSteps.vizibilityHomePage();
    }

    @Epic(value = "Тест-кейс №85")
    @Test
    public void goToAboutAppPageFromTheNewsPage() {
        Allure.step("Переход на страницу 'О приложении' со страницы 'Новости'.ТЕСТ УПАДЕТ");
        mainSteps.allNewsButtonOnTheAppsHomePage(); //нажала кнопку "Все новости" на главной
        newsPage.vizibilityOfAllNewsBlocksOnTheNewsPage();
        mainSteps.buttonBurgerMenuOfTheDifferentPages();
        burgerMenuPage.selectingAboutAppPageInBurgerMenu();
        aboutTheAppPage.titleAboutTheApp.check(matches(isDisplayed()));
    }

    @Epic(value = "Тест-кейс №80")
    @Test
    public void navigatingToTheMainPageFromTheControlPanelPage() {
        Allure.step("Переход на главную страницу со страницы 'Панель управления'");
        mainSteps.allNewsButtonOnTheAppsHomePage(); //нажала кнопку "Все новости" на главной
        newsPage.vizibilityControlPanelButton();
        newsPageSteps.clickOnTheControlPanel();
        mainSteps.buttonBurgerMenuOfTheDifferentPages();
        burgerMenuPage.selectingHomePageInBurgerMenu();
        mainPage.loadingTheMainPage();
        mainSteps.vizibilityHomePage();
    }

    @Epic(value = "Тест-кейс №81")
    @Test
    public void navigatingToTheNewsPageFromTheControlPanelPage() {
        Allure.step("Переход на страницу 'Новости' со страницы 'Панель управления'");
        mainSteps.allNewsButtonOnTheAppsHomePage(); //нажала кнопку "Все новости" на главной
        newsPage.vizibilityControlPanelButton();
        newsPageSteps.clickOnTheControlPanel();
        mainSteps.buttonBurgerMenuOfTheDifferentPages();
        burgerMenuPage.selectingNewsPageInBurgerMenu();
        newsPage.newsBlockDop.check(matches(isDisplayed()));
    }

    @Epic(value = "Тест-кейс №82")
    @Test
    public void navigatingToTheAboutAppPageFronTheControlPanelPage() {
        Allure.step("Переход на страницу 'О приложении' со страницы 'Панель управления'");
        mainSteps.allNewsButtonOnTheAppsHomePage(); //нажала кнопку "Все новости" на главной
        newsPage.vizibilityControlPanelButton();
        newsPageSteps.clickOnTheControlPanel();
        mainSteps.buttonBurgerMenuOfTheDifferentPages();
        burgerMenuPage.selectingAboutAppPageInBurgerMenu();
        aboutTheAppPage.titleAboutTheApp.check(matches(isDisplayed()));
    }

    @Epic(value = "Тест-кейс №77")
    @Test
    public void navigatingToTheMainPageFromTheQuotePage() {
        Allure.step("Переход на главную со страницы с цитатами");
        mainSteps.buttonQuotesOfTheMainPage();
        quotePage.vizibilityOfTheBlockWithQuotes();
        mainSteps.buttonBurgerMenuOfTheDifferentPages();
        burgerMenuPage.selectingHomePageInBurgerMenu();
        mainPage.loadingTheMainPage();
        mainSteps.vizibilityHomePage();
    }

    @Epic(value = "Тест-кейс №78")
    @Test
    public void navigatingToTheNewsPageFromTheQuotePage() {
        Allure.step("Переход на страницу 'Новости' со страницы с цитатами");
        mainSteps.buttonQuotesOfTheMainPage();
        quotePage.vizibilityOfTheBlockWithQuotes();
        mainSteps.buttonBurgerMenuOfTheDifferentPages();
        burgerMenuPage.selectingNewsPageInBurgerMenu();
        newsPage.newsBlockDop.check(matches(isDisplayed()));
    }

    @Epic(value = "Тест-кейс №79")
    @Test
    public void navigatingToTheAboutAppPageFromTheQuotePage() {
        Allure.step("Переход на страницу 'О приложении' со страницы с цитатами");
        mainSteps.buttonQuotesOfTheMainPage();
        quotePage.vizibilityOfTheBlockWithQuotes();
        mainSteps.buttonBurgerMenuOfTheDifferentPages();
        burgerMenuPage.selectingAboutAppPageInBurgerMenu();
        aboutTheAppPage.titleAboutTheApp.check(matches(isDisplayed()));
    }

}
