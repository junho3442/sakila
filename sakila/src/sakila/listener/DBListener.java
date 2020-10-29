package sakila.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class DBListener
 *
 */
@WebListener
public class DBListener implements ServletContextListener {
    public DBListener() {
       
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    //톰켓이 종료될때 실행
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
    //톰켓이 실행될때 실행    
    	try {
    		Class.forName("org.mariadb.jdbc.Driver"); //db 드라이버 연결
    		//여러번 호출하지 않아도 되서
    	}catch(Exception e) { //드라이버 연결 실패시
    		e.printStackTrace();
    		System.out.println("드라이버 연결 실패");
    	}
    }
	
}
