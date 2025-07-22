package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.FieldIDs;

public class FilterNewsSteps {
    public void openingTheCategoryField() {
        Allure.step("Раскрытие поля 'Категория'");
        FieldIDs.categoryNews.perform(click());
    }
    public void dateDetectionLeftField() {
        Allure.step("Определение даты в левом поле");
        FieldIDs.dateLeftNews.perform(click());
    }
    public void dateDetectionRightField() {
        Allure.step("Определение даты в правом поле");
        FieldIDs.dateRightNews.perform(click());
    }
    public void checkThatNewsActive() {
        Allure.step("Установить галочку, что новость активна");
        FieldIDs.checkmarkActiveFilterNews.perform(click());
    }
    public void checkThatNewsNotActive() {
        Allure.step("Установить галочку, что новость не активна");
        FieldIDs.checkmarkNotActiveFilterNews.perform(click());
    }
    public void filterButtonForFilteringNews() {
        Allure.step("Кнопка 'Фильтровать' для фильтрации новостей");
        FieldIDs.buttonFilterNews.perform(click());
    }
    public void cancelNewFilteringButton() {
        Allure.step("Кнопка 'Отмена' фильтрации новостей");
        FieldIDs.buttonCancelNews.perform(click());
    }

}