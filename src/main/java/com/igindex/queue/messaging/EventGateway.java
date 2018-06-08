package com.igindex.queue.messaging;

import com.igindex.queue.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
public class EventGateway {

    @Autowired
    private Queue queue;

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(Orders orders) {
        try {
            jmsTemplate.convertAndSend(queue, orders);
        } catch (JmsException e) {
            e.printStackTrace();
        }
    }
}

