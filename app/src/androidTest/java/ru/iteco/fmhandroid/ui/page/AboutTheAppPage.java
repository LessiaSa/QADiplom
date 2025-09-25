package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class
AboutTheAppPage {
    public static int aboutAppBlock = R.id.container_custom_app_bar_include_on_fragment_about;
    public static ViewInteraction titleAboutTheApp = onView(withId(R.id.about_version_title_text_view));
    public static ViewInteraction buttonBackAboutTheApp = onView(withId(R.id.about_back_image_button));


}
