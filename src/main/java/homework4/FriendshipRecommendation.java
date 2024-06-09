package homework4;

public class FriendshipRecommendation implements Comparable<FriendshipRecommendation> {
    private String user;
    private int recommendationStrength;

    public FriendshipRecommendation(String user, int recommendationStrength) {
        this.user = user;
        this.recommendationStrength = recommendationStrength;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getRecommendationStrength() {
        return recommendationStrength;
    }

    public void setRecommendationStrength(int recommendationStrength) {
        this.recommendationStrength = recommendationStrength;
    }

    @Override
    public int compareTo(FriendshipRecommendation o) {
        // samo obrnut redoslijed
        if (o.recommendationStrength > this.recommendationStrength) {
            return -1;
        } else if (o.recommendationStrength < this.recommendationStrength) {
            return  1;
        } else {
            return 0;
        }
    }
}
