package com.alaska.dmytest.other;

import javax.servlet.ServletContextEvent;

/**
 * 功能描述:
 *
 * @ClassName: MyContextListener
 * @Workstation: AlaSKa_
 * @Author: Laoshuaitou-AlaSKa
 * @Date: 2019/11/19 14:43
 * @Version:
 * @Description:
 */
public class MyContextListener {
	private SSHConnection conexionssh;


	public MyContextListener() {
		super();
	}


	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Context initialized ... !");
		try {
			conexionssh = new SSHConnection();
		} catch (Throwable e) {
			e.printStackTrace(); // error connecting SSH server
		}
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Context destroyed ... !");
		conexionssh.closeSSH(); // disconnect
	}

}
