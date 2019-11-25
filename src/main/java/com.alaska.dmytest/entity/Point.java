package com.alaska.dmytest.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 功能描述:
 *
 * @ClassName: Point
 * @Workstation: AlaSKa_
 * @Author: Laoshuaitou-AlaSKa
 * @Date: 2019/11/20 15:03
 * @Version:1.0
 * @Description:时间点描述实体类
 */
@Data
public class Point {
	private int id;
	private int userId;
	private String name;
	private String description;
	private Timestamp time;

	@Override
	public String toString() {
		return "Point{" +
				"id=" + id +
				", userId=" + userId +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", time=" + time +
				'}';
	}
}
