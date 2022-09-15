package com.farzoom.lime.ehd.service;

import com.farzoom.lime.ehd.model.OrderRecord;
import com.farzoom.lime.ehd.repository.EhdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EhdService {
    private final EhdRepository ehdRepository;
    private final OrderService orderService;

    public void fetchDataAndInsert(){
        List<OrderRecord> orderRecords = orderService.getAllOrderRecords();
        ehdRepository.insertAll(orderRecords);
    }
}
