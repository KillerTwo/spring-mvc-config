package org.lwt.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.lwt.enums.Sex;

public class SexTypeHandlerForBase extends BaseTypeHandler<Sex> {

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, Sex parameter, JdbcType jdbcType) throws SQLException {
    
  }

  @Override
  public Sex getNullableResult(ResultSet rs, String columnName) throws SQLException {
   
    return null;
  }

  @Override
  public Sex getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    
    return null;
  }

  @Override
  public Sex getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    
    return null;
  }

}
