package com.alaska.dmytest.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 功能描述:
 *
 * @ClassName: Schedule
 * @Workstation: AlaSKa_
 * @Author: Laoshuaitou-AlaSKa
 * @Date: 2019/11/19 15:30
 * @Version:1.0
 * @Description:时间段描述实体类
 */
@Data
public class Schedule {
	private int id;
	private int userId;
	private String name;
	private String description;
	private Timestamp begin;
	private Timestamp end;

	@Override
	public String toString() {
		return "Schedule{" +
				"id=" + id +
				", userId=" + userId +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", begin=" + begin +
				", end=" + end +
				'}';
	}

}
