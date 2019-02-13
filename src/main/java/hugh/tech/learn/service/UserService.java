package hugh.tech.learn.service;

import com.github.pagehelper.PageInfo;
import hugh.tech.learn.entity.User;


/**
 * @author: hugh
 * Created on 2019/2/10
 * func:
 * params:
 * link:
 */
public interface UserService {


    PageInfo<User> selectAll(int pageNum, int pageSize);

    User findById(Long id);

    User login(String name, String sex);

    int register(User user);

    void deleteById(Long id);
}
