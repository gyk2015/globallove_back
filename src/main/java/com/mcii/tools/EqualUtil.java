package com.mcii.tools;

import com.mcii.entity.Account;

public class EqualUtil {
	public static boolean equals(Object obj1,Object obj2) {  
        if (obj1 == obj2)      //传入的对象就是它自己，如s.equals(s)；肯定是相等的；  
            return true;   
        if (obj1.getClass() != obj2.getClass())
            return false;  
        Account aaccount = (Account) obj1;
        Account baccount = (Account) obj2;
        if (aaccount.getId() == baccount.getId()){
        	return true;
        }
        return false;
    }  
}
