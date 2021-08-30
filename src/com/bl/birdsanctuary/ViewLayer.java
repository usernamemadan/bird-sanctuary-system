package com.bl.birdsanctuary;

public class ViewLayer {

	 public void print() {
		 	BirdSanctuaryRespository birdSanctuaryRepository = BirdSanctuaryRespository.getInstance();
	    	for(Bird item: birdSanctuaryRepository.getAllBirds()) {
	    		System.out.println(item);
	    	}
	    }   
	 
	 public void printFlyable() {
		 	BirdSanctuaryRespository birdSanctuaryRepository = BirdSanctuaryRespository.getInstance();
	    	for(Bird bird: birdSanctuaryRepository.getAllBirds()) {
	    		if( bird.canFly) {
	    			bird.fly();
	    		}
	    	}
	    } 
	 
	 public void printSwimmable() {
		 	BirdSanctuaryRespository birdSanctuaryRepository = BirdSanctuaryRespository.getInstance();
	    	for(Bird bird: birdSanctuaryRepository.getAllBirds()) {
	    		if( bird.canSwim ) {
	    			bird.swim();
	    		}
	    	}
	    } 
	 
	 public void printEatable() {
		 	BirdSanctuaryRespository birdSanctuaryRepository = BirdSanctuaryRespository.getInstance();
	    	for(Bird bird: birdSanctuaryRepository.getAllBirds()) {
	    		bird.eat();
	    	}
	    } 
}
