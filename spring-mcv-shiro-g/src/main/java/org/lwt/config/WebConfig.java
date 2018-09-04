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

  /**
   * me 添加消息转换器
   */
  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
        .indentOutput(true)
        .dateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        //.modulesToInstall(new ParameterNamesModule());
    
    converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
    converters.add(new MappingJackson2XmlHttpMessageConverter(builder.createXmlMapper(true).build()));
    // 默认的消息转换器，如果添加了其他的转换器则默认的转换器将不会被添加。
    converters.add(new ByteArrayHttpMessageConverter());
    converters.add(new StringHttpMessageConverter());
    converters.add(new SourceHttpMessageConverter<Source>());
    converters.add(new AllEncompassingFormHttpMessageConverter());
  }

  /**
   * in 添加拦截器配置
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new MyInterceptor())
    .addPathPatterns("/**")             // 设置拦截路径
    .excludePathPatterns("/login");     // 排除拦截路径
  }

  // 配置静态资源的处理
  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    super.configureDefaultServletHandling(configurer);
  }
}
