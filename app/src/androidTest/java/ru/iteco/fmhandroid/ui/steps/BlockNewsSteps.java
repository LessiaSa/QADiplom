package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.FieldIDs;

public class BlockNewsSteps {
    public void buttonOpeningDescriptionNews() {
        Allure.step("Кнопка для раскрытия описания новости на блоке новости");
        FieldIDs.buttonExpandNews.check(matches(isDisplayed())).perform(click());
    }
    public void deleteNewsOnTheNewsBlock() {
        Allure.step("Удаление новости на блоке новости");
        FieldIDs.buttonDeleteNews.check(matches(isDisplayed())).perform(click());
    }
    public void buttonEditingNews() {
        Allure.step("Кнопка для редактирования новости");
        FieldIDs.buttonNewsEditing.check(matches(isDisplayed())).perform(click());
    }
    public void switchActiveOrInactiveNews() {
        Allure.step("Переключатель - активна или неактивна новость");
        FieldIDs.switcherActiveNotActiveNews.check(matches(isDisplayed())).perform(click());
    }
}
