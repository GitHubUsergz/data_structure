package Queue;

public class ArrayQueue {
    public static void main(String[] args) throws Exception {
        Array array = new Array(5);
        System.out.println(array.ary[1]);

        array.addArray(3);
        array.addArray(4);
        array.addArray(5);
        array.addArray(6);
        array.addArray(7);

        for (int i = 0; i < 5; i++){
            System.out.println(array.ary[i]);
        }

        array.removeArray();
        array.removeArray();
        array.removeArray();
        array.removeArray();
        array.removeArray();
        array.removeArray();

    }
}

class Array{
    private int MaxSize;
    int front;
    int rear;
    int[] ary;

    public Array(int maxSize) {
        MaxSize = maxSize;
        this.ary = new int[getMaxSize()];
        this.front = -1;
        this.rear = -1;
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
        return rear == MaxSize - 1;
    }

    public void addArray(int x) throws Exception {
        if (isFull()){
            throw new Exception("队列已满");
        }else {
            rear = rear + 1;
            ary[rear] = x;
        }
    }

    public void removeArray() throws Exception {
        if (isEmpty()){
            throw new Exception("队列已空");
        }else {
            ary[front + 1] = 0;
            front = front + 1;
        }
    }
}
