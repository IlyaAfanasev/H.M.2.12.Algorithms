package pro.sky.java.course2.constant;

import pro.sky.java.course2.IntegerListImpl;
import pro.sky.java.course2.StringListImpl;

public class ListImplConstants {
    public static final String STRING_1 = "Один";
    public static final String STRING_2 = "Два";
    public static final String STRING_3 = "Три";
    public static final String STRING_4 = "Четыре";
    public static final String STRING_5 = "Пять";

    public static final StringListImpl OTHER_LIST =
            new StringListImpl(STRING_1, STRING_2, STRING_3, STRING_4, STRING_5);

    public static final String[] STRINGS_ARRAY = new String[]{STRING_1, STRING_2, STRING_3, STRING_4};



    public static final Integer INTEGER_1 = 1;
    public static final Integer INTEGER_2 = 2;
    public static final Integer INTEGER_3 = 3;
    public static final Integer INTEGER_4 = 4;
    public static final Integer INTEGER_5 = 5;

    public static final IntegerListImpl OTHER_INTEGER_LIST =
            new IntegerListImpl(INTEGER_1, INTEGER_2, INTEGER_3, INTEGER_4, INTEGER_5);

    public static final Integer[] INTEGERS_ARRAY = new Integer[]{INTEGER_1, INTEGER_2, INTEGER_3, INTEGER_4};
}
