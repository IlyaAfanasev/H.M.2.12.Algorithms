package pro.sky.java.course2.constant;

import pro.sky.java.course2.StringListImpl;

public class StringListImplConstants {
    public static final String STRING_1 = "Один";
    public static final String STRING_2 = "Два";
    public static final String STRING_3 = "Три";
    public static final String STRING_4 = "Четыре";
    public static final String STRING_5 = "Пять";

    public static final StringListImpl OTHER_LIST =
            new StringListImpl(STRING_1, STRING_2, STRING_3, STRING_4, STRING_5);

    public static final String[] STRINGS_ARRAY = new String[]{STRING_1, STRING_2, STRING_3, STRING_4};
}
