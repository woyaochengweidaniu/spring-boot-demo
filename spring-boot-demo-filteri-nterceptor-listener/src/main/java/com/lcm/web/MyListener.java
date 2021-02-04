package com.lcm.web;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuchaomin
 * @date 2021/2/4 22:02
 *
 * 监听器通常用于监听 Web 应用程序中对象的创建、销毁等动作的发送，同时对监听的情况作出相应的处理，最常用于统计网站的在线人数、访问量等。
 *
 * 监听器大概分为以下几种：
 *
 * ServletContextListener：用来监听 ServletContext 属性的操作，比如新增、修改、删除。
 * HttpSessionListener：用来监听 Web 应用种的 Session 对象，通常用于统计在线情况。
 * ServletRequestListener：用来监听 Request 对象的属性操作。
 * 监听器的使用#
 * 我们通过 HttpSessionListener来统计当前在线人数、ip等信息，为了避免并发问题我们使用原子int来计数。
 *
 * ServletContext,是一个全局的储存信息的空间，它的生命周期与Servlet容器也就是服务器保持一致，服务器关闭才销毁。request，一个用户可有多个；session，一个用户一个；而servletContext，
 * 所有用户共用一个。所以，为了节省空间，提高效率，ServletContext中，要放必须的、重要的、所有用户需要共享的线程又是安全的一些信息。因此我们这里用ServletContext来存储在线人数sessionCount最为合适。
 */
public class MyListener implements HttpSessionListener {

    public static AtomicInteger userCount = new AtomicInteger();

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        userCount.getAndIncrement();
        se.getSession().getServletContext().setAttribute("sessionCount",userCount.get());
        System.out.println("-----------当前在线人数："+ userCount.get() + "--------------");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        userCount.getAndDecrement();
        se.getSession().getServletContext().setAttribute("sessionCount",userCount.get());
        System.out.println("-----------【在线人数】人数减少为:"+ userCount.get() + "--------------");
    }
}
