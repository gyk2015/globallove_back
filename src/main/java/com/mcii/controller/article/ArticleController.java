package com.mcii.controller.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mcii.entity.Article;
import com.mcii.service.article.ArticleService;
import com.mcii.tools.BaseResponse;
import com.mcii.tools.PageRecord;
import com.mcii.tools.Tool;

@Controller
@RequestMapping("article")
public class ArticleController {
	@Autowired
	ArticleService articleService;
	
	/**
     * 获取栏目文章列表
     */
    @ResponseBody
    @RequestMapping(value = "getArticles",method = RequestMethod.GET)
    public BaseResponse getArticles(
    		@RequestParam(required = true,defaultValue = "1")Integer type,
    		@RequestParam(required = true,defaultValue = "1")Integer page,
    		@RequestParam(required = true,defaultValue = "5")Integer pageSize){
    	PageRecord pageRecord = articleService.getArticleList(type,page,pageSize);
    	return Tool.returnSuccess("查询成功",pageRecord);
    }
    
    /**
     * 获取某篇文章
     */
    @ResponseBody
    @RequestMapping(value = "getArticle",method = RequestMethod.GET)
    public BaseResponse getArticle(
    		@RequestParam(required = true,defaultValue = "1")Integer id){
    	Article article = articleService.getArticleById(id);
    	return Tool.returnSuccess("查询成功", article);
    }
    
    /**
     * 获取人气文章列表
     */
    @ResponseBody
    @RequestMapping(value = "getPopList",method = RequestMethod.GET)
    public BaseResponse getPopList(
    		@RequestParam(required = true,defaultValue = "1")Integer page,
    		@RequestParam(required = true,defaultValue = "5")Integer pageSize){
    	PageRecord pageRecord = articleService.getPop(page,pageSize);
    	return Tool.returnSuccess("查询成功",pageRecord);
    }
    
    /**
     * 获取最新文章列表
     */
    @ResponseBody
    @RequestMapping(value = "getNewestList",method = RequestMethod.GET)
    public BaseResponse getNewestList(
    		@RequestParam(required = true,defaultValue = "1")Integer page,
    		@RequestParam(required = true,defaultValue = "5")Integer pageSize){
    	PageRecord pageRecord = articleService.getNewest(page,pageSize);
    	return Tool.returnSuccess("查询成功",pageRecord);
    }
    
    /**
     * 点赞文章
     */
    @ResponseBody
    @RequestMapping(value = "updateGood",method = RequestMethod.POST)
    public BaseResponse updateGood(
    		@RequestParam(required = true,defaultValue = "1")Integer id){
    	articleService.updateGood(id);
//    	System.out.println(article);
//    	int liked = (int)article.getLiked();
//    	liked = liked+1;
//    	article.setLiked(liked);
//    	articleService.save(article);
    	return Tool.returnSuccess("点赞成功", null);
    }
}
