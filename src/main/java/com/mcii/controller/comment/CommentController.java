package com.mcii.controller.comment;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import com.mcii.entity.Account;
import com.mcii.entity.Comment;
import com.mcii.service.comment.CommentService;
import com.mcii.tools.BaseResponse;
import com.mcii.tools.PageRecord;
import com.mcii.tools.ThisUser;
import com.mcii.tools.Tool;


@Controller
@RequestMapping("comment")
public class CommentController {
	
	@Autowired
    @Qualifier("commentServiceImpl")
	CommentService commentService;
	
	/**
	 * 添加评论
	 */
	@ResponseBody
    @RequestMapping(value = "addComment",method = RequestMethod.POST)
    public BaseResponse addComment(
            @RequestParam(required = true)Integer targettype,
            @RequestParam(required = true)Integer targetid,
            @RequestParam(required = true)String content){
		Account account = ThisUser.get();
		if(targettype==Comment.MOOD){
			//判断是否为好友，未写
		}
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setReviewerid(account);
		comment.setTargettype(targettype);
		comment.setTime(new Timestamp(new Date().getTime()));
		comment.setTargetid(targetid);
		commentService.add(comment);
		return Tool.returnSuccess("添加成功",null);
	}
	
	/**
     * 获取评论
     * @
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getComment",method = RequestMethod.GET)
    public BaseResponse getComment(
    		@RequestParam(required = true,defaultValue = "1")Integer page,
            @RequestParam(required = true,defaultValue = "5")Integer pageSize,
            @RequestParam(required = true)Integer targetid,
            @RequestParam(required = true)Integer targettype){
    	PageRecord pageRecord = commentService.getCommentByTargetid(page,pageSize,targetid,targettype);
    	if (pageRecord.getCurrentPage()==0||pageRecord.getObjects().size()==0)
            return Tool.returnFail("没有信息",null);
        return Tool.returnSuccess("查询成功",pageRecord);
    }
}
