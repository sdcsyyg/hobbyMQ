package cn.edu.sdu.yyg.mq;

import java.util.HashSet;
import java.util.Set;

/**
 * 消息，
 * @author sdcsyyg
 */
public class Message {
    private Publisher publisher;
    private Set<Subscriber> subscribers = new HashSet<Subscriber>();
    private String body;
    // 优先级，TTL等

    public Message(){}

    public Message(String body){
        this.body = body;
    }
    public Message(String body, Publisher pub){
        this.body = body;
        this.publisher = pub;
    }

    public boolean addSubscriber(Subscriber sub) {
        return this.subscribers.add(sub);
    }

    public boolean removeSubscriber(Subscriber sub) {
        return  this.removeSubscriber(sub);
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Set<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Set<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
