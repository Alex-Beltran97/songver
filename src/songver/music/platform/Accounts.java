package songver.music.platform;

import java.util.ArrayList;
import java.util.List;

public class Accounts {
    private static Accounts instance;
    private final List<Profile> profiles;
    private Profile authUser;
    private int authUserIdx;
    private Accounts() {
        this.profiles = new ArrayList<>();
        this.authUser = null;
        this.authUserIdx = 0;
    }

    public static Accounts getInstance() {
        if (instance == null) {
            instance = new Accounts();
        }
        return instance;
    }

    public void createProfile(Profile profile) {
        profiles.add(profile);
    }

    public void editProfile(Profile profile) {
        Profile currentProfile = profiles.get(authUserIdx);
        currentProfile.setUserName(profile.getUserName());
        currentProfile.setEmailAddress(profile.getEmailAddress());
        currentProfile.setPassword(profile.getPassword());
    }

    public void deleteProfile() {
        profiles.remove(authUserIdx);
        logOutUser();
    }

    public void findUser(String email) {
        for (int i = 0; i < profiles.size(); i++) {
            Profile profile = profiles.get(i);
            if (profile.getEmailAddress().equals(email)) {
                authUser = profile;
                authUserIdx = i;
                break;
            }
        }

        if (authUser == null) {
            throw new Error("User is not exist. Please try again.");
        }
    }

    public void validatePassword(String password) {
       if (!password.equals(authUser.getPassword())) {
           authUser = null;
           authUserIdx = -1;
           throw new Error("Given password is wrong. Please try again.");
       }
    }

    public Profile getAuthUser() {
        return authUser;
    }

    public void logOutUser() {
        this.authUser = null;
        this.authUserIdx = -1;
    }
}
