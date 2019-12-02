package com.alaska.dmytest.service;

import com.alaska.dmytest.entity.User;
import com.alaska.dmytest.entity.UserMessage;

/**
 * 功能描述:
 *
 * @ClassName: UserService
 * @Workstation: AlaSKa_
 * @Author: Laoshuaitou-AlaSKa
 * @Date: 2019/11/26 14:02
 * @Version:1.0
 * @Description:用户操作接口
 * 其中包括不同类型用户的登陆、密码修改、详细信息查询等操作
 */
public interface UserService {
	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: UserService.login
	 * 功能描述: 用户登录功能
	 *
	 * @params: [request] 用户输入的登录信息
	 * @return: int 将返回当前用户ID
	 * 若成功返回当前用户ID，若不成功返回0
	 * @Date: 2019/11/26 14:11
	 */
	public int login(User request);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: UserService.changePassword
	 * 功能描述: 修改密码功能
	 *
	 * @params: [userId, oldPassword, newPassword] 用户查询本用户信息的用户ID 输入的旧密码 输入的新密码
	 * @return: int
	 * @Date: 2019/12/2 22:41
	 */
	public int changePassword(int userId,String oldPassword,String newPassword);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: UserService.showUserMessage
	 * 功能描述: 展示用户详细信息
	 *
	 * @params: [userId] 用户ID
	 * @return: com.alaska.dmytest.entity.UserMessage 需要展示的用户详细信息
	 * @Date: 2019/11/26 14:16
	 */
	public UserMessage showUserMessage(int userId);
}
