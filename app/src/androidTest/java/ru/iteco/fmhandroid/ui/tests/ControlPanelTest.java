package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.Espresso.closeSoftKeyboard;

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
import ru.iteco.fmhandroid.ui.page.BurgerMenuPage;
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

public class ControlPanelTest {

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
    DataHelper dataHelper = new DataHelper();
    BurgerMenuPage burgerMenuPage = new BurgerMenuPage();
    CheckingPage checkingPage = new CheckingPage();
    CreateNewsPage createNewsPage = new CreateNewsPage();
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

    @After
    public void tearDown() {
        try {
            mainPage.buttonLogOutProfile();
            mainSteps.logOutPopUpOfTheProfile();
        } catch (Exception ignored) {

        }
    }

    @Epic(value = "Тест-кейс №28")
    @Test
    public void filteringOnlyActiveNews() {
        Allure.step("Фильтрация только активных новостей");
        newsPageSteps.clickOnTheFilterNews();
        filterNewsSteps.checkThatNewsNotActive();
        filterNewsSteps.filterButtonForFilteringNews();
        newsPage.vizibilityOfOneNewsBlock();
        controlPanelPage.vizibilityInformationWhetherNewsIsActiveOrNotActive();
        controlPanelPage.checkingInformationWhetherNewsIsActive();
    }

    @Epic(value = "Тест-кейс №27")
    @Test
    public void filteringOnlyNotActiveNews() {
        Allure.step("Фильтрация только неактивных новостей");
        newsPageSteps.clickOnTheFilterNews();
        filterNewsSteps.checkThatNewsActive();
        filterNewsSteps.filterButtonForFilteringNews();
        try {
            newsPage.vizibilityOfOneNewsBlock();
            controlPanelPage.vizibilityInformationWhetherNewsIsActiveOrNotActive();
            controlPanelPage.checkingInformationWhetherNewsNotActive();
        } catch (Exception e) {
            mainSteps.buttonBurgerMenuOfTheDifferentPages();
            burgerMenuPage.selectingNewsPageInBurgerMenu();
            newsPageSteps.clickOnTheControlPanel();
            controlPanelSteps.buttonEditingNews();
            controlPanelPage.clickingActiveOrNotActiveNews();
            createNewsSteps.saveNewsButton();
            newsPageSteps.clickOnTheFilterNews();
            filterNewsSteps.checkThatNewsActive();
            filterNewsSteps.filterButtonForFilteringNews();
            newsPage.vizibilityOfOneNewsBlock();
            controlPanelPage.vizibilityInformationWhetherNewsIsActiveOrNotActive();
            controlPanelPage.checkingInformationWhetherNewsNotActive();
        }
    }

    @Epic(value = "Тест-кейс №31")
    @Test
    public void cancelingNewsFilteringWhenNoFieldsAreFieldIn() {
        Allure.step("Отмена фильтрации новостей при незаполненном ни одном поле");
        newsPageSteps.clickOnTheFilterNews();
        filterNewsSteps.cancelNewFilteringButton();
        controlPanelPage.vizibilityNewsListControlPanel();
    }

    @Epic(value = "Тест-кейс №33")
    @Test
    public void cancelingNewsFilteringWhenAllFilteringFieldsAreFilledIn() {
        Allure.step("Отмена фильтрации новостей при заполнении всех полей для фильтрации");
        newsPageSteps.clickOnTheFilterNews();
        filterNewsSteps.openingTheCategoryField();
        filterNewsPage.selectingCategoryFromTheDropDownList();
        filterNewsSteps.dateDetectionLeftField();
        dataHelper.getDate(1);
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        filterNewsSteps.dateDetectionRightField();
        dataHelper.getDate(+5);
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        filterNewsSteps.cancelNewFilteringButton();
        controlPanelPage.vizibilityNewsListControlPanel();
    }

    @Epic(value = "Тест-кейс №66")
    @Test
    public void deleteNews() {
        Allure.step("Удаление новости");
        createEndDeleneNewsSteps.createNewsForDifferendNeeds();
        createEndDeleneNewsSteps.deletingACreateNewsItem();
        checkingPage.checkDoesNotExist();
    }

    @Epic(value = "Тест-кейс №55")
    @Test
    public void editingTheNewsDescription() {
        Allure.step("Редактирование описания новости");
        createEndDeleneNewsSteps.createNewsForDifferendNeeds();
        controlPanelSteps.buttonEditingNews();
        createNewsSteps.enteringTheTextInTheDescriptionField(checkingPage.descriptionTellEveryone);
        createNewsSteps.saveNewsButton();
        controlPanelSteps.newsControlPanelSwipeToRefresh();
        controlPanelPage.vizibilityNewsListControlPanel();
        newsPage.vizibilityOfOneNewsBlock();
        controlPanelPage.clickingTitle();
        newsPage.vizibilityDescriptionNews();
        checkingPage.checkingDescriptionTellEveryone();
        createEndDeleneNewsSteps.deleteNewsOnTheNewsBlock();
    }


    @Epic(value = "Тест-кейс №52")
    @Test
    public void editingTheNewsCategory() {
        Allure.step("Редактирование заголовка уже опубликованной новости");
        createEndDeleneNewsSteps.createNewsForDifferendNeeds();
        controlPanelSteps.buttonEditingNews();
        createNewsSteps.clickOnTheHeaderField();
        createNewsSteps.enteringTextTitleField(checkingPage.titleHello);
        createNewsSteps.saveNewsButton();
        controlPanelSteps.newsControlPanelSwipeToRefresh();
        controlPanelPage.vizibilityNewsListControlPanel();
        newsPage.vizibilityOfOneNewsBlock();
        checkingPage.checkingIsDisplayedHello();
        createEndDeleneNewsSteps.deletingACreateNewsTitleHello();
    }

    @Epic(value = "Тест-кейс №56")
    @Test
    public void changingStatusOfAnAlreadyPublishedNewsItemFromActiveToInactive() {
        Allure.step("Изменение статуса уже опубликованной новости");
        controlPanelSteps.buttonEditingNews();
        controlPanelPage.clickingActiveOrNotActiveNews();
        createNewsSteps.saveNewsButton();
        newsPage.vizibilityOfOneNewsBlock();
        controlPanelPage.vizibilityInformationWhetherNewsIsActiveOrNotActive();

    }

    @Epic(value = "Тест-кейс №58")
    @Test
    public void cancelingEditingWhenMakingChangesFields() {
        Allure.step("Отмена редактирования при внесении изменнений в поля");
        controlPanelSteps.buttonEditingNews();
        createNewsSteps.clickOnTheHeaderField();
        createNewsSteps.enteringTextTitleField(checkingPage.titleHello);
        createNewsSteps.canselButtonUniversal();
        checkingPage.checkHelloDoesNotExist();
    }

    @Epic(value = "Тест-кейс №59")
    @Test
    public void cancelEditingChangesHaveBeenMadeFields() {
        Allure.step("Отмена редактирования, если изменения полей не было");
        createEndDeleneNewsSteps.createNewsForDifferendNeeds();
        controlPanelSteps.buttonEditingNews();
        createNewsSteps.canselButtonUniversal();
        controlPanelSteps.newsControlPanelSwipeToRefresh();
        controlPanelPage.vizibilityNewsListControlPanel();
        newsPage.vizibilityOfOneNewsBlock();
        checkingPage.checkingIsDisplayed();
        createEndDeleneNewsSteps.deletingACreateNewsItem();
    }

    @Epic(value = "Тест-кейс №69")
    @Test
    public void datePublicationOfTheNewsBlock() {
        Allure.step("Дата публикации на блоке новости");
        createEndDeleneNewsSteps.createNewsForDifferendNeeds();
        controlPanelPage.vizibilityNewsListControlPanel();
        newsPage.vizibilityOfOneNewsBlock();
        createNewsPage.checkingDatePublicationNewsBlockNews();
        createEndDeleneNewsSteps.deleteNewsOnTheNewsBlock();
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