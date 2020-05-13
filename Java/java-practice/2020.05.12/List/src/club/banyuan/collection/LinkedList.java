package club.banyuan.collection;

import club.banyuan.util.Iterator;

public class LinkedList implements List {

    class Node {

    private Object data;

    private club.banyuan.collection.LinkedList.Node next; //因为外部有一个同名的类 所以这里需要写全称

    private club.banyuan.collection.LinkedList.Node prev;

    public Object getData() {
      return data;
    }

    public void setData(Object data) {
      this.data = data;
    }

    public club.banyuan.collection.LinkedList.Node getNext() {
      return next;
    }

    public void setNext(club.banyuan.collection.LinkedList.Node next) {
      this.next = next;
    }

    public club.banyuan.collection.LinkedList.Node getPrev() {
      return prev;
    }

    public void setPrev(club.banyuan.collection.LinkedList.Node prev) {
      this.prev = prev;
    }
  }

  private Node head = new Node();
  private Node tail = head;
  private int size; //数组长度

  //根据下标找到相应结点
  public Node getNode(int index) {
    int count = index;
    Node cur = head;
    while (count != -1) {
      cur = cur.getNext();
      count--;
    }
    return cur;
  }

  @Override
  public Object set(int index, Object element) {
    if (index >= size) {
      System.out.println("下标不合法");
      return null;
    }
    Node cur = getNode(index); //要替换元素的结点
    Object replaceElement = cur.getData();//找到要替换的元素
    cur.setData(element);
    return replaceElement;
  }

  @Override
  public Object get(int index) {
    if (index >= size) {
      System.out.println("下标不合法");
      return null;
    }
    int count = index;
    Node cur = head;
    while (count != -1) {
      cur = cur.getNext();
      count--;
    }
    return cur.getData(); //返回数组元素
  }

  @Override
  public void clear() {
    head.setNext(null);
    tail = head;
    size = 0;
  }

  @Override
  public Object remove(int index) {
    if (index >= size || index < 0) {
      System.out.println("下标不合法");
      return null;
    }
    Object removeElement = get(index);
    if (index == size - 1) { //删除尾结点
      tail = tail.getPrev();
      tail.setNext(null);
    } else {
      if (index == 0) { //删除头结点
        head = head.getNext();
        head.setPrev(null);
      } else {
        Node node = getNode(index);
        node.getNext().setPrev(node.getPrev());
        node.getPrev().setNext(node.getNext());
      }
    }
    size--;
    return removeElement;
  }

  //查找匹配的元素并删除
  //实现思路：根据元素找到对应的结点，删除
  @Override
  public boolean remove(Object o) {
    boolean isfind = false;
    for (int i = 0; i < size; i++) {
      if (o == getNode(i).getData()) {
        remove(i);
        i--;
        isfind = true;
      }
    }
    return isfind;
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
    return size == 0;
  }

  @Override
  public int size() {
    return size;
  }

  public Iterator iterator() {
    List list = new ArrayList();
    Node curNode = head.getNext();
    while (curNode != null) {
      list.add(curNode.getData());
      curNode = curNode.getNext();
    }
    return new Iterator(list);
  }
}