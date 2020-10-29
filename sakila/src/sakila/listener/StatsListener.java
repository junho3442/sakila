package sakila.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import sakila.service.StatsService;

/**
 * Application Lifecycle Listener implementation class StatsListener
 *
 */
@WebListener
public class StatsListener implements HttpSessionListener {
	private StatsService statsService;
  
	public void sessionCreated(HttpSessionEvent event)  { 
         if(event.getSession().isNew()){ // ������ ���� ������ �������� Ȯ��
        	 StatsService statsService = new StatsService();
        	 statsService.countStats(); // ���ο� ������ �߻��ϸ� �޼��� ����
         }
    }
    public void sessionDestroyed(HttpSessionEvent event)  { 
        
    }
	
}
