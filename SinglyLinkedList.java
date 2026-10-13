/**
 * SinglyLinkedList
 */
public class SinglyLinkedList implements LinkedList{

    public Node head,tail;
    private int size=0;

    public SinglyLinkedList(){
        head=tail=null;
    }
    public boolean isEmpty(){
        return(size==0);
    }
    public int size(){
        return size;
    }
    public void addFirst(Object inputData){
        Node baru = new Node(inputData);
        if (isEmpty()){
            head = baru;
            tail = baru;
            size++;
        }
        else {
            baru.pointer = head;
            head = baru;
            size++;
        }
    }

    public void addLast(Object inputData){
        Node baru = new Node(inputData);
        if (isEmpty()){
            head = baru;
            tail = baru;
            size++;
        }
        else {
            tail.pointer = baru;
            tail = baru;
            size++;
        }
    }

    public void addAfter(int index,Object inputData){
        Node baru = new Node(inputData);
        Node C=head;
        for(int i=0;i<index;i++){
            C = C.pointer;
        }
        baru.pointer = C.pointer;
        C.pointer = baru;
    }

    public void deleteFirst(){
        if(isEmpty()){
            System.err.println("Linked list kosong");
        }
        else if(size==1){//else if(head==tail)
            head = null;
            tail = null;
            size--;
        }
        else{
            head = head.pointer;
            size--;
        }
    }

    public void deleteLast(){
        if(isEmpty()){
            System.err.println("Linked list kosong");
        }
        else if(size==1){//else if(head==tail)
            head = null;
            tail = null;
            size--;
        }
        else{
            Node temp = head;
            for(int i=1;i<size;i++){
                temp = temp.pointer;
            }
            tail = temp;
            tail.pointer = null;
            size--;
        }
    }

    public void deleteAfter(int index){
        if(isEmpty()){
            System.err.println("Linked list kosong");
        }
        else if(size==1){//else if(head==tail)
            head = null;
            tail = null;
            size--;
        }
        else{
            Node temp = head;
            for(int i=0;i<index;i++){
                temp = temp.pointer;
            }
            temp.pointer = temp.pointer.pointer;
            size--;
        }
    }

    public void print(){
        Node currentNode = head;
        for(int i =0;i<size;i++){
            System.out.println(currentNode.data);
            currentNode = currentNode.pointer;
        }
    }
    @Override
    public Object get(int index) {
        // TODO digunakan untuk mengembalikan data pada index ke-i dimulai dari head. Head memiliki index 0
        Node tmp = head;
        if (tmp == null) return null;
        try {
            if (index > size) throw new ExceptionInInitializerError("Out of bound");
        } catch (ExceptionInInitializerError e) {
            return "Exception Error, Out Of Bound!";
        }
        for (int i = 0; i < index; i++) {
            tmp = tmp.pointer;
        }
        return tmp.data;
    }
    @Override
    public int indexOf(Object targetData) {
        // TODO digunakan mencari kemunculan pertama targetData pada linked list dan mengembalikan indeksnya. Indeks dari head adalah 0. Jika tidak ada targetData pada linked list, kembalikan nilai -1 
        Node tmp = head;
        if (tmp == null) {}
        else {
            int i = 0;
            while (tmp != null) {
                if (tmp.data == targetData) return i;
                tmp = tmp.pointer; i++;                  
            }
        }
        return -1;
    }
    @Override
    public void printReverse() {
        // TODO digunakan untuk mencetak data pada linked list dengan urutan terbalik, dari tail ke head.
        Node curr = head, prev = null, next;
        while (curr != null) {
            next = curr.pointer;

            curr.pointer = prev;
            
            prev = curr;
            curr = next;
        }

        while (prev != null) {
            System.out.print(prev.data);
            if (prev.pointer != null) System.out.print(" -> ");
            prev = prev.pointer;
        }
        System.out.println();
    }

    public SinglyLinkedList copy() {
        SinglyLinkedList copy = new SinglyLinkedList();
        Node curr = head;
        while (curr != null) {
            copy.addLast(curr.data);
            curr = curr.pointer;
        }
        return copy;
    }

    @Override
    public boolean remove(Object targetData) {
        // TODO digunakan untuk mencari dan menghapus node dengan data=targetData pada linked list serta mengembalikan nilai True jika berhasil, dan False jika targetData tidak ada di linkedList
        boolean rm = false;
        Node curr = head, prev = null;
        if (head.data == targetData) {
                head = head.pointer;
                rm = true;
        }
        while (curr != null) {
            if (curr.data == targetData) {
                if (curr == tail) {
                    tail = prev;
                    tail.pointer = null;
                } else {
                    prev.pointer = curr.pointer;
                }

                rm = true;
            }
            prev = curr;
            curr = curr.pointer;
        }
            
        if (rm) size--;
        return rm;
    }
    @Override
    public Object[] toArray() {
        // TODO digunakan untuk mendapatkan keseluruhan data pada node-node di linked list dalam bentuk array. Data-data pada array disusun secara urut mulai dari head sampai dengan tail.
        if (head != null) {
            Object[] tmp = new Object[size];
            Node curr = head;
            for (int i = 0; i < size; i++) {
                if (curr == null) break;
                tmp[i] = curr.data;
                curr = curr.pointer;
            }
            return tmp;
        }

        return null;
    }
}
