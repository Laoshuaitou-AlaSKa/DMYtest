package com.alaska.dmytest.other;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.util.Properties;

/**
 * 功能描述:
 *
 * @ClassName: SSHConnection
 * @Workstation: AlaSKa_
 * @Author: Laoshuaitou-AlaSKa
 * @Date: 2019/11/19 14:42
 * @Version:
 * @Description:
 */
public class SSHConnection {
	private final static String S_PATH_FILE_PRIVATE_KEY = "/Users/Ala/.ssh/id_rsa";
	private final static String S_PATH_FILE_KNOWN_HOSTS = "/Users/hdwang/.ssh/known_hosts";
	private final static String S_PASS_PHRASE = "";
	private final static int LOCAl_PORT = 3306;
	private final static int REMOTE_PORT = 3306;
	private final static int SSH_REMOTE_PORT = 22;
	private final static String SSH_USER = "root";
	private final static String SSH_PASSWORD = "Cao83809988";
	private final static String SSH_REMOTE_SERVER = "101.132.128.122";
	private final static String MYSQL_REMOTE_SERVER = "123.mysql.com";

	private Session sesion; //represents each ssh session

	public void closeSSH ()
	{
		sesion.disconnect();
	}

	public SSHConnection () throws Throwable
	{

		JSch jsch = null;

		jsch = new JSch();
//		jsch.setKnownHosts(S_PATH_FILE_KNOWN_HOSTS);
		jsch.addIdentity(S_PATH_FILE_PRIVATE_KEY);

		sesion = jsch.getSession(SSH_USER, SSH_REMOTE_SERVER, SSH_REMOTE_PORT);

		sesion.setPassword(SSH_PASSWORD);

		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		sesion.setConfig(config);

		sesion.connect(); //ssh connection established!

		//by security policy, you must connect through a fowarded port
		sesion.setPortForwardingL(LOCAl_PORT, MYSQL_REMOTE_SERVER, REMOTE_PORT);

	}
}
