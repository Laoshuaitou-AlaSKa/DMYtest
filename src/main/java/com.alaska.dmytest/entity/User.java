package com.alaska.dmytest.entity;

import lombok.Data;

/**
 * 功能描述:
 *
 * @ClassName: User
 * @Workstation: AlaSKa_
 * @Author: Laoshuaitou-AlaSKa
 * @Date: 2019/11/19 15:24
 * @Version:
 * @Description:
 */

@Data
public class User {
	private int id;
	private String username;
	private String password;

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
