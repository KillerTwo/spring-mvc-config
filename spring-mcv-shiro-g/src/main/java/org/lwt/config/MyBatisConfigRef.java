package org.lwt.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Config;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.spring.annotation.MapperScan;
/**
 *  m 配置通用mapper
 * @author Administrator
 *
 */
@Configuration
@MapperScan(
    value = "org.lwt.dao",  // 指定mapper接口存放的包
    mapperHelperRef="mapperHelper",
    sqlSessionFactoryRef="sqlSessionFactory"
    )
public class MyBatisConfigRef {
  
  @Bean
  public MapperHelper mapperHelper() {
    Config config = new Config();
    List<Class> mappers = new ArrayList<>();
    mappers.add(Mapper.class);
    config.setMappers(mappers);
    
    MapperHelper mapperHelper = new MapperHelper();
    mapperHelper.setConfig(config);
    
    return mapperHelper;
    
  }
}
