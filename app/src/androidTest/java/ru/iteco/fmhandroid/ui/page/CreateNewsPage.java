package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

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

}
