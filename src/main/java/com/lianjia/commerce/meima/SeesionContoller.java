package com.lianjia.commerce.meima;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


/**
 * @author yangxiaochen
 * Date: 2018-01-08
 */
@RestController
public class SeesionContoller {

    @Autowired
    Environment environment;

    @RequestMapping
    public String session(HttpSession session) {
        return environment.getProperty("server.port") + " " +session.getId();
    }
}
