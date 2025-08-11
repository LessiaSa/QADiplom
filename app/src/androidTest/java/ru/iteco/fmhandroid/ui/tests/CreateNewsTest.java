package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.data.DataHelper.withIndex;

import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Epic;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.data.FieldIDs;
import ru.iteco.fmhandroid.ui.page.AuthorizationPage;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.ControlPanelSteps;
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
    AuthorizationPage authorizationPage = new AuthorizationPage();
    NewsPageSteps newsPageSteps = new NewsPageSteps();
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    FilterNewsSteps filterNewsSteps = new FilterNewsSteps();
    ControlPanelSteps controlPanelSteps = new ControlPanelSteps();
    FieldIDs fieldIDs = new FieldIDs();
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
            controlPanelSteps.createNewsItemButton();
        } catch (Exception e) {
            mainSteps.buttonLogOutProfile();
            mainSteps.logOutPopUpOfTheProfile();
            authorizationPage.titleAuthorizationText();
            authorizationSteps.authorizWithValidData();
            mainSteps.loadingTheMainPage();
            mainSteps.allNewsButtonOnTheAppsHomePage(); //нажала кнопку "Все новости" на главной
            newsPageSteps.vizibilityControlPanelButton();
            newsPageSteps.clickOnTheControlPanel();
            controlPanelSteps.createNewsItemButton();
        }
        mActivityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    @After
    public void tearDown() {
        try {
            fieldIDs.buttonDeleteNews.perform(click());
            controlPanelSteps.clickButtonOkDeleteNews();
            onView(Matchers.allOf(withId(R.id.news_item_description_text_view)
                    , withText("Читайте, читайте и не говорите, что не читали!"))).check(doesNotExist());
            mainSteps.buttonLogOutProfile();
            mainSteps.logOutPopUpOfTheProfile();
        } catch (Exception ignored) {

        }
    }

    @Epic(value = "Тест-кейс №34")
    @Test
    public void newsCreation() {
        Allure.step("Создание новости");
        filterNewsSteps.openingTheCategoryField();
        filterNewsSteps.selectingCategoryFromTheDropDownList();
        createNewsSteps.datePublicationNewsField();
        dataHelper.getDate(1);
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        createNewsSteps.timePublicationNewsField();
        dataHelper.getCurrentTime();
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        createNewsSteps.clickDescriptionNewsField();
        createNewsSteps.enteringTheTextInTheDescriptionField("Читайте, читайте и не говорите, что не читали!");
        createNewsSteps.saveNewsButton();

        controlPanelSteps.newsControlPanelSwipeToRefresh();
        controlPanelSteps.vizibilityNewsListControlPanel();
        newsPageSteps.vizibilityOfOneNewsBlock();
        fieldIDs.buttonExpandNews.perform(click());
        newsPageSteps.vizibilityDescriptionNews();
        onView(withIndex(withId(R.id.news_item_description_text_view), 0))
                .check(matches(withText("Читайте, читайте и не говорите, что не читали!")));

        fieldIDs.buttonDeleteNews.perform(click());
        controlPanelSteps.clickButtonOkDeleteNews();
        onView(Matchers.allOf(withId(R.id.news_item_description_text_view)
                , withText("Читайте, читайте и не говорите, что не читали!"))).check(doesNotExist());
    }

    @Epic(value = "Тест-кейс №36")
    @Test
    public void creatingNewsStoryWithYourOwnHeadline() {
        Allure.step(" Создание новости со своим заголовком");
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

        controlPanelSteps.newsControlPanelSwipeToRefresh();
        controlPanelSteps.vizibilityNewsListControlPanel();
        newsPageSteps.vizibilityOfOneNewsBlock();
        fieldIDs.buttonExpandNews.perform(click());
        newsPageSteps.vizibilityDescriptionNews();
        onView(withIndex(withId(R.id.news_item_title_text_view), 0))
                .check(matches(withText("Обязательно к прочтению")));

        fieldIDs.buttonDeleteNews.perform(click());
        controlPanelSteps.clickButtonOkDeleteNews();
        onView(Matchers.allOf(withId(R.id.news_item_title_text_view), withText("Обязательно к прочтению"))).check(doesNotExist());
    }

    @Epic(value = "Тест-кейс №45")
    @Test
    public void automaticCreationTitleWhenSelectingCategory() {
        Allure.step("Автоматическое создание заголовка при выборе категории");
        filterNewsSteps.openingTheCategoryField();
        filterNewsSteps.selectingCategoryFromTheDropDownList();
        ViewInteraction titleText = fieldIDs.headerFieldNews;
        titleText.check(matches(isDisplayed()));
        titleText.check(matches(withText("День рождения")));
    }

    @Epic(value = "Тест-кейс №25")
    @Test
    public void unlimitedNumberCharactersTitleField() {
        Allure.step("Неограниченное число символов в поле 'Заголовок'ТЕСТ ДОЛЖЕН УПАСТЬ");
        filterNewsSteps.openingTheCategoryField();
        filterNewsSteps.enterCategoryNewsForNewsPage();
        createNewsSteps.clickOnTheHeaderField();
        createNewsSteps.enteringTextTitleField("Обязательно к прочтению85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvkt" +
                "lvjd85hgb&$)Hcdekvktlvjd85hgb&\" +\n" +
                "                    \"$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85hg\" +\n" +
                "                    \"b&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd");
        createNewsSteps.datePublicationNewsField();
        dataHelper.getDate(+1);
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        createNewsSteps.timePublicationNewsField();
        dataHelper.getCurrentTime();
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        createNewsSteps.clickDescriptionNewsField();
        createNewsSteps.enteringTheTextInTheDescriptionField("Читайте, читайте и не говорите, что не читали!");
        createNewsSteps.saveNewsButton();
        createNewsSteps.vizibilityContainerCreateNews();
    }

    @Epic(value = "Тест-кейс №40")
    @Test
    public void unlimitedNumberCharactersDescriptionField() {
        Allure.step("Неограниченное число символов в поле 'Описание'ТЕСТ ДОЛЖЕН УПАСТЬ");
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
        createNewsSteps.enteringTheTextInTheDescriptionField("Читайте, читайте и не говорите, что не читали!kvktlvjd85hgb&$" +
                ")Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcde" +
                "                kvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85" +
                "                vktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)" +
                "Hcdekvktvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd8");
        createNewsSteps.saveNewsButton();
        createNewsSteps.vizibilityContainerCreateNews();
    }

    @Epic(value = "Тест-кейс №49")
    @Test
    public void cancelButtonWhenFillingFields() {
        Allure.step("Кнопка 'Отмена' при заполнении всех полей валидными данными");
        filterNewsSteps.openingTheCategoryField();
        filterNewsSteps.enterCategoryNewsForNewsPage();
        createNewsSteps.clickOnTheHeaderField();
        createNewsSteps.enteringTextTitleField("Здравствуйте!");
        createNewsSteps.datePublicationNewsField();
        dataHelper.getDate(+1);
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        createNewsSteps.timePublicationNewsField();
        dataHelper.getCurrentTime();
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        createNewsSteps.clickDescriptionNewsField();
        createNewsSteps.enteringTheTextInTheDescriptionField("Читайте, читайте и не говорите, что не читали!;");
        createNewsSteps.canselButtonUniversal();
        onView(Matchers.allOf(withId(R.id.news_item_title_text_view), withText("Здравствуйте!"))).check(doesNotExist());
    }

    @Epic(value = "Тест-кейс №50")
    @Test
    public void cancelButtonWhenPartiallyField() {
        Allure.step("Кнопка 'Отмена' при частичном заполнении полей");
        createNewsSteps.clickOnTheHeaderField();
        createNewsSteps.enteringTextTitleField("Здравствуйте!");
        createNewsSteps.canselButtonUniversal();
        onView(Matchers.allOf(withId(R.id.news_item_title_text_view), withText("Здравствуйте!"))).check(doesNotExist());
    }

}
