package ru.iteco.fmhandroid.ui.data;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.espresso.util.TreeIterables;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeoutException;
import io.qameta.allure.kotlin.Allure;


public class DataHelper {
    private final String validLogin;
    private final String validPassword;
    private final String invalidLogin = "log";
    private final String invalidPassword = "pass";

    public DataHelper() {
        validLogin = "login2";
        validPassword = "password2";
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

    public User getValidUser() {

        return new User(getValidLogin(), getValidPassword());
    }

    public User getInvalidUser() {
        return new User(getInvalidLogin(), getInvalidPassword());
    }


    public class User {
        private final String login;
        private final String password;

        public User(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public String getLogin() {
            return login;
        }
        public String getPassword() {
            return password;
        }

        public String getInvalidLogin() {
            return invalidLogin;
        }
        public String getInvalidPassword() {
            return invalidPassword;
        }
    }

    public static String getCurrentDate() {
        return new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(new Date());
    }

    public static String getCurrentTime() {
        return new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
    }

    //Если параметр положительный - будущая дата, если отрицательный - прошедшая дата
    public static String getDate(int days) {
        LocalDate date;
        if (days >= 0) {
            date = LocalDate.now().plusDays(days); // Будущая дата
        } else {
            date = LocalDate.now().minusDays(-days); // Прошлая дата
        }
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static void pauseExecution(long millis) {
        Allure.step("Ожидание " + millis / 6000 + " сек");
        SystemClock.sleep(millis);
    }

    public static class RandomCategory {
        final Random rand = new Random();

        public String randomCategory() {
            String[] category = {
                    "Объявление",
                    "День рождения",
                    "Зарплата",
                    "Профсоюз",
                    "Праздник",
                    "Массаж",
                    "Благодарность",
                    "Нужна помощь",
            };
            return category[rand.nextInt(category.length)];
        }
    }

    //Для видимости текста в текстовом поле
    // В тесте надо взывать следующим образом:
    //TextHelpers.getText(Espresso.onView(withId(R.id.element)));

        public String getText(ViewInteraction matcher) {
            final String[] text = new String[1];
            ViewAction viewAction = new ViewAction() {
                @Override
                public Matcher<View> getConstraints() {
                    return isAssignableFrom(TextView.class);
                }

                @Override
                public String getDescription() {
                    return "Text of the view";
                }

                @Override
                public void perform(UiController uiController, View view) {
                    TextView textView = (TextView) view;
                    text[0] = textView.getText().toString();
                }
            };
            matcher.perform(viewAction);

            return text[0];
        }


    //Ждем элемент
    public static Matcher<View> elementWaiting(final Matcher<View> matcher, int millis) {
        onView(isRoot()).perform(waitForElement(matcher, millis));
        return matcher;
    }
    public static ViewAction waitForElement(final Matcher<View> matcher, final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "wait for a specific view with attribute <" + matcher + "> during " + millis + " millis.";
            }

            @Override
            public void perform(final UiController uiController, final View view) {
                uiController.loopMainThreadUntilIdle();
                final long startTime = System.currentTimeMillis();
                final long endTime = startTime + millis;
                final Matcher<View> viewMatcher = matcher;

                do {
                    for (View child : TreeIterables.breadthFirstViewTraversal(view)) {
                        try {
                            if (viewMatcher.matches(child)) {
                                return;
                            }
                        } catch (NoMatchingViewException ignored) {
                        }

                        uiController.loopMainThreadForAtLeast(5000);
                    }

                }
                while (System.currentTimeMillis() < endTime);

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


    public static Matcher<View> childAtPosition(final Matcher<View> parentMatcher, final int position) {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}