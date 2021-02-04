package com.lcm.web;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @author liuchaomin
 * @date 2021/2/4 22:18
 */

public class MyHttpRequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request 监听器被销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
        String requestURI = req.getRequestURI();
        System.out.println(requestURI + "--" + "被调用");
    }
}
