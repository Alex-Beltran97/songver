package songver.music.forms;

import songver.music.platform.Accounts;
import songver.music.platform.Profile;

public class RegisterForm extends Form {
    @Override
    public void showForm() {
        try {
            String userName = getText("Please set your name:").trim();
            fieldValidator("Name", userName);

            String emailAddress = getText("Please set your email:").trim();
            fieldValidator("Email", emailAddress);

            String password = getText("Please set your password:").trim();
            fieldValidator("Password", password);

            String confirmedPassword = getText("Please confirm your password:").trim();
            fieldValidator("Confirmed Password", confirmedPassword, password);

            Profile profile = new Profile(userName, emailAddress, password);

            Accounts accounts = Accounts.getInstance();
            accounts.createProfile(profile);

            successMessage();
        } catch (Error e) {
            throw new Error("🚫 Something went wrong while creating user profile: " + e.getMessage());
        }
    }

    @Override
    public void successMessage() {
        System.out.println("✅ Congrats. Your user was created successfully.");
        System.out.println("Now, try to login to start.");
        getDivider();
    }
}
