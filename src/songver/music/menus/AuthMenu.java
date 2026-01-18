package songver.music.menus;

import songver.music.forms.Form;
import songver.music.forms.LoginForm;
import songver.music.forms.RegisterForm;

import java.util.HashMap;
import java.util.InputMismatchException;

public class AuthMenu extends Menu {
    private final HashMap<String, Integer> option = new HashMap<>();

    @Override
    public HashMap<String, Integer> displayMenu() {
        int option = getOption("""
         1) Login
         2) Register
         3) Quit
        """);

        if (
            option != 1 &&
            option != 2 &&
            option != 3
        ) {
            handleNonExistOption();
        }

        setOption(option);

        switch (option) {
            case 1:
                assignForm(new LoginForm());
                break;
            case 2:
                assignForm(new RegisterForm());
                break;
        }

        return this.option;
    }

    private void setOption(int option) {
        this.option.put("auth", option);
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
