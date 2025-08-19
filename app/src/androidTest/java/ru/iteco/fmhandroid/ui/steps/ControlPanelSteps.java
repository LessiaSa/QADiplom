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
import ru.iteco.fmhandroid.ui.page.ControlPanelPage;
import ru.iteco.fmhandroid.ui.page.CreateNewsPage;
import ru.iteco.fmhandroid.ui.page.FilterNewsPage;

public class ControlPanelSteps {
    NewsPageSteps newsPageSteps = new NewsPageSteps();
    ControlPanelPage controlPanelPage = new ControlPanelPage();
    CreateNewsPage createNewsPage = new CreateNewsPage();
    FilterNewsPage filterNewsPage = new FilterNewsPage();

    public void newsControlPanelSwipeToRefresh() {
        Allure.step("Свайп 'Обновить' на странице 'Панель управления'");
        controlPanelPage.swipeToRefreshControlPanel.perform(swipeDown());
    }

    public void createNewsItemButton() {
        Allure.step("Кнопка 'Создать новость' на странице 'Панель управления'");
        createNewsPage.buttonCreateNews.check(matches(isDisplayed())).perform(click());
    }

    public void vizibilityInformationWhetherNewsIsActiveOrNotActive() {
        Allure.step("Видимость информации на блоке новости - активна новость или неактивна");
        onView(isRoot()).perform(waitDisplayed(controlPanelPage.activeOrInactiveNewsSectionNews, 5000));
    }

    public void checkingInformationWhetherNewsIsActive() {
        Allure.step("Проверка, что новость в блоке активна");
        onView(withIndex(withId(R.id.news_item_published_text_view), 0)).check(matches(withText("Активна")));
    }

    public void checkingInformationWhetherNewsNotActive() {
        Allure.step("Проверка, что новость в блоке неактивна");
        onView(withIndex(withId(R.id.news_item_published_text_view), 0)).check(matches(withText("Не активна")));
    }

    public void vizibilityNewsListControlPanel() {
        Allure.step("Видимость всех новостей на странице 'Панель управления'");
        onView(isRoot()).perform(waitDisplayed(controlPanelPage.newsListControlPanel, 5000));
    }

    public void clickButtonOkDeleteNews() {
        Allure.step("Нажать кнопку 'Ок' для удаления новости");
        filterNewsPage.buttonOkDeleteNews.perform(click());
    }


    public void buttonEditingNews() {
        Allure.step("Кнопка редактирования новости");
        controlPanelSteps.vizibilityNewsListControlPanel();
        newsPageSteps.vizibilityOfOneNewsBlock();
        controlPanelPage.buttonExpandNews.perform(click());
        controlPanelPage.buttonNewsEditing.perform(click());
    }

}