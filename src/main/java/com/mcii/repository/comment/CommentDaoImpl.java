package com.mcii.repository.comment;

import org.springframework.stereotype.Repository;

import com.mcii.entity.Comment;
import com.mcii.repository.DomainRepositoryImpl;
@Repository
public class CommentDaoImpl extends DomainRepositoryImpl<Comment> implements CommentDao{

}
