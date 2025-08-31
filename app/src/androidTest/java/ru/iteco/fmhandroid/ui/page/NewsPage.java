package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class NewsPage {
    ControlPanelPage controlPanelPage = new ControlPanelPage();
    public static int newsBlock = R.id.all_news_cards_block_constraint_layout;// Все блоки с новостями на странице "Новости";//Все!!!блоки с новостями на странице "Новости"
    public static ViewInteraction newsBlockDop = onView(withId(R.id.all_news_cards_block_constraint_layout));
    public static ViewInteraction newsButton = onView(withId(R.id.all_news_text_view)); //кнопка "Все новости";
    public static ViewInteraction buttonCollapse = onView(withId(R.id.expand_material_button));

    public void vizibilityControlPanelButton() {
        Allure.step("Видимость кнопки 'Панель управления'");
        onView(isRoot()).perform(waitDisplayed(controlPanelPage.buttonControlPanelVizibility, 5000));
    }

    public void vizibilityOfAllNewsBlocksOnTheNewsPage() {
        Allure.step("Видимость всех блоков с новостями на странице 'Новости'");
        onView(isRoot()).perform(waitDisplayed(newsBlock, 5000));
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
