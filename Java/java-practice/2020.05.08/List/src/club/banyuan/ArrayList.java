package club.banyuan;

public class ArrayList implements List {
   private static  int INIT_ARRAYLIST_LENGTH = 10;
   private  Object[] arrayList = new Object[INIT_ARRAYLIST_LENGTH];
   private static int size;
  @Override
  public Object set(int index, Object element) {
    if (index >= arrayList.length) {
      System.out.println("下标不合法");
      return null;
    } //下面已进行了判断，可以不再进行判断
    Object replaceElement = get(index);
    arrayList[index] = element;
    return replaceElement;
  }

  @Override
  public Object get(int index) {
    if (index >= arrayList.length) {
      System.out.println("下标不合法");
      return null;
    }
    return arrayList[index];
  }

  @Override
  public void clear() {
    for (int i = 0; i < arrayList.length; i++) {
      arrayList[i] = null;
    }//arrays fill
  }

  @Override
  public Object remove(int index) {
    if (index >= arrayList.length) {
      System.out.println("下标不合法");
      return null;
    }//
    Object removeIndexElement = get(index);
    for (int i = index; i < arrayList.length - 1 ; i++) {
      arrayList[i] = arrayList[i+1];
    }
    arrayList[arrayList.length-1] = null;   //用size
    return removeIndexElement;
  }


  @Override
  public boolean remove(Object o) {
    boolean isTrue = false;
    for (int i = 0; i < arrayList.length ; i++) {
      if(arrayList[i] == o){  //.equals  ==是判断地址是否相同 可以重写equals方法 在保存的内里 判断的灵活性
        for (int j = i; j < arrayList.length - 1; j++) {
          arrayList[j] = arrayList[j+1];
        }
        arrayList[arrayList.length-1] = null;
        i--;
        isTrue = true;
      }
    }
    return isTrue;
  }

  @Override
  public boolean add(Object o) {
    if(arrayList[arrayList.length-1] != null)
       arrayListDilatation();
    for (int i = 0; i < arrayList.length; i++) {
      if(arrayList[i] == null){
        arrayList[i] = o;
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean isEmpty() {
    for (int i = 0; i < arrayList.length ; i++) {
      if(arrayList[i] != null) {
        return false;
      }
      return true;
    }

  }

  @Override
  public int size() {
    int size = 0;
    for (int i = 0; i < arrayList.length ; i++) {
      if(arrayList[i] != null)
        size++;
      else
        continue;
    }
    return size;
  }

  /**
   * 数组扩容
   *
   */
  private void arrayListDilatation(){   //在方法内部不希望别人来对此进行修改，内部方法在内部使用
    INIT_ARRAYLIST_LENGTH = INIT_ARRAYLIST_LENGTH*2;
    Object[] arrayListDilatation = new Object[INIT_ARRAYLIST_LENGTH];
    for (int i = 0; i < arrayList.length ; i++) {
         arrayListDilatation[i] = arrayList[i];  //arraycopy
    }
    arrayList = arrayListDilatation;
  }
}

