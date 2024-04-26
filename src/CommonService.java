import java.util.ArrayList;
import java.util.Random;

public class CommonService {
	
	public static String generateCouponCode(int length) {
        Random random = new Random();
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < length; i++) {
            // ASCII range for uppercase and lowercase letters: A-Z (65-90), a-z (97-122)
            int randomType = random.nextInt(2);
            int asciiValue = 0;

            if (randomType == 0) {
                asciiValue = random.nextInt(26) + 65; // Uppercase letter
            } else {
                asciiValue = random.nextInt(26) + 97; // Lowercase letter
            }

            code.append((char) asciiValue);
        }

        return code.toString();
    }
	
	
    public static void redeemCupen(User user, Reward rd) {
        System.out.println("USER POINTS " + user.getPoints());
        System.out.println("REWARD VALUE " + rd.getValue());
        if(user.getPoints() > rd.getValue()) {
            user.setPoints(user.getPoints() - rd.getValue());
            user.setRedeemedPoints(user.getRedeemedPoints()+ rd.getValue()); 
            user.addRedeemedGiftCards(user, rd);
            System.out.println("You have successfully redeemed coupen");
            System.out.println("Your remaining points : " + user.getPoints());
        }
        else{
            System.out.println("You don't have enough points to redeem the cupen");
        }
    }
    
 
    
    public static ArrayList<Reward> rewardCreation(int n) {
        ArrayList<Reward> rewards = new ArrayList<Reward>(n) ;

        for(int i = 1; i <= n; i++) {
            String coupen =  generateCouponCode(10) ;
            Reward r = new Reward(i, "Category1", coupen, 1000 * i) ;
            rewards.add(r) ;
        }
        return rewards ;
    }
    
    

    public static void showCupens(ArrayList<Reward> rewards) {
        System.out.println("You have following Cupens ");
        System.out.println("===========================================================");
        for (Reward r : rewards) {
            System.out.println("Cupen Id : " + r.getId());
            System.out.println("Cupen Category : " + r.getCategory());
            System.out.println("Cupen Name : " + r.getName());
            System.out.println("Cupen Value : " + r.getValue());
            System.out.println();
        }
    }
    


	public static void updatePoints(User u) {
		// TODO Auto-generated method stub
		u.setPoints(u.getPoints()+200);
    	System.out.println("UPDATED POINTS OF USER: " + u.getPoints());
		
	}
	
	 public static String generateFirstName() {
	        Random random = new Random();
	        StringBuilder firstNameBuilder = new StringBuilder();

	        // Define characters to be used in the name
	        String characters = "abcdefghijklmnopqrstuvwxyz";

	        // Generate a random name of length 5
	        for (int i = 0; i < 5; i++) {
	            int index = random.nextInt(characters.length());
	            firstNameBuilder.append(characters.charAt(index));
	        }

	        return firstNameBuilder.toString();
	    }


	public static ArrayList<User> userCreation(int n) {
		// TODO Auto-generated method stub
		  ArrayList<User> users = new ArrayList<User>(n) ;

	        for(int i = 1; i <= n; i++) {
	        	String name = generateFirstName();
	            User u = new User(i, name,name, 5000,0, new ArrayList<>() ) ;
	            System.out.println("**********"+ name);
	            users.add(u) ;
	        }
	        return users ;
	}


	
}
