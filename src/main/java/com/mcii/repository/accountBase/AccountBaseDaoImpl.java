package com.mcii.repository.accountBase;

import org.springframework.stereotype.Repository;

import com.mcii.entity.AccountBase;
import com.mcii.repository.DomainRepositoryImpl;
import com.mcii.repository.account.AccountDao;

@Repository
public class AccountBaseDaoImpl extends DomainRepositoryImpl<AccountBase> implements AccountBaseDao{

}
