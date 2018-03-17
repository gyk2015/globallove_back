package com.mcii.tools;

import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;


/**
 * 封装所有工具
 */
@Component
public class Tool {

    /**
     * 生成成功的响应
     * @param message 响应信息
     * @param object 响应对象
     * @return
     */
    public static BaseResponse returnSuccess(String message,Object object){
        BaseResponse baseResponse = new BaseResponse(message,ResponseStatus.SUCCESS,object);
        return baseResponse;
    }

    /**
     * 生成失败的响应
     * @param message 响应信息
     * @param object 响应对象
     * @return
     */
    public static BaseResponse returnFail(String message,Object object){
        BaseResponse baseResponse = new BaseResponse(message,ResponseStatus.FAIL,object);
        return baseResponse;
    }

    /**
     * md5加密
     * @param inStr 源字符串
     * @return
     */
    public static String md5Encode(String inStr){
        if (inStr==null)
            return null;
        if ("".equals(inStr))
            return null;
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] byteArray = inStr.getBytes("UTF-8");
            byte[] md5Bytes = md5.digest(byteArray);
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16) {
                    hexValue.append("0");
                }
                hexValue.append(Integer.toHexString(val));
            }
            return hexValue.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成分页
     * @param page 当前页
     * @param pageSize 页大小
     * @param query 数据库连接
     * @return
     */
    public static PageRecord pageList(int page, int pageSize, Query query){
        PageRecord pageRecord = new PageRecord();
        int all = query.list().size();
        int firstResult = pageSize*(page-1);
        int maxResult = pageSize;
        List<Object> accounts = query.setFirstResult(firstResult).setMaxResults(maxResult).getResultList();
        int totalPage = (all+pageSize-1)/pageSize;
        if (page>totalPage)
            page = totalPage;
        pageRecord.setCurrentPage(page);
        pageRecord.setPageSize(pageSize);
        pageRecord.setObjects(accounts);
        pageRecord.setTotalPage(totalPage);
        return pageRecord;
    }

    /**
     * 生成一个安全码（UUID）
     * @return
     */
    public static String getSecurityCode() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    /**
     * 读文件
     * @param url 文件路径
     * @return
     */
    public static String readFile(String url){
        try {
            File file = new File(url);
            if (!file.exists())
                return "";
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder stringBuilder = new StringBuilder();
            String buffer;
            while ((buffer=bufferedReader.readLine())!=null)
                stringBuilder.append(buffer+"\n");
            bufferedReader.close();
            reader.close();
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 写文件
     * @param content 文件内容
     * @param url 文件路径
     * @return
     */
    public static boolean writeFile(String content,String url){
        try {
            File file = new File(url);
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.flush();
            writer.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除文件
     * @param url 文件路径
     * @return
     */
    public static void deleteFile(String url){
        String url1 = url.replace("/","\\");
        File file = new File(url1);
        file.delete();
    }

    /**
     * 根据字段数组和搜索内容，生成hql后部分语句，例如（a like :1 or b like :1 ）
     * @param columns 字段数组
     * @param position 位置，用于query插值
     * @return
     */
    public static String spliceHql(String[] columns,int position){
        StringBuilder hql = new StringBuilder(" (");
        for (int i=0;i<columns.length;i++){
            hql.append(columns[i]+" like ?"+position+"");
            if (i!=columns.length-1)
                hql.append(" or ");
        }
        hql.append(")");
        return hql.toString();
    }
}
