package ru.iteco.fmhandroid.ui.tests;

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
import ru.iteco.fmhandroid.ui.steps.BlockNewsSteps;
import ru.iteco.fmhandroid.ui.steps.ControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.CreateNewsSteps;
import ru.iteco.fmhandroid.ui.steps.FilterNewsSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsPageSteps;

@LargeTest
@RunWith(AndroidJUnit4.class)
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
    FieldIDs fieldIDs = new FieldIDs();
    BlockNewsSteps blockNewsSteps = new BlockNewsSteps();
    CreateNewsSteps createNewsSteps = new CreateNewsSteps();
    DataHelper dataHelper = new DataHelper();
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
    @Test
    public void filteringOnlyNotActiveNews() {
        Allure.step("Фильтрация только неактивных новостей");
        newsPageSteps.clickOnTheFilterNews();
        filterNewsSteps.checkThatNewsActive();
        filterNewsSteps.filterButtonForFilteringNews();
        newsPageSteps.vizibilityOfOneNewsBlock();
        controlPanelSteps.vizibilityInformationWhetherNewsIsActiveOrNotActive();
        controlPanelSteps.checkingInformationWhetherNewsNotActive();
    }
    // СНАЧАЛА СОЗДАТЬ НОВОСТЬ, А ПОТОМ ПРОВЕРИТЬ, ЧТО ЕЕ НЕТ
//    @Test
//    public void deleteNews() {
//        Allure.step("Удаление новости");
//        newsPageSteps.vizibilityOfOneNewsBlock();
//        blockNewsSteps. deleteNewsOnTheNewsBlock();
//        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
//    }
    @Test
    public void newsCreation() {
        Allure.step(" Создание новости со своим заголовком");
        controlPanelSteps.createNewsItemButton();
        filterNewsSteps.openingTheCategoryField();
        filterNewsSteps.enterCategoryNewsForNewsPage();
        createNewsSteps.clickOnTheHeaderField();
        createNewsSteps.enteringTextTitleField("Обязательно к прочтению");
        createNewsSteps.datePublicationNewsField();
        dataHelper.getDate(+1);
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        createNewsSteps.timePublicationNewsField();
        dataHelper.getCurrentTime();
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        createNewsSteps.clickDescriptionNewsField();
        createNewsSteps.enteringTheTextInTheDescriptionField("Читайте, читайте и не говорите, что не читали!");
        createNewsSteps.saveNewsButton();
        createNewsSteps.checkingWhetherTheNewsHasBeenPublished();

//        ViewInteraction textViewBlockNews = fieldIDs.blockOneNews;
//        textViewBlockNews.check(matches(isDisplayed()));
//        textViewBlockNews.check(matches(withText("Обязательно к прочтению")));
    }

}
