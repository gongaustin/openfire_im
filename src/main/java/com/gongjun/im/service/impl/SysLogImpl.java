package com.gongjun.im.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gongjun.im.mapper.SysLogMapper;
import com.gongjun.im.model.log.SysLog;
import com.gongjun.im.service.ISysLogService;
import org.springframework.stereotype.Service;

/**
 * Author:GongJun
 * Date:2019/1/17
 */
@Service
public class SysLogImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {
}
