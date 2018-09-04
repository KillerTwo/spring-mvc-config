/*package org.lwt.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.lwt.dao.DepartmentsMapper;
import org.lwt.entity.Departments;
import org.springframework.beans.factory.annotation.Autowired;

public class MapperFilter implements Filter {
  @Autowired
  private DepartmentsMapper countryMapper;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
      System.out.println("init");
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
      List<Departments> countries = countryMapper.selectAll();
      filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void destroy() {
      System.out.println("destroy");
  }
}*/