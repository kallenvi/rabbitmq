package com.rabbit.demo.test;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WLog {

    private static final Logger log = LoggerFactory.getLogger(WLog.class);

    public static void main(String[] args)
    {
        log.error("【微信支付】发起支付, response={}", "msg");
    }
}
