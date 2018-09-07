package org.lwt.entity;

import javax.persistence.*;

import org.lwt.enums.Sex;
import org.lwt.typehandler.SexTypeHandler;

import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "`member`")
public class Member {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "`name`")
    private String name;

    @Column(name = "`sex`")
    @ColumnType(typeHandler = SexTypeHandler.class)
    private Sex sex;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return sex
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(Sex sex) {
        this.sex = sex;
    }
}