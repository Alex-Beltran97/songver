package songver.music.menus;

import songver.music.platform.Accounts;

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

            int result = menuType.displayMenu();

            if (result == 3) {
                this.menuType.farewell();
                setHasQuit(true);
            }
        } while (!hasQuit);
    }

    public void setMenu(Menu menuType) {
        this.menuType = menuType;
    }

    public void setHasQuit(boolean hasQuit) {
        this.hasQuit = hasQuit;
    }
}
