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
         if(event.getSession().isNew()){ // 技记捞 货肺 积己等 技记牢瘤 犬牢
        	 StatsService statsService = new StatsService();
        	 statsService.countStats(); // 货肺款 技记捞 惯积窍搁 皋辑靛 角青
         }
    }
    public void sessionDestroyed(HttpSessionEvent event)  { 
        
    }
	
}
