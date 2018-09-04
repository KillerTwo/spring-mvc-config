package org.lwt.enums;

public enum Sex {
  MAN(1,"男"), FMAN(0,"女");
  private int code ;
  private String status;
  private Sex(int code, String status) {
    this.code = code ;
    this.status = status;
  }
  /**
   * re 根据code返回枚举值
   * @param code
   * @return
   */
  public static Sex getSexForCode(int code) {
    for(Sex sex: Sex.values()) {
      if(sex.getCode() == code) {
        return sex;
      }
    }
    return null;
  }
  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
  
  
  
}
