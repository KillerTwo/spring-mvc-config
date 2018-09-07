package org.lwt.config;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.xml.transform.Source;

import org.lwt.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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
@EnableWebMvc     // 启动mvc
@ComponentScan(basePackages= {"org.lwt.controller"})    // 
public class WebConfig extends WebMvcConfigurerAdapter {
  
  // 试图解析器
  @Bean
  public ViewResolver viewResolver(){
      InternalResourceViewResolver resolver =
              new InternalResourceViewResolver();

      resolver.setPrefix("/WEB-INF/");
      resolver.setSuffix(".jsp");
      resolver.setExposeContextBeansAsAttributes(true);

      return resolver;
  }

  /**
   * me 消息转换器
   */
  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
        .indentOutput(true)
        .dateFormat(new SimpleDateFormat("yyyy-MM-dd"));
    converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
    converters.add(new MappingJackson2XmlHttpMessageConverter(builder.createXmlMapper(true).build()));
    converters.add(new ByteArrayHttpMessageConverter());
    converters.add(new StringHttpMessageConverter());
    converters.add(new SourceHttpMessageConverter<Source>());
    converters.add(new AllEncompassingFormHttpMessageConverter());
  }

  /**
   * in 拦截器
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new MyInterceptor())
    .addPathPatterns("/**")             
    .excludePathPatterns("/login");     
  }

  // 静态资源访问
  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    super.configureDefaultServletHandling(configurer);
  }
}
