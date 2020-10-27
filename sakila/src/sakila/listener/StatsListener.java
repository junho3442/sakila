package sakila.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class StatsListener
 *
 */
@WebListener
public class StatsListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent event)  { 
         if(event.getSession().isNew()){ // 技记捞 货肺 积己等 技记牢瘤 犬牢
        	 StatsService statsService = new StatsService();
        	 
         }
    }
    public void sessionDestroyed(HttpSessionEvent event)  { 
        
    }
	
}
