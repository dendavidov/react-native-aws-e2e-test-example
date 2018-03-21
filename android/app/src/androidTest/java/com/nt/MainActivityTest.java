package com.nt;

import android.support.test.runner.AndroidJUnit4;
import com.microsoft.appcenter.espresso.Factory;
import com.microsoft.appcenter.espresso.ReportHelper;

import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;

import com.nt.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.After;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ReportHelper reportHelper = Factory.getReportHelper();

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction reactEditText = onView(
                allOf(withContentDescription("text"),
                        childAtPosition(
                                allOf(withContentDescription("testview"),
                                        childAtPosition(
                                                withClassName(is("com.facebook.react.ReactRootView")),
                                                0)),
                                0),
                        isDisplayed()));
        reactEditText.perform(replaceText("1"), closeSoftKeyboard());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction reactEditText2 = onView(
                allOf(withText("1"), withContentDescription("text"),
                        childAtPosition(
                                allOf(withContentDescription("testview"),
                                        childAtPosition(
                                                withClassName(is("com.facebook.react.ReactRootView")),
                                                0)),
                                0),
                        isDisplayed()));
        reactEditText2.perform(click());

        ViewInteraction reactEditText3 = onView(
                allOf(withText("1"), withContentDescription("text"),
                        childAtPosition(
                                allOf(withContentDescription("testview"),
                                        childAtPosition(
                                                withClassName(is("com.facebook.react.ReactRootView")),
                                                0)),
                                0),
                        isDisplayed()));
        reactEditText3.perform(click());

        ViewInteraction reactEditText4 = onView(
                allOf(withText("1"), withContentDescription("text"),
                        childAtPosition(
                                allOf(withContentDescription("testview"),
                                        childAtPosition(
                                                withClassName(is("com.facebook.react.ReactRootView")),
                                                0)),
                                0),
                        isDisplayed()));
        reactEditText4.perform(replaceText(""));

        ViewInteraction reactEditText5 = onView(
                allOf(withContentDescription("text"),
                        childAtPosition(
                                allOf(withContentDescription("testview"),
                                        childAtPosition(
                                                withClassName(is("com.facebook.react.ReactRootView")),
                                                0)),
                                0),
                        isDisplayed()));
        reactEditText5.perform(closeSoftKeyboard());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction reactEditText6 = onView(
                allOf(withContentDescription("text"),
                        childAtPosition(
                                allOf(withContentDescription("testview"),
                                        childAtPosition(
                                                withClassName(is("com.facebook.react.ReactRootView")),
                                                0)),
                                0),
                        isDisplayed()));
        reactEditText6.perform(replaceText("2"), closeSoftKeyboard());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction reactEditText7 = onView(
                allOf(withText("2"), withContentDescription("text"),
                        childAtPosition(
                                allOf(withContentDescription("testview"),
                                        childAtPosition(
                                                withClassName(is("com.facebook.react.ReactRootView")),
                                                0)),
                                0),
                        isDisplayed()));
        reactEditText7.perform(replaceText("2"));

        ViewInteraction reactEditText8 = onView(
                allOf(withText("2"), withContentDescription("text"),
                        childAtPosition(
                                allOf(withContentDescription("testview"),
                                        childAtPosition(
                                                withClassName(is("com.facebook.react.ReactRootView")),
                                                0)),
                                0),
                        isDisplayed()));
        reactEditText8.perform(closeSoftKeyboard());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//
//        ViewInteraction textView = onView(
//                allOf(withText("Ervin Howell"), withContentDescription("name"),
//                        childAtPosition(
//                                allOf(withContentDescription("testview"),
//                                        childAtPosition(
//                                                IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
//                                                0)),
//                                3),
//                        isDisplayed()));
//        textView.check(matches(withText("Ervin Howell")));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

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

    @After
    public void TearDown(){
        reportHelper.label("Stopping App");
    }
}
