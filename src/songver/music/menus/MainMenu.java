package songver.music.menus;

import java.util.HashMap;

public class MainMenu extends Menu{
    private final HashMap<String, Integer> option = new HashMap<>();

    @Override
    public HashMap<String, Integer> displayMenu() {
       int option = getOption("""
         1) Add new songs
         2) Library
         3) Manage My Account
         4) Logout
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
        this.option.put("main", option);
    }
}
