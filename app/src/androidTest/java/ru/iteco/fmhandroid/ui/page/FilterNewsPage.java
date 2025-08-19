package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class FilterNewsPage {
    public static ViewInteraction filterNewsButton = onView(withId(R.id.filter_news_material_button));
    public static ViewInteraction categoryNews = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public static ViewInteraction dateLeftNews = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    public static ViewInteraction dateRightNews = onView(withId(R.id.news_item_publish_date_end_text_input_layout));
    public static ViewInteraction checkmarkActiveFilterNews = onView(withId(R.id.filter_news_active_material_check_box));
    public static ViewInteraction checkmarkNotActiveFilterNews = onView(withId(R.id.filter_news_inactive_material_check_box));
    //кнопка "Фильтровать"
    public static ViewInteraction buttonFilterNews = onView(withId(R.id.filter_button));
    public static ViewInteraction buttonCancelNews = onView(withId(R.id.cancel_button));
    //кнопка "Ок" при выставлении даты
    public static ViewInteraction buttonOkDate = onView(allOf(withId(android.R.id.button1), withText("ОК")));
    public static ViewInteraction buttonOkDeleteNews = onView(withId(android.R.id.button1));
}
