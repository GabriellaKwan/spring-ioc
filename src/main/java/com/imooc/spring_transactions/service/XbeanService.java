package com.imooc.spring_transactions.service;

import com.mooc.beans.Xbean;

public interface XbeanService {
    Xbean getXbean(int id);
    void insertXbean(Xbean xb);
}
