package com.farzoom.lime.ehd.service;

import com.farzoom.common.business.genparam.GenParamService;
import com.farzoom.common.persistence.es.model.Company;
import com.farzoom.common.persistence.es.model.Order;
import com.farzoom.common.persistence.es.repositories.OrderRepository;
import com.farzoom.lime.ehd.mapper.OrderMapper;
import com.farzoom.lime.ehd.model.OrderRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository esOrderRepository;
    private final CompanyService companyService;
    private final GenParamService genParamService;
    private final OrderMapper orderMapper;

    String CHANNEL_TYPE_FIELD = "order.rko.channelType";

    public List<OrderRecord> getAllOrderRecords() {
        List<Order> orders = esOrderRepository.searchAll("orderTypeRefId:rko", "30s");
        Map<Order, Company> orderToCompanyMap = orders.stream()
                .collect(Collectors.toMap(
                        order -> order,
                        this::getCompanyByOrder));
        Map<Order, String> orderToChannelMap = orders.stream()
                .collect(Collectors.toMap(
                        order -> order,
                        this::getGenparamOrderChannelByOrder
                ));

        return orders.stream().map(
                        t ->
                                orderMapper.mapToOrders(t, orderToCompanyMap.get(t), orderToChannelMap.get(t)))
                .collect(Collectors.toList());

    }

    private Company getCompanyByOrder(Order order) {
        return companyService.getCompanyByPrincipalCompanyId(order.getPrincipalCompanyId());
    }

    private String getGenparamOrderChannelByOrder(Order order) {
        return genParamService
                .loadOne("order", order.getId(), CHANNEL_TYPE_FIELD)
                .getValue()
                .getKeyValue();
    }
}
