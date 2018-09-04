package org.lwt.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.lwt.servlet.MyServlet;
import org.springframework.web.WebApplicationInitializer;
/**
 *    add添加自定义的servlet类
 *  @author Administrator
 *
 */
public class ServletConfig implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    /*System.out.println("开始添加一个 "+"servlet...");
    ServletRegistration.Dynamic myServlet = servletContext.addServlet("myServlet", MyServlet.class);
    myServlet.addMapping("/myservlet/**");*/
    //myServlet.setLoadOnStartup(1);
    /*FilterRegistration.Dynamic myFilter = servletContext.addFilter("myFilter", MyFilter.class);
    myFilter.addMappingForUrlPatterns(null, false, "/myservlet/**");
    myFilter.addMappingForServletNames(null, false, "myServlet");
    myFilter.setInitParameter("exclusions","*.jsp");*/
  }

}
