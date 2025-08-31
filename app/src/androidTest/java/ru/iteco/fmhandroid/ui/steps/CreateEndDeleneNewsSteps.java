package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.page.ControlPanelPage;
import ru.iteco.fmhandroid.ui.page.NewsPage;

public class CreateEndDeleneNewsSteps {
    static CreateNewsSteps createNewsSteps = new CreateNewsSteps();
    static FilterNewsSteps filterNewsSteps = new FilterNewsSteps();
    static ControlPanelSteps controlPanelSteps = new ControlPanelSteps();
    static DataHelper dataHelper = new DataHelper();
    static ControlPanelPage controlPanelPage = new ControlPanelPage();
    NewsPage newsPage = new NewsPage();

    public static void createNewsForDifferendNeeds() {
        Allure.step("Создание новости для разных нужд");
        controlPanelPage.createNewsItemButton();
        filterNewsSteps.openingTheCategoryField();
        filterNewsSteps.enterCategoryNewsForNewsPage();
        createNewsSteps.clickOnTheHeaderField();
        createNewsSteps.enteringTextTitleField("Снова рады сообщить");
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
    }

    public void deleteNewsOnTheNewsBlock() {
        Allure.step("Удаление новости на блоке новости");
        controlPanelPage.vizibilityNewsListControlPanel();
        newsPage.vizibilityOfOneNewsBlock();
        controlPanelPage.buttonDeleteNews.perform(click());
        controlPanelPage.clickButtonOkDeleteNews();
    }

    public void deletingACreateNewsItem() {
        Allure.step("Удаление созданной новости");
        controlPanelPage.clickingTitle();
        controlPanelPage.buttonDeleteNews.perform(click());
        controlPanelPage.clickButtonOkDeleteNews();
    }

    public void deletingACreateNewsTitleHello() {
        controlPanelPage.clickingTitleHello();
        controlPanelPage.buttonDeleteNews.perform(click());
        controlPanelPage.clickButtonOkDeleteNews();
    }

    public void createNewsForTestDateCreate() {
        Allure.step("Создание новости для проверки даты создания новости");
        controlPanelPage.createNewsItemButton();
        filterNewsSteps.openingTheCategoryField();
        filterNewsSteps.enterCategoryNewsForNewsPage();
        createNewsSteps.clickOnTheHeaderField();
        createNewsSteps.enteringTextTitleField("Не пропустите!");
        createNewsSteps.datePublicationNewsField();
        dataHelper.getDate(+1);
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        createNewsSteps.timePublicationNewsField();
        dataHelper.getCurrentTime();
        filterNewsSteps.buttonOkInThePopUpMessageToConfirmTheSelection();
        createNewsSteps.clickDescriptionNewsField();
        createNewsSteps.enteringTheTextInTheDescriptionField("Только сегодня!");
        createNewsSteps.saveNewsButton();
        controlPanelSteps.newsControlPanelSwipeToRefresh();
    }

}
