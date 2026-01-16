package songver.music.platform;

import java.util.ArrayList;
import java.util.List;

public class Accounts {
    private static Accounts instance;
    private final List<Profile> profiles;
    private Profile authUser;
    private Accounts() {
        this.profiles = new ArrayList<>();
        this.authUser = null;
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

    public void findUser(String email) {
        for (Profile profile: profiles) {
            if (profile.getEmailAddress().equals(email)) {
                authUser = profile;
                break;
            }
        };

        if (authUser == null) {
            throw new Error("User is not exist. Please try again.");
        }
    }

    public void validatePassword(String password) {
       if (!password.equals(authUser.getPassword())) {
           authUser = null;
           throw new Error("Given password is wrong. Please try again.");
       }
    }

    public Profile getAuthUser() {
        return authUser;
    }
}
