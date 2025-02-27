package com.hasnat.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

//@PropertySource("classpath:application.properties")
@Component("vehical")
public class Vehical {

	
	 /* private IEngine engine;
	  
	  public Vehical(@Value("${engine.id}") String engineId, ApplicationContext
	  ctx) { this.engine = ctx.getBean(engineId, IEngine.class); // Manually
	  fetching bean }
	*/ 
    
    @Autowired
    private ApplicationContext ctx; // To dynamically fetch beans

    @Value("${engine.id}") // Engine ID from properties
    private String engineId;

    private IEngine engine;

    @PostConstruct // Runs after the object is created
    public void init() {
        this.engine = ctx.getBean(engineId, IEngine.class);
    }
    
 

    public void journey(String startPlace, String endPlace) {
        engine.startEngine();
        System.out.println("Journey is started from :: " + startPlace);
        System.out.println("Journey is going on ::");
        engine.stopEngine();
        System.out.println("Journey is ended at :: " + endPlace);
    }
}
