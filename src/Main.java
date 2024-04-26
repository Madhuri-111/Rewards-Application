import java.util.*;
public class Main {

    
 
    public static void main(String[] args) {
    	
    	User Guest = null;
        System.out.println("Welcome To Rewards Application");
        Scanner sc = new Scanner(System.in) ;
        
        // Authentication
        ArrayList<User> users= CommonService.userCreation(5);
        
        while(true) {
	        System.out.println("Please enter you name:");
	        String name = sc.nextLine();
	      
	        System.out.println("Please enter you password:");
	        String password = sc.nextLine();
	        boolean isUserPresent = false;
	        
	        
	        for(User u: users) {
	        	if(u.getName().equals(name)){
	        		isUserPresent = true;
	        		
	        		if(u.getPassword().equals(password)) {
	        			Guest = u;
	        			break;
	        		}
	        	}
	        }
	        
	        if(isUserPresent==false) {
	        	System.out.println("User does not exists.");
	        }
	        else break;
        }
        
        
        ArrayList<Reward> rewards = CommonService.rewardCreation(5) ;
        
        ThreadTransaction t1 = new ThreadTransaction(Guest);
    	t1.start();

        System.out.println("You have " + Guest.getPoints() + " Points which you can redeem.");
        while (true) {
            System.out.println("Enter the Id of the cupen which you want to redeem : ");
            CommonService.showCupens(rewards) ;
            int cupenId = sc.nextInt() ;
            CommonService.redeemCupen(Guest, rewards.get(cupenId - 1)) ;
            System.out.println("Do you want to redeemed more cupen : (Y/N)");
            char c = sc.next().charAt(0) ;
            if(c == 'N') {
                System.out.println("Thank you!");
                TaskManager.setTaskDone(true);
                break;
            }
        }

    }
}