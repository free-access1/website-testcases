package com.bizzclick.website.ui.Signup;


import com.bizzclick.website.ui.TestSuite;

public class DeletingAccountWithoutConfirmationTest {

    // функционал не сделан, проверять пока нечего
    // логика такая:
    // 1. SignUp without confirmation
    // 2. Change tokenExpires field to -24 hours -(deleting period)
    // 3. Login after deleting period
    // 4. Must have: NO User Alert
}
