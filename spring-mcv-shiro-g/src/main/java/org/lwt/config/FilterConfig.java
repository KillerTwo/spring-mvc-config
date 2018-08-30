package org.lwt.config;

import java.nio.charset.StandardCharsets;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.lwt.filter.MyFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

public class FilterConfig implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    
  //×Ö·û¼¯¹ýÂËÆ÷ 
    FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
    encodingFilter.setInitParameter("encoding", String.valueOf(StandardCharsets.UTF_8));
    encodingFilter.setInitParameter("forceEncoding", "true");
    encodingFilter.addMappingForUrlPatterns(null, false, "/*");
    
    
    FilterRegistration.Dynamic filter = servletContext.addFilter("myFilter", MyFilter.class);
    //filter.addMappingForServletNames(null, false, "myServlet");
    filter.addMappingForUrlPatterns(null, false, "/*");
    filter.setInitParameter("exclusions", "*.jsp,*/myservlet");
  }

}
