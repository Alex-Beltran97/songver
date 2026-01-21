package songver.music.menus;

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

        return this.option;
    }

    private void setOption(int option) {
        this.option.put("manage", option);
    }
}
