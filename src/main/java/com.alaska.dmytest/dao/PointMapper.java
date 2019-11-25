package com.alaska.dmytest.dao;

import com.alaska.dmytest.entity.Point;

import java.util.List;

/**
 * 功能描述:
 *
 * @ClassName: PointMapper
 * @Workstation: AlaSKa_
 * @Author: Laoshuaitou-AlaSKa
 * @Date: 2019/11/26 1:30
 * @Version:1.0
 * @Description:时间点操作 DAO
 */
public interface PointMapper {
	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: PointMapper.createPoint
	 * 功能描述: 创建一个时间点
	 *
	 * @params: [point] 被创建的时间点实体
	 * @return: int 成功创建的时间点数量
	 * @Date: 2019/11/26 1:32
	 */
	int createPoint(Point point);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: PointMapper.deletePointByUserId
	 * 功能描述: 通过时间点ID删除时间点
	 *
	 * @params: [userId] 用户ID
	 * @return: int 被删除时间点数
	 * @Date: 2019/11/26 1:37
	 */
	int deletePointByUserId(int userId);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: PointMapper.deletePointByName
	 * 功能描述: 对某个时间点下的时间点，通过时间点名删除时间点
	 *
	 * @params: [userId, name] 用户ID 时间点名
	 * @return: int 被删除时间点数
	 * @Date: 2019/11/26 1:39
	 */
	int deletePointByName(int userId,String name);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: PointMapper.deletePointById
	 * 功能描述: 通过时间点ID删除时间点
	 *
	 * @params: [id] 时间点ID
	 * @return: int 被删除时间点数
	 * @Date: 2019/11/26 1:41
	 */
	int deletePointById(int id);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: PointMapper.updatePoint
	 * 功能描述: 修改时间点
	 *
	 * @params: [point] 被修改时间点实体
	 * @return: int 被修改时间点数
	 * @Date: 2019/11/26 1:42
	 */
	int updatePoint(Point point);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: PointMapper.selectPointById
	 * 功能描述: 通过ID查询时间点（ID唯一对应一个时间点实体）
	 *
	 * @params: [id] 时间点ID
	 * @return: com.alaska.dmytest.entity.Point 被查询的单个时间点实体
	 * @Date: 2019/11/26 1:46
	 */
	Point selectPointById(int id);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: PointMapper.selectPointsByUserId
	 * 功能描述: 通过用户ID查询所有该用户下的时间点
	 *
	 * @params: [userId] 用户ID
	 * @return: java.util.List<com.alaska.dmytest.entity.Point> 被查询的该用户下的所有时间点
	 * @Date: 2019/11/26 1:47
	 */
	List<Point> selectPointsByUserId(int userId);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: PointMapper.selectPointByName
	 * 功能描述: 通过时间点名查询时间点
	 *
	 * @params: [userId, name] 用户ID 时间点名
	 * @return: java.util.List<com.alaska.dmytest.entity.Point> 通过时间点名查询指定用户ID下的所有时间点
	 * @Date: 2019/11/26 1:49
	 */
	List<Point> selectPointByName(int userId,String name);

	/**
	 * @Workstation:AlaSKa_
	 * @Author: Laoshuaitou-AlaSKa
	 * @methodName: PointMapper.selectAllPoint
	 * 功能描述: 查询所有时间点
	 *
	 * @params: []
	 * @return: java.util.List<com.alaska.dmytest.entity.Point> 所有时间点集
	 * @Date: 2019/11/26 1:50
	 */
	List<Point> selectAllPoint();
}
