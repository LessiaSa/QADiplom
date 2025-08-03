package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.data.FieldIDs;

public class MainSteps {
    FieldIDs fieldIDs = new FieldIDs();
    static DataHelper dataHelper = new DataHelper();


    public void loadingTheMainPage() {
        Allure.step("Загрузка главной страницы приложения");
        onView(isRoot()).perform(waitDisplayed(R.id.authorization_image_button, 5000));
    }

    public void allNewsButtonOnTheAppsHomePage() {
        Allure.step("кнопка 'Все новости' на главной странице приложения");
        FieldIDs.newsButton.perform(click());
    }
    public void buttonBurgerMenuOfTheMainPage() {
        Allure.step("Кнопка BurgerMenu на главной странице");
        FieldIDs.buttonBurgerMenu.check(matches(isDisplayed())).perform(click());
    }
    public void buttonQuotesOfTheMainPage() {
        Allure.step("Кнопка для перехода на страницу с цитатами");
        FieldIDs.buttonQuotes.check(matches(isDisplayed())).perform(click());
    }
    public void buttonBurgerMenuToGoNewsPage() {
        Allure.step("Кнопка BurgerMenu для перехода на страницу с новостями");
        FieldIDs.buttonNewsBurgerMenu.check(matches(isDisplayed())).perform(click());
    }
    public void buttonBurgerMenuToGoAboutTheApp() {
        Allure.step("Кнопка BurgerMenu для перехода на страницу 'О приложении'");
        FieldIDs.buttonAboutTheAppBurgerMenu.check(matches(isDisplayed())).perform(click());
    }
    public void buttonBurgerMenuToGoMainPage() {
        Allure.step("Кнопка BurgerMenu для перехода на главную страницу приложения");
        FieldIDs.buttonMainBurgerMenu.check(matches(isDisplayed())).perform(click());
    }
    public void buttonLogOutProfile() {
        Allure.step("Кнопка с абстрактным изображением человека для выхода из профиля");
        onView(isRoot()).perform(waitDisplayed(R.id.authorization_image_button, 5000));
        fieldIDs.buttonLogOut.perform(click());
    }
    public void logOutPopUpOfTheProfile() {
        Allure.step("Всплывающая кнопка 'Выйти'");
        fieldIDs.buttonExitPopUpWindow.perform(click());
    }
    public void swipeRefreshMainPage() {
        Allure.step("Свайп 'Обновить' на главной странице приложения");
        FieldIDs.gestureUpdate.perform(click());
    }
}
