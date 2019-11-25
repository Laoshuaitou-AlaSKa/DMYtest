package com.alaska.dmytest.dao;

import com.alaska.dmytest.entity.Schedule;

import java.util.List;

/**
 * 功能描述:
 *
 * @ClassName: ScheduleMapper
 * @Workstation: AlaSKa_
 * @Author: Laoshuaitou-AlaSKa
 * @Date: 2019/11/26 1:50
 * @Version:1.0
 * @Description:时间段操作 DAO
 */
public interface ScheduleMapper {
	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: ScheduleMapper.createSchedule
	 * 功能描述: 创建一个时间段
	 *
	 * @params: [schedule] 时间段实体
	 * @return: int 返回被创建时间段数
	 * @Date: 2019/11/26 1:56
	 */
	int createSchedule(Schedule schedule);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: ScheduleMapper.deleteScheduleById
	 * 功能描述: 通过唯一ID删除一个时间段
	 *
	 * @params: [id] 时间段唯一ID
	 * @return: int 返回被删除时间段数
	 * @Date: 2019/11/26 1:56
	 */
	int deleteScheduleById(int id);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: ScheduleMapper.deleteScheduleByUserId
	 * 功能描述: 通过用户ID批量删除属于该用户的时间段
	 *
	 * @params: [userId] 用户ID
	 * @return: int 返回被删除时间段数
	 * @Date: 2019/11/26 1:57
	 */
	int deleteScheduleByUserId(int userId);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: ScheduleMapper.deleteScheduleByName
	 * 功能描述: 通过时间段名删除属于某一用户的具体时间段
	 *
	 * @params: [userId, name] 用户ID 时间段名
	 * @return: int 返回被删除时间段数
	 * @Date: 2019/11/26 1:58
	 */
	int deleteScheduleByName(int userId,String name);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: ScheduleMapper.updateSchedule
	 * 功能描述: 修改一个时间段信息
	 *
	 * @params: [schedule] 被修改时间段实体
	 * @return: int 返回被修改时间段数
	 * @Date: 2019/11/26 1:58
	 */
	int updateSchedule(Schedule schedule);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: ScheduleMapper.selectScheduleById
	 * 功能描述: 通过唯一ID查询某个时间段
	 *
	 * @params: [id] 时间段唯一ID
	 * @return: com.alaska.dmytest.entity.Schedule 被查询的时间段
	 * @Date: 2019/11/26 1:59
	 */
	Schedule selectScheduleById(int id);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: SchedulesMapper.selectScheduleByUserId
	 * 功能描述: 通过用户ID查询属于该用户的时间段集
	 *
	 * @params: [userId] 用户ID
	 * @return: java.util.List<com.alaska.dmytest.entity.Schedule> 被查询的属于该用户的时间段实体集
	 * @Date: 2019/11/26 1:59
	 */
	List<Schedule> selectSchedulesByUserId(int userId);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: ScheduleMapper.selectScheduleByName
	 * 功能描述: 通过时间段名查询属于某一用户的时间段集
	 *
	 * @params: [userId, name]
	 * @return: java.util.List<com.alaska.dmytest.entity.Schedule> 被查询的属于某一用户的具体时间段实体集
	 * @Date: 2019/11/26 2:00
	 */
	List<Schedule> selectScheduleByName(int userId,String name);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: ScheduleMapper.selectAllSchedule
	 * 功能描述: 查询所有时间段信息
	 *
	 * @params: []
	 * @return: java.util.List<com.alaska.dmytest.entity.Schedule> 所有时间段实体集
	 * @Date: 2019/11/26 2:01
	 */
	List<Schedule> selectAllSchedule();
}
