package test.testespresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import test.testespresso.ui.activities.Main;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainTest
{
    public static final String STRING_TO_BE_TYPED = "Espresso";

    @Rule
    public ActivityTestRule<Main> mActivityRule = new ActivityTestRule<>(Main.class);

    @Test
    public void changeText_sameActivity()
    {
        onView(withId(R.id.main_test_edit))
                .perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard());
        onView(withId(R.id.main_test_button))
                .perform(click());
        onView(withId(R.id.main_test_text))
                .check(matches(withText(STRING_TO_BE_TYPED)));
    }

//    @Test
//    public void changeText_newActivity()
//    {
//        // Type text and then press the button.
//        onView(withId(R.id.editTextUserInput)).perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard());
//        onView(withId(R.id.activityChangeTextBtn)).perform(click());
//
//        // This view is in a different Activity, no need to tell Espresso.
//        onView(withId(R.id.show_text_view)).check(matches(withText(STRING_TO_BE_TYPED)));
//    }
}