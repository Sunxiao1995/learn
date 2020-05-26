package club.banyuan;

import java.io.File;

public class MyRBTree<T extends Comparable<T>,D> {
  private RBNode<T,D> root; // 根节点


  /**
   * 节点的颜色
   */
  private static final Boolean RED = false;
  private static final Boolean BLACK = true;


  /**
   * 获取某个节点的父节点
   * @param node 载入的节点
   * @return 父节点
   */
  public RBNode<T, D> parentOf(RBNode<T, D> node) {
    if (node != null) {
      return node.getParent();
    }
    return null;
  }

  /**
   * 获取某个节点的颜色
   * @param node
   * @return
   */
  public Boolean colorOf(RBNode<T, D> node) {
    if (node != null) {
      return node.getColor();
    }
    return BLACK;

  }

  /**
   * 创建树的时候需要设置其父节点
   * @param node
   * @param parent
   */

  public void setParent(RBNode<T, D> node, RBNode<T, D> parent) {
    if (node != null) {
      node.setParent(parent);
    }
  }


  /**
   * 设置某节点的颜色
   * @param node
   * @param color
   */
  public void setColor(RBNode<T, D> node, Boolean color) {
    if (node != null) {
      node.setColor(color);
    }
  }

  /**
   * 判断节点的颜色
   * @param node
   * @return
   */
  public Boolean isRed(RBNode<T, D> node) {
    return node != null && node.getColor() == RED;

  }

  /**
   * 寻找值为key的节点
   * @param key
   * @param node
   * @return
   */
  public RBNode<T, D> search(T key, RBNode<T, D> node) {

    if (node != null) {
      //查找的过程，就是一直递归比较到叶子为止
      int com = key.compareTo(node.getKey());
      if (com < 0) {
        return search(key, node.getLeftChild());
      } else if (com > 0) {
        return search(key, node.getRightChild());
      } else {
        return node;
      }
    }
    return null;
  }

  public D get(T key){
    RBNode<T,D> node = search(key,root);
    return node == null ? null : node.getDate();
  }


  public void leftRotate(RBNode<T, D> x) {
    //右孩子
    RBNode<T, D> y = x.getRightChild();

    if (y.getLeftChild() != null) {
      //当前节点 变成了 右孩子的左节点的父亲
      y.getLeftChild().setParent(x);
    }
    x.setRightChild(y.getLeftChild());
    y.setLeftChild(x);
    //当前的父亲变成了右孩子的父亲
    y.setParent(x.getParent());

    if (x.getParent() != null) {
      if (x.getParent().getLeftChild() == x) {
        x.getParent().setLeftChild(y);
      } else {
        x.getParent().setRightChild(y);
      }
    } else {
      this.root = y;
    }
    x.setParent(y);
    File

  }










}
