package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.data.DataHelper.getCurrentDate;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;
import static ru.iteco.fmhandroid.ui.data.DataHelper.withIndex;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.FieldIDs;

public class CreateNewsSteps {
    FieldIDs fieldIDs = new FieldIDs();
    ControlPanelSteps controlPanelSteps = new ControlPanelSteps();


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
        fieldIDs.datePublicationNews.check(matches(isDisplayed())).perform(click());
    }

    public void timePublicationNewsField() {
        Allure.step("Поле 'Время публикации'");
        fieldIDs.timePublicationNews.check(matches(isDisplayed())).perform(click());
    }

    public void clickDescriptionNewsField() {
        Allure.step("Клик по полю 'Описание'");
        fieldIDs.descriptionNews.check(matches(isDisplayed())).perform(click());
    }

    public void enteringTheTextInTheDescriptionField(String text) {
        Allure.step("Вводим текст в поле 'Описание'");
        fieldIDs.descriptionNews.perform(click(), clearText(), replaceText(text), closeSoftKeyboard());
    }

    public void saveNewsButton() {
        Allure.step("Кнопка 'Сохранить' при создании новости");
        fieldIDs.buttonSaveNews.check(matches(isDisplayed())).perform(click());
    }

    public void canselButtonUniversal() {
        Allure.step("Кнопка 'Отмена'");
        fieldIDs.buttonCancelNews.check(matches(isDisplayed())).perform(click());
        controlPanelSteps.clickButtonOkDeleteNews();
    }

    public void checkingDatePublicationNewsBlockNews() {
        Allure.step("Проверка даты публикации новости на блоке новости");
        onView(withIndex(withId(R.id.news_item_publication_date_text_view), 0))
                .check(matches(withText(getCurrentDate())));
    }

    public void checkingDisplayedDateOfTheNewsCreation() {
        Allure.step("Отображаемая дата создания новости на блоке новости");
        onView(withIndex(withId(R.id.news_item_create_date_text_view), 0))
                .check(matches(withText(getCurrentDate())));
    }

    public void vizibilityContainerCreateNews() {
        Allure.step("Видимость вкладки 'Создание новости'");
        onView(isRoot()).perform(waitDisplayed(fieldIDs.containerCreateNews, 5000));
    }

}
