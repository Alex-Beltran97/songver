package songver.music.menus;

import songver.music.platform.Accounts;

import java.util.HashMap;

public class DisplayMenu {
    private final Accounts accounts = Accounts.getInstance();
    private boolean hasQuit = false;
    private Menu menuType;

    public void display() {
        System.out.println("What do you want to do?\n");

        setMenu(new AuthMenu());

        do {
            if (accounts.getAuthUser() != null) {
             setMenu(new MainMenu());
            }

            try {
                HashMap<String,Integer> result = menuType.displayMenu();
                handleMenuAction(result);
            } catch (Error e) {
                System.out.println(e.getMessage());
            }

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

        if (fromMain != null && fromMain == 3) {
            setMenu(new ManageAccountMenu());
            HashMap<String,Integer> result = menuType.displayMenu();

            switch (result.get("manage")) {
                case 2:
                    setConfirmAction("delete account", () -> {
                        System.out.println("✅ Your account was deleted successfully!");
                        this.menuType.userFarewell(accounts.getAuthUser().getUserName());
                        accounts.deleteProfile();
                        setMenu(new AuthMenu());
                    });
                    break;
                case 3:
                    setMenu(new MainMenu());
                    break;
            }

            return;
        }

        if (fromMain != null && fromMain == 4) {
            setConfirmAction("logout account", this::logoutAccount);
            return;
        };
    }

    public void logoutAccount() {
        this.menuType.userFarewell(accounts.getAuthUser().getUserName());
        accounts.logOutUser();
        setMenu(new AuthMenu());
    }

    public void setConfirmAction(String actionName, Runnable _action) {
        setMenu(new ConfirmMenu(actionName));
        HashMap<String,Integer> result = menuType.displayMenu();

        if (result.get("confirm") == 1) {
            _action.run();
        } else {
            setMenu(new MainMenu());
        }
    }
}