//package com.example.saucedemo.data;
//
//import lombok.Data;
//import lombok.Value;
//@Data
//public class DataHelper {
//    private static final String STANDARD_USER = "standard_user";
//    private static final String LOCKED_OUT_USER = "locked_out_user";
//    private static final String PROBLEM_USER = "problem_user";
//    private static final String PERFORMANCE_GLITCH_USER = "performance_glitch_user";
//    private static final String USER_PASSWORD = "secret_sauce";
//
//    public static UserInfo getStandardUserInfo() {
//        return new UserInfo(
//                STANDARD_USER,
//                USER_PASSWORD
//        );
//    }
//
//    public static UserInfo getLockedOutUserInfo() {
//        return new UserInfo(
//                LOCKED_OUT_USER,
//                USER_PASSWORD
//        );
//    }
//
//
//    public static UserInfo getProblemUserInfo(){
//        return new UserInfo(
//                PROBLEM_USER,
//                USER_PASSWORD
//        );
//    }
//
//    public static UserInfo getPerformanceGlitchUser(){
//        return new UserInfo(
//                PERFORMANCE_GLITCH_USER,
//                USER_PASSWORD
//        );
//    }
//
//
//
//
//
//    @Value
//    public static class UserInfo {
//        private String userName;
//        private String userPassword;
//    }
//
//
//}


package com.example.saucedemo.data;

import lombok.Data;
import lombok.Value;

@Data
public class DataHelper {
    public static UserInfo getUserInfo() {
        String userName = System.getProperty("userName");
        String userPassword = System.getProperty("userPassword");
        return new UserInfo(userName, userPassword);
    }

    public static UserInfo getLockedOutUserInfo() {
        String userName = System.getProperty("lockedOutUserName", "locked_out_user");
        String userPassword = System.getProperty("lockedOutUserPassword", "locked_secret");
        return new UserInfo(userName, userPassword);
    }

    @Value
    public static class UserInfo {
        private String userName;
        private String userPassword;
    }
}