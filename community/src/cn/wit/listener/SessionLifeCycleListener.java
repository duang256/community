package cn.wit.listener;

import javax.servlet.ServletContext;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import cn.wit.common.*;
import cn.wit.pojo.User;

/**
 * ���HttpSession���������ٵ�����
 */
@WebListener
public class SessionLifeCycleListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
            //��ȡServletContext����Ȼ������Ӧ��HttpSessionɾ����
        HttpSession session = se.getSession();
        ServletContext servletContext = session.getServletContext();
        User user = (User) session.getAttribute(Constants.USER_SESSION_KEY);
        servletContext.removeAttribute(user.getUserid()+"");
    }
}
