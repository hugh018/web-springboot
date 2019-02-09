package hugh.tech.learn.entity;

/**
 * @author: hugh
 * Created on 2019/2/8
 * func:
 * params:
 * link:
 */
public class User {
    private Long id;
    private String name;
    private String sex;

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
