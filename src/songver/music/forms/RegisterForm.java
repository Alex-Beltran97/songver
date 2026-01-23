package songver.music.forms;

import songver.music.platform.Accounts;
import songver.music.platform.Profile;
import songver.music.utils.Mode;

import java.util.Objects;

public class RegisterForm extends Form {
    private final Accounts accounts = Accounts.getInstance();
    private final Mode mode;

    public RegisterForm(Mode mode) {
        this.mode = mode;
    }

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

            if (mode == Mode.CREATE) {
                accounts.createProfile(profile);
                accounts.logOutUser();
                successMessage(mode);
                return;
            }

            if (mode == Mode.EDIT) {
                accounts.editProfile(profile);
                successMessage(mode);
                return;
            }

        } catch (Error e) {
            throw new Error("🚫 Something went wrong while creating user profile: " + e.getMessage());
        }
    }

    @Override
    public void fieldValidator(String field, String value) {
        super.fieldValidator(field, value);

        if (mode == Mode.EDIT) return;

        boolean userExist = false;

        if (Objects.equals(field, "Email")) {
            try {
                accounts.findUser(value);
                userExist = true;
                accounts.logOutUser();
            } catch (Error e) {
                System.out.println("✅ Email can be used");
            }
        }

        if (userExist) {
            throw new Error("User is already exist. Try with another email.\n");
        }
    }

    @Override
    public void successMessage(Mode mode) {
        String statusMsg = mode == Mode.CREATE ? "created" : "edited";
        System.out.println("✅ Congrats. Your user was " + statusMsg + " successfully.");
        if (statusMsg.equals("created")) {
            System.out.println("Now, try to login to start.\n");
        }
        getDivider();
    }
}
