package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.RootMatchers;

import org.hamcrest.Matchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.page.FilterNewsPage;

public class FilterNewsSteps {
    FilterNewsPage filterNewsPage = new FilterNewsPage();
    DataHelper dataHelper = new DataHelper();

    public void openingTheCategoryField() {
        Allure.step("Раскрытие поля 'Категория'");
        filterNewsPage.categoryNews.check(matches(isDisplayed())).perform(click());
    }

    public void enterCategoryNewsForNewsPage() {
        Allure.step("Выбор случайной категории новости");
        dataHelper.randomCategory();
    }

    public void selectingCategoryFromTheDropDownList() {
        Allure.step("Выбор категории из выпадающего списка");
        Espresso.onData(Matchers.anything())
                .inRoot(RootMatchers.isPlatformPopup()).atPosition(1).perform(click());
    }

    public void dateDetectionLeftField() {
        Allure.step("Клик по левому полю 'ДД.ММ.ГГГГ'");
        filterNewsPage.dateLeftNews.check(matches(isDisplayed())).perform(click());
    }

    public void dateDetectionRightField() {
        Allure.step("Клик по правому полю 'ДД.ММ.ГГГГ'");
        filterNewsPage.dateRightNews.check(matches(isDisplayed())).perform(click());
    }

    public void buttonOkInThePopUpMessageToConfirmTheSelection() {
        Allure.step("Кнопка 'Ок' во всплывающем сообщении для подтверждения выбора");
        filterNewsPage.buttonOkDate.check(matches(isDisplayed())).perform(click());
    }

    public void checkThatNewsActive() {
        Allure.step("Нажать галочку 'Активна'");
        filterNewsPage.checkmarkActiveFilterNews.check(matches(isDisplayed())).perform(click());
    }

    public void checkThatNewsNotActive() {
        Allure.step("Нажать галочку 'Не активна'");
        filterNewsPage.checkmarkNotActiveFilterNews.check(matches(isDisplayed())).perform(click());
    }


    public void filterButtonForFilteringNews() {
        Allure.step("Кнопка 'Фильтровать' для фильтрации новостей");
        filterNewsPage.buttonFilterNews.check(matches(isDisplayed())).perform(click());
    }

    public void cancelNewFilteringButton() {
        Allure.step("Кнопка 'Отмена' фильтрации новостей");
        filterNewsPage.buttonCancelNews.check(matches(isDisplayed())).perform(click());
    }

}
