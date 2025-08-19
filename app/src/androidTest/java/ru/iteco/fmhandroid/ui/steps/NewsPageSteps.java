package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.page.ControlPanelPage;
import ru.iteco.fmhandroid.ui.page.FilterNewsPage;
import ru.iteco.fmhandroid.ui.page.NewsPage;

public class NewsPageSteps {
    FilterNewsPage filterNewsPage = new FilterNewsPage();
    ControlPanelPage controlPanelPage = new ControlPanelPage();
    NewsPage newsPage = new NewsPage();

    public void clickOnTheFilterNews() {
        Allure.step("Клик по кнопке 'Фильтровать новости' на странице 'Новости'");
        filterNewsPage.filterNewsButton.check(matches(isDisplayed())).perform(click());
    }

    public void vizibilityControlPanelButton() {
        Allure.step("Видимость кнопки 'Панель управления'");
        onView(isRoot()).perform(waitDisplayed(controlPanelPage.buttonControlPanelVizibility, 5000));
    }

    public void clickOnTheControlPanel() {
        Allure.step("Клик по кнопке 'Панель управления'");
        controlPanelPage.buttonControlPanel.check(matches(isDisplayed())).perform(click());
    }

    public void vizibilityOfAllNewsBlocksOnTheNewsPage() {
        Allure.step("Видимость всех блоков с новостями на странице 'Новости'");
        onView(isRoot()).perform(waitDisplayed(newsPage.newsBlock, 5000));
    }

    public void vizibilityOfOneNewsBlock() {
        Allure.step("Видимость одного блока новости");
        onView(isRoot()).perform(waitDisplayed(controlPanelPage.blockNews, 5000));
    }

    public void vizibilityDescriptionNews() {
        Allure.step("Видимость описания в одном блоке новости");
        onView(isRoot()).perform(waitDisplayed(controlPanelPage.descriptionNewsBlockNews, 5000));
    }
}
