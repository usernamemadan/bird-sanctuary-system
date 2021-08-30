package com.bl.birdsanctuary;

import java.util.EnumSet;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		
		Main mymain = new Main();
		mymain.showUserMenu();

		/*
		 * Duck duck = new Duck(); duck.id = "d001"; Ostrich ostrich = new Ostrich();
		 * ostrich.id = "o001"; Parrot parrot = new Parrot(); parrot.id = "p001";
		 * Penguin penguin = new Penguin(); penguin.id = "pn001"; Penguin penguin2 =new
		 * Penguin(); penguin2.id = "pn001";
		 * 
		 * BirdSanctuaryRespository birdSanctuaryRepository = new
		 * BirdSanctuaryRespository();
		 * 
		 * birdSanctuaryRepository.add(duck); birdSanctuaryRepository.add(ostrich);
		 * birdSanctuaryRepository.add(parrot); birdSanctuaryRepository.add(penguin);
		 * birdSanctuaryRepository.add(penguin); birdSanctuaryRepository.add(penguin2);
		 * 
		 * birdSanctuaryRepository.print();
		 * 
		 * birdSanctuaryRepository.remove(penguin);
		 * birdSanctuaryRepository.remove(parrot);
		 * 
		 * System.out.println("After the deletion"); birdSanctuaryRepository.print();
		 */
	}

	void showUserMenu() {
		int choice = 0;
		Scanner scanner = new Scanner(System.in);
		final int EXIT_VALUE = 10;

		while (choice != EXIT_VALUE) {
			System.out.println("Enter your choice");
			System.out.println("1.add a bird \n2.remove the bird \n3.print the birds \n4.print swimmab"
					+ "e \n5.print flyable \n6.print eatable \n7.Edit bird \n" + EXIT_VALUE + ".exit\n ");
			choice = scanner.nextInt();
			ViewLayer viewLayer = new ViewLayer();

			BirdSanctuaryRespository birdSanctuaryRepository;
			Bird bird;
			switch (choice) {
			case 1:
			    addTemporaryBirds();
				addBird();
				
				
//				Duck duck = new Duck(); 
//				duck.id = "d001"; 
//				Ostrich ostrich = new Ostrich();
//				ostrich.id = "o001"; 
//				Parrot parrot = new Parrot(); 
//				parrot.id = "p001";
//				Penguin penguin = new Penguin(); 
//				penguin.id = "pn001";
//				Penguin penguin2 =new Penguin(); 
//				penguin2.id = "pn001";
//				 
//				BirdSanctuaryRespository birdSanctuaryRepository = BirdSanctuaryRespository.getInstance();
//				birdSanctuaryRepository.add(duck); 
//				birdSanctuaryRepository.add(ostrich);
//				birdSanctuaryRepository.add(parrot);
//				birdSanctuaryRepository.add(penguin);
//				birdSanctuaryRepository.add(penguin); 
//				birdSanctuaryRepository.add(penguin2); 
				
				
				break;
				
			case 2:
				String birdName;
				System.out.println("enter the bird name to remove");
				birdName = scanner.next();
	            
				birdSanctuaryRepository = BirdSanctuaryRespository.getInstance();
				bird = birdSanctuaryRepository.getBird(birdName);
				birdSanctuaryRepository.remove(bird);
				break;
				
			case 3:
				viewLayer.print();
				break;
				
			case 4:
				viewLayer.printSwimmable();
				break;
				
			case 5:
				viewLayer.printFlyable();
				break;
				
			case 6:
				viewLayer.printEatable();
				break;
				
			case 7:
				editBird();
				
				break;
			}

		}
	}
	
	//remove this function later
	
	private void addTemporaryBirds() {
		
		Bird duck = new Bird();
		duck.name = "duck";
		duck.id = "d001";
		duck.color = Bird.Color.WHITE;
		duck.canFly = true ;
		duck.canSwim = true ;
		BirdSanctuaryRespository.getInstance().add(duck);
		
	
		
		Bird penguin = new Bird();
		penguin.name = "penguin";
		penguin.id = "p001";
		penguin.color = Bird.Color.BLACK_WHITE;
		penguin.canFly = false ;
		penguin.canSwim = true ;
		BirdSanctuaryRespository.getInstance().add(penguin);
		
	}
	
	private void addBird(){
		Bird bird = new Bird();
		System.out.println("Enter the id");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.nextLine();
		bird.id = id;
		System.out.println("enter the name");
		String name = scanner.nextLine();
		bird.name = name;
		System.out.println("enter the new color");
		System.out.println("choose the color");
		
		int count = 1;
		for(Bird.Color color: EnumSet.allOf(Bird.Color.class)) {
			System.out.println(""+count+"."+color);
			count++;
		}
		
		int colorChoice = scanner.nextInt();
		int count1 = 1;
		for(Bird.Color color: EnumSet.allOf(Bird.Color.class)) {
			if( colorChoice == count1) {
				bird.color = color;
				break;
			}
			count1++;
		}
		System.out.println("can the bird fly");
	    Boolean canFly = scanner.nextBoolean();
	    bird.canFly = canFly;
	    
	    System.out.println("cant the bird swim");
	    Boolean canSwim = scanner.nextBoolean();
	    bird.canSwim = canSwim;
	    
	    
	    BirdSanctuaryRespository birdSanctuaryRepository = BirdSanctuaryRespository.getInstance();
	    birdSanctuaryRepository.add(bird);
		
	}
	
	private void editBird() {
		System.out.println("Enter bird name to edit");
		Scanner scanner = new Scanner(System.in);
		String birdname = scanner.nextLine();
		Bird editBird = BirdSanctuaryRespository.getInstance().getBird(birdname);
		
		
		int choice = 0;
		while(choice != 4) {
			System.out.println("1.edit bird \n2.Edit id \n3.edit color \n4.back");
			choice = scanner.nextInt();
			
			switch( choice ) {
			case 1:
				System.out.println("enter the new name");
				scanner.nextLine();
				String bname = scanner.nextLine();
				editBird.name = bname;
				break;
			case 2:
				System.out.println("Enter the new id");
				scanner.nextLine();
				String id = scanner.nextLine();
				editBird.id = id;
				break;
			case 3:
				System.out.println("enter the new color");
				System.out.println("choose the color");
				
				int count = 1;
				for(Bird.Color color: EnumSet.allOf(Bird.Color.class)) {
					System.out.println(""+count+"."+color);
					count++;
				}
				
				int colorChoice = scanner.nextInt();
				int count1 = 1;
				for(Bird.Color color: EnumSet.allOf(Bird.Color.class)) {
					if( colorChoice == count1) {
						editBird.color = color;
						break;
					}
					count1++;
				}
				break;
			
			case 4:return;	
			}
		}
		
	}
}
