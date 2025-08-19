package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.page.AboutTheAppPage;

public class AboutTheAppSteps {
    AboutTheAppPage aboutTheAppPage = new AboutTheAppPage();

    public void linkPrivacyPolicyOnAboutTheApp() {
        Allure.step("Ссылка на страницу о политике конфиденциальности");
        aboutTheAppPage.linkPrivacyPolicy.check(matches(isDisplayed())).perform(click());
    }


    public void linkUserAgreementOnAboutTheApp() {
        Allure.step("Ссылка на страницу с пользовательским соглашением");
        aboutTheAppPage.linkUserAgreement.check(matches(isDisplayed())).perform(click());
    }

    public void buttonToReturnPreviousPage() {
        Allure.step("Кнопка возвращения на предыдущую страницу со страницы 'О приложении'");
        aboutTheAppPage.buttonBackAboutTheApp.check(matches(isDisplayed())).perform(click());
    }

    public void vizibilityAboutTheAppPage() {
        Allure.step("Видимость страницы 'О приложении'");
        onView(isRoot()).perform(waitDisplayed(aboutTheAppPage.aboutAppBlock, 5000));
    }
}
