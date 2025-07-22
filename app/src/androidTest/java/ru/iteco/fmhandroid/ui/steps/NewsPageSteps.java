package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.FieldIDs;

public class NewsPageSteps {

    public void clickOnTheSortNewsButton() {
        Allure.step("Клик по кнопке 'Сортировать новости'");
        FieldIDs.sortNewsButton.perform(click());
    }
    public void clickOnTheFilterNews() {
        Allure.step("Клик по кнопке 'Фильтровать новости'");
        FieldIDs.filterNewsButton.perform(click());
    }
    public void clickOnTheControlPanel() {
        Allure.step("Клик по кнопке 'Панель управления'");
        FieldIDs.buttonControlPanel.perform(click());
    }
}