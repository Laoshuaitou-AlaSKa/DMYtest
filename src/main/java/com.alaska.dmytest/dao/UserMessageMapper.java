package com.alaska.dmytest.dao;

import com.alaska.dmytest.entity.UserMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 功能描述:
 *
 * @ClassName: UserMessageMapper
 * @Workstation: AlaSKa_
 * @Author: Laoshuaitou-AlaSKa
 * @Date: 2019/11/26 1:12
 * @Version:1.0
 * @Description:UserMessage DAO
 */
public interface UserMessageMapper {
	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: UserMessageMapper.createUserMessage
	 * 功能描述: 创建用户详细信息
	 * @params: [userMessage] 具体用户详细信息实体
	 * @return: int 返回被创建实体数
	 * @Date: 2019/11/26 1:16
	 */
	int createUserMessage(@Param("userMessage") UserMessage userMessage);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: UserMessageMapper.deleteUserMessageByUserId
	 * 功能描述: 通过用户ID删除用户详细信息
	 * @params: [userId] 被删除的用户ID
	 * @return: int 被删除的用户实体数
	 * @Date: 2019/11/26 1:19
	 */
	int deleteUserMessageByUserId(@Param("userId") int userId);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: UserMessageMapper.deleteUserMessageByNickname
	 * 功能描述: 通过用户昵称删除用户详细信息
	 * @params: [nickname] 被删除的用户昵称
	 * @return: int 被删除用户实体数
	 * @Date: 2019/11/26 1:19
	 */
	int deleteUserMessageByNickname(@Param("nickname") String nickname);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: UserMessageMapper.updateUserMessageByUserId
	 * 功能描述: 通过用户ID修改用户详细数据
	 * @params: [userId, userMessage] 需要修改的用户ID 具体被修改的用户实体
	 * @return: int 被修改的用户数
	 * @Date: 2019/11/26 1:21
	 */
	int updateUserMessageByUserId(@Param("userId") int userId, @Param("userMessage") UserMessage userMessage);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: UserMessageMapper.selectUserMessageByUserId
	 * 功能描述: 通过用户ID查询用户
	 * @params: [userId] 用户ID
	 * @return: com.alaska.dmytest.entity.UserMessage 被查询的用户详细信息实体
	 * @Date: 2019/11/26 1:25
	 */
	UserMessage selectUserMessageByUserId(@Param("userId") int userId);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: UserMessageMapper.selectUserMessageByNicknaem
	 * 功能描述: 通过昵称查询用户
	 * @params: [nickname] 用户昵称
	 * @return: com.alaska.dmytest.entity.UserMessage 被查询的用户详细信息实体
	 * @Date: 2019/11/26 1:25
	 */
	UserMessage selectUserMessageByNickname(@Param("nickname") String nickname);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: UserMessageMapper.selectUserMessagesBySex
	 * 功能描述: 通过性别查询用户集
	 * @params: [sex] 用户性别
	 * @return: java.util.List<com.alaska.dmytest.entity.UserMessage> 用户详细信息实体集
	 * @Date: 2019/11/26 1:28
	 */
	List<UserMessage> selectUserMessagesBySex(@Param("sex") String sex);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: UserMessageMapper.selectAllUserMessages
	 * 功能描述: 查询所用用户集
	 * @params: []
	 * @return: java.util.List<com.alaska.dmytest.entity.UserMessage> 所用用户集
	 * @Date: 2019/11/26 1:28
	 */
	List<UserMessage> selectAllUserMessages();
}
