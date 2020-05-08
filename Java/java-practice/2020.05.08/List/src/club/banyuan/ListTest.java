package club.banyuan;

public class ListTest {

  public static void main(String[] args) {
    //测试链表列表
    /*List list = new LinkedList();
    list.add(15);
    list.add(12);
    list.add("sun");
    list.add(14);
    list.add(16);
    list.add("sun");
    list.add(13);
    list.add("sdd");
    list.add("sun");
    printList(list);
    list.remove("sun");
    printList(list);
    list.clear();
    printList(list);
    System.out.println(list.isEmpty());*/


    //测试数组列表
    List arrayList = new ArrayList();
    arrayList.add(222);
    arrayList.add(3);
    arrayList.add("sin");
    arrayList.add(14);
    arrayList.add(16);
    arrayList.add("sun");
    arrayList.add(13);
    arrayList.add("sdd");
    arrayList.add("sun");
    printList(arrayList);
    arrayList.remove("sun");
    printList(arrayList);
    arrayList.clear();
    printList(arrayList);
    System.out.println(arrayList.isEmpty());
    System.out.println(arrayList.size());
  }

  public static void printList(List list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.println("[" + i + "]=" + list.get(i));
    }
  }
}



