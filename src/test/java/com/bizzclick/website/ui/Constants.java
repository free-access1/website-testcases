package com.bizzclick.website.ui;

public interface Constants {
    // CONSTANTS FOR DB  ===============================================================================================
    String DB_CONNECTION_URL                        = "jdbc:mysql://192.168.88.36:3306/test?useSSL=false&serverTimezone=UTC";
    //String DB_CONNECTION_URL                        = "jdbc:mysql://217.77.220.74:3306/test?useSSL=false&serverTimezone=UTC";
    String DB_USER                                  = "root";
    String DB_PASSWORD                              = "zx1234";
    String DB_PUBLISHERS_TABLE_NAME_VALUE           = "PUBLISHERS";
    String DB_APPLICATIONS_TABLE_NAME_VALUE         = "APPLICATIONS";
    String DB_AD_SPACES_TABLE_NAME_VALUE            = "ADSPACES";
    String DB_AD_SPACES_STATS_TABLE_NAME_VALUE      = "ADSPACE_STATS";
    String[] DB_ALL_TABLES_NAMES = {DB_PUBLISHERS_TABLE_NAME_VALUE, DB_APPLICATIONS_TABLE_NAME_VALUE, DB_AD_SPACES_TABLE_NAME_VALUE, DB_AD_SPACES_STATS_TABLE_NAME_VALUE};
    String[] DB_APP_ADS_STAT_TABLES_NAMES = {DB_APPLICATIONS_TABLE_NAME_VALUE, DB_AD_SPACES_TABLE_NAME_VALUE, DB_AD_SPACES_STATS_TABLE_NAME_VALUE};

    // EMAIL ACCOUNT VALUES ============================================================================================
    String EMAIL_VALUE_CORRECT_VALID                = "in-log@mail.ua";
    String EMAIL_VALUE_CORRECT_INVALID              = "free@mail.ru";
    String EMAIL_VALUE_INCORRECT1                   = "freemail.ru";
    String EMAIL_VALUE_INCORRECT2                   = "free@mailru";
    String EMAIL_VALUE_INCORRECT3                   = ".fr@mail.ru";
    String EMAIL_VALUE_INCORRECT4                   = "@mail.ru";
    String EMAIL_VALUE_INCORRECT5                   = "free@";
    String EMAIL_VALUE_INCORRECT6                   = "free @ mail.ru";
    String EMAIL_VALUE_INCORRECT7                   = "@.";
    String EMAIL_VALUE_INCORRECT8                   = "";
    String EMAIL_VALUE_INCORRECT9                   = "<input type=\"text\">";
    String EMAIL_VALUE_FOR_CONFIRMATION             = "confirmed.account@mail.ru";
    String EMAIL_VALUE_WITHOUT_CONFIRMATION         = "un-confirmed-account@mail.ua";
    String FORGOT_PASSWORD_EMAIL_VALUE              = "forgot-password@mail.ua";
    String APPLICATIONS_TESTING_EMAIL_VALUE         = "applications-test@mail.ua";


    // PASSWORD VALUES  ================================================================================================
    String PASSWORD_VALUE_VALID                     = "123456";
    String PASSWORD_VALUE_VALID_FOR_DB              = "$2a$08$.P3piD0wMDy2qegh9sxTeuN9vqV7D.QItXPfTbgyx25oALBNu2NuK";
    String PASSWORD_VALUE_VALID_DIFFERENT           = "654321";
    String PASSWORD_VALUE_INVALID                   = "12345";


    // CONSTANTS FOR TEST SUITS  =======================================================================================
    String FF                                       = "ff";
    String IE                                       = "ie";
    String CHROME                                   = "chrome";
    String OPERA                                    = "opera";
    String SAFARI                                   = "safari";
    String BASE_URL                                 = "http://192.168.88.36:3000/";
    //String BASE_URL                                 = "http://217.77.220.74:65002/";


    //// HEADER STARTS =================================================================================================
    // NON-LOGGED MAIN PAGE
    String LOGO_XPATH                               = "//a[@class='navbar-brand']";
    String LOGIN_LINK_XPATH                         = "//ul[@class='nav navbar-nav navbar-right']/li[1]";
    String SIGNUP_LINK_XPATH                        = "//ul[@class='nav navbar-nav navbar-right']/li[2]";
    // alerts
    String CONFIRM_EMAIL_ALERT_XPATH                = "//div[@class='alert alert-info fade in']/div[contains(text(), 'Please confirm registration')]";
    String INCORRECT_TOKEN_ALERT_XPATH              = "//div[@class='alert alert-danger fade in']/div[contains(text(), 'Incorrect token')]";
    // LOGGED MAIN PAGE
    String APPLICATIONS_TAB_XPATH                   = "//ul[@class='nav navbar-nav']/li[1]";
    String AD_SPACES_TAB_XPATH                      = "//ul[@class='nav navbar-nav']/li[2]";
    String OFFERWALLS_TAB_XPATH                     = "//ul[@class='nav navbar-nav']/li[3]";
    String CROSS_PROMOTION_TAB_XPATH                = "//ul[@class='nav navbar-nav']/li[4]";
    String USER_MENU_XPATH                          = "//a[@class='dropdown-toggle']";
    String USER_MENU_ACCOUNT_XPATH                  = "//ul[@class='dropdown-menu']/li[1]/a";
    String USER_MENU_CASHOUT_XPATH                  = "//ul[@class='dropdown-menu']/li[3]/a";
    String USER_MENU_TRANSACTION_HISTORY_XPATH      = "//ul[@class='dropdown-menu']/li[5]/a";
    String USER_MENU_SUPPORT_XPATH                  = "//ul[@class='dropdown-menu']/li[7]/a";
    String USER_MENU_LOGOUT_XPATH                   = "//ul[@class='dropdown-menu']/li[9]/a";
    //// HEADER ENDS   =================================================================================================


    // LOGGED MAIN PAGE ================================================================================================
    String LOGIN_SUCCESS_GREEN_ALERT_XPATH          = "//div[@class='alert alert-success fade in']/div[contains(text(), 'Success! You are logged in.')]";


    // FOOTER  =========================================================================================================
    String FOOTER_ABOUT_XPATH                       = "//ul[@class='list-inline']/li[1]/a";
    String FOOTER_BLOG_XPATH                        = "//ul[@class='list-inline']/li[2]/a";
    String FOOTER_TESTIMONIALS_XPATH                = "//ul[@class='list-inline']/li[3]/a";
    String FOOTER_CONTACT_XPATH                     = "//ul[@class='list-inline']/li[4]/a";
    String FOOTER_RESOURCES_XPATH                   = "//ul[@class='list-inline']/li[5]/a";
    String FOOTER_LEGAL_PRIVACY_XPATH               = "//ul[@class='list-inline']/li[6]/a";


    // LOGIN PAGE  =====================================================================================================
    String EMAIL_ID                                 = "email";
    String PASSWORD_ID                              = "password";
    String LOGIN_BUTTON_XPATH                       = "//button[@type='submit']";
    String FORGOT_PASSWORD_LINK_XPATH               = "//a[@class='btn btn-link']";
    // alerts
    String NO_USER_FOUND_ALERT_XPATH                = "//div[@class='alert alert-danger fade in']/div[contains(text(), 'not found')]";
    String WRONG_PASSWORD_ALERT_XPATH               = "//div[@class='alert alert-danger fade in']/div[contains(text(), 'Wrong password')]";
    String EMAIL_IS_NOT_VALID_ALERT_XPATH           = "//div[@class='alert alert-danger fade in']/div[contains(text(), 'Email is not valid')]";


    // SIGNUP PAGE =====================================================================================================
    String NAME_ID                                  = "name";
    String COMPANY_ID                               = "company";
    String CONFIRM_PASSWORD_ID                      = "confirmPassword";
    String SIGNUP_BUTTON_ID                         = "send_email";
    // values
    String NAME_VALUE                               = "Abduharabdashid Ibn Balda";
    String COMPANY_VALUE                            = "Balda Incorporated";
    // alerts
    String EMAIL_CONFIRMATION_MESSAGE_XPATH         = "//div[@class='page-header']/h3[contains(text(), '!!!')]";
    String ACTIVATE_ACCOUNT_ALERT_XPATH             = "//div[@class='alert alert-danger fade in']/div[contains(text(), 'Please activate your account')]";
    String EMAIL_NOT_FOUND_ALERT_XPATH              = "//div[@class='alert alert-danger fade in']/div[contains(text(), 'Email not found')]";
    String PASSWORD_LESS_6_CHARACTERS_ALERT_XPATH   = "//div[@class='alert alert-danger fade in']/div[contains(text(), 'Password must be at least 6 characters long')]";
    String ALL_FIELDS_WRONG_RED_ALERT_XPATH         = "//div[@class='alert alert-danger fade in']/div[contains(text(), 'Name cannot be blank')]/following::div[contains(text(), 'Company cannot be blank')]/following::div[contains(text(), 'Email is not valid')]/following::div[contains(text(), 'Password must be at least 6 characters')]";
    String PASSWORD_MISMATCH                        = "//div[@class='alert alert-danger fade in']/div[contains(text(), 'Passwords do not match')]";
    String COMPANY_EMPTY_RED_ALERT_XPATH            = "//div[@class='alert alert-danger fade in']/div[contains(text(), 'Company cannot be blank')]";
    String NAME_EMPTY_RED_ALERT_XPATH               = "//div[@class='alert alert-danger fade in']/div[contains(text(), 'Name cannot be blank')]";


    // MAILBOX PAGE ====================================================================================================
    // main page
    String MAILBOX_URL                                              = "http://mail.ru";
    String MAILBOX_LOGIN_ID                                         = "mailbox__login";
    String MAILBOX_PASSWORD_ID                                      = "mailbox__password";
    String MAILBOX_LOGIN_BUTTON_ID                                  = "mailbox__auth__button";
    String MAILBOX_MAIN_PAGE_LOGOUT_LINK_XPATH                      = "//a[@id='js-mailbox-exit']";
    String MAILBOX_PASSWORD_VALUE                                   = "1qa@WS";
    // list of letters
    String MAILBOX_NEW_LETTER_ABOUT_FORGOT_PASSWORD_XPATH           = "//div[@class='b-datalist__item js-datalist-item b-datalist__item_unread']//a[@data-subject='Reset your password']";
    String MAILBOX_ONLY_ONE_NEW_LETTER_ABOUT_CONFIRM_EMAIL_XPATH    = "//div[@class='b-datalist__item js-datalist-item b-datalist__item_unread b-datalist__item_last']//a[@class='js-href b-datalist__item__link']";
    String MAILBOX_FIRST_OF_NEW_LETTER_ABOUT_CONFIRM_EMAIL_XPATH    = "//div[@class='b-datalist__item js-datalist-item b-datalist__item_unread b-datalist__item_last']//a[@data-subject='Please confirm your registration']";
    String MAILBOX_SELET_ALL_EMAILS_CHECKBOX_XPATH                  = "//div[@class='js-checkbox b-checkbox b-checkbox_transparent b-checkbox_false js-shortcut']";
    String MAILBOX_DELETE_BUTTON                                    = "//div[@class='b-toolbar__btn b-toolbar__btn_false b-toolbar__btn_false b-toolbar__btn_adaptive b-toolbar__btn_adaptive_msgl-high b-toolbar__btn_grouped b-toolbar__btn_grouped_first js-shortcut']";
    String MAILBOX_LOGOUT_LINK_XPATH                                = "//a[@id='PH_logoutLink']";
    // inside letter
    String MAILBOX_CONFIRMATION_LINK_XPATH                          = "//div[@class='b-letter__body']//a[contains(@href, 'verify')]";
    String MAILBOX_FORGOT_PASSWORD_LINK_XPATH                       = "//div[@class='b-letter__body']//a[contains(@href, 'reset')]";


    // FORGOT PASSWORD PAGE  ===========================================================================================
    String FORGOT_PASSWORD__EMAIL_ID                                = "email";
    String FORGOT_PASSWORD__RESET_PASSWORD_BUTTON_XPATH             = "//button[@class='btn btn-primary']";
    String FORGOT_PASSWORD_OLD_PASSWORD_VALUE                       = "1q2w3e4r5t6y7u8i9o0p";
    // alerts
    String FORGOT_PASSWORD__TOKEN_SENT__BLUE_ALERT_XPATH            = "//div[@class='alert alert-info fade in']/div[contains(text(), 'An e-mail has been sent')]";
    String FORGOT_PASSWORD_INCORRECT_EMAIL_RED_ALERT_XPATH          = "//div[@class='alert alert-danger fade in']//div[contains(text(), 'Please enter a valid email address')]";
    String FORGOT_PASSWORD_INVALID_EMAIL_RED_ALERT_XPATH            = "//div[@class='alert alert-danger fade in']//div[contains(text(), 'Account with that email address does not exist')]";


    // RESET PASSWORD PAGE  ============================================================================================
    String RESET_PASSWORD__PASSWORD_ID                              = "password";
    String RESET_PASSWORD__CONFIRM_PASSWORD_ID                      = "confirm";
    String RESET_PASSWORD__CHANGE_PASSWORD_BUTTON_XPATH             = "//button[@type='submit']";
    String RESET_PASSWORD__NEW_PASSWORD_VALUE                       = "1q2w3e";
    // alerts
    String RESET_PASSWORD__PASSWORD_MISMATCH_ALERT_XPATH            = "//div[@class='alert alert-danger fade in']/div[contains(text(), 'Passwords must match')]";
    String RESET_PASSWORD__INCORRECT_PASSWORD_ALERT_XPATH           = "//div[@class='alert alert-danger fade in']/div[contains(text(), 'Password must be at least 6 characters long')]";
    String RESET_PASSWORD__PASSWORD_CHANGED_GREEN_ALERT_XPATH       = "//div[@class='alert alert-success fade in']//div[contains(text(), 'Success! Your password has been changed')]";


    // APLLICATIONS LIST - EMPTY  ======================================================================================
    // MENU ITEMS
    String EMPTY_APPLICATIONS_LIST_URL_TAIL                         = "apps/list";
    String APLLICATIONS_MENU_DASHBOARD                              = "//ul[@id='navigation']/li[1]";
    String APLLICATIONS_MENU_APPLICATIONS_LIST                      = "//ul[@id='navigation']/li[2]";
    String APLLICATIONS_MENU_REPORTS                                = "//ul[@id='navigation']/li[3]";
    // PAGE ELEMENTS
    String ADD_APPLICATION_BUTTON                                   = "//button[@class='btn btn-default pull-right']";
    String ADD_APPLICATION_LINK                                     = "//h3[@class='text-center']/a[@href='/apps/add-new-application']";


    // ADD NEW APPLICATION PAGE ========================================================================================
    String ADD_NEW_APPLICATION_URL_TAIL                             = "apps/add-new-application";
    String INPUT_TITLE_XPATH                                        = "//input[@id='title']";
    String INPUT_PACKAGE_NAME_XPATH                                 = "//input[@id='package_name']";
    String INPUT_APP_URL_XPATH                                      = "//input[@id='url']";
    String MULTI_SELECT_CATEGORY_BUTTON_XPATH                       = "//button[@class='ms-choice']";
    String MULTI_SELECT_CATEGORY_SEARCH_XPATH                       = "//button[@class='ms-choice']/following::div[@class='ms-drop bottom']/div[@class='ms-search']/input[@type='text']";
    String SELECT_PLATFORM_XPATH                                    = "//select[@id='platform']";
    String SELECT_AGE_LIMITS_XPATH                                  = "//select[@id='age_limits']";
    String CHECKBOX_PAID_APPLICATION_XPATH                          = "//input[@id='paid-application']";
    String CHECKBOX_VIRTUAL_CURRENCY_XPATH                          = "//input[@id='virtual_currency']";
    String INPUT_CURRENCY_NAME_XPATH                                = "//input[@id='currency_name']";
    String INPUT_EXCHANGE_RATE_XPATH                                = "//input[@id='exchange_rate']";
    String CHECKBOX_EXCHANGE_INTO_REAL_CURRENCY_XPATH               = "//input[@id='real_currency']";
    String BUTTON_ADD_NEW_APPLICATION_XPATH                         = "//button[@class='btn btn-success']";
    String BUTTON_CANCEL_XPATH                                      = "//button[@class='btn btn-danger pull-right']";
    String BREAD_CRUMBS_LINK_XPATH                                  = "//ol[@class='breadcrumb']//a[@href='/apps/list']";
    // INPUT VALUES
    String APPLICATION_TITLE_VALUE                                  = "Cox Homelife";
    String APPLICATION_TITLE_EMPTY_VALUE                            = "";
    String PACKAGE_NAME_CORRECT_VALUE                               = "com.cox.homesecurity";
    String PACKAGE_NAME_BLANK_VALUE                                 = "";
    String PACKAGE_NAME_INCORRECT_VALUE                             = "1";
    String APP_URL_CORRECT_VALUE                                    = "https://play.google.com/store/apps/details?id=com.cox.homesecurity&hl=en";
    String APP_URL_INCORRECT_VALUE                                  = "play.google/store/";
    String APP_URL_EMPTY_VALUE                                      = "";
    String MULTI_SELECT_CATEGORY_ALL_XPATH                          = "//input[@data-name='selectAllcategory']";
    String CHECKBOX_1ST_CATEGORY_ITEM_XPATH                         = "//input[@value='IAB1 Arts & Entertainment']";
    String CHECKBOX_2ND_CATEGORY_ITEM_XPATH                         = "//input[@value='IAB1-1 Books & Literature']";
    String CHECKBOX_LST_CATEGORY_ITEM_XPATH                         = "//input[@value='IAB26-3 Copyright Infringement']";
    String PLATFORM_ANDROID_VALUE                                   = "android";
    String PLATFORM_IOS_VALUE                                       = "ios";
    String AGE_LIMIT_0_VALUE                                        = "0";
    String AGE_LIMIT_5_VALUE                                        = "5";
    String AGE_LIMIT_10_VALUE                                       = "10";
    String AGE_LIMIT_13_VALUE                                       = "13";
    String AGE_LIMIT_18_VALUE                                       = "18";
    String CURRENCY_NAME_CORRECT_VALUE                              = "Tons of GOLD";
    String CURRENCY_NAME_EMPTY_VALUE                                = "";
    String EXCHANGE_RATE_CORRECT_VALUE1                             = "100000";
    String EXCHANGE_RATE_CORRECT_VALUE2                             = "100.000";
    String EXCHANGE_RATE_INCORRECT_TEXT_VALUE                       = "one ton of GOLD";
    String EXCHANGE_RATE_INCORRECT_NUMBER_VALUE1                    = "0.3";
    String EXCHANGE_RATE_INCORRECT_NUMBER_VALUE2                    = "0,3";
    String EXCHANGE_RATE_EMPTY_VALUE                                = "";
    // ALERTS
    String APPLICATION_CREATED_BLUE_ALERT_XPATH                     = "//div[@class='alert alert-info fade in']//div[contains(text(), 'Application successfully created')]";
    String APPLICATION_TITLE_IS_BLANK_RED_ALERT_XPATH               = "//div[@class='alert alert-danger fade in']/div[contains(text(), 'Title cannot be blank')]";
    String PACKAGE_NAME_IS_BLANK_RED_ALERT_XPATH                    = "//div[@class='alert alert-danger fade in']/div[contains(text(), 'Package name cannot be blank')]";
    String CATEGORY_IS_BLANK_RED_ALERT_XPATH                        = "//div[@class='alert alert-danger fade in']/div[contains(text(), 'Category cannot be blank')]";
    String PLATFORM_IS_BLANK_RED_ALERT_XPATH                        = "//div[@class='alert alert-danger fade in']/div[contains(text(), 'Platform cannot be blank')]";
    String AGE_LIMIT_IS_BLANK_RED_ALERT_XPATH                       = "//div[@class='alert alert-danger fade in']/div[contains(text(), 'Age limits cannot be blank')]";
    String CURRENCY_NAME_IS_BLANK_RED_ALERT_XPATH                   = "//div[@class='alert alert-danger fade in']/div[contains(text(), 'Currency name cannot be blank')]";
    String CURRENCY_RATE_IS_INCORRECT_RED_ALERT_XPATH               = "//div[@class='alert alert-danger fade in']/div[contains(text(), 'Please, enter a valid value for the field Exchange Rate')]";
    // неправильный урл приложения не проверяется на сервере
    // не светятся все ошибки, если чел "накосячил" во всех полях сразу - светится только CURRENCY_RATE_IS_INCORRECT_RED_ALERT_XPATH


    // FILLED APPLICATION LIST PAGE ====================================================================================
    String APPLICATION_SEND_TO_APPROVE_BUTTON_XPATH                 = "//table[@class='table app-table']/tbody/tr[1]//img[@class='check-button']";
    String APPLICATION_PLAY_BUTTON_XPATH                            = "//table[@class='table app-table']/tbody/tr[1]//img[@class='start-button']";
    String APPLICATION_PAUSE_BUTTON_XPATH                           = "//table[@class='table app-table']/tbody/tr[1]//img[@class='pause-button']";
    String APPLICATION_KEY_BUTTON_XPATH                             = "//table[@class='table app-table']/tbody/tr[1]//img[@class='appkey-button']";
    String APPLICATION_SETTINGS_BUTTON_XPATH                        = "//table[@class='table app-table']/tbody/tr[1]//img[@class='settings-button']";


}