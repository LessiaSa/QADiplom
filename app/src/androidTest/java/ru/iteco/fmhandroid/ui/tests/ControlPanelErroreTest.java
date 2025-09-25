package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Epic;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.page.AuthorizationPage;
import ru.iteco.fmhandroid.ui.page.ControlPanelPage;
import ru.iteco.fmhandroid.ui.page.CreateNewsPage;
import ru.iteco.fmhandroid.ui.page.MainPage;
import ru.iteco.fmhandroid.ui.page.NewsPage;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.ControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.CreateEndDeleneNewsSteps;
import ru.iteco.fmhandroid.ui.steps.CreateNewsSteps;
import ru.iteco.fmhandroid.ui.steps.FilterNewsSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsPageSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ControlPanelErroreTest {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    MainSteps mainSteps = new MainSteps();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    NewsPageSteps newsPageSteps = new NewsPageSteps();
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    FilterNewsSteps filterNewsSteps = new FilterNewsSteps();
    ControlPanelSteps controlPanelSteps = new ControlPanelSteps();
    ControlPanelPage controlPanelPage = new ControlPanelPage();
    CreateNewsSteps createNewsSteps = new CreateNewsSteps();
    CreateEndDeleneNewsSteps createEndDeleneNewsSteps = new CreateEndDeleneNewsSteps();
    CreateNewsPage createNewsPage = new CreateNewsPage();
    MainPage mainPage = new MainPage();
    NewsPage newsPage = new NewsPage();
    private View decorView;

    @Before
    public void setUp() {
        try {
            authorizationPage.applicationHomeScreen();
            authorizationPage.titleAuthorizationText();
            authorizationSteps.authorizWithValidData();
            mainPage.loadingTheMainPage();
            mainSteps.allNewsButtonOnTheAppsHomePage(); //нажала кнопку "Все новости" на главной
            newsPage.vizibilityControlPanelButton();
            newsPageSteps.clickOnTheControlPanel();
        } catch (Exception e) {
            mainPage.buttonLogOutProfile();
            mainSteps.logOutPopUpOfTheProfile();
            authorizationPage.titleAuthorizationText();
            authorizationSteps.authorizWithValidData();
            mainPage.loadingTheMainPage();
            mainSteps.allNewsButtonOnTheAppsHomePage(); //нажала кнопку "Все новости" на главной
            newsPage.vizibilityControlPanelButton();
            newsPageSteps.clickOnTheControlPanel();
        }
        mActivityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    @Epic(value = "Тест-кейс №63")
    @Test
    public void changingTheNewsCreationDate() {
        Allure.step("Изменение даты создания новости.ТЕСТ ДОЛЖЕН УПАСТЬ");
        controlPanelSteps.buttonEditingNews();
        filterNewsSteps.openingTheCategoryField();
        filterNewsSteps.enterCategoryNewsForNewsPage();
        filterNewsSteps.openingTheCategoryField();
        closeSoftKeyboard();
        createNewsSteps.saveNewsButton();
        controlPanelSteps.newsControlPanelSwipeToRefresh();
        controlPanelPage.vizibilityNewsListControlPanel();
        newsPage.vizibilityOfOneNewsBlock();
        createNewsPage.checkingDisplayedDateOfTheNewsCreation();
    }

    @Epic(value = "Тест-кейс №62")
    @Test
    public void visibleDateOfTheNewsCreation() {
        Allure.step("Отображаемая дата создания новости на блоке новости.ТЕСТ ДОЛЖЕН УПАСТЬ");
        createEndDeleneNewsSteps.createNewsForTestDateCreate();
        controlPanelPage.vizibilityNewsListControlPanel();
        newsPage.vizibilityOfOneNewsBlock();
        createNewsPage.checkingDisplayedDateOfTheNewsCreation();
    }
}
