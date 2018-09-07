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
    
    PageHelper.startPage(1, 3);     // ��ѯ��һҳ��ÿҳ3������
    List<Departments> list = departmentsMapper.selectAll();
    
    // PageInfo�а���������ķ�ҳ��Ϣ��
    PageInfo<Departments> pageInfo = new PageInfo<Departments>(list);
   /* map.put("result", pageInfo.getList());      // ��ѯ��������
    map.put("pageNum", pageInfo.getPageNum());  // ��ǰ�ǵڼ�ҳ
    map.put("pageSize", pageInfo.getPageSize());   // ÿҳ��ʾ����������
    map.put("total", pageInfo.getTotal());      // �ܹ��ж���������
    map.put("pages", pageInfo.getPages());   // �ܹ��ж���ҳ
*/    
    System.err.println("��ѯ���������ǣ�");
    for (Departments departments : list) {
      System.err.println("name is : "+departments.getDeptName());
    }
  }
}
