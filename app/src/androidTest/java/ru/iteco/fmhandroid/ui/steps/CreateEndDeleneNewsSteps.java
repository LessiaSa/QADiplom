package ru.iteco.fmhandroid.ui.steps;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.DataHelper;

public class CreateEndDeleneNewsSteps {
    static CreateNewsSteps createNewsSteps = new CreateNewsSteps();
    static FilterNewsSteps filterNewsSteps = new FilterNewsSteps();
    static ControlPanelSteps controlPanelSteps = new ControlPanelSteps();
    static DataHelper dataHelper = new DataHelper();

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

}
