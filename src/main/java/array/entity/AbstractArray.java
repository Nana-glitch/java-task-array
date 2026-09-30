package array.entity;

public abstract class AbstractArray {

  private final long id;

  protected AbstractArray(long id) {
    this.id = id;
  }

  public long getId() {
    return id;
  }

  public abstract int getLength();
}
