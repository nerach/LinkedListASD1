/**
 * testSinglyLinkedList
 */
public class testSinglyLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addFirst(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(6);
        System.out.println(linkedList.get(2)); // menghasilkan nilai 3
        System.out.println(linkedList.get(12)); //Terjadi exception error
        System.out.println(linkedList.indexOf(4));// menghasilkan 3
        System.out.println(linkedList.indexOf(10));// menghasilkan -1
        SinglyLinkedList linkedListCopy = linkedList.copy();

        linkedListCopy.printReverse(); // Menghasilkan 6,5,4,3,2,1
        System.out.println(linkedList.remove(3)); // Menghasilkan True
        System.out.println(linkedList.remove(8)); // Menghasilkan False
        Object[] tmp = linkedList.toArray();
        for (int i = 0; i < tmp.length; i++) {
            System.out.print(tmp[i] + " "); //Menghasilkan [6,5,4,3,2,1]
        }
    }
}