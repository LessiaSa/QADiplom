package ru.iteco.fmhandroid.ui.data;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.DataHelper.withIndex;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class FieldIDs {
    public static int authorizationButtonEnter;
    public static ViewInteraction enterButton;

    //Новости
    public static int newsBlock;//Все!!!блоки с новостями на странице "Новости"
    public static ViewInteraction newsBlockDop;
    public static ViewInteraction newsButton;
    public static ViewInteraction buttonCollapse; //Кнопка скрыть или раскрыть блоки с новостями на главной
    //кнопка"Фильтровать новости на Tabbar
    public static ViewInteraction filterNewsButton;
    public static ViewInteraction titleFilterNews;
    public static ViewInteraction categoryNews;
    public static ViewInteraction dateLeftNews;
    public static ViewInteraction dateRightNews;
    public static ViewInteraction checkmarkActiveFilterNews;
    public static ViewInteraction checkmarkNotActiveFilterNews;
    //кнопка "Фильтровать"
    public static ViewInteraction buttonFilterNews;
    public static ViewInteraction buttonCancelNews;
    //кнопка "Ок" при выставлении даты
    public static ViewInteraction buttonOkDate;
    public static ViewInteraction buttonOkDeleteNews;


    //Панель управления
    public static ViewInteraction buttonControlPanel;
    public static int buttonControlPanelVizibility;
    public static ViewInteraction swipeToRefreshControlPanel;


    //Создание новости
    public static ViewInteraction buttonCreateNews;
    public static int containerCreateNews;
    //Поле "заголовок" при создании новости
    public static ViewInteraction headerFieldNews;
    public static ViewInteraction datePublicationNews; //выставляем когда создаем новость
    public static ViewInteraction timePublicationNews;
    public static ViewInteraction descriptionNews;
    public static ViewInteraction buttonSaveNews;


    //Редактирование новости
    public static ViewInteraction buttonNewsEditing;
    public static ViewInteraction switcherActiveNotActiveNews;

    //Удаление новости
    public static ViewInteraction buttonDeleteNews;

    //Блок новости
    public static int blockNews; //Блок одной новости
    public static ViewInteraction buttonExpandNews; //развернуть описание ОДНОЙ новости(то же и для панели управления в блоке новости)
    public static int descriptionNewsBlockNews; //описание новости в блоке новости при ее разворачивании
    public static int newsListControlPanel;


    //Блок новости панели управления
    public static int activeOrInactiveNewsSectionNews;

    //BurgerMenu
    public static ViewInteraction buttonBurgerMenu;


    //О приложении
    public static int aboutAppBlock;
    public static ViewInteraction titleAboutTheApp;
    public static ViewInteraction headerPrivacyPolicy;
    public static ViewInteraction linkPrivacyPolicy;
    public static ViewInteraction headerUserAgreement;
    public static ViewInteraction linkUserAgreement;
    public static ViewInteraction buttonBackAboutTheApp;

    //Цитаты
    public static ViewInteraction buttonQuotes;
    public static int quoteBlockAllQuotes; //Блок со всеми цитатами
    public static int quoteBlock;
    public static ViewInteraction buttonUnwrapRollUpQuotes;
    public static int descriptionQuoteBlock;

    //Кнока "Выйти"
    public static ViewInteraction buttonLogOut;
    public static ViewInteraction buttonExitPopUpWindow;

    public FieldIDs() {
        authorizationButtonEnter = R.id.enter_button;
        enterButton = onView(withId(R.id.enter_button));
        newsButton = onView(withId(R.id.all_news_text_view)); //кнопка "Все новости"
        buttonCollapse = onView(withId(R.id.expand_material_button));
        newsBlock = R.id.all_news_cards_block_constraint_layout;// Все блоки с новостями на странице "Новости"
        newsBlockDop = onView(withId(R.id.all_news_cards_block_constraint_layout));
        descriptionNewsBlockNews = R.id.news_item_description_text_view;
        filterNewsButton = onView(withId(R.id.filter_news_material_button));
        categoryNews = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
        dateLeftNews = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
        dateRightNews = onView(withId(R.id.news_item_publish_date_end_text_input_layout));
        buttonFilterNews = onView(withId(R.id.filter_button));
        buttonCancelNews = onView(withId(R.id.cancel_button));
        buttonControlPanel = onView(withId(R.id.edit_news_material_button));
        buttonControlPanelVizibility = R.id.edit_news_material_button;
        swipeToRefreshControlPanel = onView(withId(R.id.news_control_panel_swipe_to_refresh));
        titleFilterNews = onView(withId(R.id.filter_news_title_text_view));
        checkmarkActiveFilterNews = onView(withId(R.id.filter_news_active_material_check_box));
        checkmarkNotActiveFilterNews = onView(withId(R.id.filter_news_inactive_material_check_box));
        buttonCreateNews = onView(withId(R.id.add_news_image_view));
        containerCreateNews = R.id.container_custom_app_bar_include_on_fragment_create_edit_news;
        headerFieldNews = onView(withId(R.id.news_item_title_text_input_edit_text));

        datePublicationNews = onView(withId(R.id.news_item_publish_date_text_input_edit_text));

        timePublicationNews = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
        descriptionNews = onView(withId(R.id.news_item_description_text_input_edit_text)); //поле "Описание" при создании новости
        buttonSaveNews = onView(withId(R.id.save_button));
        activeOrInactiveNewsSectionNews = R.id.news_item_published_text_view;
        buttonDeleteNews = onView(withIndex(withId(R.id.delete_news_item_image_view), 0));
        buttonNewsEditing = onView(withIndex(withId(R.id.edit_news_item_image_view), 0));
        switcherActiveNotActiveNews = onView(withId(R.id.switcher));

        buttonBurgerMenu = onView(withId(R.id.main_menu_image_button));
        aboutAppBlock = R.id.container_custom_app_bar_include_on_fragment_about;
        titleAboutTheApp = onView(withId(R.id.about_version_title_text_view));
        headerPrivacyPolicy = onView(withId(R.id.about_privacy_policy_label_text_view));
        linkPrivacyPolicy = onView(withId(R.id.about_privacy_policy_value_text_view));
        headerUserAgreement = onView(withId(R.id.about_terms_of_use_label_text_view));
        linkUserAgreement = onView(withId(R.id.about_terms_of_use_value_text_view));
        buttonBackAboutTheApp = onView(withId(R.id.about_back_image_button));
        buttonQuotes = onView(withId(R.id.our_mission_image_button));
        quoteBlockAllQuotes = R.id.our_mission_item_list_recycler_view;
        quoteBlock = R.id.our_mission_item_material_card_view;
        //“В хосписе не работают плохие люди” В.В. Миллионщикова
        buttonUnwrapRollUpQuotes = onView(withIndex(withId(R.id.our_mission_item_open_card_image_button), 0));
        //Все сотрудники хосписа - это адвокаты пациента, его прав и потребностей. Поиск путей решения различных задач -
        // это и есть хосписный индивидуальный подход к паллиативной помощи.
        descriptionQuoteBlock = R.id.our_mission_item_description_text_view;
        buttonLogOut = onView(withId(R.id.authorization_image_button));
        buttonExitPopUpWindow = onView(allOf(withId(android.R.id.title), withText("Выйти")));
        blockNews = R.id.news_item_material_card_view;
        buttonExpandNews = onView(withIndex(withId(R.id.view_news_item_image_view), 0));
        newsListControlPanel = R.id.news_list_recycler_view;
        buttonOkDate = onView(allOf(withId(android.R.id.button1), withText("ОК")));
        buttonOkDeleteNews = onView(withId(android.R.id.button1));
    }
}
