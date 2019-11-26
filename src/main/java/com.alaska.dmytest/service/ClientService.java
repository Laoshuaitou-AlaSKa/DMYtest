package com.alaska.dmytest.service;

import com.alaska.dmytest.entity.User;
import com.alaska.dmytest.entity.UserMessage;

/**
 * 功能描述:
 *
 * @ClassName: ClientService
 * @Workstation: AlaSKa_
 * @Author: Laoshuaitou-AlaSKa
 * @Date: 2019/11/26 14:07
 * @Version:1.0
 * @Description:客户端操作接口
 * 客户端功能允许用户执行登陆、注册、修改密码、查询详细信息、修改详细信息等功能
 * 父接口中定义了登陆、修改密码、查询详细信息功能
 */
public interface ClientService extends UserService{
	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: ClientService.regist
	 * 功能描述: 注册模块
	 *
	 * @params: [request, requestMessage] 被创建的用户实体 被创建的用户详细信息实体
	 * @return: int 返回是否成功执行创建操作
	 * @Date: 2019/11/26 14:19
	 */
	public int regist(User request, UserMessage requestMessage);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: ClientService.changeUserMessage
	 * 功能描述: 修改用户详细信息
	 *
	 * @params: [request] 被修改的用户详细信息实体
	 * @return: int 返回是否成功执行修改操作
	 * @Date: 2019/11/26 14:22
	 */
	public int changeUserMessage(UserMessage request);
}
