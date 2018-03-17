package com.mcii.repository.activeEnroll;

import org.springframework.stereotype.Repository;

import com.mcii.entity.Enroll;
import com.mcii.repository.DomainRepositoryImpl;
@Repository
public class ActiveEnrollDaoImpl  extends DomainRepositoryImpl<Enroll> implements ActiveEnrollDao {

}
