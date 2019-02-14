package hugh.tech.learn.entity;

import java.io.Serializable;

/**
 * @author: hugh
 * Created on 2019/2/8
 * func:
 * params:
 * link:
 */
public class User implements Serializable {
    private Long id;
    private String name;
    private String sex;

//    @Column(name = "last_login_ip") // 命名不同时，可以在这里指定映射关系
//    private String lastLoginIp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
