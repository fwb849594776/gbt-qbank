package com.fitt.gbt.qbank.controller;

import com.fitt.gbt.qbank.common.utils.SignUtil;
import com.fitt.gbt.qbank.service.CoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p> Description	: 核心控制类 </p>
 * <p> Copyright	: Copyright (c) 2017 by FITT</p>
 * <p> Author 		: Miles[ZhengCongChun] </p>
 * <p> Create		: 2017-12-05 23:30 </p>
 * <p> version 		: 1.0 </p>
 */
@Controller
@RequestMapping("")
public class CoreController {
    //增加日志
    private static Logger log = LoggerFactory.getLogger(CoreController.class);

    @Autowired
    private CoreService coreService;

    //验证是否来自微信服务器的消息
    @GetMapping
    public String checkSignature(@RequestParam(name = "signature" ,required = false) String signature  ,
                                 @RequestParam(name = "nonce",required = false) String  nonce ,
                                 @RequestParam(name = "timestamp",required = false) String  timestamp ,
                                 @RequestParam(name = "echostr",required = false) String  echostr){
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            log.info("接入成功");
            return echostr;
        }
        log.error("接入失败");
        return "";
    }
    // 调用核心业务类接收消息、处理消息跟推送消息
    @PostMapping
    public  String post(HttpServletRequest req){
        String respMessage = coreService.processRequest(req);
        return respMessage;
    }

    @RequestMapping(value = "/weixin/index")
    public String index() {
        return "weixin/index";
    }

    @RequestMapping(value = "/layui/template")
    public String laytpl() {
        return "laytpl";
    }

    @RequestMapping(value = "/main")
    public String main() {
        return "main";
    }

}
