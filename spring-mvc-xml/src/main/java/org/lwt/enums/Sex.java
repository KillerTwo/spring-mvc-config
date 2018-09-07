package org.lwt.enums;

public enum Sex {
  MAN(1,"��"), FMAN(0,"Ů");
  private int code ;
  private String status;
  private Sex(int code, String status) {
    this.code = code ;
    this.status = status;
  }
  /**
   * re ����code����ö��ֵ
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
