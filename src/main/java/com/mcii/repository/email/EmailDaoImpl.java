package com.mcii.repository.email;

import org.springframework.stereotype.Repository;

import com.mcii.entity.Email;
import com.mcii.repository.DomainRepositoryImpl;
@Repository
public class EmailDaoImpl extends DomainRepositoryImpl<Email> implements EmailDao {

}
