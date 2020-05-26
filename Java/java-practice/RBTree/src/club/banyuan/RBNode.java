package club.banyuan;

public class RBNode<T extends Comparable<T>,D> {

   private Boolean color;   //节点颜色
   private T key;           //键值 与compare相关 比较放出节点位置
   private D date;          //具体的数据
   private RBNode<T,D> parent;
   private RBNode<T,D> leftChild;
   private RBNode<T,D> rightChild;

  public RBNode(Boolean color, T key, D date, RBNode<T, D> parent,
      RBNode<T, D> leftChild, RBNode<T, D> rightChild) {
    this.color = color;
    this.key = key;
    this.date = date;
    this.parent = parent;
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }

  public Boolean getColor() {
    return color;
  }

  public void setColor(Boolean color) {
    this.color = color;
  }

  public T getKey() {
    return key;
  }

  public void setKey(T key) {
    this.key = key;
  }

  public D getDate() {
    return date;
  }

  public void setDate(D date) {
    this.date = date;
  }

  public RBNode<T, D> getParent() {
    return parent;
  }

  public void setParent(RBNode<T, D> parent) {
    this.parent = parent;
  }

  public RBNode<T, D> getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(RBNode<T, D> leftChild) {
    this.leftChild = leftChild;
  }

  public RBNode<T, D> getRightChild() {
    return rightChild;
  }

  public void setRightChild(RBNode<T, D> rightChild) {
    this.rightChild = rightChild;
  }

}
