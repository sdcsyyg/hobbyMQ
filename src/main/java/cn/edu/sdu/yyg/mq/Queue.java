package cn.edu.sdu.yyg.mq;

/**
 * 消息队列
 * TODO ： 并发情况下的数据可能会不一致，尤其是size属性
 * @author sdcsyyg
 */
public class Queue {

    private QueueNode front = null;
    private QueueNode rear = null;
    private int size = 0;

    public Queue() {}

    public Queue(QueueNode front) {
        this.front = this.rear = front;
        this.size = 1;
    }

    /**
     * 入队列
     * @param m 将m入队
     */
    public void into(Message m) {
        QueueNode node = new QueueNode(m);
        if( isEmpty() ) {
            this.front = this.rear = node;
        } else {
            this.rear.setNext(node);
            this.rear = node;
        }
        this.size ++;
    }

    /**
     * 出队列
     * @return 返回队首消息
     */
    public Message out() {
        if( isEmpty() ) {
            return null;
        }
        Message ret = this.front.getMessage();
        if( this.front == this.rear ) {
            this.empty();
        } else {
            this.front = front.getNext();
        }
        this.size --;
        return ret;
    }

    /**
     * 清空一个队列
     */
    public void empty() {
        this.front = this.rear = null;
        this.size = 0;
    }

    /**
     * 判断是否为空队列
     * @return true if is empty, or false if not.
     */
    public boolean isEmpty() {
        return this.front == null && this.rear==null;
    }

    public int size() {
        if( this.size < 0 ) {
            // TODO : 这是因为并发修改造成的，should be refined.
        }
        return this.size;
    }

    private static class QueueNode {
        private Message message;
        private QueueNode next;
        public QueueNode(Message m){
            this.message = m;
            this.next = null;
        }
        public Message getMessage() {
            return message;
        }
        public void setMessage(Message message) {
            this.message = message;
        }
        public QueueNode getNext() {
            return next;
        }
        public void setNext(QueueNode next) {
            this.next = next;
        }
    }

    public QueueNode getFront() {
        return front;
    }

    public void setFront(QueueNode front) {
        this.front = front;
    }

    public QueueNode getRear() {
        return rear;
    }

    public void setRear(QueueNode rear) {
        this.rear = rear;
    }
}
