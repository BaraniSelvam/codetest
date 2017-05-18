package com.gcd.services;


import com.gcd.dao.DatabaseService;
import com.gcd.dao.GCDRepository;
import com.gcd.utility.QueueUtility;
import jaxwsGenerated.GCDService;

import java.util.List;

public class GCDSoapServiceImpl implements GCDService {
    QueueUtility queueUtility;

    public GCDSoapServiceImpl(GCDRepository gcdRepository) {
        this.queueUtility = new QueueUtility(new DatabaseService(gcdRepository));
    }

    @Override
    public int gcdSum() {
        return queueUtility.gcdSum();
    }

    @Override
    public List<String> gcdList() {
        return queueUtility.gcdList();
    }

    @Override
    public int gcd() {
        return 0;
    }
}
