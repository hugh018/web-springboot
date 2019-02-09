package hugh.tech.learn.mapper;


import hugh.tech.learn.entity.User;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;

/**
 * @author: hugh
 * Created on 2019/2/8
 * func:
 * params:
 * link:
 */

@Mapper
public interface UserMapper {

    @Select("select * from user where name = #{name}")
    List<User> findByName(@Param("name") String name);

    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "sex", column = "sex")
    })
    @Select("select name,sex from user")
    List<User> findAll();

    // insert 3 type
    // no 1 @Param  default
    @Insert("insert into user(name,sex) values(#{name},#{sex})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(@Param("name") String name, @Param("sex") String sex);

    // no2 map
    @Insert("insert into user(name,sex) values(#{name,jdbcType=VARCHAR},#{sex,jdbcType=VARCHAR})")
    int insertByMap(Map<String, Object> map);

    // no3 object
    @Insert("insert into user(name,sex) values(#{name},#{sex})")
    int insertByObj(User user);

    @Update("update user set sex=#{sex} where name=#{name}")
    void update(User user);

    @Delete("delete from user where id=#{id}")
    void delete(@Param("id") Long id);

    User findById(Long id);

    List<User> selectAll();

    User login(String name, String sex);

    int register(User user);

}
