import java.util.ArrayList;

public class User {
    int id ;
    String name ;
    String password;
	int points ;
    int redeemedPoints ;
    ArrayList<Reward> redeemedGiftCards;
    
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    synchronized public int getPoints() {
        return points;
    }

    synchronized public void setPoints(int points) {
        this.points = points;
    }

    public int getRedeemedPoints() {
        return redeemedPoints;
    }

    public void setRedeemedPoints(int redeemedPoints) {
        this.redeemedPoints = redeemedPoints;
    }

    public ArrayList<Reward> getRedeemedGiftCards() {
        return redeemedGiftCards;
    }

    public void setRedeemedGiftCards(ArrayList<Reward> redeemedGiftCards) {
//      Optimize
        this.redeemedGiftCards = redeemedGiftCards;
    }

    public void addRedeemedGiftCards(User user, Reward r) {
        redeemedGiftCards.add(r) ;
    }


    public User(int id, String name, String password, int points, int redeemedPoints, ArrayList<Reward> redeemedGiftCards) {
        this.id = id;
        this.name = name;
        this.password=password;
        this.points = points;
        this.redeemedPoints = redeemedPoints;
        this.redeemedGiftCards = redeemedGiftCards;
    }
}
