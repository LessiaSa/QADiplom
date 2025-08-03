package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.data.FieldIDs;

public class FilterNewsSteps {
    FieldIDs fieldIDs = new FieldIDs();
    DataHelper dataHelper = new DataHelper();
    public void openingTheCategoryField() {
        Allure.step("Раскрытие поля 'Категория'");
        fieldIDs.categoryNews.check(matches(isDisplayed())).perform(click());
    }
    public void enterCategoryNewsForNewsPage() {
        Allure.step("Выбор категории новости");
       dataHelper.randomCategory();
    }
    public void dateDetectionLeftField() {
        Allure.step("Клик по левому полю 'ДД.ММ.ГГГГ'");
        fieldIDs.dateLeftNews.check(matches(isDisplayed())).perform(click());
    }
    public void dateDetectionRightField() {
        Allure.step("Клик по правому полю 'ДД.ММ.ГГГГ'");
        fieldIDs.dateRightNews.check(matches(isDisplayed())).perform(click());
    }
    public void buttonOkInThePopUpMessageToConfirmTheSelection() {
        Allure.step("Кнопка 'Ок' во всплывающем сообщении для подтверждения выбора");
        fieldIDs.buttonOkDate.check(matches(isDisplayed())).perform(click());
    }
    public void checkThatNewsActive() {
        Allure.step("Нажать галочку 'Активна'");
        fieldIDs.checkmarkActiveFilterNews.check(matches(isDisplayed())).perform(click());
    }
    public void checkThatNewsNotActive() {
        Allure.step("Нажать галочку 'Не активна'");
        fieldIDs.checkmarkNotActiveFilterNews.check(matches(isDisplayed())).perform(click());
    }


    public void filterButtonForFilteringNews() {
        Allure.step("Кнопка 'Фильтровать' для фильтрации новостей");
        //onView(isRoot()).perform(waitDisplayed(fieldIDs.filterNewsButtonVizibility, 5000));
        fieldIDs.buttonFilterNews.check(matches(isDisplayed())).perform(click());
    }
    public void cancelNewFilteringButton() {
        Allure.step("Кнопка 'Отмена' фильтрации новостей");
        fieldIDs.buttonCancelNews.check(matches(isDisplayed())).perform(click());
    }

}
