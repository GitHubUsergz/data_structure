package Queue;

public class CircleArrayQueue {
    public static void main(String[] args) throws Exception {
        Array1 array1 = new Array1(4);
        System.out.println(array1.ary[3]);

        array1.addArray(3);
        array1.addArray(4);
        array1.addArray(5);
        //array1.addArray(6);
        array1.displayArray();
        array1.headArray();

        /*for (int i = 0; i < 3; i++){
            System.out.println(array1.ary[i]);
        }*/
        /*for (int i = array1.front; i < array1.rear; i++){
            System.out.println(array1.ary[i]);
        }*/


        System.out.println("------------------------------------------");

        array1.removeArray();
        array1.removeArray();
        //array1.removeArray();
        //array1.removeArray();
        //array1.removeArray();
        array1.displayArray();
        array1.headArray();
        /*for (int i = 0; i < 4; i++){
            System.out.println(array1.ary[i]);
        }*/
        System.out.println("------------------------------");
        array1.addArray(7);
        array1.addArray(8);
        array1.displayArray();
        array1.headArray();
    }
}

class Array1{
    private int MaxSize;
    int front;
    int rear;
    int[] ary;

    public Array1(int maxSize) {
        MaxSize = maxSize;
        this.ary = new int[getMaxSize()];
        this.front = 0;
        this.rear = 0;
    }

    public int getMaxSize() {
        return MaxSize;
    }

    public void setMaxSize(int maxSize) {
        MaxSize = maxSize;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public boolean isFull(){
        //return  rear == MaxSize -1;
        return (rear + 1) % MaxSize == front;
    }

    public void addArray(int x) throws Exception {
        if (isFull()){
            throw new Exception("队列已满");
        }else {
            ary[rear] = x;
            rear = (rear + 1) % MaxSize;
            //rear = rear + 1;
        }
    }

    public void removeArray() throws Exception {
        if (isEmpty()){
            throw new Exception("队列已空");
        }else {
            ary[front] = 0;
            front = (front + 1) % MaxSize;
            //front = front + 1;
        }
    }

    public void displayArray() throws Exception {
        if (isEmpty()){
            throw new Exception("队列已空");
        }
        for (int i = front; i < front + size(); i++){
            System.out.printf("arr[%d]=%d\n", i % MaxSize,ary[i % MaxSize]);
        }
    }

    public int size(){
        return (rear + MaxSize - front) % MaxSize;
    }

    public void headArray() throws Exception {
        if (isEmpty()){
            throw new Exception("队列已空");
        }
        System.out.printf("头元素为ary[%d]=%d\n",front,ary[front]);
    }
}
