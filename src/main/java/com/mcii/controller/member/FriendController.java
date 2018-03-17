package com.mcii.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mcii.service.member.friend.FriendService;

@Controller
@RequestMapping("friend")
public class FriendController {
	@Autowired
	@Qualifier("friendServiceImpl")
	FriendService friendService;
	
	
}
