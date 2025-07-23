package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.ui.data.DataHelper.elementWaiting;
import static ru.iteco.fmhandroid.ui.data.FieldIDs.buttonExitPopUpWindow;
import static ru.iteco.fmhandroid.ui.data.FieldIDs.buttonLogOut;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.data.FieldIDs;

public class MainSteps {
    FieldIDs fieldIDs = new FieldIDs();
    static DataHelper dataHelper = new DataHelper();


    public void loadingTheMainPage() {
        Allure.step("Загрузка главной страницы приложения");
        fieldIDs.mainTitle.check(matches(isDisplayed()));
    }

    public void checkVisibilityOfTheNewsBlock() {
        Allure.step("Проверка видимости блока 'Новости'");
        dataHelper.elementWaiting(fieldIDs.newsBlock, 5000);
    }
    public void allNewsButtonOnTheAppsHomePage() {
        Allure.step("кнопка 'Все новости' на главной странице приложения");
        FieldIDs.newsButton.perform(click());
    }
    public void buttonBurgerMenuOfTheMainPage() {
        Allure.step("Кнопка BurgerMenu на главной странице");
        FieldIDs.buttonBurgerMenu.perform(click());
    }
    public void buttonQuotesOfTheMainPage() {
        Allure.step("Кнопка для перехода на страницу с цитатами");
        FieldIDs.buttonQuotes.perform(click());
    }
    public void buttonBurgerMenuToGoNewsPage() {
        Allure.step("Кнопка BurgerMenu для перехода на страницу с новостями");
        FieldIDs.buttonNewsBurgerMenu.perform(click());
    }
    public void buttonBurgerMenuToGoAboutTheApp() {
        Allure.step("Кнопка BurgerMenu для перехода на страницу 'О приложении'");
        FieldIDs.buttonAboutTheAppBurgerMenu.perform(click());
    }
    public void buttonBurgerMenuToGoMainPage() {
        Allure.step("Кнопка BurgerMenu для перехода на главную страницу приложения");
        FieldIDs.buttonMainBurgerMenu.perform(click());
    }
    public void buttonLogOutProfile() {
        Allure.step("Кнопка с абстрактным изображением человека для выхода из профиля");
        elementWaiting(buttonLogOut, 5000);
        buttonLogOut.matches(click());
    }
    public void logOutPopUpOfTheProfile() {
        Allure.step("Всплывающая кнопка 'Выйти'");
        buttonExitPopUpWindow.matches(click());
    }
    public void swipeRefreshMainPage() {
        Allure.step("Свайп 'Обновить' на главной странице приложения");
        FieldIDs.gestureUpdate.perform(click());
    }
}