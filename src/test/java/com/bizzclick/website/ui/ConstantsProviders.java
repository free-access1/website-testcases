package com.bizzclick.website.ui;

import org.testng.annotations.*;

public class ConstantsProviders implements Constants {

    @DataProvider
    public Object[][] nonLoggedHeaderItems() {
        return new Object[][]
                {
                        {LOGO_XPATH, BASE_URL},
                        {LOGIN_LINK_XPATH, BASE_URL+"login"},
                        {SIGNUP_LINK_XPATH, BASE_URL+"signup"}
                };
    }

    @DataProvider
    public Object[][] navigationToHeaderTabsData() {
        return new Object[][] {
            {EMAIL_VALUE_CORRECT_VALID, PASSWORD_VALUE_VALID, APPLICATIONS_TAB_XPATH,    BASE_URL+"apps/list"},
            {EMAIL_VALUE_CORRECT_VALID, PASSWORD_VALUE_VALID, AD_SPACES_TAB_XPATH,       BASE_URL+"ad-spaces/list"},
            {EMAIL_VALUE_CORRECT_VALID, PASSWORD_VALUE_VALID, OFFERWALLS_TAB_XPATH,      BASE_URL+"#"},
            {EMAIL_VALUE_CORRECT_VALID, PASSWORD_VALUE_VALID, CROSS_PROMOTION_TAB_XPATH, BASE_URL+"#"}
        };
    }

    @DataProvider
    public Object[][] navigationToUserMenuItemsData() {
        return new Object[][] {
            {EMAIL_VALUE_CORRECT_VALID, PASSWORD_VALUE_VALID, USER_MENU_ACCOUNT_XPATH,              BASE_URL+"account"},
            {EMAIL_VALUE_CORRECT_VALID, PASSWORD_VALUE_VALID, USER_MENU_CASHOUT_XPATH,              BASE_URL+"#"},
            {EMAIL_VALUE_CORRECT_VALID, PASSWORD_VALUE_VALID, USER_MENU_TRANSACTION_HISTORY_XPATH,  BASE_URL+"#"},
            {EMAIL_VALUE_CORRECT_VALID, PASSWORD_VALUE_VALID, USER_MENU_SUPPORT_XPATH,              BASE_URL+"#"},
            {EMAIL_VALUE_CORRECT_VALID, PASSWORD_VALUE_VALID, USER_MENU_LOGOUT_XPATH,               BASE_URL}
        };
    }

    @DataProvider
    public Object[][] footerItems() {
        return new Object[][] {
            {FOOTER_ABOUT_XPATH},
            {FOOTER_BLOG_XPATH},
            {FOOTER_TESTIMONIALS_XPATH},
            {FOOTER_CONTACT_XPATH},
            {FOOTER_RESOURCES_XPATH},
            {FOOTER_LEGAL_PRIVACY_XPATH}
        };
    }

    @DataProvider
    public Object[][] navigationToLoginPageItems() {
        return new Object[][]
                {
                        {SIGNUP_LINK_XPATH,          BASE_URL+"signup"},
                        {LOGO_XPATH,                 BASE_URL},
                        {FORGOT_PASSWORD_LINK_XPATH, BASE_URL+"forgot"}
                };
    }

    @DataProvider
    public Object[][] getIncorrectEmail() {
        return new Object[][] {
            {EMAIL_VALUE_INCORRECT1, PASSWORD_VALUE_VALID},
            {EMAIL_VALUE_INCORRECT2, PASSWORD_VALUE_VALID},
            {EMAIL_VALUE_INCORRECT3, PASSWORD_VALUE_VALID},
            {EMAIL_VALUE_INCORRECT4, PASSWORD_VALUE_VALID},
            {EMAIL_VALUE_INCORRECT5, PASSWORD_VALUE_VALID},
            {EMAIL_VALUE_INCORRECT6, PASSWORD_VALUE_VALID},
            {EMAIL_VALUE_INCORRECT7, PASSWORD_VALUE_VALID},
            {EMAIL_VALUE_INCORRECT8, PASSWORD_VALUE_VALID},
            {EMAIL_VALUE_INCORRECT9, PASSWORD_VALUE_VALID}
        };
    }

    @DataProvider
    public Object[][] getJustIncorrectEmail() {
        return new Object[][] {
                {EMAIL_VALUE_INCORRECT1},
                {EMAIL_VALUE_INCORRECT2},
                {EMAIL_VALUE_INCORRECT3},
                {EMAIL_VALUE_INCORRECT4},
                {EMAIL_VALUE_INCORRECT5},
                {EMAIL_VALUE_INCORRECT6},
                {EMAIL_VALUE_INCORRECT7},
                {EMAIL_VALUE_INCORRECT8},
                {EMAIL_VALUE_INCORRECT9}
        };
    }

    @DataProvider
    public Object[][] getDifferentPasswords() {
        return new Object[][] {
                {FORGOT_PASSWORD_OLD_PASSWORD_VALUE, RESET_PASSWORD__NEW_PASSWORD_VALUE}
        };
    }

    @DataProvider
    public Object[][] getIncorrectPasswords() {
        return new Object[][] {
                {"", ""},
                {PASSWORD_VALUE_INVALID, PASSWORD_VALUE_INVALID}
        };
    }

    @DataProvider
    public Object[][] getCorrectPasswords() {
        return new Object[][] {
                {RESET_PASSWORD__NEW_PASSWORD_VALUE, RESET_PASSWORD__NEW_PASSWORD_VALUE}
        };
    }

    @DataProvider
    public Object[][] incorrectValuesForSignUp() {
        return new Object[][]
                {
                        {"",         COMPANY_VALUE, EMAIL_VALUE_CORRECT_VALID, PASSWORD_VALUE_VALID,   PASSWORD_VALUE_VALID,           NAME_EMPTY_RED_ALERT_XPATH},
                        {NAME_VALUE, "",            EMAIL_VALUE_CORRECT_VALID, PASSWORD_VALUE_VALID,   PASSWORD_VALUE_VALID,           COMPANY_EMPTY_RED_ALERT_XPATH},
                        {NAME_VALUE, COMPANY_VALUE, EMAIL_VALUE_INCORRECT1,    PASSWORD_VALUE_VALID,   PASSWORD_VALUE_VALID,           EMAIL_IS_NOT_VALID_ALERT_XPATH},
                        {NAME_VALUE, COMPANY_VALUE, EMAIL_VALUE_INCORRECT2,    PASSWORD_VALUE_VALID,   PASSWORD_VALUE_VALID,           EMAIL_IS_NOT_VALID_ALERT_XPATH},
                        {NAME_VALUE, COMPANY_VALUE, EMAIL_VALUE_INCORRECT3,    PASSWORD_VALUE_VALID,   PASSWORD_VALUE_VALID,           EMAIL_IS_NOT_VALID_ALERT_XPATH},
                        {NAME_VALUE, COMPANY_VALUE, EMAIL_VALUE_INCORRECT4,    PASSWORD_VALUE_VALID,   PASSWORD_VALUE_VALID,           EMAIL_IS_NOT_VALID_ALERT_XPATH},
                        {NAME_VALUE, COMPANY_VALUE, EMAIL_VALUE_INCORRECT5,    PASSWORD_VALUE_VALID,   PASSWORD_VALUE_VALID,           EMAIL_IS_NOT_VALID_ALERT_XPATH},
                        {NAME_VALUE, COMPANY_VALUE, EMAIL_VALUE_INCORRECT6,    PASSWORD_VALUE_VALID,   PASSWORD_VALUE_VALID,           EMAIL_IS_NOT_VALID_ALERT_XPATH},
                        {NAME_VALUE, COMPANY_VALUE, EMAIL_VALUE_INCORRECT7,    PASSWORD_VALUE_VALID,   PASSWORD_VALUE_VALID,           EMAIL_IS_NOT_VALID_ALERT_XPATH},
                        {NAME_VALUE, COMPANY_VALUE, EMAIL_VALUE_INCORRECT8,    PASSWORD_VALUE_VALID,   PASSWORD_VALUE_VALID,           EMAIL_IS_NOT_VALID_ALERT_XPATH},
                        {NAME_VALUE, COMPANY_VALUE, EMAIL_VALUE_INCORRECT9,    PASSWORD_VALUE_VALID,   PASSWORD_VALUE_VALID,           EMAIL_IS_NOT_VALID_ALERT_XPATH},
                        {NAME_VALUE, COMPANY_VALUE, EMAIL_VALUE_CORRECT_VALID, PASSWORD_VALUE_INVALID, PASSWORD_VALUE_INVALID,         PASSWORD_LESS_6_CHARACTERS_ALERT_XPATH},
                        {NAME_VALUE, COMPANY_VALUE, EMAIL_VALUE_CORRECT_VALID, PASSWORD_VALUE_VALID,   PASSWORD_VALUE_VALID_DIFFERENT, PASSWORD_MISMATCH},
                        {"",         "",            EMAIL_VALUE_INCORRECT1,    PASSWORD_VALUE_INVALID, PASSWORD_VALUE_INVALID,         ALL_FIELDS_WRONG_RED_ALERT_XPATH},
                };
    }

    @DataProvider
    public Object[][] getURLsByApplicationsMenuItems() {
        return new Object[][] {
                {APLLICATIONS_MENU_DASHBOARD,           BASE_URL + EMPTY_APPLICATIONS_LIST_URL_TAIL + "#"},
                {APLLICATIONS_MENU_APPLICATIONS_LIST,   BASE_URL + EMPTY_APPLICATIONS_LIST_URL_TAIL},
                {APLLICATIONS_MENU_REPORTS,             BASE_URL + EMPTY_APPLICATIONS_LIST_URL_TAIL}
        };
    }

    @DataProvider
    public Object[][] getURLsByElementsOnEmptyApplicationsListPage() {
        return new Object[][] {
                {ADD_APPLICATION_BUTTON, BASE_URL + ADD_NEW_APPLICATION_URL_TAIL},
                {ADD_APPLICATION_LINK,   BASE_URL + ADD_NEW_APPLICATION_URL_TAIL}
        };
    }

    @DataProvider
    public Object[][] getURLsByElementsOnAddNewApplicationPage() {
        return new Object[][] {
                {BREAD_CRUMBS_LINK_XPATH, BASE_URL + EMPTY_APPLICATIONS_LIST_URL_TAIL},
                {BUTTON_CANCEL_XPATH,     BASE_URL + EMPTY_APPLICATIONS_LIST_URL_TAIL}
        };
    }

    @DataProvider
    public Object[][] getCorrectDataForAddingApplication() {
        return new Object[][] {
                {APPLICATION_TITLE_VALUE, PACKAGE_NAME_CORRECT_VALUE, APP_URL_CORRECT_VALUE, CHECKBOX_1ST_CATEGORY_ITEM_XPATH, PLATFORM_ANDROID_VALUE, AGE_LIMIT_0_VALUE,  true,  true,  CURRENCY_NAME_CORRECT_VALUE, EXCHANGE_RATE_CORRECT_VALUE1, true},
                {APPLICATION_TITLE_VALUE, PACKAGE_NAME_CORRECT_VALUE, APP_URL_CORRECT_VALUE, CHECKBOX_2ND_CATEGORY_ITEM_XPATH, PLATFORM_IOS_VALUE,     AGE_LIMIT_5_VALUE,  true,  true,  CURRENCY_NAME_CORRECT_VALUE, EXCHANGE_RATE_CORRECT_VALUE2, false},
                {APPLICATION_TITLE_VALUE, PACKAGE_NAME_CORRECT_VALUE, APP_URL_CORRECT_VALUE, CHECKBOX_LST_CATEGORY_ITEM_XPATH, PLATFORM_ANDROID_VALUE, AGE_LIMIT_10_VALUE, true,  false, CURRENCY_NAME_CORRECT_VALUE, EXCHANGE_RATE_CORRECT_VALUE1, true},
                {APPLICATION_TITLE_VALUE, PACKAGE_NAME_CORRECT_VALUE, APP_URL_CORRECT_VALUE, CHECKBOX_1ST_CATEGORY_ITEM_XPATH, PLATFORM_IOS_VALUE,     AGE_LIMIT_13_VALUE, true,  false, CURRENCY_NAME_CORRECT_VALUE, EXCHANGE_RATE_CORRECT_VALUE2, false},
                {APPLICATION_TITLE_VALUE, PACKAGE_NAME_CORRECT_VALUE, APP_URL_CORRECT_VALUE, CHECKBOX_2ND_CATEGORY_ITEM_XPATH, PLATFORM_ANDROID_VALUE, AGE_LIMIT_18_VALUE, false, true,  CURRENCY_NAME_CORRECT_VALUE, EXCHANGE_RATE_CORRECT_VALUE1, true},
                {APPLICATION_TITLE_VALUE, PACKAGE_NAME_CORRECT_VALUE, APP_URL_CORRECT_VALUE, CHECKBOX_LST_CATEGORY_ITEM_XPATH, PLATFORM_IOS_VALUE,     AGE_LIMIT_0_VALUE,  false, true,  CURRENCY_NAME_CORRECT_VALUE, EXCHANGE_RATE_CORRECT_VALUE2, false},
                {APPLICATION_TITLE_VALUE, PACKAGE_NAME_CORRECT_VALUE, APP_URL_CORRECT_VALUE, CHECKBOX_1ST_CATEGORY_ITEM_XPATH, PLATFORM_ANDROID_VALUE, AGE_LIMIT_5_VALUE,  false, false, CURRENCY_NAME_CORRECT_VALUE, EXCHANGE_RATE_CORRECT_VALUE1, true},
                {APPLICATION_TITLE_VALUE, PACKAGE_NAME_CORRECT_VALUE, APP_URL_CORRECT_VALUE, CHECKBOX_2ND_CATEGORY_ITEM_XPATH, PLATFORM_IOS_VALUE,     AGE_LIMIT_10_VALUE, false, false, CURRENCY_NAME_CORRECT_VALUE, EXCHANGE_RATE_CORRECT_VALUE2, false},
                {APPLICATION_TITLE_VALUE, PACKAGE_NAME_CORRECT_VALUE, APP_URL_EMPTY_VALUE,   CHECKBOX_LST_CATEGORY_ITEM_XPATH, PLATFORM_ANDROID_VALUE, AGE_LIMIT_13_VALUE, true,  true,  CURRENCY_NAME_CORRECT_VALUE, EXCHANGE_RATE_CORRECT_VALUE2, true},
                {APPLICATION_TITLE_VALUE, PACKAGE_NAME_CORRECT_VALUE, APP_URL_EMPTY_VALUE,   CHECKBOX_1ST_CATEGORY_ITEM_XPATH, PLATFORM_IOS_VALUE,     AGE_LIMIT_18_VALUE, true,  true,  CURRENCY_NAME_CORRECT_VALUE, EXCHANGE_RATE_CORRECT_VALUE1, false},
                {APPLICATION_TITLE_VALUE, PACKAGE_NAME_CORRECT_VALUE, APP_URL_EMPTY_VALUE,   CHECKBOX_2ND_CATEGORY_ITEM_XPATH, PLATFORM_ANDROID_VALUE, AGE_LIMIT_0_VALUE,  true,  false, CURRENCY_NAME_CORRECT_VALUE, EXCHANGE_RATE_CORRECT_VALUE2, true},
                {APPLICATION_TITLE_VALUE, PACKAGE_NAME_CORRECT_VALUE, APP_URL_EMPTY_VALUE,   CHECKBOX_LST_CATEGORY_ITEM_XPATH, PLATFORM_IOS_VALUE,     AGE_LIMIT_5_VALUE,  true,  false, CURRENCY_NAME_CORRECT_VALUE, EXCHANGE_RATE_CORRECT_VALUE1, false},
                {APPLICATION_TITLE_VALUE, PACKAGE_NAME_CORRECT_VALUE, APP_URL_EMPTY_VALUE,   CHECKBOX_1ST_CATEGORY_ITEM_XPATH, PLATFORM_ANDROID_VALUE, AGE_LIMIT_10_VALUE, false, true,  CURRENCY_NAME_CORRECT_VALUE, EXCHANGE_RATE_CORRECT_VALUE2, true},
                {APPLICATION_TITLE_VALUE, PACKAGE_NAME_CORRECT_VALUE, APP_URL_EMPTY_VALUE,   CHECKBOX_2ND_CATEGORY_ITEM_XPATH, PLATFORM_IOS_VALUE,     AGE_LIMIT_13_VALUE, false, true,  CURRENCY_NAME_CORRECT_VALUE, EXCHANGE_RATE_CORRECT_VALUE1, false},
                {APPLICATION_TITLE_VALUE, PACKAGE_NAME_CORRECT_VALUE, APP_URL_EMPTY_VALUE,   CHECKBOX_LST_CATEGORY_ITEM_XPATH, PLATFORM_ANDROID_VALUE, AGE_LIMIT_18_VALUE, false, false, CURRENCY_NAME_CORRECT_VALUE, EXCHANGE_RATE_CORRECT_VALUE2, true},
                {APPLICATION_TITLE_VALUE, PACKAGE_NAME_CORRECT_VALUE, APP_URL_EMPTY_VALUE,   CHECKBOX_1ST_CATEGORY_ITEM_XPATH, PLATFORM_IOS_VALUE,     AGE_LIMIT_0_VALUE,  false, false, CURRENCY_NAME_CORRECT_VALUE, EXCHANGE_RATE_CORRECT_VALUE1, false}
        };
    }

    @DataProvider
    public Object[][] getIncorrectDataForAddingApplication() {
        return new Object[][] {
                {APPLICATION_TITLE_EMPTY_VALUE, PACKAGE_NAME_CORRECT_VALUE,   APP_URL_CORRECT_VALUE,   CHECKBOX_1ST_CATEGORY_ITEM_XPATH,   PLATFORM_ANDROID_VALUE, AGE_LIMIT_0_VALUE,  true, true, CURRENCY_NAME_CORRECT_VALUE, EXCHANGE_RATE_CORRECT_VALUE1,          true, APPLICATION_TITLE_IS_BLANK_RED_ALERT_XPATH},
                {APPLICATION_TITLE_VALUE,       PACKAGE_NAME_BLANK_VALUE,     APP_URL_CORRECT_VALUE,   CHECKBOX_2ND_CATEGORY_ITEM_XPATH,   PLATFORM_IOS_VALUE,     AGE_LIMIT_5_VALUE,  true, true, CURRENCY_NAME_CORRECT_VALUE, EXCHANGE_RATE_CORRECT_VALUE1,          true, PACKAGE_NAME_IS_BLANK_RED_ALERT_XPATH},
                {APPLICATION_TITLE_VALUE,       PACKAGE_NAME_INCORRECT_VALUE, APP_URL_CORRECT_VALUE,   CHECKBOX_2ND_CATEGORY_ITEM_XPATH,   PLATFORM_IOS_VALUE,     AGE_LIMIT_5_VALUE,  true, true, CURRENCY_NAME_CORRECT_VALUE, EXCHANGE_RATE_CORRECT_VALUE1,          true, ""},
                {APPLICATION_TITLE_VALUE,       PACKAGE_NAME_CORRECT_VALUE,   APP_URL_INCORRECT_VALUE, CHECKBOX_LST_CATEGORY_ITEM_XPATH,   PLATFORM_ANDROID_VALUE, AGE_LIMIT_10_VALUE, true, true, CURRENCY_NAME_CORRECT_VALUE, EXCHANGE_RATE_CORRECT_VALUE1,          true, ""},
                {APPLICATION_TITLE_VALUE,       PACKAGE_NAME_CORRECT_VALUE,   APP_URL_CORRECT_VALUE,   MULTI_SELECT_CATEGORY_ALL_XPATH,    PLATFORM_IOS_VALUE,     AGE_LIMIT_13_VALUE, true, true, CURRENCY_NAME_CORRECT_VALUE, EXCHANGE_RATE_CORRECT_VALUE1,          true, ""},
                {APPLICATION_TITLE_VALUE,       PACKAGE_NAME_CORRECT_VALUE,   APP_URL_CORRECT_VALUE,   MULTI_SELECT_CATEGORY_BUTTON_XPATH, PLATFORM_IOS_VALUE,     AGE_LIMIT_13_VALUE, true, true, CURRENCY_NAME_CORRECT_VALUE, EXCHANGE_RATE_CORRECT_VALUE1,          true, CATEGORY_IS_BLANK_RED_ALERT_XPATH},
                {APPLICATION_TITLE_VALUE,       PACKAGE_NAME_CORRECT_VALUE,   APP_URL_CORRECT_VALUE,   CHECKBOX_2ND_CATEGORY_ITEM_XPATH,   PLATFORM_ANDROID_VALUE, AGE_LIMIT_18_VALUE, true, true, CURRENCY_NAME_EMPTY_VALUE,   EXCHANGE_RATE_CORRECT_VALUE1,          true, PLATFORM_IS_BLANK_RED_ALERT_XPATH},
                {APPLICATION_TITLE_VALUE,       PACKAGE_NAME_CORRECT_VALUE,   APP_URL_CORRECT_VALUE,   CHECKBOX_LST_CATEGORY_ITEM_XPATH,   PLATFORM_IOS_VALUE,     AGE_LIMIT_0_VALUE,  true, true, CURRENCY_NAME_CORRECT_VALUE, EXCHANGE_RATE_INCORRECT_TEXT_VALUE,    true, ""},
                {APPLICATION_TITLE_VALUE,       PACKAGE_NAME_CORRECT_VALUE,   APP_URL_CORRECT_VALUE,   CHECKBOX_LST_CATEGORY_ITEM_XPATH,   PLATFORM_ANDROID_VALUE, AGE_LIMIT_5_VALUE,  true, true, CURRENCY_NAME_CORRECT_VALUE, EXCHANGE_RATE_INCORRECT_NUMBER_VALUE1, true, ""},
                {APPLICATION_TITLE_VALUE,       PACKAGE_NAME_CORRECT_VALUE,   APP_URL_CORRECT_VALUE,   CHECKBOX_LST_CATEGORY_ITEM_XPATH,   PLATFORM_IOS_VALUE,     AGE_LIMIT_10_VALUE, true, true, CURRENCY_NAME_CORRECT_VALUE, EXCHANGE_RATE_INCORRECT_NUMBER_VALUE2, true, ""},
                {APPLICATION_TITLE_VALUE,       PACKAGE_NAME_CORRECT_VALUE,   APP_URL_CORRECT_VALUE,   CHECKBOX_1ST_CATEGORY_ITEM_XPATH,   PLATFORM_ANDROID_VALUE, AGE_LIMIT_13_VALUE, true, true, CURRENCY_NAME_CORRECT_VALUE, EXCHANGE_RATE_EMPTY_VALUE,             true, ""}
        };
    }

    @DataProvider
    public Object[][] getURLsByElementsOnFilledApplicationListPage() {
        return new Object[][] {
                {ADD_APPLICATION_BUTTON,            BASE_URL + ADD_NEW_APPLICATION_URL_TAIL},
                {APPLICATION_SETTINGS_BUTTON_XPATH, BASE_URL + EMPTY_APPLICATIONS_LIST_URL_TAIL}
        };
    }
}