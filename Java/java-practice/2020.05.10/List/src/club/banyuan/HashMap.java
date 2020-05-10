package club.banyuan;

import club.banyuan.collection.ArrayList;
import club.banyuan.collection.List;
import club.banyuan.util.Iterator;

public class HashMap implements Map {

  public static final int INIT_LENGTH = 20;
  private List[] listArr = new List[INIT_LENGTH];
  private int size;

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }



  @Override
  public boolean containsKey(Object key) {
    if (key == null) {
      return false;
    }
    int hashCode = key.hashCode();
    List list = listArr[hashCode % INIT_LENGTH];
    if(list == null){
      return false;
    }
    Iterator iterator = list.iterator();
    while (iterator.hasNext()) {
      Entry entry = (Entry) iterator.next();
      if (entry.getKey().equals(key)) {
        return true;
      }
    }
    return false;
  }



  @Override
  public boolean containsValue(Object value) {
    for (int i = 0; i < listArr.length ; i++) {
      if(listArr[i] == null)
        continue;
      Iterator iterator = listArr[i].iterator();
      while (iterator.hasNext()) {
        Entry entry = (Entry) iterator.next();
        if(entry.getValue().equals(value))
          return true;
      }
    }
    return false;
  }

  @Override
  public Object get(Object key) {
    if (key == null) {
      return null;
    }

    int hashCode = key.hashCode();  //Object类的一个方法 得到Object对象的哈希值
    List list = listArr[hashCode % INIT_LENGTH];  //对得到的哈希值取余，通过哈希值找到对应的List数组位置
    if (list == null) {
      return null;
    }

    Iterator iterator = list.iterator();  //将找到的list放入迭代器
    while (iterator.hasNext()) {     //遍历迭代器 ，每个位置都有一个key
      Entry entry = (Entry) iterator.next(); //使用entry来得到key 构造方法的原因在构造的时候需要添加key值；
      if (entry.getKey().equals(key)) {    //比较各个位置的key与需要查询的key是否相同
        return entry.getValue();
      }
    }

    return null;
  }
  //根据key值来保存 value
  @Override
  public Object put(Object key, Object value) {
    if (key == null) {
      return null;
    }

    int hashCode = key.hashCode();    //key 的hashcode
    List list = listArr[hashCode % INIT_LENGTH]; //根据hashcode的值来找到一个位置
    if (list == null) {
      list = new ArrayList();         // 如果此时list上没有的话，新建list
      listArr[hashCode % INIT_LENGTH] = list;    //将list传入这个位置
    }
    Iterator iterator = list.iterator();         //list转换成迭代器
    while (iterator.hasNext()) {
      Entry entry = (Entry) iterator.next();   //遍历如果下一个不是空 就看下一个位置的k
      if (entry.getKey().equals(key)) {        //如果相同就覆盖
        entry.setValue(value);
        return value;
      }
    }
    list.add(new Entry(key, value));           //如果不同就新建 在创建的时候根据构造方法要将key值传入
    size++;
    return value;
  }


  @Override
  public Object remove(Object key) {
    if(!containsKey(key)){
      System.out.println("key值不正确");
      return null;
    }
    int hashCode = key.hashCode();
    List list = listArr[hashCode % INIT_LENGTH];
    Iterator iterator = list.iterator();
    while (iterator.hasNext()) {
      Entry entry = (Entry) iterator.next();
      if (entry.getKey().equals(key)) {
        Object obj = entry.getValue();
        list.remove(entry);
        size--;
        return obj;
      }
    }
    return null;
  }

}
