package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.page.CreateNewsPage;
import ru.iteco.fmhandroid.ui.page.FilterNewsPage;

public class CreateNewsSteps {
    FilterNewsPage filterNewsPage = new FilterNewsPage();
    CreateNewsPage createNewsPage = new CreateNewsPage();


    public void clickOnTheHeaderField() {
        Allure.step("Клик по полю 'Заголовок' при создании новости");
        createNewsPage.headerFieldNews.check(matches(isDisplayed())).perform(click());
    }

    public void enteringTextTitleField(String text) {
        Allure.step("Вводим текст в поле 'Заголовок'");
        createNewsPage.headerFieldNews.perform(click(), clearText(), replaceText(text), closeSoftKeyboard());
    }

    public void datePublicationNewsField() {
        Allure.step("Поле 'Дата публикации'");
        createNewsPage.datePublicationNews.check(matches(isDisplayed())).perform(click());
    }

    public void timePublicationNewsField() {
        Allure.step("Поле 'Время публикации'");
        createNewsPage.timePublicationNews.check(matches(isDisplayed())).perform(click());
    }

    public void clickDescriptionNewsField() {
        Allure.step("Клик по полю 'Описание'");
        createNewsPage.descriptionNews.check(matches(isDisplayed())).perform(click());
    }

    public void enteringTheTextInTheDescriptionField(String text) {
        Allure.step("Вводим текст в поле 'Описание'");
        createNewsPage.descriptionNews.perform(click(), clearText(), replaceText(text), closeSoftKeyboard());
    }

    public void saveNewsButton() {
        Allure.step("Кнопка 'Сохранить' при создании новости");
        createNewsPage.buttonSaveNews.check(matches(isDisplayed())).perform(click());
    }

    public void canselButtonUniversal() {
        Allure.step("Кнопка 'Отмена'");
        filterNewsPage.buttonCancelNews.check(matches(isDisplayed())).perform(click());
        filterNewsPage.buttonOkDeleteNews.perform(click());
    }

}
