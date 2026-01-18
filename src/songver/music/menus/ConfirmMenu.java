package songver.music.menus;

import java.util.HashMap;

public class ConfirmMenu extends Menu {
    private final HashMap<String, Integer> option = new HashMap<>();

    private String action;

    public ConfirmMenu(String action) {
        this.action = action;
    }

    @Override
    public HashMap<String, Integer> displayMenu() {
        System.out.println("Are you sure you want to \"" + action + "\"?");
        int option = getOption("""
         1) Yes
         2) No
        """);

        if (option != 1 && option != 2) {
            handleNonExistOption();
        }

        setOption(option);

        return this.option;
    }

    private void setOption(int option) {
        this.option.put("confirm", option);
    }
}
