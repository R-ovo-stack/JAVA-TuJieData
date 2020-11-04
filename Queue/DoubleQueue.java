package Queue;

class QNode {
    int data;
    QNode next;

    // 构造
    public QNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DoubleQueue {
    public QNode front; // 队列前端指针
    public QNode rear; // 队列尾端指针

    public DoubleQueue() {
        this.front = null;
        this.rear = null;
    }

    // 入队
    public boolean enqueue(int value) {
        QNode node = new QNode(value); // 建立结点
        // 检查是否为空队列
        if (rear == null)
            front = node; // 将建立的结点成为第一个结点
        else
            rear.next = node; // 尾端指针指向新加入的结点
        rear = node;
        return true;
    }

    // 出队
    public int dequeue(int action) {
        int value;
        QNode tempNode, startNode;
        // 从前端取出数据
        if (!(front == null) && action == 1) {
            if (front == rear)
                rear = null;
            value = front.data;// 将队列数据从前端取出
            front = front.next; // 将队列的前端指针指向下一个
            return value;
        }
        // 从尾端取出数据F
        else {
            if (!(rear == null) && action == 2) {
                startNode = front; // 先记下前端的指针值
                value = rear.data;// 取出当前尾端的数据
                // 查找最尾端结点的前一个结点
                tempNode = front;
                while (front.next != rear && front.next != null) {
                    front = front.next;
                    tempNode = front;
                }
                front = startNode; // 记录从尾端取出数据后的队列的前端指针
                rear = tempNode; // 记录从尾端取出数据后的队列尾端指针

                // 下一列程序是指当队列中仅剩最后一个结点时，取出数据后便将front及rear指向Null
                if ((front.next == null) || (rear.next == null)) {
                    front = null;
                    rear = null;
                }
                return value;
            } else
                return -1;
        }
    }
}
