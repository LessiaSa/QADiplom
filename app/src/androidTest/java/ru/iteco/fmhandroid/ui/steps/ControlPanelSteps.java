package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;
import static ru.iteco.fmhandroid.ui.data.DataHelper.withIndex;
import static ru.iteco.fmhandroid.ui.steps.CreateEndDeleneNewsSteps.controlPanelSteps;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.FieldIDs;

public class ControlPanelSteps {
    FieldIDs fieldIDs = new FieldIDs();
    NewsPageSteps newsPageSteps = new NewsPageSteps();

    public void newsControlPanelSwipeToRefresh() {
        Allure.step("Свайп 'Обновить' на странице 'Панель управления'");
        fieldIDs.swipeToRefreshControlPanel.perform(swipeDown());
    }

    public void createNewsItemButton() {
        Allure.step("Кнопка 'Создать новость' на странице 'Панель управления'");
        fieldIDs.buttonCreateNews.check(matches(isDisplayed())).perform(click());
    }

    public void vizibilityInformationWhetherNewsIsActiveOrNotActive() {
        Allure.step("Видимость информации на блоке новости - активна новость или неактивна");
        onView(isRoot()).perform(waitDisplayed(fieldIDs.activeOrInactiveNewsSectionNews, 5000));
    }

    public void checkingInformationWhetherNewsIsActive() {
        Allure.step("Проверка, что новость в блоке активна");
        onView(withIndex(withId(R.id.news_item_published_text_view), 0)).check(matches(withText("Активна")));
    }

    public void checkingInformationWhetherNewsNotActive() {
        Allure.step("Проверка, что новость в блоке неактивна");
        onView(withIndex(withId(R.id.news_item_published_text_view), 0)).check(matches(withText("Не активна")));
    }

    public  void vizibilityNewsListControlPanel() {
        Allure.step("Видимость всех новостей на странице 'Панель управления'");
        onView(isRoot()).perform(waitDisplayed(fieldIDs.newsListControlPanel, 5000));
    }

    public void clickButtonOkDeleteNews() {
        Allure.step("Нажать кнопку 'Ок' для удаления новости");
        fieldIDs.buttonOkDeleteNews.perform(click());
    }

    public void deleteNewsOnTheNewsBlock() {
        Allure.step("Удаление новости на блоке новости");
        controlPanelSteps.vizibilityNewsListControlPanel();
        newsPageSteps.vizibilityOfOneNewsBlock();
        fieldIDs.buttonExpandNews.perform(click());
        fieldIDs.buttonDeleteNews.perform(click());
        controlPanelSteps.clickButtonOkDeleteNews();
    }

    public void buttonEditingNews() {
        Allure.step("Кнопка редактирования новости");
        controlPanelSteps.vizibilityNewsListControlPanel();
        newsPageSteps.vizibilityOfOneNewsBlock();
        fieldIDs.buttonExpandNews.perform(click());
        fieldIDs.buttonNewsEditing.perform(click());
    }

}
