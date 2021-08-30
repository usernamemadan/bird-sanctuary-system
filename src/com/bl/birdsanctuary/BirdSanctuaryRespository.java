package com.bl.birdsanctuary;

import java.util.HashSet;
import java.util.Set;

public class BirdSanctuaryRespository {

	private static BirdSanctuaryRespository instance;
	
	Set<Bird> birdList = new HashSet();
	
	private BirdSanctuaryRespository() {
		
	}
	
	static synchronized BirdSanctuaryRespository getInstance() {
		if(instance == null)
			instance = new BirdSanctuaryRespository();
		return instance;
	}
    
    public void add(Bird bird) {
    	birdList.add(bird);
    	
    }
    
    public void remove(Bird bird) {
    	birdList.remove(bird);
    }
    
    public Bird getBird(String birdName) {
    	for(Bird b: birdList) {
    		if(b.name.equals(birdName))
    			return b;
    	}
    	return null;
    }
    
    public Set<Bird> getAllBirds() {
    	return birdList;
    }
}
