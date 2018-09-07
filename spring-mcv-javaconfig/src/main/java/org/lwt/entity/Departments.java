package org.lwt.entity;

import javax.persistence.*;

@Table(name = "`departments`")
public class Departments {
    @Id
    @Column(name = "`dept_no`")
    private String deptNo;

    @Column(name = "`dept_name`")
    private String deptName;

    /**
     * @return dept_no
     */
    public String getDeptNo() {
        return deptNo;
    }

    /**
     * @param deptNo
     */
    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo == null ? null : deptNo.trim();
    }

    /**
     * @return dept_name
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * @param deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }
}