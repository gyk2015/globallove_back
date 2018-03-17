package com.mcii.repository.mood;

import org.springframework.stereotype.Repository;

import com.mcii.entity.Mood;
import com.mcii.repository.DomainRepositoryImpl;
@Repository
public class MoodDaoImpl  extends DomainRepositoryImpl<Mood>  implements MoodDao{

}
