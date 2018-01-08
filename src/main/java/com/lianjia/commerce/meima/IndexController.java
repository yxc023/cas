package com.lianjia.commerce.meima;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yangxiaochen
 * Date: 2017-12-28
 */
@RestController
public class IndexController {
    @RequestMapping("/index")
    public String index() {

        return "index~~~~~~~~~~~";
    }
}
