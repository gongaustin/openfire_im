/**
 * IP处理类
 */
package com.gongjun.im.core.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author advance
 */


public class IPDeal {
    /**
     * 此方法调用百度AIP来查询IP所在地域(YYR)
     *
     * @param strIP（传入的IP地址）
     * @return
     */
    public static String getAddressByIP(String strIP) {
        try {
            URL url = new URL("http://api.map.baidu.com/location/ip?ak=F454f8a5efe5e577997931cc01de3974&ip=" + strIP);
            URLConnection conn = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line = null;
            StringBuffer result = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
            String ipAddr = result.toString();
            try {
                JSONObject obj1 = JSON.parseObject(ipAddr);
                if ("0".equals(obj1.get("status").toString())) {
                    JSONObject obj2 = JSON.parseObject(obj1.get("content").toString());
                    JSONObject obj3 = JSON.parseObject(obj2.get("address_detail").toString());
                    return obj3.get("city").toString();
                } else {
                    return "读取失败";
                }
            } catch (JSONException e) {
                e.printStackTrace();
                return "读取失败";
            }

        } catch (IOException e) {
            return "读取失败";
        }
    }

    /**
     * 获取客户端IP的方法
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.contains(",")) {
            return ip.split(",")[0];
        } else {
            return ip;
        }
    }

    public static void main(String[] args) {
        String strip = "110.121.113.116";
        System.out.println(getAddressByIP(strip));
    }

}
