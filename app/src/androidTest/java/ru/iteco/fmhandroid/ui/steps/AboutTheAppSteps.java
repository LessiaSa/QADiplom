package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.FieldIDs;

public class AboutTheAppSteps {
    public void linkPrivacyPolicyOnAboutTheApp() {
        Allure.step("Ссылка на страницу о политике конфиденциальности");
        FieldIDs.linkPrivacyPolicy.perform(click());
    }
    public void linkUserAgreementOnAboutTheApp() {
        Allure.step("Ссылка на страницу с пользовательским соглашением");
        FieldIDs.linkUserAgreement.perform(click());
    }
    public void buttonToReturnPreviousPage() {
        Allure.step("Кнопка возвращения на предыдущую страницу со страницы 'О приложении'");
        FieldIDs.buttonBackAboutTheApp.perform(click());
    }
}
