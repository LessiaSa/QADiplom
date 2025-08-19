package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class NewsPage {
    public static int newsBlock = R.id.all_news_cards_block_constraint_layout;// Все блоки с новостями на странице "Новости";//Все!!!блоки с новостями на странице "Новости"
    public static ViewInteraction newsBlockDop = onView(withId(R.id.all_news_cards_block_constraint_layout));
    public static ViewInteraction newsButton = onView(withId(R.id.all_news_text_view)); //кнопка "Все новости";
    public static ViewInteraction buttonCollapse = onView(withId(R.id.expand_material_button));; //Кнопка скрыть или раскрыть блоки с новостями на главной
}
