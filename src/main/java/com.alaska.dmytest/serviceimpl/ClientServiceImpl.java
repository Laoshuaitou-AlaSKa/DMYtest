package com.alaska.dmytest.serviceimpl;

import com.alaska.dmytest.dao.UserMapper;
import com.alaska.dmytest.dao.UserMessageMapper;
import com.alaska.dmytest.entity.User;
import com.alaska.dmytest.entity.UserMessage;
import com.alaska.dmytest.service.ClientService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 功能描述:
 *
 * @ClassName: ClientServiceImpl
 * @Workstation: AlaSKa_
 * @Author: Laoshuaitou-AlaSKa
 * @Date: 2019/11/26 14:35
 * @Version:
 * @Description:
 */
public class ClientServiceImpl implements ClientService{
	private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	private UserMapper userMapper = applicationContext.getBean(UserMapper.class);
	private UserMessageMapper userMessageMapper = applicationContext.getBean(UserMessageMapper.class);
	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: ClientServiceImpl.regist
	 * 功能描述: 客户端注册功能实现模块
	 * 检测一：应检查用户是否创建相同用户名的用户
	 *
	 * @params: [request, requestMessage]
	 * @return: int 返回是否成功执行创建操作
	 * @Date: 2019/11/26 14:39
	 */
	@Override
	public int regist(User request, UserMessage requestMessage) {
		/*-
		 - @Workstation:AlaSKa_
		 - @Author: Laoshuaitou-AlaSKa
		 - @methodName: ClientServiceImpl.regist
		 - 部分功能描述: 检查用户名是否已被占用
		 -*/
		User check = userMapper.selectUserByUsername(request.getUsername());
		if (check.getId()!=0){
			return -1;
		}

		/*-
		 - @Workstation:AlaSKa_
		 - @Author: Laoshuaitou-AlaSKa
		 - @methodName: ClientServiceImpl.regist
		 - 部分功能描述: 同步用户ID
		 -*/
		request.setId(userMapper.getMaxId()+1);
		requestMessage.setUserId(request.getId());

		/*-
		 - @Workstation:AlaSKa_
		 - @Author: Laoshuaitou-AlaSKa
		 - @methodName: ClientServiceImpl.regist
		 - 部分功能描述: 创建用户
		 - @Date: 2019/11/26 15:16
		 -*/
		int userCreateId = userMapper.createUser(request);
		int userMessageCreateId = userMessageMapper.createUserMessage(requestMessage);

		/*-
		 - @Workstation:AlaSKa_
		 - @Author: Laoshuaitou-AlaSKa
		 - @methodName: ClientServiceImpl.regist
		 - 部分功能描述: 判断是否创建成功
		 - @Date: 2019/11/26 15:17
		 -*/
		if (userCreateId == 0){
			return 0;
		}
		if (userMessageCreateId == 0){
			return 0;
		}
		return 1;
	}

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: ClientServiceImpl.changeUserMessage
	 * 功能描述: 修改用户信息功能
	 *
	 * @params: [request] 将被修改的用户信息实体
	 * @return: int 返回被修改的数据数
	 * @Date: 2019/11/26 15:18
	 */
	@Override
	public int changeUserMessage(UserMessage request) {
		/*-
		 - @Workstation:AlaSKa_
		 - @Author: Laoshuaitou-AlaSKa
		 - @methodName: ClientServiceImpl.changeUserMessage
		 - 部分功能描述: 执行修改
		 - @Date: 2019/11/26 15:20
		 -*/
		int updateId = userMessageMapper.updateUserMessageByUserId(request.getUserId(),request);
		return updateId;
	}

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: ClientServiceImpl.login
	 * 功能描述: 客户端登陆模块
	 *
	 * @params: [request] 登陆实体
	 * @return: int 返回已登录的用户ID
	 * @Date: 2019/11/26 15:22
	 */
	@Override
	public int login(User request) {
		/*-
		 - @Workstation:AlaSKa_
		 - @Author: Laoshuaitou-AlaSKa
		 - @methodName: ClientServiceImpl.login
		 - 部分功能描述: 初始化用于登录保持的用户ID
		 - @Date: 2019/11/26 15:26
		 -*/
		int loginId = 0;

		/*-
		 - @Workstation:AlaSKa_
		 - @Author: Laoshuaitou-AlaSKa
		 - @methodName: ClientServiceImpl.login
		 - 部分功能描述: 查询用户信息
		 - @Date: 2019/11/26 15:26
		 -*/
		User query = userMapper.selectUserByUsername(request.getUsername());
		/*-
		 - @Workstation:AlaSKa_
		 - @Author: Laoshuaitou-AlaSKa
		 - @methodName: ClientServiceImpl.login
		 - 部分功能描述: 若未查询到，则用户名错误，返回0，表示用户名或密码输入错误
		 - @Date: 2019/11/26 15:27
		 -*/
		if (query == null){
			return 0;
		}
		/*-
		 - @Workstation:AlaSKa_
		 - @Author: Laoshuaitou-AlaSKa
		 - @methodName: ClientServiceImpl.login
		 - 部分功能描述: 若密码比对一致，则返回用户ID
		 - @Date: 2019/11/26 15:28
		 -*/
		if (query.getPassword().equals(request.getPassword())){
			loginId = query.getId();
			return loginId;
		}
		/*-
		 - @Workstation:AlaSKa_
		 - @Author: Laoshuaitou-AlaSKa
		 - @methodName: ClientServiceImpl.login
		 - 部分功能描述: 若密码比对不一致，则密码错误，返回0，表示用户名或密码输入错误
		 - @Date: 2019/11/26 15:28
		 -*/
		return 0;
	}

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: ClientServiceImpl.changePassword
	 * 功能描述: 修改密码操作
	 * 前提条件：1. 用户必须已登录（userid正确）
	 * 			 2. 用户必须正确输入原始密码
	 *
	 * @params: [oldPassword, newPassword] 旧密码 新密码
	 * @return: int 返回是否成功执行修改密码操作
	 * @Date: 2019/11/26 15:29
	 */
	@Override
	public int changePassword(String oldPassword,String newPassword) {
		/*-
		 - @Workstation:AlaSKa_ 
		 - @Author: Laoshuaitou-AlaSKa
		 - @methodName: ClientServiceImpl.changePassword
		 - 部分功能描述: 判断用户是否已登录
		 - @Date: 2019/11/26 15:33
		 -*/
		
		/*-
		 - @Workstation:AlaSKa_ 
		 - @Author: Laoshuaitou-AlaSKa
		 - @methodName: ClientServiceImpl.changePassword
		 - 部分功能描述: 
		 - @Date: 2019/11/26 15:33
		 -*/
		return 0;
	}

	@Override
	public UserMessage showUserMessage(int userId) {
		return null;
	}
}
