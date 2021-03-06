package lcqjoyce.bbs.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import lcqjoyce.bbs.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findByToken(@Param("token")String token);


    User findById(@Param("id")Long id);

    List<User> findByAccountId(@Param("accountId")String accountId);

    List<User> findInId(@Param("userIds") List<Long> userIds);

}