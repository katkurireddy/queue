package com.igindex.queue.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Order")
public class Order {

    @XmlElement(name = "account")
    private String account;

    @XmlElement(name = "SubmittedAt")
    private String submittedAt;

    @XmlElement(name = "ReceivedAt")
    private String receivedAt;

    @XmlElement(name = "market")
    private String market;

    @XmlElement(name = "action")
    private String action;

    @XmlElement(name = "size")
    private String size;

    public String getAccount() {
        return account;
    }

    public String getSubmittedAt() {
        return submittedAt;
    }

    public String getReceivedAt() {
        return receivedAt;
    }

    public String getMarket() {
        return market;
    }

    public String getAction() {
        return action;
    }

    public String getSize() {
        return size;
    }
}
