import java.util.Arrays;

class CircularArrayQueue<T>  {
    T queue[];
    int front, rear;
    int numElements;
    final static int DEFAULT_CAPACITY = 10;
    
    public CircularArrayQueue(){
        queue = (T [])(new Object[DEFAULT_CAPACITY]);
        front = rear = 0;
        numElements = 0;
    }
    
    public CircularArrayQueue(int init_capacity){
        queue = (T [])(new Object[init_capacity]);
        front = rear = 0;
        numElements = 0;
    }

    public void enqueue(T element) {
        if (numElements == queue.length){
            expandCapacity();
        }
        //TODO
        queue[numElements] = element;
        rear = (rear + 1) % queue.length;
        this.numElements++;
    }

    public T first() throws Exception{
        if (this.isEmpty()) 
            return null;

        return this.queue[front];
    }   

    public T dequeue() {
        if (this.isEmpty()) 
            return null;

        T temp = this.queue[front];
        front = (front + 1) % queue.length;
        this.numElements--;
        return temp;
    }

    public boolean isEmpty() {
        return this.numElements == 0? true : false;
    }

    public int size() {
        return this.numElements;
    }
    
    private void expandCapacity() { 
        this.queue = Arrays.copyOf(this.queue, this.queue.length * 2); 
    }
}

public class Main {
    public static void main(String[] args) {
        CircularArrayQueue<Integer> queue = new CircularArrayQueue<Integer>();
        queue.enqueue(4);
        try {
            System.out.println("The first in queue is " + queue.first().intValue());
        } catch (Exception ex) {
          ex.printStackTrace();
        }

        queue.enqueue(6);
        queue.dequeue();
        try {
            System.out.println("After dequeue(), the first in queue is " + queue.first().intValue());
        } catch (Exception ex) {
          ex.printStackTrace();
        }
    }
}