package com.alaska.dmytest.entity;

import lombok.Data;

/**
 * 功能描述:
 *
 * @ClassName: UserMessage
 * @Workstation: AlaSKa_
 * @Author: Laoshuaitou-AlaSKa
 * @Date: 2019/11/19 15:28
 * @Version:1.0
 * @Description:用户详细信息实体类
 */
@Data
public class UserMessage {
	private int id;
	private int userId;
	private String nickname;
	private String sex;

	@Override
	public String toString() {
		return "UserMessage{" +
				"id=" + id +
				", userId=" + userId +
				", nickname='" + nickname + '\'' +
				", sex='" + sex + '\'' +
				'}';
	}
}
