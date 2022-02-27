package com.naukri.automation.util;

import org.testng.Reporter;

public class TestNGLogUtility {

    private static final String fail = "[ASSERT FAIL]: ";
    private static final String info = "[INFO]: ";
    private static final String pass = "[ASSERT PASS]: ";
    private static final String scripterror = "[SCRIPTING ERROR]: ";

    public static void fail(String message) {
        reportMsg(fail, message);
    }

    public static void pass(String message) {
        reportMsg(pass, message);
    }

    public static void scripterror(String message) {
        reportMsg(scripterror, message);
    }

    public static void info(String message) {
        reportMsg(info, message);
    }

    private static void reportMsg(String prefix, String message) {
        Reporter.log(prefix + message, true);
    }

}
