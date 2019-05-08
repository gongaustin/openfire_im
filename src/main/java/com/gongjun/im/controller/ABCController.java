package com.gongjun.im.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.gongjun.im.core.annotation.MyLog;
import com.gongjun.im.model.Test;
import com.gongjun.im.service.ITestService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Controller和@RestController的区别？ 官方文档：
 * @RestController is a stereotype annotation that combines @ResponseBody and @Controller.
 * 意思是：
 * @RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
 * <p>
 * 1)如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
 * 例如：本来应该到success.jsp页面的，则其显示success.
 * 2)如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
 * 3)如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。
 **/
/*
 * 定义控制层采用@RestController/@Controller
 */
@RestController
@RequestMapping("")
@Api(value = "/", description = "测试接口")
public class ABCController{
    @Resource
    private ITestService service;

//    @MyLog("查询个数")
    @GetMapping("")
    public Page ABC(String a, String b, Page<Test> page) {
        Page<Test> tests = this.service.selectPage(page,null);
        System.out.println(null == tests ? 0 : tests.getRecords().size());
        return tests;
    }

    /**
     * @param [aa, bb]
     * @return java.lang.String
     * @description 方法注解采用"/m"然后tab键即可
     * @author GongJun
     * @time 2019/1/17 11:03
     **/
    public String ss(String aa, String bb) {
        return aa + bb;
    }



    public static void main(String[] args) {
        System.out.println(0.99==1);
        System.out.println(0.99999999999999994==1);
        System.out.println(0.99999999999999995==1);
        System.out.println(0.99999999999999999==1);
        System.out.println(0.99999999999999995<0.99999999999999999);
    }
}
