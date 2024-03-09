package week2;

public class QueueBasedStack<Data> {
    private Queue<Data> q1;
    private Queue<Data> q2;

    public QueueBasedStack() {
        q1 = new Queue<Data>();
        q2 = new Queue<Data>();
    }

    public void push(Data data) {
        //Node<Data> newNode = new Node<Data>();
        //newNode.data = data;
        q2.enqueue(data);
        while (! q1.isEmpty()) {
            q2.enqueue( q1.dequeue() );
        }
        Queue<Data> temp = new Queue<>();
        temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public Data pop() {
        return q1.dequeue();
    }

    public Data peek() {
        return q1.peek();
    }

    public int size() {
        return q1.size();
    }

    public boolean isEmpty() {
        return q1.isEmpty(); //because q2 is a helper queue
    }
}
