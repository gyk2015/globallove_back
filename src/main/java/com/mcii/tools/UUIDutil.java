package com.mcii.tools;

import java.util.UUID;

/**
 * 生成随机数
 * @author 逸坤
 *
 */
public class UUIDutil {
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-","");
	}
}
