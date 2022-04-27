package com.fp.mall.pay.service.impl;

import com.fp.mall.pay.entity.AccountEntity;
import com.fp.mall.pay.exception.BalanceNotEnoughException;
import com.fp.mall.pay.mapper.AccountMapper;
import com.fp.mall.pay.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private AccountMapper accountMapper;


    @Transactional
    @Override
    public void pay(Integer uid, Integer money) {

        // 查询余额是否充足
        AccountEntity accountEntity = accountMapper.selectById(uid);
        System.out.println(accountEntity);
        if (accountEntity.getBalance() < money) throw new BalanceNotEnoughException();

        // 扣减余额
        accountEntity.setBalance(accountEntity.getBalance() - money);
        accountMapper.updateById(accountEntity);

    }
}
