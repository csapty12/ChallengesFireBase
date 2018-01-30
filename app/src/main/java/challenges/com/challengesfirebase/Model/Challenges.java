package challenges.com.challengesfirebase.Model;

/**
 * Created by carlsaptarshi on 30/01/2018.
 */

public class Challenges {

    private String date;
    private String challengeOne;
    private String challengeTwo;
    private boolean challengeOneCheck;
    private boolean challengeTwoCheck;



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getChallengeOne() {
        return challengeOne;
    }

    public void setChallengeOne(String challengeOne) {
        this.challengeOne = challengeOne;
    }

    public String getChallengeTwo() {
        return challengeTwo;
    }

    public void setChallengeTwo(String challengeTwo) {
        this.challengeTwo = challengeTwo;
    }

    public boolean isChallengeOneCheck() {
        return challengeOneCheck;
    }

    public void setChallengeOneCheck(boolean challengeOneCheck) {
        this.challengeOneCheck = challengeOneCheck;
    }

    public boolean isChallengeTwoCheck() {
        return challengeTwoCheck;
    }

    public void setChallengeTwoCheck(boolean challengeTwoCheck) {
        this.challengeTwoCheck = challengeTwoCheck;
    }
}
