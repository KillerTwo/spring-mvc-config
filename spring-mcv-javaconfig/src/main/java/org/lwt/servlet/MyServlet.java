package org.lwt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.service(req, resp);
    System.out.println("myServlet���յ�һ�����󡣡���");
    
    
  }

  @Override
  public void init() throws ServletException {
    super.init();
    System.out.println("myServlet��ʼ��������");
    
  }
  @Override
  public void destroy() {
    super.destroy();
    System.out.println("myservlet���١�����");
    
  }
}
