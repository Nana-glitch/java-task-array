package array.entity;

import java.util.Arrays;

public class IntArray extends AbstractArray {

  private final int[] values;

  public IntArray(long id, int[] values) {
    super(id);
    this.values = Arrays.copyOf(values, values.length);
  }

  public int[] getValues() {
    return Arrays.copyOf(values, values.length);
  }

  @Override
  public int getLength() {
    return values.length;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    IntArray that = (IntArray) other;
    if (getId() != that.getId()) {
      return false;
    }
    return Arrays.equals(values, that.values);
  }

  @Override
  public int hashCode() {
    int result = (int) (getId() ^ (getId() >>> 32));
    result = 31 * result + Arrays.hashCode(values);
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder builder = new StringBuilder("IntArray{");
    builder.append("id=").append(getId());
    builder.append(", values=").append(Arrays.toString(values));
    builder.append('}');
    return builder.toString();
  }
}
