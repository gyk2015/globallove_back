package com.mcii.tools;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.mcii.entity.Account;
import com.mcii.service.login.LoginService;
import com.mcii.tools.exception.LoginException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录切面处理
 */
@Aspect
public class LoginAspect {

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpSession session;

    @Autowired
    @Qualifier("loginServiceImpl")
    LoginService loginService;

    @Pointcut("(execution(* com.mcii.controller..*.*(..)))")
    public void allMethod(){}

    @Before("allMethod()")
    public void sessionValidation(JoinPoint call) throws Exception{
    	System.out.println("我被调用了");
        String className = call.getTarget().getClass().getName();
        String methodName = call.getSignature().getName();
        if (className.equals("com.mcii.controller.login.LoginController")&&!methodName.equals("resetPsd"))
        	System.out.println("我被调用了");
        else {
            Object user_id = session.getAttribute("account_id");
            System.out.println("user_id是"+user_id);
            if (user_id==null)
                throw new LoginException();
            Object role = session.getAttribute("role");
            Account account = null;
//            if ((int)role==User.MEMBER) {
//                Member member = logService.getMemberByUserId((int)user_id);
//                logService.checkVip(member);
//                ThisMember.set(member);
//                user = member.getUserId();
//            }
//            else
            account = loginService.getUser((int)user_id);
            ThisUser.set(account);
            System.out.println();
        }
    }

}
