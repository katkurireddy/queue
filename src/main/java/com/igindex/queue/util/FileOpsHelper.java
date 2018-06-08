package com.igindex.queue.util;

import com.igindex.queue.model.Orders;
import org.apache.commons.io.FilenameUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class FileOpsHelper {

    private FileOpsHelper() {
    }

    public static Orders getOrderObject(String fileName) {
        File file = new File(fileName);
        Orders orders = null;
        if (validateFile(fileName)) {
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(Orders.class);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                orders = (Orders) unmarshaller.unmarshal(file);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        return orders;
    }

    public static boolean validateFile(String fileName) {
        return FilenameUtils.getExtension(fileName).equals("xml");
    }
}
