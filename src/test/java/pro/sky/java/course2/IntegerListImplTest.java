package pro.sky.java.course2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.exceptions.ArrayIsFullException;
import pro.sky.java.course2.exceptions.ElementNotFoundException;
import pro.sky.java.course2.exceptions.InvalidIndexException;
import pro.sky.java.course2.exceptions.ItemIsNullException;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.constant.ListImplConstants.*;

public class IntegerListImplTest {
    private final IntegerList out = new IntegerListImpl();

    @Test
    public void shouldReturnCorrectResultFromMethodAddTest() {
        Integer actual = out.add(INTEGER_1);
        Assertions.assertEquals(INTEGER_1, actual);
    }

    @Test
    public void shouldThrowItemIsNullExceptionFromMethodAddWhenParamIsNull() {
        Assertions.assertThrows(ItemIsNullException.class, () -> out.add(null));
    }

    @Test
    public void shouldRThrowArrayIsFullException() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_3);
        out.add(INTEGER_4);
        out.add(INTEGER_5);
        Assertions.assertThrows(ArrayIsFullException.class, () -> out.add(INTEGER_2));
    }
    @Test
    public void shouldReturnCorrectResultFromMethodAddTestWithIndex() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_3);
        Integer actual = out.add(1, INTEGER_4);
        assertEquals(INTEGER_4, actual);

    }

    @Test
    public void shouldReturnCorrectResultFromMethodAddTestWithIndexWhenIndexIsSizeMinus1() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_3);
        Integer actual = out.add(2, INTEGER_4);
        assertEquals(INTEGER_4, actual);
    }

    @Test
    public void shouldThrowItemIsNullExceptionFromMethodAddTestWithIndex() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_3);
        assertThrows(ItemIsNullException.class, () -> out.add(1, null));
    }

    @Test
    public void shouldThrowInvalidIndexExceptionFromMethodAddTestWithIndex() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_3);
        assertThrows(InvalidIndexException.class, () -> out.add(3, INTEGER_4));
    }

    //Test Set

    @Test
    public void shouldReturnCorrectResultFromMethodSet() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_3);
        assertEquals(INTEGER_4, out.set(1, INTEGER_4));
    }

    @Test
    public void shouldThrowInvalidIndexExceptionFromMethodASet() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_3);
        assertThrows(InvalidIndexException.class, () -> out.set(3, INTEGER_4));
    }

    @Test
    public void shouldThrowItemIsNullExceptionFromMethodSet() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_3);
        assertThrows(ItemIsNullException.class, () -> out.add(1, null));
    }

    //Test Remove When param is Integer

    @Test
    public void shouldReturnCorrectResultFromMethodRemoveWhenParamIsInteger() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_3);
        assertEquals(INTEGER_2, out.remove(INTEGER_2));
    }

    @Test
    public void shouldThrowItemIsNullExceptionFromMethodRemoveWhenParamIsInteger() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_3);
        assertThrows(ItemIsNullException.class, () -> out.remove(null));
    }

    @Test
    public void shouldThrowElementNotFoundExceptionFromMethodRemoveWhenParamIsInteger() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_3);
        assertThrows(ElementNotFoundException.class, () -> out.remove(INTEGER_5));
    }

    //Test Remove When param is index

    @Test
    public void shouldReturnCorrectResultFromMethodRemoveWhenParamIsIndex() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_3);
        assertEquals(INTEGER_2, out.remove(1));
    }

    @Test
    public void shouldThrowInvalidIndexExceptionFromMethodRemoveWhenParamIsIndex() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_3);
        assertThrows(InvalidIndexException.class, () -> out.remove(3));
    }

    //Test Contains

    @Test
    public void shouldReturnTrueResultFromMethodContains() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_3);
        assertTrue(out.contains(INTEGER_2));
    }

    @Test
    public void shouldReturnFalseResultFromMethodContains() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_3);
        assertFalse(out.contains(INTEGER_4));
    }

    @Test
    public void shouldThrowItemIsNullExceptionFromMethodContains() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_3);
        assertThrows(ItemIsNullException.class, () -> out.contains(null));
    }

//Test IndexOf

    @Test
    public void shouldReturnCorrectResultFromMethodIndexOfWhenElementExist() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_2);

        assertEquals(1, out.indexOf(INTEGER_2));

    }

    @Test
    public void shouldReturnCorrectResultFromMethodIndexOfWhenElementNotExist() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_3);
        assertEquals(-1, out.indexOf(INTEGER_4));
    }

    @Test
    public void shouldThrowItemIsNullExceptionFromMethodIndexOf() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_3);
        assertThrows(ItemIsNullException.class, () -> out.indexOf(null));
    }

    //Test Lastindex

    @Test
    public void shouldReturnCorrectResultFromMethodLastIndexWhenElementExist() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_2);
        assertEquals(2, out.lastIndexOf(INTEGER_2));
    }

    @Test
    public void shouldReturnCorrectResultFromMethodLastIndexWhenElementNotExist() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_3);
        assertEquals(-1, out.lastIndexOf(INTEGER_4));
    }

    @Test
    public void shouldThrowItemIsNullExceptionFromMethodLastIndexWhenElement() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_3);
        assertThrows(ItemIsNullException.class, () -> out.lastIndexOf(null));
    }

    //Test Get

    @Test

    public void shouldReturnCorrectResultFromMethodGet() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_3);
        assertEquals(INTEGER_2, out.get(1));
    }

    @Test
    public void shouldThrowInvalidIndexExceptionFromMethodGet() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_3);
        assertThrows(InvalidIndexException.class, () -> out.get(3));
    }

//Test Equals

    @Test

    public void shouldReturnCorrectResultFromMethodEquals() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_3);
        out.add(INTEGER_4);
        out.add(INTEGER_5);

        assertTrue(out.equals(OTHER_INTEGER_LIST));

    }

    @Test
    public void shouldTrowItemIsNullExceptionFromMethodEquals() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_3);
        out.add(INTEGER_4);
        out.add(INTEGER_5);
        assertThrows(ItemIsNullException.class, () -> out.equals(null));

    }


    @Test
    public void shouldReturnCorrectResultFromMethodSize() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_3);
        out.add(INTEGER_4);
        out.add(INTEGER_5);
        assertEquals(5, out.size());
    }

    @Test
    public void shouldReturnCorrectResultFromMethodIsEmpty() {
        assertTrue(out.isEmpty());
        out.add(INTEGER_2);
        assertFalse(out.isEmpty());
    }

    @Test
    public void shouldReturnCorrectResultFromMethodClear() {

        out.add(INTEGER_2);
        assertEquals(1, out.size());
        out.clear();
        assertTrue(out.isEmpty());
    }

    @Test
    public void shouldReturnCorrectResultFromMethodToArray() {
        out.add(INTEGER_1);
        out.add(INTEGER_2);
        out.add(INTEGER_3);
        out.add(INTEGER_4);
        assertArrayEquals(INTEGERS_ARRAY, out.toArray());
    }
}


