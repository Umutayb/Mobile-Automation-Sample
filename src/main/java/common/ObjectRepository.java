package common;

import screens.MainScreen;

@SuppressWarnings("unused")
public class ObjectRepository {

    static String url;

    public static Environment environment;

    public static void setUrl(String url) {
        ObjectRepository.url = url;
    }

    public static String getUrl() {
        return url;
    }

    MainScreen mainScreen = new MainScreen();
}
