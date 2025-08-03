package ru.iteco.fmhandroid.ui.data;

import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.view.View;

import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.espresso.util.TreeIterables;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeoutException;

public class DataHelper {
    private final String validLogin = "login2";
    private final String validPassword = "password2";
    private final String invalidLogin = "log";
    private final String invalidPassword = "pass";
    public static final String announcementCategory = "Объявление";
    public static final String birthdayCategory = "День рождения";
    public static final String salaryCategory = "Зарплата";
    public static final String tradeUnionCategory = "Профсоюз";
    public static final String holidayCategory = "Праздник";
    public static final String massageCategory = "Массаж";
    public static final String gratitudeCategory = "Благодарность";
    public static final String needHelpCategory = "Нужна помощь";

    public DataHelper() {

    }

    public String getValidLogin() {
        return validLogin;
    }

    public String getValidPassword() {
        return validPassword;
    }

    public String getInvalidLogin() {
        return invalidLogin;
    }

    public String getInvalidPassword() {
        return invalidPassword;
    }

    public static String getCurrentDate() {
        return new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(new Date());
    }

    public static String getCurrentTime() {
        return new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
    }

    //Если параметр положительный - будущая дата, если отрицательный - прошедшая дата
    public static String getDate(int days) {
        LocalDate date = null;
        if (days > 0) {
            date = LocalDate.now().plusDays(days); // Будущая дата
        } else if (days < 0){
            date = LocalDate.now().minusDays(-days); // Прошлая дата
        } else if (days == 0){
            date = LocalDate.parse(getCurrentDate());
        }
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

       private static final Random random = new Random();
        private static final List<String> categoryRandom = Arrays.asList(
                announcementCategory,
                birthdayCategory,
                salaryCategory,
                tradeUnionCategory,
                holidayCategory,
                massageCategory,
                gratitudeCategory,
                needHelpCategory
        );
        public static int categoryRandom(int... items) {
            return items[random.nextInt(items.length)];
        }
        public static String randomCategory() {
            return categoryRandom.get(random.nextInt(categoryRandom.size()));
    }





    /**
     * Perform action of waiting for a specific view id to be displayed.
     * @param viewId The id of the view to wait for.
     * @param millis The timeout of until when to wait for.
     */
    public static ViewAction waitDisplayed(final int viewId, final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "wait for a specific view with id <" + viewId + "> has been displayed during " + millis + " millis.";
            }

            @Override
            public void perform(final UiController uiController, final View view) {
                uiController.loopMainThreadUntilIdle();
                final long startTime = System.currentTimeMillis();
                final long endTime = startTime + millis;
                final Matcher<View> matchId = withId(viewId);
                final Matcher<View> matchDisplayed = isDisplayed();

                do {
                    for (View child : TreeIterables.breadthFirstViewTraversal(view)) {
                        if (matchId.matches(child) && matchDisplayed.matches(child)) {
                            return;
                        }
                    }

                    uiController.loopMainThreadForAtLeast(50);
                }
                while (System.currentTimeMillis() < endTime);

                // timeout happens
                throw new PerformException.Builder()
                        .withActionDescription(this.getDescription())
                        .withViewDescription(HumanReadables.describe(view))
                        .withCause(new TimeoutException())
                        .build();
            }
        };
    }

    public static Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
        return new TypeSafeMatcher<View>() {
            int currentIndex = 0;

            @Override
            public void describeTo(Description description) {
                description.appendText("with index: ");
                description.appendValue(index);
                matcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                return matcher.matches(view) && currentIndex++ == index;
            }
        };
    }
}
