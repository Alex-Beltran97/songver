package songver.music.menus;

import songver.music.forms.Form;
import songver.music.forms.LoginForm;
import songver.music.forms.RegisterForm;

public class AuthMenu extends Menu {
    @Override
    public int displayMenu() {
        int option = getOption("""
         1) Login
         2) Register
         3) Quit
        """);

        switch (option) {
            case 1:
                assignForm(new LoginForm());
                break;
            case 2:
                assignForm(new RegisterForm());
                break;
        }

        return option;
    }

    private void assignForm(Form formType) {
        setCurrentForm(formType);
        try {
            currentForm.showForm();
        } catch (Error e) {
            System.out.println(e.getMessage());
        }
    }
}
