package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HashMapTest extends AbstractMapTest {

    @Override
    <T> void runTest(T[] expected, T[] actual) {
        // TODO

    }

    @BeforeEach
    @Override
    void setUp() {
        map = new HashMap<>();
        super.setUp();
    }

    @Test
    void getTest() {
        map.put(1, 1);
        assertEquals(map.get(1), 1);
        // testing an non existing entry
        assertNull(map.get(2));
    }

    @Test
    void putTest() {
        assertNull(map.put(1, 1));
        assertEquals(1, map.get(1));
        assertEquals(1, map.size());

        // Testing an existing key
        assertEquals(1, map.put(1, 1));
    }

    @Test
    void containsKeyTest() {
        // adding a existing key
        map.put(1, null);
        assertTrue(map.containsKey(1));
        // testing a not existing key
        assertFalse(map.containsKey(2));
    }

    @Test
    void containsValueTest() {
        map.put(3, 3);
        map.put(5, 3);
        assertTrue(map.containsValue(3));
        assertFalse(map.containsValue(4));
    }

}
