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
    //������ ����ɶ� ����
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
    //������ ����ɶ� ����    
    	try {
    		Class.forName("org.mariadb.jdbc.Driver"); //db ����̹� ����
    		//������ ȣ������ �ʾƵ� �Ǽ�
    	}catch(Exception e) { //����̹� ���� ���н�
    		e.printStackTrace();
    		System.out.println("����̹� ���� ����");
    	}
    }
	
}
