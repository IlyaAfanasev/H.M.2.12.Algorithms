package pro.sky.java.course2;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.exceptions.ElementNotFoundException;
import pro.sky.java.course2.exceptions.InvalidIndexException;
import pro.sky.java.course2.exceptions.ItemIsNullException;


import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.constant.ListImplConstants.*;

public class StringListImplTest {

    private final StringList out = new StringListImpl();

    @Test
    public void shouldReturnCorrectResultFromMethodAddTest() {
        String actual = out.add(STRING_1);
        Assertions.assertEquals(STRING_1, actual);
    }

    @Test
    public void shouldThrowItemIsNullExceptionFromMethodAddWhenParamIsNull() {
        Assertions.assertThrows(ItemIsNullException.class, () -> out.add(null));
    }

    @Test
    public void shouldReturnCorrectResultFromMethodAddTestWithIndex() {
        out.add(STRING_1);
        out.add(STRING_2);
        out.add(STRING_3);
        String actual = out.add(1, STRING_4);
        assertEquals(STRING_4, actual);
    }

    @Test
    public void shouldThrowItemIsNullExceptionFromMethodAddTestWithIndex() {
        out.add(STRING_1);
        out.add(STRING_2);
        out.add(STRING_3);
        assertThrows(ItemIsNullException.class, () -> out.add(1, null));
    }

    @Test
    public void shouldThrowInvalidIndexExceptionFromMethodAddTestWithIndex() {
        out.add(STRING_1);
        out.add(STRING_2);
        out.add(STRING_3);
        assertThrows(InvalidIndexException.class, () -> out.add(3, STRING_4));
    }

    //Test Set

    @Test
    public void shouldReturnCorrectResultFromMethodSet() {
        out.add(STRING_1);
        out.add(STRING_2);
        out.add(STRING_3);
        assertEquals(STRING_4, out.set(1, STRING_4));
    }

    @Test
    public void shouldThrowInvalidIndexExceptionFromMethodASet() {
        out.add(STRING_1);
        out.add(STRING_2);
        out.add(STRING_3);
        assertThrows(InvalidIndexException.class, () -> out.set(3, STRING_4));
    }

    @Test
    public void shouldThrowItemIsNullExceptionFromMethodSet() {
        out.add(STRING_1);
        out.add(STRING_2);
        out.add(STRING_3);
        assertThrows(ItemIsNullException.class, () -> out.add(1, null));
    }

    //Test Remove When param is String

    @Test
    public void shouldReturnCorrectResultFromMethodRemoveWhenParamIsString() {
        out.add(STRING_1);
        out.add(STRING_2);
        out.add(STRING_3);
        assertEquals(STRING_2, out.remove(STRING_2));
    }

    @Test
    public void shouldThrowItemIsNullExceptionFromMethodRemoveWhenParamIsString() {
        out.add(STRING_1);
        out.add(STRING_2);
        out.add(STRING_3);
        assertThrows(ItemIsNullException.class, () -> out.remove(null));
    }

    @Test
    public void shouldThrowElementNotFoundExceptionFromMethodRemoveWhenParamIsString() {
        out.add(STRING_1);
        out.add(STRING_2);
        out.add(STRING_3);
        assertThrows(ElementNotFoundException.class, () -> out.remove(STRING_5));
    }

    //Test Remove When param is index

    @Test
    public void shouldReturnCorrectResultFromMethodRemoveWhenParamIsIndex() {
        out.add(STRING_1);
        out.add(STRING_2);
        out.add(STRING_3);
        assertEquals(STRING_2, out.remove(1));
    }

    @Test
    public void shouldThrowInvalidIndexExceptionFromMethodRemoveWhenParamIsIndex() {
        out.add(STRING_1);
        out.add(STRING_2);
        out.add(STRING_3);
        assertThrows(InvalidIndexException.class, () -> out.remove(3));
    }

    //Test Contains

    @Test
    public void shouldReturnTrueResultFromMethodContains() {
        out.add(STRING_1);
        out.add(STRING_2);
        out.add(STRING_3);
        assertTrue(out.contains(STRING_2));
    }

    @Test
    public void shouldReturnFalseResultFromMethodContains() {
        out.add(STRING_1);
        out.add(STRING_2);
        out.add(STRING_3);
        assertFalse(out.contains(STRING_4));
    }

    @Test
    public void shouldThrowItemIsNullExceptionFromMethodContains() {
        out.add(STRING_1);
        out.add(STRING_2);
        out.add(STRING_3);
        assertThrows(ItemIsNullException.class, () -> out.contains(null));
    }

//Test IndexOf

    @Test
    public void shouldReturnCorrectResultFromMethodIndexOfWhenElementExist() {
        out.add(STRING_1);
        out.add(STRING_2);
        out.add(STRING_2);
        assertEquals(1, out.indexOf(STRING_2));
    }

    @Test
    public void shouldReturnCorrectResultFromMethodIndexOfWhenElementNotExist() {
        out.add(STRING_1);
        out.add(STRING_2);
        out.add(STRING_3);
        assertEquals(-1, out.indexOf(STRING_4));
    }

    @Test
    public void shouldThrowItemIsNullExceptionFromMethodIndexOfWhenElement() {
        out.add(STRING_1);
        out.add(STRING_2);
        out.add(STRING_3);
        assertThrows(ItemIsNullException.class, () -> out.indexOf(null));
    }

    //Test Lastindex

    @Test
    public void shouldReturnCorrectResultFromMethodLastIndexWhenElementExist() {
        out.add(STRING_1);
        out.add(STRING_2);
        out.add(STRING_2);
        assertEquals(2, out.lastIndexOf(STRING_2));
    }

    @Test
    public void shouldReturnCorrectResultFromMethodLastIndexWhenElementNotExist() {
        out.add(STRING_1);
        out.add(STRING_2);
        out.add(STRING_3);
        assertEquals(-1, out.lastIndexOf(STRING_4));
    }

    @Test
    public void shouldThrowItemIsNullExceptionFromMethodLastIndexWhenElement() {
        out.add(STRING_1);
        out.add(STRING_2);
        out.add(STRING_3);
        assertThrows(ItemIsNullException.class, () -> out.lastIndexOf(null));
    }

    //Test Get

    @Test

    public void shouldReturnCorrectResultFromMethodGet() {
        out.add(STRING_1);
        out.add(STRING_2);
        out.add(STRING_3);
        assertEquals(STRING_2, out.get(1));
    }

    @Test
    public void shouldThrowInvalidIndexExceptionFromMethodGet() {
        out.add(STRING_1);
        out.add(STRING_2);
        out.add(STRING_3);
        assertThrows(InvalidIndexException.class, () -> out.get(3));
    }

//Test Equals

    @Test

    public void shouldReturnCorrectResultFromMethodEquals() {
        out.add(STRING_1);
        out.add(STRING_2);
        out.add(STRING_3);
        out.add(STRING_4);
        out.add(STRING_5);

        assertTrue(out.equals(OTHER_LIST));

    }

    @Test
    public void shouldTrowItemIsNullExceptionFromMethodEquals() {
        out.add(STRING_1);
        out.add(STRING_2);
        out.add(STRING_3);
        out.add(STRING_4);
        out.add(STRING_5);
        assertThrows(ItemIsNullException.class, () -> out.equals(null));

    }


    @Test
    public void shouldReturnCorrectResultFromMethodSize() {
        out.add(STRING_1);
        out.add(STRING_2);
        out.add(STRING_3);
        out.add(STRING_4);
        out.add(STRING_5);
        assertEquals(5, out.size());
    }

    @Test
    public void shouldReturnCorrectResultFromMethodIsEmpty() {
        assertTrue(out.isEmpty());
        out.add(STRING_2);
        assertFalse(out.isEmpty());
    }

    @Test
    public void shouldReturnCorrectResultFromMethodClear() {

        out.add(STRING_2);
        assertEquals(1, out.size());
        out.clear();
        assertTrue(out.isEmpty());
    }

    @Test
    public void shouldReturnCorrectResultFromMethodToArray() {
        out.add(STRING_1);
        out.add(STRING_2);
        out.add(STRING_3);
        out.add(STRING_4);
        assertArrayEquals(STRINGS_ARRAY, out.toArray());
    }
}