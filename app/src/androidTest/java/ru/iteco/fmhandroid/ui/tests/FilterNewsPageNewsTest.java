package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.data.FieldIDs;
import ru.iteco.fmhandroid.ui.page.AuthorizationPage;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.FilterNewsSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsPageSteps;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class FilterNewsPageNewsTest {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    MainSteps mainSteps = new MainSteps();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    NewsPageSteps newsPageSteps = new NewsPageSteps();
    FilterNewsSteps filterNewsSteps = new FilterNewsSteps();
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    private View decorView;

    @Before
    public void setUp() {
        try {
            authorizationSteps.applicationHomeScreen();
            authorizationPage.titleAuthorizationText();
            authorizationSteps.authorizWithValidData();
            mainSteps.loadingTheMainPage();
            mainSteps.allNewsButtonOnTheAppsHomePage(); //нажала кнопку "Все новости" на главной
            newsPageSteps.vizibilityOfAllNewsBlocksOnTheNewsPage();
            newsPageSteps.clickOnTheFilterNews();
        } catch (Exception e) {
            mainSteps.buttonLogOutProfile();
            mainSteps.logOutPopUpOfTheProfile();
            authorizationPage.titleAuthorizationText();
            authorizationSteps.authorizWithValidData();
            mainSteps.loadingTheMainPage();
            mainSteps.allNewsButtonOnTheAppsHomePage(); //нажала кнопку "Все новости" на главной
            newsPageSteps.vizibilityOfAllNewsBlocksOnTheNewsPage();
            newsPageSteps.clickOnTheFilterNews();
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

    @Test
    public void filteringNewsCategoryWithoutFillingInTheOtherField() {
        Allure.step("Фильтрация новостей по фильтру 'Категория' без заполнения остальных полей");
        filterNewsSteps.openingTheCategoryField();
        filterNewsSteps.enterCategoryNewsForNewsPage();
        filterNewsSteps.openingTheCategoryField();
        filterNewsSteps.filterButtonForFilteringNews();
        NewsPageSteps.vizibilityOfAllNewsBlocksOnTheNewsPage();
    }

    @Test
    public void filteringNewsBuCategoryFilterWithLeftDate() {
        Allure.step("Фильтрация новостей по фильтру 'Категория' с заполненым левым полем даты и незаполненым правым полем даты");
        filterNewsSteps.openingTheCategoryField();
        filterNewsSteps.enterCategoryNewsForNewsPage();
        filterNewsSteps.openingTheCategoryField();
        filterNewsSteps.dateDetectionLeftField();
        DataHelper.getDate(-1);
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        filterNewsSteps.filterButtonForFilteringNews();
        onView(withText("Неверно указан период"))
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }
    @Test
    public void filteringNewsBuCategoryFilterWithRightDate() {
        Allure.step("Фильтрация новостей по фильтру 'Категория' с заполненым правым полем даты и незаполненым левым");
        filterNewsSteps.openingTheCategoryField();
        filterNewsSteps.enterCategoryNewsForNewsPage();
        filterNewsSteps.openingTheCategoryField();
        filterNewsSteps.dateDetectionRightField();
        DataHelper.getDate(1);
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        filterNewsSteps.filterButtonForFilteringNews();
        onView(withText("Неверно указан период"))
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }
    //НЕ ПРОВЕРИЛА, ЧТО ОТОБРАЖАЕТСЯ ТЕКУЩАЯ ДАТА
//    @Test
//    public void currentDateIfYouDoNotSelectDateAndImmediatelyClickOk() {
//        Allure.step("Отображение текущей даты если не выбирать дату а сразу нажать 'Ок'");
//        filterNewsSteps.dateDetectionRightField();
//        filterNewsSteps.buttonOkWhenSelectingAPublicationDateInTheCalendar();
//        FieldIDs.dateRightNews.check(matches(isDisplayed()));
//    }
    @Test
    public void failedFilteringIsAFutureDateAndTheEndPastDate() {
        Allure.step("Начало фильтрации новостей - будущая дата, а окончание - прошедшая дата.ТЕСТ ДОЛЖЕН УПАСТЬ");
        filterNewsSteps.dateDetectionLeftField();
        DataHelper.getDate(+3);
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        filterNewsSteps.dateDetectionRightField();

        DataHelper.getDate(-1);
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        filterNewsSteps.filterButtonForFilteringNews();
        onView(withText("Неверно указан период"))
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }
    @Test
    public void filteringNewsWithAllFieldWithValidData() {
        Allure.step("Фильтрация новостей со всеми заполнеными полями валидными данными на странице 'Новости'");
        filterNewsSteps.openingTheCategoryField();
        filterNewsSteps.enterCategoryNewsForNewsPage();
        filterNewsSteps.openingTheCategoryField();

        filterNewsSteps.dateDetectionLeftField();
        DataHelper.getDate(-5);
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();

        filterNewsSteps.dateDetectionRightField();
        DataHelper.getDate(5);
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        filterNewsSteps.filterButtonForFilteringNews();
        NewsPageSteps.vizibilityOfAllNewsBlocksOnTheNewsPage();
    }

}
