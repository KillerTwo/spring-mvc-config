package org.lwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * springMVC容器配置
 * 
 * 
 * 
 * @author Administrator
 *
 */
@Configuration
@EnableWebMvc     // 启用mvc
@ComponentScan(basePackages= {"org.lwt.controller"})    // 扫描指定包下的类将其注册为spring的一个bean
public class WebConfig extends WebMvcConfigurerAdapter {
  
  // 视图解析器
  @Bean
  public ViewResolver viewResolver(){
      InternalResourceViewResolver resolver =
              new InternalResourceViewResolver();

      resolver.setPrefix("/WEB-INF/");
      resolver.setSuffix(".jsp");
      resolver.setExposeContextBeansAsAttributes(true);

      return resolver;
  }
  

  //配置静态资源的处理
  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    super.configureDefaultServletHandling(configurer);
  }
}
