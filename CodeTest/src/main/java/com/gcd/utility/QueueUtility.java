package com.gcd.utility;

import com.gcd.dao.DatabaseService;
import com.gcd.dto.QueueObj;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class QueueUtility {
    static Queue myQueue = new SynchronousQueue();

    DatabaseService databaseService;

    public QueueUtility(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public List<QueueObj> getListOfValues() {
        return databaseService.getAll();
    }

    public void push(int integer1, int integer2) throws Exception {
        databaseService.save(integer1, integer2);
        myQueue.add(new QueueObj(integer1,integer2));
    }

    public int gcdSum(){
        return databaseService.getGCDSum();
    }

    public List<String> gcdList(){
        return databaseService.getAllGCD();
    }

    public int gcd(){
        QueueObj queueObj  = (QueueObj) myQueue.poll();
        return GCDCalculator.calculateGCD(queueObj.value1, queueObj.value2);
    }

}
