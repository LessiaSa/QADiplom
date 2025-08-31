package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;
import static ru.iteco.fmhandroid.ui.data.DataHelper.withIndex;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.DataHelper;

public class ControlPanelPage {
    DataHelper dataHelper = new DataHelper();
    CheckingPage checkingPage = new CheckingPage();
    FilterNewsPage filterNewsPage = new FilterNewsPage();
    CreateNewsPage createNewsPage = new CreateNewsPage();
    public static ViewInteraction buttonControlPanel = onView(withId(R.id.edit_news_material_button));
    public static int buttonControlPanelVizibility = R.id.edit_news_material_button;
    public static ViewInteraction swipeToRefreshControlPanel = onView(withId(R.id.news_control_panel_swipe_to_refresh));

    //Блок новости панели управления
    public static int activeOrInactiveNewsSectionNews = R.id.news_item_published_text_view;

    //Блок новости
    public static int blockNews = R.id.news_item_material_card_view; //Блок одной новости
    public static ViewInteraction blockNewsDop = onView(withId(R.id.news_item_material_card_view));

    //развернуть описание ОДНОЙ новости(то же и для панели управления в блоке новости)
    public static ViewInteraction buttonExpandNews = onView(withIndex(withId(R.id.view_news_item_image_view), 0));
    public static int descriptionNewsBlockNews = R.id.news_item_description_text_view; //описание новости в блоке новости при ее разворачивании
    public static int newsListControlPanel = R.id.news_list_recycler_view;

    //Редактирование новости
    public static ViewInteraction buttonNewsEditing = onView(withIndex(withId(R.id.edit_news_item_image_view), 0));
    public static ViewInteraction switcherActiveNotActiveNews = onView(withId(R.id.switcher));

    //Удаление новости
    public static ViewInteraction buttonDeleteNews = onView(withIndex(withId(R.id.delete_news_item_image_view), 0));
    public static ViewInteraction buttonBurgerMenu = onView(withId(R.id.main_menu_image_button));

    public void vizibilityInformationWhetherNewsIsActiveOrNotActive() {
        Allure.step("Видимость информации на блоке новости - активна новость или неактивна");
        onView(isRoot()).perform(waitDisplayed(activeOrInactiveNewsSectionNews, 5000));
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
        onView(isRoot()).perform(waitDisplayed(newsListControlPanel, 5000));
    }

    public void clickingTitle() {
        Allure.step("Клик по заголовку");
        onView(dataHelper.withItemText(checkingPage.title)).perform(click());
    }

    public void clickingTitleHello() {
        Allure.step("Клик по заголову 'Здравствуйте!'");
        onView(dataHelper.withItemText(checkingPage.titleHello)).perform(click());
    }

    public void clickingActiveOrNotActiveNews() {
        Allure.step("Клик по статусу новости");
        switcherActiveNotActiveNews.check(matches(isDisplayed())).perform(click());
    }

    public void clickButtonOkDeleteNews() {
        Allure.step("Нажать кнопку 'Ок' для удаления новости");
        filterNewsPage.buttonOkDeleteNews.perform(click());
    }

    public void createNewsItemButton() {
        Allure.step("Кнопка 'Создать новость' на странице 'Панель управления'");
        createNewsPage.buttonCreateNews.check(matches(isDisplayed())).perform(click());
    }
}
