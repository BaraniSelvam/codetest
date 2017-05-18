package com.gcd.dto;

import javax.xml.bind.annotation.XmlAccessorType;
import java.util.List;

@XmlAccessorType
public class QueueDTO {

    public List<QueueObj> queueObjList;

    public QueueDTO() {
    }

    public QueueDTO(List<QueueObj> queueObjList) {
        this.queueObjList = queueObjList;
    }

    public List<QueueObj> getQueueObjList() {
        return queueObjList;
    }

    public void setQueueObjList(List<QueueObj> queueObjList) {
        this.queueObjList = queueObjList;
    }
}
