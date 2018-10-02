package com.example.login

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.runner.AndroidJUnit4
import android.test.ActivityInstrumentationTestCase2
import android.util.Log
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern.matches
import com.example.chris.kotlinapp.activities.MainActivity
import com.example.login.activities.LoginActivity


@RunWith(AndroidJUnit4::class)
class LoginActivityTest : ActivityInstrumentationTestCase2<LoginActivity> {

    private val username_tobe_typed="prueba@prueba.com"
    private val correct_password ="Prueba123"
    private val wrong_password = "passme123"

    

    @Test
    fun login_success(){
        Log.e("@Test","Performing login success test")
        Espresso.onView((withId(R.id.usernameEditText)))
                .perform(ViewActions.typeText(username_tobe_typed))

        Espresso.onView(withId(R.id.passwordEditText))
                .perform(ViewActions.typeText(correct_password))

        Espresso.onView(withId(R.id.loginButton))
                .perform(ViewActions.click())

        /*Espresso.onView(withId(R.id.login_result))
                .check(matches(withText(R.string.login_success)))*/


    }

    @Test
    fun login_failure(){
        Log.e("@Test","Performing login failure test")
        Espresso.onView((withId(R.id.usernameEditText)))
                .perform(ViewActions.typeText(username_tobe_typed))

        Espresso.onView(withId(R.id.passwordEditText))
                .perform(ViewActions.typeText(wrong_password))

        Espresso.onView(withId(R.id.loginButton))
                .perform(ViewActions.click())

        /*Espresso.onView(withId(R.id.login_result))
                .check(matches(withText(R.string.login_failed)))*/

    }

    @After
    fun after_test_method() {
        Log.e("@After", "Hi this is run after every test function")
    }

}