public class DoublyLinkedList implements LinkedList{
    private Node2P head,tail;
    int size=0;

    public DoublyLinkedList(){
        head = tail = null;
    }

    public boolean isEmpty(){
        return(size==0);
    }

    public int size(){
        return size;
    }

    public void addFirst(Object inputData){
        Node2P baru = new Node2P(inputData);
        if (isEmpty()){
            head = baru;
            tail = baru;
            size++;
        }
        else{
            baru.next = head;
            head.prev = baru;
            head = baru;
            size++;
        }
    }
    public void addLast(Object inputData){
        Node2P baru = new Node2P(inputData);
        if (isEmpty()){
            head = baru;
            tail = baru;
            size++;
        }
        else{
            tail.next = baru;
            baru.prev = tail;
            tail = baru;
            size++;
        }
    }

    public void addAfter(int index,Object inputData){
        Node2P baru = new Node2P(inputData);
        if (isEmpty()){
            head = baru;
            tail = baru;
            size++;
        }
        else{
            Node2P temp = head;
            for(int i=0;i<index;i++){
                temp = temp.next;
            }
            baru.prev = temp;
            baru.next = temp.next;
            temp.next = baru;
            baru.next.prev = baru;
            size++;
        }
    }
    
    public void deleteFirst(){
        Node2P temp = head;
        if (!isEmpty()){ 
            if (head == tail)
                head = tail = null;
            else
            {
                head.next.prev = null;
                head = temp.next;
            } size--;
        }
        else
            System.out.println("List kosong!");
    }

    public void deleteLast(){
        Node2P temp = tail;
        if (!isEmpty()){
            if (tail == head){
                head = tail = null;
            }
            else {
                tail.prev.next = null;
                tail=temp.prev;
            } size--;
        }
        else System.out.println("List kosong!");

    }
    public void deleteAfter(int index){
        Node2P temp = head;
        if(index < size-2){
            for(int i=0;i<index;i++){
                temp = temp.next;
            }
            temp.next.next.prev = temp;
            temp.next = temp.next.next;
            size--;
        }
        else if(index==size-2){//menghapus tail
            this.deleteLast();
        }
        else{
            System.out.println("Index lebih besar atau sama dari ukuran list");
        }

    }


    public void print(){
        Node2P currentNode = head;
        for(int i =0;i<size;i++){
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    @Override
    public Object get(int index) {
        // TODO digunakan untuk mengembalikan data pada index ke-i dimulai dari head. Head memiliki index 0
        Node2P tmp = head;
        if (tmp == null) return null;
            try {
                if (index > size) throw new ExceptionInInitializerError("Out of bound");
            } catch (ExceptionInInitializerError e) {
                return "Exception Error, out Of Bound!";
            }
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.data;
    }
    @Override
    public int indexOf(Object targetData) {
        // TODO digunakan mencari kemunculan pertama targetData pada linked list dan mengembalikan indeksnya. Indeks dari head adalah 0. Jika tidak ada targetData pada linked list, kembalikan nilai -1 
        Node2P tmp = head;
        if (tmp == null) {}
        else {
            int i = 0;
            while (tmp != null) {
                if (tmp.data == targetData) return i;
                tmp = tmp.next; i++;                  
            }
        }
        return -1;
    }
    @Override
    public void printReverse() {
        // TODO digunakan untuk mencetak data pada linked list dengan urutan terbalik, dari tail ke head.
        Node2P curr = tail;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.prev != null) System.out.print(" <-> ");
            curr = curr.prev;
        }
        System.out.println();
    }
    @Override
    public boolean remove(Object targetData) {
        // TODO digunakan untuk mencari dan menghapus node dengan data=targetData pada linked list serta mengembalikan nilai True jika berhasil, dan False jika targetData tidak ada di linkedList
        boolean rm = false;
        Node2P curr = head;
        if (head.data == targetData) {
                head = head.next;
                head.prev = null;
                rm = true;
        }
        while (curr != null && !rm) {
            if (curr.data == targetData) {
                if (tail.data == targetData) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                }
                rm = true;
            }
            curr.prev = curr;
            curr = curr.next;
        } 
        if (rm) size--;
        return rm;
    }
    @Override
    public Object[] toArray() {
        // TODO digunakan untuk mendapatkan keseluruhan data pada node-node di linked list dalam bentuk array. Data-data pada array disusun secara urut mulai dari head sampai dengan tail.
        if (head != null) {
            Object[] tmp = new Object[size];
            Node2P curr = head;
            System.out.print("[");
            for (int i = 0; i < size; i++) {
                tmp[i] = curr.data;
                System.out.print(tmp[i]); 
                if (i != size - 1) {
                    System.out.print(","); 
                } else {
                    System.out.print("]");
                }   
                curr = curr.next;
            }
            System.out.println();
            return tmp;
        }
        return null;
    }
}
