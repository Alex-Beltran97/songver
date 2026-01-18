package songver.music.menus;

import songver.music.platform.Accounts;

import java.util.HashMap;
import java.util.Map;

public class DisplayMenu {
    private Accounts accounts = Accounts.getInstance();
    private boolean hasQuit = false;
    private Menu menuType;

    public void display() {
        System.out.println("What do you want to do?");

        setMenu(new AuthMenu());

        do {
            if (accounts.getAuthUser() != null) {
             setMenu(new MainMenu());
            }

            HashMap<String,Integer> result = menuType.displayMenu();

            handleMenuAction(result);
        } while (!hasQuit);
    }

    public void setMenu(Menu menuType) {
        this.menuType = menuType;
    }

    public void setHasQuit(boolean hasQuit) {
        this.hasQuit = hasQuit;
    }

    public void handleMenuAction(HashMap<String,Integer> option) {
        Integer fromAuth = option.get("auth");
        Integer fromMain = option.get("main");

        if (fromAuth != null && fromAuth == 3) {
            this.menuType.farewell();
            setHasQuit(true);
            return;
        };

        if (fromMain != null && fromMain == 4) {
            setMenu(new ConfirmMenu("logout account"));

            HashMap<String,Integer> result = menuType.displayMenu();

            if (result.get("confirm") == 1) {
                this.menuType.userFarewell(accounts.getAuthUser().getUserName());
                accounts.logOutUser();
                setMenu(new AuthMenu());
            } else {
                setMenu(new MainMenu());
            }

            return;
        };
    }
}