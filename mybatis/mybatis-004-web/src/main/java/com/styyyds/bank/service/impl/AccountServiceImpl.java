package com.styyyds.bank.service.impl;

import com.styyyds.bank.dao.AccountDao;
import com.styyyds.bank.exception.AppException;
import com.styyyds.bank.exception.MoneyNotEnoughException;
import com.styyyds.bank.pojo.Account;
import com.styyyds.bank.service.AccountService;
import com.styyyds.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountServiceImpl implements AccountService {

    //private AccountDao accountDao = new AccountDaoImpl();
    private AccountDao accountDao = (AccountDao) SqlSessionUtil.openSession().getMapper(AccountDao.class);
    @Override
    public void transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, AppException {
        //查询转出账户的余额
        Account fromAct = accountDao.selectByActno(fromActno);
        if(fromAct.getBalance() < money) {
            throw new MoneyNotEnoughException("对不起，您的余额不足！");
        }
        try{
            //程序如果执行到这里，则说明余额充足
            //修改账户余额
            Account toAct = accountDao.selectByActno(toActno);
            fromAct.setBalance(fromAct.getBalance() - money);
            toAct.setBalance(toAct.getBalance() + money);

            //更新数据库（添加事务）
            SqlSession sqlSession = SqlSessionUtil.openSession();
            accountDao.update(fromAct);
            //模拟异常
//            String s = null;
//            s.toString();

            accountDao.update(toAct);
            sqlSession.commit();//提交事务
            SqlSessionUtil.close(sqlSession);//关闭事务
        }catch(Exception e){
            throw new AppException("转账失败，未知原因！");
        }
    }
}
