package songver.music.menus;

public class MainMenu extends Menu{
    @Override
    public int displayMenu() {
       int option = getOption("""
         1) Add new songs
         2) Library
         3) Manage My Account
         4) Logout
        """);
       return option;
    }
}
