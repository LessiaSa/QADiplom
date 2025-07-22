package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.FieldIDs;

public class ControlPanelSteps {
    public void newsControlPanelSwipeToRefresh() {
        Allure.step("Свайп 'Обновить' на странице 'Панель управления'");
        FieldIDs.swipeToRefreshControlPanel.perform(click());
    }
    public void createNewsItemButton() {
        Allure.step("Кнопка 'Создать новость' на странице 'Панель управления'");
        FieldIDs.buttonCreateNews.perform(click());
    }
}