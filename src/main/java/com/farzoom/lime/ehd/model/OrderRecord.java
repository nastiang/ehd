package com.farzoom.lime.ehd.model;

import lombok.Data;

import java.util.Date;

@Data
public class OrderRecord {
    public Date TECH$CHANGE_DATE;
    public Integer TECH$INS_AUDIT_ID;
    public String TECH$ROW_STATUS;
    public String APPLICATION_ID;
    public String APPLICATION_NUM;
    public String INN_TXT;
    public String CLIENT_NAME_TXT;
    public Date BEGIN_DATE;
    public Date END_DATE;
    public String CHANNEL_NAME_TXT;
    public String CREATION_NAME_TXT;
    public String REGISTRATION_DEPARTMENT_TXT;
}
