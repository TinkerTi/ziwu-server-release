package cn.justin.ziwu.server.utils;

public class StringUtils {

    public static boolean isPasswordValid(String password) {
        if (password == null) {
            return false;
        }
        if (password.length() < 6
                || password.length() > 16) {
            return false;
        }
        //TODO 检测密码是否合法

//        if (outofStringScope(password,
//                passwordNumberScope + passwordWordScope + getPasswordSymbolScope())) {
//            return false;
//        }
//
//        int combination = 0;
//        if (!isStringValid(password, passwordNumberScope,
//                settingService.intValueOf(SettingScope.Password, SettingName.Password_Number))) {
//            return false;
//        } else {
//            combination = combination + 1;
//        }
//        if (!isStringValid(password, passwordWordScope,
//                settingService.intValueOf(SettingScope.Password, SettingName.Password_Word))) {
//            return false;
//        } else {
//            combination = combination + 1;
//        }
//
//        if (!isStringValid(password, getPasswordSymbolScope(),
//                settingService.intValueOf(SettingScope.Password, SettingName.Password_Symbol))) {
//            return false;
//        } else {
//            combination = combination + 1;
//        }
//
//        int minCombination = settingService
//                .intValueOf(SettingScope.Password, SettingName.Password_Min_Char_Type_Count);
//
//        if (combination < minCombination) {
//            return false;
//        }
        return true;
    }

    private static boolean isStringValid(String s, String scope, int type) {
        if (type == -1) { // 禁止
            if (scope == null || scope.length() == 0) {
                return true;
            }
            char[] cs = s.toCharArray();
            for (char c : cs) {
                if (scope.indexOf(c) != -1) {
                    return false;
                }
            }
            return true;
        } else if (type == 1) { // 必须包含
            if (scope == null || scope.length() == 0) {
                return false;
            }
            char[] cs = s.toCharArray();
            for (char c : cs) {
                if (scope.indexOf(c) != -1) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private static boolean outofStringScope(String s, String scope) {
        if (scope == null || scope.length() == 0) {
            return true;
        }
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (scope.indexOf(c) == -1) {
                return true;
            }
        }
        return false;
    }
}
