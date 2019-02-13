package hugh.tech.learn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import hugh.tech.learn.entity.User;
import hugh.tech.learn.mapper.UserMapper;
import hugh.tech.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: hugh
 * Created on 2019/2/10
 * func:
 * params:
 * link:
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Long id) {
//        User user = new User();
//        user.setName("hugh");
//        user.setSex("女女");
//        userMapper.update(user);
//
//        int res = 1 / 0;
//
//        userMapper.delete(6L);
        return userMapper.findById(id);

    }

    @Override
    public User login(String name, String sex) {
        return userMapper.login(name, sex);
    }

    @Override
    public int register(User user) {
        return userMapper.register(user);
    }


    /**
     * @param pageNum  begin pagenum
     * @param pageSize record nums
     * @return
     */
    @Override
    public PageInfo<User> selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.selectAll();
        PageInfo pageInfo = new PageInfo(users);
        return pageInfo;
    }


    @Override
    public void deleteById(Long id) {
        userMapper.deleteById(id);
    }
}
