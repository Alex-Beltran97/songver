package songver.music.menus;

import songver.music.forms.Form;
import songver.music.forms.RegisterForm;
import songver.music.utils.Mode;

import java.util.HashMap;

public class ManageAccountMenu extends Menu{
    private final HashMap<String, Integer> option = new HashMap<>();

    @Override
    public HashMap<String, Integer> displayMenu() {
        int option = getOption("""
         1) Edit profile
         2) Delete account
         3) Return
        """);

        if (
            option != 1 &&
            option != 2 &&
            option != 3 &&
            option != 4
        ) {
            handleNonExistOption();
        }

        setOption(option);

        if (option == 1) {
            assignForm(new RegisterForm(Mode.EDIT));
        }

        return this.option;
    }

    private void setOption(int option) {
        this.option.put("manage", option);
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
