package org.lwt.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lwt.entity.Member;
import org.lwt.enums.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test01 {
  
  @Autowired
  private MemberMapperBak memberMapperBak;
  @Autowired
  private MemberMapper memberMapper;
  @Test
  @Ignore
  public void testTypeHandler() {
    List<Member> list = memberMapperBak.queryAll();
    for (Member member : list) {
      System.err.println(member.getSex().getStatus());
    }
    //System.err.println(Sex.getSexForCode(1).getStatus());
  }
  @Test
  @Ignore
  public void testTypeHandler2() {
    List<Member> list = memberMapper.selectAll();
    System.err.println("查询到的值：");
    for (Member member : list) {
      System.err.println(member.getSex().getStatus());
    }
    //System.err.println(Sex.getSexForCode(1).getStatus());
  }
  @Test
  public void testInsert() {
    Member member = new Member();
    member.setName("marry");
    member.setSex(Sex.FMAN);
    memberMapper.insert(member);
    System.err.println(member.getId());
  }
  
}
