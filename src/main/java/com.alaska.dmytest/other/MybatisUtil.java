package com.alaska.dmytest.other;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * 功能描述:
 *
 * @ClassName: MybatisUtil
 * @Workstation: AlaSKa_
 * @Author: Laoshuaitou-AlaSKa
 * @Date: 2019/11/19 14:19
 * @Version:
 * @Description: 通过SSH通道连接阿里云mysql数据库
 */
public class MybatisUtil {
	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
	private static ThreadLocal<SSHChannel> channelThreadLocal = new ThreadLocal<SSHChannel>();
	private static String PRO_ENV = "ali-staging";

	/**
	 * 禁止外界通过new方法创建
	 */
	private MybatisUtil() {
	}

	public static void main(String[] args) throws Exception {
		SqlSession sqlSession = getSqlsession("ali-staging");
		//执行sql语句，测试是否连接成功
		System.out.println(sqlSession.selectList("getConfigByConfig"));
		closeSqlSession();
	}

	/**
	 * 获取SqlSession
	 */
	public static SqlSession getSqlsession(String envId) throws IOException {

		/**
		 * 加载MybatisConfig.xml配置文件
		 * 配置文件中的连接数据库的地址需要改成“127.0.0.1”，端口需要改成“本地映射端口”
		 */
		try {
			Reader reader = Resources.getResourceAsReader("MybatisConfig.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader, envId);

			if (PRO_ENV.equals(envId)) {
				SSHChannel sshChannel = channelThreadLocal.get();
				if (sshChannel == null) {
					sshChannel = new SSHChannel();
					//建立一个通道，将本地端口通过跳板机映射到远程服务器的指定端口
//					sshChannel.goSSH(本地端口, "跳板机IP",
//							跳板机端口, "跳板机用户名", "跳板机密码(如果没有写 null )",
//							"阿里云数据库IP", 阿里云数据库端口);
					channelThreadLocal.set(sshChannel);
				}
			}

			SqlSession sqlSession = threadLocal.get();
			if (sqlSession == null) {
				sqlSession = factory.openSession();
				threadLocal.set(sqlSession);
			}
			return sqlSession;

		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {

		}

	}

	/**
	 * 关闭SqlSession和sshChannel与当前线程分开
	 */
	public static void closeSqlSession() {
		SqlSession sqlSession = threadLocal.get();
		if (sqlSession != null) {
			sqlSession.close();
			threadLocal.remove();
		}
		SSHChannel sshChannel = channelThreadLocal.get();
		if (sshChannel != null) {
			sshChannel.close();
			channelThreadLocal.remove();
		}

	}
}
