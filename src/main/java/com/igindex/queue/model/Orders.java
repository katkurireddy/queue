package com.igindex.queue.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="Orders")
public class Orders {

    @XmlElement(name = "Order")
    List<Order> orderList = new ArrayList<>();

    public List<Order> getOrderList() {
        return orderList;
    }

    public void add(Order order) {
        if(this.orderList == null) {
            this.orderList = new ArrayList<>();
        }
        this.orderList.add(order);
    }
}
