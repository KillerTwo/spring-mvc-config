package org.lwt.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.druid.util.PatternMatcher;
import com.alibaba.druid.util.ServletPathMatcher;

public class MyFilter implements Filter {
  protected PatternMatcher   pathMatcher                       = new ServletPathMatcher();

  private Set<String>        excludesPattern;
  private String contextPath;
  
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println(">>��ʼ��һ��Filter "+ filterConfig.getFilterName());
    String exclusions = filterConfig.getInitParameter("exclusions");
    // exclusions = exclusions.substring(1, exclusions.length());
    excludesPattern = new HashSet<String>(Arrays.asList(exclusions.split("\\s*,\\s*")));
  }
  
  private boolean isExclusion(String requestURI) {
    System.out.println("����url : "+requestURI);
    System.out.println("�ų���url : "+excludesPattern);
    for (String pattern : excludesPattern) {
      if (pathMatcher.matches(pattern, requestURI)) {
          return true;
      }
    }
    return false;
  }
  
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    System.out.println("���й��ˡ�����filter is running");
    System.err.println("���й��ˡ�����filter is running");
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
     String requestUrl = httpServletRequest.getRequestURI();
     
     contextPath = httpServletRequest.getContextPath();
     if(isExclusion(requestUrl)) {
       chain.doFilter(request, response);
     }
     return ;
  }

  @Override
  public void destroy() {
   System.out.println("filter���١�����");

  }

}
