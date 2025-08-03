package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.fieldIDs;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.FieldIDs;

public class CreateNewsSteps {

    public void clickOnTheHeaderField() {
        Allure.step("Клик по полю 'Заголовок' при создании новости");
        fieldIDs.headerFieldNews.check(matches(isDisplayed())).perform(click());
    }

    public void enteringTextTitleField(String text) {
        Allure.step("Вводим текст в поле 'Заголовок'");
        fieldIDs.headerFieldNews.perform(click(), clearText(), replaceText(text), closeSoftKeyboard());
    }
    public void datePublicationNewsField() {
        Allure.step("Поле 'Дата публикации'");
        FieldIDs.datePublicationNews.check(matches(isDisplayed())).perform(click());
    }
    public void timePublicationNewsField() {
        Allure.step("Поле 'Время публикации'");
        FieldIDs.timePublicationNews.check(matches(isDisplayed())).perform(click());
    }
    public void clickDescriptionNewsField() {
        Allure.step("Клик по полю 'Описание'");
        FieldIDs.descriptionNews.check(matches(isDisplayed())).perform(click());
    }

    public void enteringTheTextInTheDescriptionField(String text) {
        Allure.step("Вводим текст в поле 'Описание'");
        fieldIDs.descriptionNews.perform(click(),clearText(), replaceText(text),closeSoftKeyboard());
    }
    public void saveNewsButton() {
        Allure.step("Кнопка 'Сохранить' при создании новости");
        FieldIDs.buttonSaveNews.check(matches(isDisplayed())).perform(click());
    }

//    public void scrollToTheDesiredNews(String text) {
//        Allure.step(" Прокрутить до нужной новости");
//
//    }
    public void checkingWhetherTheNewsHasBeenPublished() {
        Allure.step("Проверка - опубликована ли новость");
        fieldIDs.checkingWhetherNews.check(matches(isDisplayed()));
    }
}
