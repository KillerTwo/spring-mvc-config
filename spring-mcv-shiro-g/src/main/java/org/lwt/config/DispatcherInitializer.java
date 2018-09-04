package org.lwt.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.lwt.filter.MyFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * dipatcherServlet相关配置，  用来代替web.xml中的
 * dipatcherServlet和ContextLoadListener相关配置
 * @author Administrator
 *
 */

public class DispatcherInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    System.out.println("加载RootConfig配置类");
    return new Class[] {RootConfig.class};
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    
    return new Class[] {WebConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
   
    return new String[] {"/"};
  }
  /**
   *  add 添加一个Filter到dipatcherServlet
   */
  /*@Override
  protected Filter[] getServletFilters() {
    
    return new Filter[] {new MyFilter()};
  }*/

  /**
   *  m处理上传文件
   */
  @Override
  protected void customizeRegistration(Dynamic registration) {
    // 设置临时目录
    registration.setMultipartConfig(new MultipartConfigElement("/tmp"));
  }
  

}
