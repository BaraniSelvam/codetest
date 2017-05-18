package com.gcd.dao;

import com.gcd.dto.QueueObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseService {

    GCDRepository gcdRepository;

    @Autowired
    public DatabaseService(GCDRepository gcdRepository) {
        this.gcdRepository = gcdRepository;
    }

    public void save(int integer1, int integer2) {
        GCDEntity gcd = new GCDEntity(integer1, integer2);
        gcdRepository.save(gcd);
    }

    public List<QueueObj> getAll() {
        return fromEntity(gcdRepository.findAll());
    }

    public List<QueueObj> fromEntity(List<GCDEntity> all) {
        List<QueueObj> list = new ArrayList<>();
        all.forEach(a -> {
            list.add(new QueueObj(a.number1, a.number2, a.gcd));
        });
        return list;
    }

    public List<String> getAllGCD(){
        List<GCDEntity> allGCD = gcdRepository.getAllGCD();
        List<String> list = new ArrayList<>();
        allGCD.forEach(a -> {
            list.add(String.valueOf(a.getGcd()));
        });
        return list;

    }

    public int getGCDSum(){
        return gcdRepository.getGCDSum();
    }


}
