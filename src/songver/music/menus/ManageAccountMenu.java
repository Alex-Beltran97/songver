package songver.music.menus;

public class ManageAccountMenu extends Menu{
    @Override
    public int displayMenu() {
        int option = getOption("""
         1) Play song
         2) Edit info song
         3) Delete song
         4) Return
        """);
        return option;
    }
}
