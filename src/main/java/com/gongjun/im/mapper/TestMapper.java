package com.gongjun.im.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.gongjun.im.model.Test;
import org.springframework.stereotype.Repository;

/**
 * 定义DAO层的bean采用@Repository注解
 */
@Repository
public interface TestMapper extends BaseMapper<Test> {
}
