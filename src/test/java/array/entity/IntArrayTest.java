package array.entity;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class IntArrayTest {

  private static final long SAMPLE_ID = 1L;
  private static final int[] SAMPLE_VALUES = {3, 1, 2};
  private static final int[] DIFFERENT_VALUES = {9, 9, 9};

  @Test
  void shouldConsiderTwoArraysEqualWhenIdAndValuesMatch() {
    final IntArray first = new IntArray(SAMPLE_ID, SAMPLE_VALUES);
    final IntArray second = new IntArray(SAMPLE_ID, SAMPLE_VALUES);
    assertEquals(first, second);
  }

  @Test
  void shouldConsiderTwoArraysNotEqualWhenValuesDiffer() {
    final IntArray first = new IntArray(SAMPLE_ID, SAMPLE_VALUES);
    final IntArray second = new IntArray(SAMPLE_ID, DIFFERENT_VALUES);
    assertNotEquals(first, second);
  }

  @Test
  void shouldProduceSameHashCodeForEqualArrays() {
    final IntArray first = new IntArray(SAMPLE_ID, SAMPLE_VALUES);
    final IntArray second = new IntArray(SAMPLE_ID, SAMPLE_VALUES);
    assertEquals(first.hashCode(), second.hashCode());
  }

  @Test
  void shouldNotExposeInternalArrayReferenceThroughGetter() {
    final IntArray array = new IntArray(SAMPLE_ID, SAMPLE_VALUES);
    final int[] firstCall = array.getValues();
    firstCall[0] = 999;
    final int[] secondCall = array.getValues();
    assertArrayEquals(SAMPLE_VALUES, secondCall);
  }
}
