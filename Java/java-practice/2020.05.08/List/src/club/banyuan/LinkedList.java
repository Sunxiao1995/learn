package club.banyuan;

public class LinkedList implements List {

  private Node head = new Node();
  private Node tail = head;
  private int size;

  @Override
  public Object set(int index, Object element) {
    if (index >= size) {
      System.out.println("下标不合法");
      return null;
    }
    Node cur = getIndexNode(index);
    Object replaceElement = get(index);
    cur.setData(element);
    return replaceElement;
  }

  @Override
  public Object get(int index) {
    if (index >= size) {
      System.out.println("下标不合法");
      return null;
    }
    Node cur = getIndexNode(index);
    return cur.getData();
  }

  @Override
  public void clear() {

    head.setNext(null);
    tail = head;
    size = 0;
  }

  @Override
  public Object remove(int index) {
   if (index >= size) {
      System.out.println("下标不合法");
      return null;
    }
    Object removeIndexElement = get(index);
    if(index == size-1){
      tail= tail.getPrev();
      tail.setNext(null);

    }else{
    Node removeIndexNode = getIndexNode(index);
    removeIndexNode.getPrev().setNext(removeIndexNode.getNext());
    removeIndexNode.getNext().setPrev(removeIndexNode.getPrev());
    }
    size--;
    return removeIndexElement;
  }

  @Override
  public boolean remove(Object o) {
    boolean isTrue = false;
    Node needRemove = head.getNext();
    for (int i = 0; i < size ; i++) {
      if(needRemove.getData() == o)
      {needRemove = needRemove.getNext();
        remove(i);
        isTrue = true;
        i--;
      }
      else{
        needRemove = needRemove.getNext();
      }
    }
    return isTrue;
  }

  @Override
  public boolean add(Object o) {
    Node node = new Node();
    node.setData(o);
    node.setPrev(tail);
    tail.setNext(node);
    tail = node;
    size++;
    return true;
  }

  @Override
  public boolean isEmpty() {
    if (size == 0)
      return true;
    else
      return false;
  }

  @Override
  public int size() {
    return size;
  }


  /**
   * 找到对应下标的节点
   *
   * @param index   对应的位置
   * @return 对应位置的节点
   */
  public Node getIndexNode(int index) {
    int count = index;
    Node cur = head;
    while (count != -1) {
      cur = cur.getNext();
      count--;
    }
    return cur;
  }

}
