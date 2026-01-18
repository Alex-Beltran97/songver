package songver.music.menus;

import java.util.HashMap;

public class SongMenu extends Menu{
    private final HashMap<String, Integer> option = new HashMap<>();

    @Override
    public HashMap<String, Integer> displayMenu() {
        int option = getOption("""
         1) Play song
         2) Edit info song
         3) Delete song
         4) Return
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
        this.option.put("song", option);
    }
}
