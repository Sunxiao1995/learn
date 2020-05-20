package club.banyuan;
import java.util.Iterator;

public class Pairs<K, V> implements Iterable<Pair<K, V>> {

  /* 声明一对对象的固定大小的数组（最多10个元素） */
    private Pair<K,V>[] pairs = new Pair[10];
    private int pairsCount = 0;

    /**
   * 创建一个集合，该集合将存储成对添加的项目。
   */
  public Pairs() {
  }

  /**
   * 创建一个新的对，并在有空间的情况下将其添加到集合中。
   *
   * @param first  The first object.
   * @param second The second object.
   */
  public boolean addPair(K first, V second) {
      if(pairsCount == pairs.length){
          return false;
      }
      pairs[pairsCount] = new Pair<K,V>(first,second);
      pairsCount++;
    return true;
  }


  @Override
  public Iterator<Pair<K, V>> iterator() {

    return new PairIterator();
  }

  /*
   * 根据以下位置的API文档在此处实现迭代器
   * https://docs.oracle.com/javase/10/docs/api/java/util/Iterator.html
   * 按照规定抛出异常
   */
  private class PairIterator implements Iterator<Pair<K, V>> {
      private int next = 0;
      private int current =-1;


    @Override
    public boolean hasNext() {
        if(next == pairsCount){
            return false;
        }
        if(pairs[next] instanceof Pair ){
            return next != pairsCount;
        }else {
      throw new UnsupportedOperationException();
    }
    }

    /**
     * 返回迭代器中的下一个对象
     */
    @Override
    public Pair<K, V> next() {
        if(pairs[next] instanceof Pair ) {
            current++;
            return pairs[next++];
        }else {
      throw new UnsupportedOperationException();}
    }

    /**
     * 从集合中移除next（）返回的上一个对象。
     */
    @Override
    public void remove() {
        if(next == pairsCount){
           pairs[next] =null;
           pairsCount--;
        }
        if(pairsCount == 0){
      throw new UnsupportedOperationException();}
        remove(current);
        current--;
        next--;
    }
    private void remove(int index){
        for (int i = index; i < pairsCount-1; i++) {
            pairs[i] = pairs[i+1];
        }
        pairs[pairsCount - 1] = null;
        pairsCount -- ;

    }

  }

}