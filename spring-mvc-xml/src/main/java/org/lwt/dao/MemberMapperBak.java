package org.lwt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.lwt.entity.Member;

@Mapper
public interface MemberMapperBak {
  List<Member> queryAll();
}
