package com.styyyds.bank.service;

import com.styyyds.bank.exception.AppException;
import com.styyyds.bank.exception.MoneyNotEnoughException;

/**
 * 账户业务类。
 * @author sty
 * @version 1.0
 * @since 1.0
 */
public interface AccountService {
    /**
     * 银行账户转账
     * @param fromActno 转出账户
     * @param toActno 转入账户
     * @param money 转账金额
     * @throws MoneyNotEnoughException 余额不足异常
     * @throws AppException App发生异常
     */
    void transfer(String fromActno,String toActno,double money) throws MoneyNotEnoughException, AppException;
}
