package com.gongjun.im.controller;

import com.gongjun.im.core.bean.ResponseBean;
import com.gongjun.im.core.constant.HttpCodeConstant;
import io.swagger.annotations.Api;
import org.jivesoftware.smack.ConnectionConfiguration;  
import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jivesoftware.smackx.iqregister.AccountManager;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.jid.parts.Localpart;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


/**
 * @Description:IM聊天接口
 * @Author:GongJun
 * @Date:2019/5/8
 */
@RestController
@RequestMapping("im")
@Api(value = "/im", description = "聊天接口")
public class IMController{
    @Value("${openfire.server}")
    private String server;

    @Value("${openfire.port}")
    private int port;

    @Value("${openfire.hostname}")
    private String hostname;

    private XMPPTCPConnection getConnetion(){
        XMPPTCPConnectionConfiguration config = null;
        try {
            config = XMPPTCPConnectionConfiguration.builder()
                    .setHost(server)
                    .setPort(port)
                    .setXmppDomain(JidCreate.domainBareFrom(server))
                    .setSendPresence(false)
                    .setSecurityMode((ConnectionConfiguration.SecurityMode.disabled))
                    .setUsernameAndPassword("admin","123456")
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        XMPPTCPConnection connection = new XMPPTCPConnection(config);
        SASLAuthentication.blacklistSASLMechanism("SCRAM-SHA-1");
        SASLAuthentication.blacklistSASLMechanism("DIGEST-MD5");
        SASLAuthentication.blacklistSASLMechanism("CRAM-MD5");
        try {
            connection.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    @GetMapping("register")
    private ResponseBean register (@RequestParam String name,@RequestParam String password) {
        ResponseBean rb = new ResponseBean(200, "success", null);
        XMPPTCPConnection connection = this.getConnetion();
        try {
            /**
             * 先登录后注册，否则无法注册
             * */
            connection.login("admin", "123456");
            AccountManager manager = AccountManager.getInstance(connection);
            manager.sensitiveOperationOverInsecureConnection(true);
            manager.createAccount(Localpart.from(name), password);
        } catch (XMPPException e) {
            rb.setCode(HttpCodeConstant.BADGATEWAY);
            rb.setMsg("already registered or registered failed");
        } catch (Exception e) {
            e.printStackTrace();
        }
            return rb;
        }

}
