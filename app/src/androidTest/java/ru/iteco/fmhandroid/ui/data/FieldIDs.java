package ru.iteco.fmhandroid.ui.data;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.DataHelper.withIndex;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class FieldIDs {
    public static Matcher<View> homeScreen;
    public static ViewInteraction titleAuthoriz;
    public static Matcher<View> authorizLog;
    public static ViewInteraction authorizPass;
    public static int authorizationButtonEnter;
    public static ViewInteraction enterButton;
    public static ViewInteraction mainTitle;
    public static ViewInteraction gestureUpdate;

    //Новости
    public static int newsBlock;//Все!!!блоки с новостями на странице "Новости"
    public static  ViewInteraction newsButton;
    public static ViewInteraction sortNewsButton;
    public static ViewInteraction buttonCollapse; //Кнопка скрыть или раскрыть блоки с новостями на главной
    //кнопка"Фильтровать новости на Tabbar
    public static ViewInteraction filterNewsButton;
    public static int filterNewsButtonVizibility;
    public static ViewInteraction titleFilterNews;
    public static ViewInteraction categoryNews;
    public static ViewInteraction dateLeftNews;
    public static ViewInteraction buttonCancelDateLeftNews;
    public static ViewInteraction dateRightNews;
    public static ViewInteraction checkmarkActiveFilterNews;
    public static ViewInteraction checkmarkNotActiveFilterNews;
    public ViewInteraction buttonOkDateRightNews;
    public ViewInteraction buttonCancelDateRightNews;
    //кнопка "Фильтровать"
    public static ViewInteraction buttonFilterNews;
    public static ViewInteraction buttonCancelNews;
    //кнопка "Ок" при выставлении даты
    public static ViewInteraction buttonOkDate;



    //Панель управления
    public static ViewInteraction buttonControlPanel;
    public static int buttonControlPanelVizibility;
    //Страница "Панель управления"(вся страница)
    public static ViewInteraction controlPanelContainer;
    public static ViewInteraction swipeToRefreshControlPanel;
    public ViewInteraction buttonOkLeftFilterNewsControlPanel;
    public ViewInteraction buttonCancelLeftFilterNewsControlPanel;
    public ViewInteraction buttonOkRightFilterNewsControlPanel;
    public ViewInteraction buttonCancelRightFilterNewsControlPanel;



    //Создание новости
    public static ViewInteraction buttonCreateNews;
    //Поле "заголовок" при создании новости
    public static ViewInteraction headerFieldNews;
    public static ViewInteraction datePublicationNews; //выставляем когда создаем новость
    public ViewInteraction buttonOkDatePublicationCreateNews;
    public ViewInteraction buttonCancelDatePublicationCreateNews;
    public static ViewInteraction timePublicationNews;
    public static ViewInteraction descriptionNews;
    public static ViewInteraction buttonSaveNews;
    public static ViewInteraction checkingWhetherNews;
    public ViewInteraction buttonOkTimePublicationCreateNews;
    public ViewInteraction buttonCancelTimePublicationCreateNews;
    public ViewInteraction buttonKeyboardOnScreenTimePublicationCreateNews;
    public ViewInteraction titleTimeKeyboardOnScreenTimePublicationCreateNews;
    public ViewInteraction clockFieldTimeKeyboardOnScreenTimePublicationCreateNews;
    public ViewInteraction minuteFieldTimeKeyboardOnScreenTimePublicationCreateNews;
    public ViewInteraction buttonOkTimeKeyboardOnScreenPublicationCreateNews;
    public ViewInteraction buttonCancelTimeKeyboardOnScreenPublicationCreateNews;
    public ViewInteraction buttonClockForTransitionClockImageCreateNews;
    public ViewInteraction buttonOkConformationPopUpWindowCreateNews;
    public ViewInteraction buttonCancelConformationPopUpWindowCreateNews;


    //Редактирование новости
    public static ViewInteraction buttonNewsEditing;
    public ViewInteraction buttonCancelTimeKeyboardOnScreenPublicationNewsEditing;
    public ViewInteraction buttonClockForTransitionClockImageNewsEditing;
    public ViewInteraction descriptionNewsEditing;
    public static ViewInteraction switcherActiveNotActiveNews;
    public ViewInteraction buttonOkConformationPopUpWindowNewsEditing;
    public ViewInteraction buttonCancelConformationPopUpWindowNewsEditing;

    //Удаление новости
    public static ViewInteraction buttonDeleteNews;
    public ViewInteraction buttonOkConformationPopUpWindowDeleteNews;
    public ViewInteraction buttonCancelConformationPopUpWindowDeleteNews;

    //Блок новости
    public static int blockNews; //Блок одной новости
    public static ViewInteraction blockOneNews; // Блок одной новости для других нужд
    public static ViewInteraction titleBlockNews;  //То же и для блока новости для панели управления
    public static ViewInteraction iconNewsCategory; //То же и для блока новости для панели управления
    public static ViewInteraction buttonExpandNews; //развернуть описание ОДНОЙ новости(то же и для панели управления в блоке новости)
    public static ViewInteraction dateNewsPublication; //дата публикации на блоке новости на странице "Новости"
    public static int descriptionNewsBlockNews; //описание новости в блоке новости при ее разворачивании
    public static ViewInteraction descriptionNewsBlock;
    public static int newsListRecyclerView; //Прокрутить страницу с новостями


    //Блок новости панели управления
    public static ViewInteraction datePublicationNewsSectionNews; //дата публикации на блоке новости на странице "Панель управления"
    public static ViewInteraction dateCreateNewsSectionNews;
    public static int activeOrInactiveNewsSectionNews;

    //BurgerMenu
    public static ViewInteraction buttonBurgerMenu;
    public static ViewInteraction buttonNewsBurgerMenu;
    public static ViewInteraction buttonAboutTheAppBurgerMenu;
    public static ViewInteraction buttonMainBurgerMenu;


    //О приложении
    public static ViewInteraction titleAboutTheApp;
    public static ViewInteraction headerPrivacyPolicy;
    public static ViewInteraction linkPrivacyPolicy;
    public static ViewInteraction headerUserAgreement;
    public static ViewInteraction linkUserAgreement;
    public static ViewInteraction buttonBackAboutTheApp;

    //Цитаты
    public static ViewInteraction buttonQuotes;
    public static ViewInteraction titleQuotes;
    public static ViewInteraction quoteBlock;
    public static ViewInteraction quoteInBlockQuote;
    public static ViewInteraction buttonUnwrapRollUpQuotes;
    public static ViewInteraction descriptionQuoteBlock;

    //Кнока "Выйти"
    public static ViewInteraction buttonLogOut;
    public static ViewInteraction buttonExitPopUpWindow;

    public FieldIDs() {
        homeScreen = withId(R.id.splashscreen_image_view);
        titleAuthoriz = onView(allOf(withText("Authorization"), withParent(withParent(withId(R.id.nav_host_fragment)))));
        authorizLog = withId(R.id.login_text_input_layout);
        authorizPass = onView(withId(R.id.password_text_input_layout));
        authorizationButtonEnter = R.id.enter_button;
        enterButton = onView(withId(R.id.enter_button));
        mainTitle = onView(withId(R.id.trademark_image_view));
        gestureUpdate = onView(withId(R.id.main_swipe_refresh));
        newsButton = onView(withId(R.id.all_news_text_view)); //кнопка "Все новости"
        buttonCollapse = onView(withId(R.id.expand_material_button));
        newsBlock = R.id.all_news_cards_block_constraint_layout ;//блоки с новостями на странице "Новости"
        descriptionNewsBlockNews = R.id.news_item_description_text_view;
        descriptionNewsBlock = onView(withId(R.id.news_item_description_text_view));
        sortNewsButton = onView(withId(R.id.sort_news_material_button));
        filterNewsButton = onView(withId(R.id.filter_news_material_button));
        filterNewsButtonVizibility = R.id.filter_news_material_button;
        categoryNews = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
        dateLeftNews = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
        dateRightNews = onView(withId(R.id.news_item_publish_date_end_text_input_layout));
        buttonFilterNews = onView(withId(R.id.filter_button));
        buttonCancelNews = onView(withId(R.id.cancel_button));
        buttonControlPanel = onView(withId(R.id.edit_news_material_button));
        buttonControlPanelVizibility = R.id.edit_news_material_button;
        controlPanelContainer = onView(withId(R.id.container_custom_app_bar_include_on_fragment_news_control_panel));
        swipeToRefreshControlPanel = onView(withId(R.id.news_control_panel_swipe_to_refresh));
        titleFilterNews = onView(withId(R.id.filter_news_title_text_view));
        checkmarkActiveFilterNews = onView(withId(R.id.filter_news_active_material_check_box));
        checkmarkNotActiveFilterNews = onView(withId(R.id.filter_news_inactive_material_check_box));
        buttonCreateNews = onView(withId(R.id.add_news_image_view));
        headerFieldNews = onView(withId(R.id.news_item_title_text_input_edit_text));

        datePublicationNews = onView(withId(R.id.news_item_publish_date_text_input_edit_text));

        timePublicationNews = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
        descriptionNews = onView(withId(R.id.news_item_description_text_input_edit_text));
        buttonSaveNews = onView(withId(R.id.save_button));

        datePublicationNewsSectionNews = onView(withId(R.id.news_item_publication_date_text_view));

        dateCreateNewsSectionNews = onView(withId(R.id.news_item_create_date_text_view));
        activeOrInactiveNewsSectionNews = R.id.news_item_published_text_view;
        buttonDeleteNews = onView(withId(R.id.delete_news_item_image_view));
        buttonNewsEditing = onView(withId(R.id.edit_news_item_image_view));
        switcherActiveNotActiveNews = onView(withId(R.id.switcher));
        buttonBurgerMenu = onView(withId(R.id.main_menu_image_button));
        buttonMainBurgerMenu = onView(withId(R.id.menu_item_main));
        buttonNewsBurgerMenu = onView(withId(R.id.menu_item_news));
        buttonAboutTheAppBurgerMenu = onView(withId(R.id.menu_item_about));
        titleAboutTheApp = onView(withId(R.id.about_version_title_text_view));
        headerPrivacyPolicy = onView(withId(R.id.about_privacy_policy_label_text_view));
        linkPrivacyPolicy = onView(withId(R.id.about_privacy_policy_value_text_view));
        headerUserAgreement = onView(withId(R.id.about_terms_of_use_label_text_view));
        linkUserAgreement = onView(withId(R.id.about_terms_of_use_value_text_view));
        buttonBackAboutTheApp = onView(withId(R.id.about_back_image_button));
        buttonQuotes = onView(withId(R.id.our_mission_image_button));
        titleQuotes = onView(withId(R.id.our_mission_title_text_view));
        quoteBlock = onView(withId(R.id.our_mission_item_material_card_view));
        //“В хосписе не работают плохие люди” В.В. Миллионщикова
        quoteInBlockQuote = onView(withId(R.id.our_mission_item_title_text_view));
        buttonUnwrapRollUpQuotes = onView(withId(R.id.our_mission_item_open_card_image_button));
        //Все сотрудники хосписа - это адвокаты пациента, его прав и потребностей. Поиск путей решения различных задач -
        // это и есть хосписный индивидуальный подход к паллиативной помощи.
        descriptionQuoteBlock = onView(withId(R.id.our_mission_item_description_text_view));
        buttonLogOut = onView(withId(R.id.authorization_image_button));
        buttonExitPopUpWindow = onView(allOf(withId(android.R.id.title), withText("Выйти")));
        blockNews = R.id.news_item_material_card_view;
        blockOneNews = onView(withId(R.id.news_item_material_card_view));
        titleBlockNews = onView(withId(R.id.news_item_title_text_view));
        buttonExpandNews = onView(withIndex(withId(R.id.view_news_item_image_view),0));
        dateNewsPublication = onView(withId(R.id.news_item_date_text_view));
        newsListRecyclerView = R.id.news_list_recycler_view;
        iconNewsCategory = onView(withId(R.id.category_icon_image_view));
        buttonOkDate = onView(allOf(withId(android.R.id.button1), withText("ОК")));
        checkingWhetherNews = onView(withIndex(withId(R.id.news_item_description_text_view), 0))
                .check(matches(withText("Читайте, читайте и не говорите, что не читали!")));
    }
}
