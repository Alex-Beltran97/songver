package songver.music;

import songver.music.menus.DisplayMenu;

public class Main {
    private static final String PLATFORM_NAME = "Songver Music";
    public static void main(String[] args) {
        // Greet welcome
        System.out.println("Welcome to Songver Music");
        init().display();
    }

    public static DisplayMenu init() {
        return new DisplayMenu();
    }
}
