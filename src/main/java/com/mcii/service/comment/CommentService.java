package com.mcii.service.comment;

import com.mcii.entity.Comment;
import com.mcii.service.BaseService;
import com.mcii.tools.PageRecord;

public interface CommentService extends BaseService<Comment>{
	//添加评论
	void add(Comment comment);
	//	获取评论
	PageRecord getCommentByTargetid(Integer page, Integer pageSize, Integer targetid,Integer targettype);

}
