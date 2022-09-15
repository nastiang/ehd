package com.farzoom.lime.ehd.repository;

import com.farzoom.lime.ehd.model.OrderRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EhdRepository {
    public void insertAll(List<OrderRecord> orderRecords) {
        //TODO запрос id для вставки, затем инсерт
    }
}
