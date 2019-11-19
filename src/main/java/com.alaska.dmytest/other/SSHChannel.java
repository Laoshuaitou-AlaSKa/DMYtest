package com.alaska.dmytest.other;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/**
 * 功能描述:
 *
 * @ClassName: SSHChannel
 * @Workstation: AlaSKa_
 * @Author: Laoshuaitou-AlaSKa
 * @Date: 2019/11/19 14:20
 * @Version:
 * @Description:
 */
public class SSHChannel {
	private Session session;
	private Channel channel;
	private String sshPrvKey = "~/.ssh/id_rsa";//SSH证书存放的目录

	/**
	 *
	 * @param localPort  本地host 建议mysql 3306 redis 6379
	 * @param sshHost   ssh host
	 * @param sshPort   ssh port
	 * @param sshUserName   ssh 用户名
	 * @param sshPassWord   ssh密码
	 * @param remotoHost   远程机器地址
	 * @param remotoPort	远程机器端口
	 */
	public void goSSH(int localPort, String sshHost, int sshPort,
					  String sshUserName, String sshPassWord,
					  String remotoHost, int remotoPort) {
		try {
			JSch jsch = new JSch();
			//如果使用证书登入ssh的方式，如果使用密码可以不需要这行
			jsch.addIdentity(sshPrvKey);
			//登陆跳板机
			session = jsch.getSession(sshUserName, sshHost, sshPort);
			session.setPassword(sshPassWord);
			session.setConfig("StrictHostKeyChecking", "no");
			session.connect();
			//建立通道
			channel = session.openChannel("session");
			channel.connect();
			//通过ssh连接到mysql机器
			int assinged_port = session.setPortForwardingL(localPort, remotoHost, remotoPort);
			System.out.println("通道建立成功，映射端口号："+assinged_port);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭
	 */
	public void close() {
		if (session != null && session.isConnected() ) {
			session.disconnect();
		}

		if (channel != null && session.isConnected() ) {
			channel.disconnect();
		}
	}
}
