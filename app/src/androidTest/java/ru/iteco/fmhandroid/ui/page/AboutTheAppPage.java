package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutTheAppPage {
    public static int aboutAppBlock = R.id.container_custom_app_bar_include_on_fragment_about;
    public static ViewInteraction titleAboutTheApp = onView(withId(R.id.about_version_title_text_view));
    public static ViewInteraction linkPrivacyPolicy = onView(withId(R.id.about_privacy_policy_value_text_view));
    public static ViewInteraction linkUserAgreement = onView(withId(R.id.about_terms_of_use_value_text_view));
    public static ViewInteraction buttonBackAboutTheApp = onView(withId(R.id.about_back_image_button));
}
