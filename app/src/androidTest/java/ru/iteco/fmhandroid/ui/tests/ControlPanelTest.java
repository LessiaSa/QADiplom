package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
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
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.page.AuthorizationPage;
import ru.iteco.fmhandroid.ui.page.CheckingPage;
import ru.iteco.fmhandroid.ui.page.ControlPanelPage;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.BurgerMenuSteps;
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
    BurgerMenuSteps burgerMenuSteps = new BurgerMenuSteps();
    CheckingPage checkingPage = new CheckingPage();
    private View decorView;

    @Before
    public void setUp() {
        try {
            authorizationSteps.applicationHomeScreen();
            authorizationPage.titleAuthorizationText();
            authorizationSteps.authorizWithValidData();
            mainSteps.loadingTheMainPage();
            mainSteps.allNewsButtonOnTheAppsHomePage(); //нажала кнопку "Все новости" на главной
            newsPageSteps.vizibilityControlPanelButton();
            newsPageSteps.clickOnTheControlPanel();
        } catch (Exception e) {
            mainSteps.buttonLogOutProfile();
            mainSteps.logOutPopUpOfTheProfile();
            authorizationPage.titleAuthorizationText();
            authorizationSteps.authorizWithValidData();
            mainSteps.loadingTheMainPage();
            mainSteps.allNewsButtonOnTheAppsHomePage(); //нажала кнопку "Все новости" на главной
            newsPageSteps.vizibilityControlPanelButton();
            newsPageSteps.clickOnTheControlPanel();
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

    @Epic(value = "Тест-кейс №28")
    @Test
    public void filteringOnlyActiveNews() {
        Allure.step("Фильтрация только активных новостей");
        newsPageSteps.clickOnTheFilterNews();
        filterNewsSteps.checkThatNewsNotActive();
        filterNewsSteps.filterButtonForFilteringNews();
        newsPageSteps.vizibilityOfOneNewsBlock();
        controlPanelSteps.vizibilityInformationWhetherNewsIsActiveOrNotActive();
        controlPanelSteps.checkingInformationWhetherNewsIsActive();
    }

    @Epic(value = "Тест-кейс №27")
    @Test
    public void filteringOnlyNotActiveNews() {
        Allure.step("Фильтрация только неактивных новостей");
        newsPageSteps.clickOnTheFilterNews();
        filterNewsSteps.checkThatNewsActive();
        filterNewsSteps.filterButtonForFilteringNews();
        try {
            newsPageSteps.vizibilityOfOneNewsBlock();
            controlPanelSteps.vizibilityInformationWhetherNewsIsActiveOrNotActive();
            controlPanelSteps.checkingInformationWhetherNewsNotActive();
        } catch (Exception e) {
            mainSteps.buttonBurgerMenuOfTheDifferentPages();
            burgerMenuSteps.selectingNewsPageInBurgerMenu();
            newsPageSteps.clickOnTheControlPanel();
            controlPanelSteps.buttonEditingNews();
            controlPanelPage.switcherActiveNotActiveNews.check(matches(isDisplayed())).perform(click());
            createNewsSteps.saveNewsButton();
            newsPageSteps.clickOnTheFilterNews();
            filterNewsSteps.checkThatNewsActive();
            filterNewsSteps.filterButtonForFilteringNews();
            newsPageSteps.vizibilityOfOneNewsBlock();
            controlPanelSteps.vizibilityInformationWhetherNewsIsActiveOrNotActive();
            controlPanelSteps.checkingInformationWhetherNewsNotActive();
        }
    }

    @Epic(value = "Тест-кейс №31")
    @Test
    public void cancelingNewsFilteringWhenNoFieldsAreFieldIn() {
        Allure.step("Отмена фильтрации новостей при незаполненном ни одном поле");
        newsPageSteps.clickOnTheFilterNews();
        filterNewsSteps.cancelNewFilteringButton();
        controlPanelSteps.vizibilityNewsListControlPanel();
    }

    @Epic(value = "Тест-кейс №33")
    @Test
    public void cancelingNewsFilteringWhenAllFilteringFieldsAreFilledIn() {
        Allure.step("Отмена фильтрации новостей при заполнении всех полей для фильтрации");
        newsPageSteps.clickOnTheFilterNews();
        filterNewsSteps.openingTheCategoryField();
        filterNewsSteps.selectingCategoryFromTheDropDownList();
        filterNewsSteps.dateDetectionLeftField();
        dataHelper.getDate(1);
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        filterNewsSteps.dateDetectionRightField();
        dataHelper.getDate(+5);
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        filterNewsSteps.cancelNewFilteringButton();
        controlPanelSteps.vizibilityNewsListControlPanel();
    }

    @Epic(value = "Тест-кейс №66")
    @Test
    public void deleteNews() {
        Allure.step("Удаление новости");
        createEndDeleneNewsSteps.createNewsForDifferendNeeds();
        createEndDeleneNewsSteps.deleteNewsOnTheNewsBlock();
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
        controlPanelSteps.vizibilityNewsListControlPanel();
        newsPageSteps.vizibilityOfOneNewsBlock();
        onView(dataHelper.withItemText(checkingPage.title)).perform(click());
        newsPageSteps.vizibilityDescriptionNews();
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
        controlPanelSteps.vizibilityNewsListControlPanel();
        newsPageSteps.vizibilityOfOneNewsBlock();
        onView(dataHelper.withItemText(checkingPage.titleHello)).perform(click());
        newsPageSteps.vizibilityDescriptionNews();
        checkingPage.checkingIsDisplayedHello();
        createEndDeleneNewsSteps.deleteNewsOnTheNewsBlock();
    }

    @Epic(value = "Тест-кейс №56")
    @Test
    public void changingStatusOfAnAlreadyPublishedNewsItemFromActiveToInactive() {
        Allure.step("Изменение статуса уже опубликованной новости");
        createEndDeleneNewsSteps.createNewsForDifferendNeeds();
        controlPanelSteps.buttonEditingNews();
        controlPanelPage.switcherActiveNotActiveNews.check(matches(isDisplayed())).perform(click());
        createNewsSteps.saveNewsButton();
        newsPageSteps.vizibilityOfOneNewsBlock();
        onView(dataHelper.withItemText(checkingPage.title)).perform(click());
        controlPanelSteps.vizibilityInformationWhetherNewsIsActiveOrNotActive();
        controlPanelSteps.checkingInformationWhetherNewsNotActive();
        createEndDeleneNewsSteps.deleteNewsOnTheNewsBlock();
    }

    @Epic(value = "Тест-кейс №58")
    @Test
    public void cancelingEditingWhenMakingChangesFields() {
        Allure.step("Отмена редактирования при внесении изменнений в поля");
        createEndDeleneNewsSteps.createNewsForDifferendNeeds();
        controlPanelSteps.buttonEditingNews();
        createNewsSteps.clickOnTheHeaderField();
        createNewsSteps.enteringTextTitleField(checkingPage.titleHello);
        createNewsSteps.canselButtonUniversal();
        checkingPage.checkHelloDoesNotExist();
        createEndDeleneNewsSteps.deleteNewsOnTheNewsBlock();
    }

    @Epic(value = "Тест-кейс №59")
    @Test
    public void cancelEditingChangesHaveBeenMadeFields() {
        Allure.step("Отмена редактирования, если изменения полей не было");
        createEndDeleneNewsSteps.createNewsForDifferendNeeds();
        controlPanelSteps.buttonEditingNews();
        createNewsSteps.canselButtonUniversal();
        controlPanelSteps.newsControlPanelSwipeToRefresh();
        controlPanelSteps.vizibilityNewsListControlPanel();
        newsPageSteps.vizibilityOfOneNewsBlock();
        checkingPage.checkingIsDisplayed();
        createEndDeleneNewsSteps.deleteNewsOnTheNewsBlock();
    }

    @Epic(value = "Тест-кейс №69")
    @Test
    public void datePublicationOfTheNewsBlock() {
        Allure.step("Дата публикации на блоке новости");
        createEndDeleneNewsSteps.createNewsForDifferendNeeds();
        controlPanelSteps.vizibilityNewsListControlPanel();
        newsPageSteps.vizibilityOfOneNewsBlock();
        createNewsSteps.checkingDatePublicationNewsBlockNews();
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
        controlPanelSteps.vizibilityNewsListControlPanel();
        newsPageSteps.vizibilityOfOneNewsBlock();
        createNewsSteps.checkingDisplayedDateOfTheNewsCreation();
    }

    @Epic(value = "Тест-кейс №62")
    @Test
    public void displayedDateOfTheNewsCreation() {
        Allure.step("Отображаемая дата создания новости на блоке новости.ТЕСТ ДОЛЖЕН УПАСТЬ");
        createEndDeleneNewsSteps.createNewsForDifferendNeeds();
        controlPanelSteps.vizibilityNewsListControlPanel();
        newsPageSteps.vizibilityOfOneNewsBlock();
        createNewsSteps.checkingDisplayedDateOfTheNewsCreation();
    }


}