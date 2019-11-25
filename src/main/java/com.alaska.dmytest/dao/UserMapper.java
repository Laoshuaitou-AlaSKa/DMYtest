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
 * @Version:
 * @Description:
 */
public interface UserMapper {
	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: UserMapper.createUser
	 * 功能描述: 创建一个用户
	 *
	 * @params: [user] 被创建的用户实例
	 * @return: int 是否成功创建，成功1，不成功0，有相同-1
	 * @Date: 2019/11/20 15:32
	 */
	int createUser(User user);

	int createUsers(List<User> users);

}
