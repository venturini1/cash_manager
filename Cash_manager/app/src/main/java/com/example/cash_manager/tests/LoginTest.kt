//package com.example.cash_manager.tests
//import org.junit.Rule
//import org.junit.Test
//import androidx.compose.ui.test.junit4.createComposeRule
//import androidx.navigation.compose.rememberNavController
//import com.example.cash_manager.LoginPage
//
//class LoginPageTest {
//
//    @get:Rule
//    val composeTestRule = createComposeRule()
//
//    private fun launchLoginPage() {
//        composeTestRule.setContent {
//          //  val navController = rememberNavController()
//            LoginPage(navController = navController)
//        }
//    }
//
//    @Test
//    fun loginPage_HasLoginText() {
//        launchLoginPage()
//        composeTestRule.onNodeWithText("Login").assertExists()
//    }
//
//    @Test
//    fun loginPage_HasUserNameEmailField() {
//        launchLoginPage()
//        composeTestRule.onNodeWithText("Enter your user name or your email").assertExists()
//    }
//
//    @Test
//    fun loginPage_HasPasswordField() {
//        launchLoginPage()
//        composeTestRule.onNodeWithText("Enter your password").assertExists()
//    }
//
//    @Test
//    fun loginPage_HasForgetText() {
//        launchLoginPage()
//        composeTestRule.onNodeWithText("Forget Password").assertExists()
//    }
//
//    @Test
//    fun loginPage_HasLoginButton() {
//        // This assumes the button itself contains the text 'Login'
//        launchLoginPage()
//        composeTestRule.onNodeWithText("Login").assertExists()
//    }
