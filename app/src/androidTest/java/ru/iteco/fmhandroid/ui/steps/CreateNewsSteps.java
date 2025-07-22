package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.FieldIDs;

public class CreateNewsSteps {
    public void titleFieldWhenCreatingNewsItem() {
        Allure.step("Поле 'Заголовок' при создании новости");
        FieldIDs.headerFieldNews.perform(click());
    }
    public void datePublicationNewsField() {
        Allure.step("Поле 'Дата публикации'");
        FieldIDs.datePublicationNews.perform(click());
    }
    public void timePublicationNewsField() {
        Allure.step("Поле 'Время публикации'");
        FieldIDs.timePublicationNews.perform(click());
    }
    public void descriptionNewsField() {
        Allure.step("Описание новости");
        FieldIDs.descriptionNews.perform(click());
    }
    public void saveNewsButton() {
        Allure.step("Кнопка 'Сохранить' при создании новости");
        FieldIDs.buttonSaveNews.perform(click());
    }
}