package songver.music.forms;

import songver.music.platform.Accounts;
import songver.music.platform.Profile;

import java.util.Objects;

public class LoginForm extends Form {
    private final Accounts accounts = Accounts.getInstance();
    @Override
    public void showForm() {
        try {
            String emailAddress = getText("Please set your email:").trim();
            fieldValidator("Email", emailAddress);

            String password = getText("Please set your password:").trim();
            fieldValidator("Password", password);

            successMessage();
        } catch (Error e) {
            throw new Error("🚫 Something went wrong while login user profile: " + e.getMessage());
        }
    }

    @Override
    public void fieldValidator(String field, String value) {
        if (Objects.equals(field, "Email")) {
            accounts.findUser(value);
        }

        if (Objects.equals(field, "Password")) {
            accounts.validatePassword(value);
        }
    }

    @Override
    public void successMessage() {
        System.out.println("✅ Login successfully!!!\n" +
            "Welcome " + accounts.getAuthUser().getUserName() + "\n"
        );
    }
}
