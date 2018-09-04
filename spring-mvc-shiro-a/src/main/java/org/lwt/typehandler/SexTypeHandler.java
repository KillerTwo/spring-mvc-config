package org.lwt.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.lwt.enums.Sex;
/**
 *  typehandler 自定义mybatis类型转换器类
 * @author Administrator
 *
 */
public class SexTypeHandler implements TypeHandler<Sex> {

  @Override
  public void setParameter(PreparedStatement ps, int i, Sex parameter, JdbcType jdbcType) throws SQLException {
    int code = parameter.getCode();
    ps.setInt(i, code);
  }

  @Override
  public Sex getResult(ResultSet rs, String columnName) throws SQLException {
    int code = rs.getInt(columnName);
    return Sex.getSexForCode(code);
  }

  @Override
  public Sex getResult(ResultSet rs, int columnIndex) throws SQLException {
    int code = rs.getInt(columnIndex);
    return Sex.getSexForCode(code);
  }

  @Override
  public Sex getResult(CallableStatement cs, int columnIndex) throws SQLException {
    int code = cs.getInt(columnIndex);
    return Sex.getSexForCode(code);
  }

}
