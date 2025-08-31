package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.data.DataHelper.getCurrentDate;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;
import static ru.iteco.fmhandroid.ui.data.DataHelper.withIndex;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class CreateNewsPage {
    public static ViewInteraction buttonCreateNews = onView(withId(R.id.add_news_image_view));
    public static int containerCreateNews = R.id.container_custom_app_bar_include_on_fragment_create_edit_news;
    //Поле "заголовок" при создании новости
    public static ViewInteraction headerFieldNews = onView(withId(R.id.news_item_title_text_input_edit_text));
    public static ViewInteraction datePublicationNews = onView(withId(R.id.news_item_publish_date_text_input_edit_text)); //выставляем когда создаем новость
    public static ViewInteraction timePublicationNews = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    public static ViewInteraction descriptionNews = onView(withId(R.id.news_item_description_text_input_edit_text));
    public static ViewInteraction buttonSaveNews = onView(withId(R.id.save_button));

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
        onView(isRoot()).perform(waitDisplayed(containerCreateNews, 5000));
    }

    public void clickButtonCreateNews() {
        buttonCreateNews.check(matches(isDisplayed())).perform(click());
    }

}
