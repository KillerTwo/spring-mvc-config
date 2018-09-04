package org.lwt.dao;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lwt.config.MyBatisConfigRef;
import org.lwt.config.RootConfig;
import org.lwt.entity.Departments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.javafx.collections.MappingChange.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class,MyBatisConfigRef.class})
public class TestDeptDao {
  //private Map<String, Object> map = (Map<String, Object>) new HashMap();
  @Autowired
  private DepartmentsMapper departmentsMapper;
  @Test
  public void testSelect() {
    
    PageHelper.startPage(1, 3);     // 查询第一页，每页3条数据
    List<Departments> list = departmentsMapper.selectAll();
    
    // PageInfo中包含了所需的分页信息。
    PageInfo<Departments> pageInfo = new PageInfo<Departments>(list);
   /* map.put("result", pageInfo.getList());      // 查询到的数据
    map.put("pageNum", pageInfo.getPageNum());  // 当前是第几页
    map.put("pageSize", pageInfo.getPageSize());   // 每页显示多少条数据
    map.put("total", pageInfo.getTotal());      // 总共有多少条数据
    map.put("pages", pageInfo.getPages());   // 总共有多少页
*/    
    System.err.println("查询到的数据是：");
    for (Departments departments : list) {
      System.err.println("name is : "+departments.getDeptName());
    }
  }
}
