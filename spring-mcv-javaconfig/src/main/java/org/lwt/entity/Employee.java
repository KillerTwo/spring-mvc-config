package org.lwt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Employee {
  
  private String name;
  private String birthDate;
  private BigDecimal payment;
  private BigDecimal bonus;
  public Employee() {
    
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getBirthDate() {
    return birthDate;
  }
  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }
  public BigDecimal getPayment() {
    return payment;
  }
  public void setPayment(BigDecimal payment) {
    this.payment = payment;
  }
  public BigDecimal getBonus() {
    return bonus;
  }
  public void setBonus(BigDecimal bonus) {
    this.bonus = bonus;
  }
  @Override
  public String toString() {
    return "Employee [name=" + name + ", birthDate=" + birthDate + ", payment=" + payment + ", bonus=" + bonus + "]";
  }
  
  
}
