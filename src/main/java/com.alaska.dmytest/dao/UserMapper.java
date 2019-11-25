package com.alaska.dmytest.dao;

import com.alaska.dmytest.entity.User;

import java.util.List;

/**
 * 功能描述:
 *
 * @ClassName: UserMapper
 * @Workstation: AlaSKa_
 * @Author: Laoshuaitou-AlaSKa
 * @Date: 2019/11/20 15:09
 * @Version:1.0
 * @Description:User DAO
 */
public interface UserMapper {
	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: UserMapper.createUser
	 * 功能描述: 创建一个用户
	 *
	 * @params: [user] 被创建的用户实体
	 * @return: int 是否成功创建，返回被修改实体数
	 * @Date: 2019/11/20 15:32
	 */
	int createUser(User user);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: UserMapper.deleteUserByUserId
	 * 功能描述: 通过用户ID删除一个用户
	 *
	 * @params: [id] 用户ID
	 * @return: int 是否成功删除，返回被修改实体数
	 * @Date: 2019/11/26 0:56
	 */
	int deleteUserByUserId(int id);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: UserMapper.deleteUserByUsername
	 * 功能描述: 通过用户名删除一个用户
	 *
	 * @params: [username] 用户名
	 * @return: int 是否成功删除，返回被修改实体数
	 * @Date: 2019/11/26 0:58
	 */
	int deleteUserByUsername(String username);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: UserMapper.updateUser
	 * 功能描述: 修改用户信息
	 *
	 * @params: [user] 被修改用户实体
	 * @return: int 是否成功修改，返回被修改实体数
	 * @Date: 2019/11/26 0:59
	 */
	int updateUser(User user);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: UserMapper.selectUserById
	 * 功能描述: 通过用户ID查询一个用户
	 *
	 * @params: [id] 用户ID
	 * @return: com.alaska.dmytest.entity.User 返回被查询的用户实体
	 * @Date: 2019/11/26 1:01
	 */
	User selectUserById(int id);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: UserMapper.selectUserByUsername
	 * 功能描述: 通过用户名查询一个用户
	 *
	 * @params: [username] 用户名
	 * @return: com.alaska.dmytest.entity.User 返回被查询用户实体
	 * @Date: 2019/11/26 1:02
	 */
	User selectUserByUsername(String username);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: UserMapper.selectAllUser
	 * 功能描述: 查询库中所有用户
	 *
	 * @params: []
	 * @return: java.util.List<com.alaska.dmytest.entity.User> 返回所有用户实体集
	 * @Date: 2019/11/26 1:03
	 */
	List<User> selectAllUser();
}
