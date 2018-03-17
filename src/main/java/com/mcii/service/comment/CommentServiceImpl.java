package com.mcii.service.comment;

import java.io.Serializable;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;





import com.mcii.entity.Comment;
import com.mcii.repository.comment.CommentDao;
import com.mcii.tools.PageRecord;
import com.mcii.tools.Tool;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{
	
	@Autowired 
	@Qualifier("commentDaoImpl")
	CommentDao commentDao;

	@Override
	public Comment get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable save(Comment entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Comment entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Comment entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Comment comment) {
		// TODO Auto-generated method stub
		commentDao.save(comment);
	}

	@Override
	public PageRecord getCommentByTargetid(Integer page, Integer pageSize, Integer targetid,Integer targettype) {
		// TODO Auto-generated method stub
		String hql = "from Comment where targetid=?0 and targettype=?1";
		Query<Comment> query = commentDao.queryByHql(hql);
		query.setParameter(0, targetid);
		query.setParameter(1, targettype);
		return Tool.pageList(page,pageSize,query);
	}

}
