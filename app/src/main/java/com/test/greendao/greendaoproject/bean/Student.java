package com.test.greendao.greendaoproject.bean;


import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;

/**
 * Created by zhouwei on 2018/5/18.
 */

@Entity
public class Student {

    @Id(autoincrement = true)
    private Long id;//建议定义成Long类型，因为采用自动增长的主键可以，框架自己维护Key的递增关系，即：再insert对象的时候，
                      // 可以设置为null

    @NotNull
    @Property(nameInDb = "STU_NAME")
    private String stuName;

    @Transient
    private int stuTemp;

    @Generated(hash = 1288346107)
    public Student(Long id, @NotNull String stuName) {
        this.id = id;
        this.stuName = stuName;
    }

    @Generated(hash = 1556870573)
    public Student() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStuName() {
        return this.stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

}
