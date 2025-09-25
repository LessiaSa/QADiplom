package ru.iteco.fmhandroid.ui.tests;


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
import ru.iteco.fmhandroid.ui.page.CheckingPage;
import ru.iteco.fmhandroid.ui.page.ControlPanelPage;
import ru.iteco.fmhandroid.ui.page.CreateNewsPage;
import ru.iteco.fmhandroid.ui.page.FilterNewsPage;
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
public class CreateNewsTest {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    MainSteps mainSteps = new MainSteps();
    CreateNewsPage createNewsPage = new CreateNewsPage();
    ControlPanelPage controlPanelPage = new ControlPanelPage();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    NewsPageSteps newsPageSteps = new NewsPageSteps();
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    FilterNewsSteps filterNewsSteps = new FilterNewsSteps();
    ControlPanelSteps controlPanelSteps = new ControlPanelSteps();
    CreateNewsSteps createNewsSteps = new CreateNewsSteps();
    DataHelper dataHelper = new DataHelper();
    CreateEndDeleneNewsSteps createEndDeleneNewsSteps = new CreateEndDeleneNewsSteps();
    CheckingPage checkingPage = new CheckingPage();
    FilterNewsPage filterNewsPage = new FilterNewsPage();
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
            createNewsPage.clickButtonCreateNews();
        } catch (Exception e) {
            mainPage.buttonLogOutProfile();
            mainSteps.logOutPopUpOfTheProfile();
            authorizationPage.titleAuthorizationText();
            authorizationSteps.authorizWithValidData();
            mainPage.loadingTheMainPage();
            mainSteps.allNewsButtonOnTheAppsHomePage(); //нажала кнопку "Все новости" на главной
            newsPage.vizibilityControlPanelButton();
            newsPageSteps.clickOnTheControlPanel();
            createNewsPage.clickButtonCreateNews();
        }
        mActivityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }


    @Epic(value = "Тест-кейс №34")
    @Test
    public void newsCreation() {
        Allure.step("Создание новости");
        filterNewsSteps.openingTheCategoryField();
        filterNewsPage.selectingCategoryFromTheDropDownList();
        createNewsSteps.datePublicationNewsField();
        dataHelper.getDate(1);
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        createNewsSteps.timePublicationNewsField();
        dataHelper.getCurrentTime();
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        createNewsSteps.clickDescriptionNewsField();
        createNewsSteps.enteringTheTextInTheDescriptionField(checkingPage.description);
        createNewsSteps.saveNewsButton();
        controlPanelSteps.newsControlPanelSwipeToRefresh();
        controlPanelPage.vizibilityNewsListControlPanel();
        newsPage.vizibilityOfOneNewsBlock();
        controlPanelPage.buttonExpandNews.perform(click());
        newsPage.vizibilityDescriptionNews();
        checkingPage.checkingDescriptionReadIt();
        createEndDeleneNewsSteps.deleteNewsOnTheNewsBlock();
    }

    @Epic(value = "Тест-кейс №36")
    @Test
    public void creatingNewsStoryWithYourOwnHeadline() {
        Allure.step(" Создание новости со своим заголовком");
        filterNewsSteps.openingTheCategoryField();
        filterNewsSteps.enterCategoryNewsForNewsPage();
        createNewsSteps.clickOnTheHeaderField();
        createNewsSteps.enteringTextTitleField(checkingPage.titleAMustRead);
        createNewsSteps.datePublicationNewsField();
        dataHelper.getDate(+1);
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        createNewsSteps.timePublicationNewsField();
        dataHelper.getCurrentTime();
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        createNewsSteps.clickDescriptionNewsField();
        createNewsSteps.enteringTheTextInTheDescriptionField(checkingPage.description);
        createNewsSteps.saveNewsButton();
        controlPanelSteps.newsControlPanelSwipeToRefresh();
        controlPanelPage.vizibilityNewsListControlPanel();
        newsPage.vizibilityOfOneNewsBlock();
        controlPanelPage.buttonExpandNews.perform(click());
        newsPage.vizibilityDescriptionNews();
        checkingPage.checkingIsDisplayedAMustRead();
        createEndDeleneNewsSteps.deleteNewsOnTheNewsBlock();
    }

    @Epic(value = "Тест-кейс №45")
    @Test
    public void automaticCreationTitleWhenSelectingCategory() {
        Allure.step("Автоматическое создание заголовка при выборе категории");
        filterNewsSteps.openingTheCategoryField();
        filterNewsPage.selectingCategoryFromTheDropDownList();
        checkingPage.checkTextBirthday();
    }

    @Epic(value = "Тест-кейс №25")
    @Test
    public void unlimitedNumberCharactersTitleField() {
        Allure.step("Неограниченное число символов в поле 'Заголовок'ТЕСТ ДОЛЖЕН УПАСТЬ");
        filterNewsSteps.openingTheCategoryField();
        filterNewsSteps.enterCategoryNewsForNewsPage();
        createNewsSteps.clickOnTheHeaderField();
        createNewsSteps.enteringTextTitleField(checkingPage.bigTitle);
        createNewsSteps.datePublicationNewsField();
        dataHelper.getDate(+1);
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        createNewsSteps.timePublicationNewsField();
        dataHelper.getCurrentTime();
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        createNewsSteps.clickDescriptionNewsField();
        createNewsSteps.enteringTheTextInTheDescriptionField(checkingPage.description);
        createNewsSteps.saveNewsButton();
        createNewsPage.vizibilityContainerCreateNews();
    }

    @Epic(value = "Тест-кейс №40")
    @Test
    public void unlimitedNumberCharactersDescriptionField() {
        Allure.step("Неограниченное число символов в поле 'Описание'ТЕСТ ДОЛЖЕН УПАСТЬ");
        filterNewsSteps.openingTheCategoryField();
        filterNewsSteps.enterCategoryNewsForNewsPage();
        createNewsSteps.clickOnTheHeaderField();
        createNewsSteps.enteringTextTitleField(checkingPage.titleAMustRead);
        createNewsSteps.datePublicationNewsField();
        dataHelper.getDate(+1);
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        createNewsSteps.timePublicationNewsField();
        dataHelper.getCurrentTime();
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        createNewsSteps.clickDescriptionNewsField();
        createNewsSteps.enteringTheTextInTheDescriptionField(checkingPage.bigDescription);
        createNewsSteps.saveNewsButton();
        createNewsPage.vizibilityContainerCreateNews();
    }

    @Epic(value = "Тест-кейс №49")
    @Test
    public void cancelButtonWhenFillingFields() {
        Allure.step("Кнопка 'Отмена' при заполнении всех полей валидными данными");
        filterNewsSteps.openingTheCategoryField();
        filterNewsSteps.enterCategoryNewsForNewsPage();
        createNewsSteps.clickOnTheHeaderField();
        createNewsSteps.enteringTextTitleField(checkingPage.titleHello);
        createNewsSteps.datePublicationNewsField();
        dataHelper.getDate(+1);
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        createNewsSteps.timePublicationNewsField();
        dataHelper.getCurrentTime();
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        createNewsSteps.clickDescriptionNewsField();
        createNewsSteps.enteringTheTextInTheDescriptionField(checkingPage.description);
        createNewsSteps.canselButtonUniversal();
        checkingPage.checkHelloDoesNotExist();
    }

    @Epic(value = "Тест-кейс №50")
    @Test
    public void cancelButtonWhenPartiallyField() {
        Allure.step("Кнопка 'Отмена' при частичном заполнении полей");
        createNewsSteps.clickOnTheHeaderField();
        createNewsSteps.enteringTextTitleField(checkingPage.titleHello);
        createNewsSteps.canselButtonUniversal();
        checkingPage.checkHelloDoesNotExist();
    }

}
