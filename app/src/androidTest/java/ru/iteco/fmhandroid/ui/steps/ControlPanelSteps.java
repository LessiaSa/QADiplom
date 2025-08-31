package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeDown;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.page.ControlPanelPage;
import ru.iteco.fmhandroid.ui.page.NewsPage;

public class ControlPanelSteps {
    ControlPanelPage controlPanelPage = new ControlPanelPage();
    NewsPage newsPage = new NewsPage();

    public void newsControlPanelSwipeToRefresh() {
        Allure.step("Свайп 'Обновить' на странице 'Панель управления'");
        controlPanelPage.swipeToRefreshControlPanel.perform(swipeDown());
    }

    public void buttonEditingNews() {
        Allure.step("Кнопка редактирования новости");
        controlPanelPage.vizibilityNewsListControlPanel();
        newsPage.vizibilityOfOneNewsBlock();
        controlPanelPage.buttonExpandNews.perform(click());
        controlPanelPage.buttonNewsEditing.perform(click());
    }

}