package com.gcd.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface GCDRepository extends CrudRepository<GCDEntity, Long> {

    List<GCDEntity> findAll();

    GCDEntity save(GCDEntity gcd);

    @Query("select c from GCDEntity c where c.FirstValue = :number1 and c.secondValue = :number2 order by id")
    List<GCDEntity> findBy(@Param("number1") int number1, @Param("number2") int number2);

    @Query("select c from GCDEntity c where c.GCD is not null")
    List<GCDEntity> getAllGCD();

    @Query("select sum(GCD) from GCDEntity c where c.GCD is not null group by c.gcd")
    int getGCDSum();


}
