package com.farzoom.lime.ehd.mapper;

import com.farzoom.common.persistence.es.model.Company;
import com.farzoom.common.persistence.es.model.Order;
import com.farzoom.lime.ehd.model.OrderRecord;

public class OrderMapper {

    public OrderRecord mapToOrders(Order order, Company company, String orderChannel) {
        OrderRecord orderRecord = new OrderRecord();
        orderRecord.setAPPLICATION_ID(order.getId());
        orderRecord.setAPPLICATION_NUM(order.getOrderNumber());
        orderRecord.setBEGIN_DATE(order.getCreatedDateTime());
        orderRecord.setEND_DATE(order.getExecutedDateTime());
        orderRecord.setCHANNEL_NAME_TXT(orderChannel);
        orderRecord.setCLIENT_NAME_TXT(company.getShortName());
        orderRecord.setCREATION_NAME_TXT(order.getInitiator().getFullName());
        orderRecord.setINN_TXT(company.getINN());
     //   orderRecord.setRegistrationDepartmentTxt();  TODO непонятно откуда брать
     //   orderRecord.setTech$changeDate(); TODO технические поля по идее заполняются на уровне базы - уточнить
    //    orderRecord.setTech$insAuditId();
     //   orderRecord.setTech$rowStatus();
        return orderRecord;
    }

}
