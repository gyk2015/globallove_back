package com.mcii.repository.photo;

import org.springframework.stereotype.Repository;

import com.mcii.entity.Photo;
import com.mcii.repository.DomainRepositoryImpl;

@Repository
public class PhotoDaoImpl extends DomainRepositoryImpl<Photo> implements PhotoDao{

}
