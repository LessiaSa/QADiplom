package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.page.ControlPanelPage;

public class CreateEndDeleneNewsSteps {
    static CreateNewsSteps createNewsSteps = new CreateNewsSteps();
    static FilterNewsSteps filterNewsSteps = new FilterNewsSteps();
    static ControlPanelSteps controlPanelSteps = new ControlPanelSteps();
    static DataHelper dataHelper = new DataHelper();
    NewsPageSteps newsPageSteps = new NewsPageSteps();
    ControlPanelPage controlPanelPage = new ControlPanelPage();

    public static void createNewsForDifferendNeeds() {
        Allure.step("Создание новости для разных нужд");
        controlPanelSteps.createNewsItemButton();
        filterNewsSteps.openingTheCategoryField();
        filterNewsSteps.enterCategoryNewsForNewsPage();
        createNewsSteps.clickOnTheHeaderField();
        createNewsSteps.enteringTextTitleField("Снова рады сообщить");
        createNewsSteps.datePublicationNewsField();
        dataHelper.getDate(+5);
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
        controlPanelSteps.vizibilityNewsListControlPanel();
        newsPageSteps.vizibilityOfOneNewsBlock();
        controlPanelPage.buttonDeleteNews.perform(click());
        controlPanelSteps.clickButtonOkDeleteNews();
    }

}
//controlPanelPage.buttonDeleteNews.perform(click());
//        controlPanelSteps.clickButtonOkDeleteNews();
//onView(Matchers.allOf(withId(R.id.news_item_title_text_view), withText("Снова рады сообщить"))).check(doesNotExist());
//        }