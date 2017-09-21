package kpartition;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertNull;

/**
 * Created by yuhaowang on 9/15/17.
 */
public class KPartitionTest {

    KPartition kPartition;

    @Before
    public void setUp() throws Exception {
        kPartition = new KPartition();
    }

    @Test
    public void test1() throws Exception {
        assert !kPartition.separate(null, 1);
    }

    @Test
    public void test2() throws Exception {
        Integer[] array = {7, 3, 5, 12, 2, 1, 5, 3, 8, 4, 6, 4};
        assert kPartition.separate(Arrays.asList(array), 1);
    }

    @Test
    public void test3() throws Exception {
        Integer[] array = {7, 3, 5, 12, 2, 1, 5, 3, 8, 4, 6, 4};
        assert kPartition.separate(Arrays.asList(array), 2);
    }

    @Test
    public void test4() throws Exception {
        Integer[] array = {7, 3, 5, 12, 2, 1, 5, 3, 8, 4, 6, 4};
        assert kPartition.separate(Arrays.asList(array), 4);
    }

    @Test
    public void test5() throws Exception {
        Integer[] array = {7, 3, 5, 12, 2, 1, 5, 3, 8, 4, 6, 4};
        assert !kPartition.separate(Arrays.asList(array), 6);
    }

    @Test
    public void test6() throws Exception {
        Integer[] array = {10, 20, 10, 20, 10, 20, 10, 20, 10, 20};
        assert kPartition.separate(Arrays.asList(array), 5);
    }

    @Test
    public void test7() throws Exception {
        Integer[] array = {1, 2, 4, 5, 7};
        assert !kPartition.separate(Arrays.asList(array), 3);
    }

    @Test
    public void test8() throws Exception {
        Integer[] array = {2, 1, 4, 5, 6};
        assert kPartition.separate(Arrays.asList(array), 3);
    }

    @Test
    public void test9() throws Exception {
        Integer[] array = {2, 1, 4, 5, 6};
        assert !kPartition.separate(Arrays.asList(array), 6);
    }

    @Test
    public void test10() throws Exception {
        Integer[] array = {1, 2, 3, 1, 2, 3};
        assert kPartition.separate(Arrays.asList(array), 2);
    }

    @After
    public void tearDown() throws Exception {
        kPartition = null;
        assertNull(kPartition);
    }
}