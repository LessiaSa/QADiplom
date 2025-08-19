package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.data.DataHelper.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ControlPanelPage {
    public static ViewInteraction buttonControlPanel = onView(withId(R.id.edit_news_material_button));
    public static int buttonControlPanelVizibility = R.id.edit_news_material_button;
    public static ViewInteraction swipeToRefreshControlPanel = onView(withId(R.id.news_control_panel_swipe_to_refresh));

    //Блок новости панели управления
    public static int activeOrInactiveNewsSectionNews = R.id.news_item_published_text_view;

    //Блок новости
    public static int blockNews = R.id.news_item_material_card_view; //Блок одной новости

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
}
