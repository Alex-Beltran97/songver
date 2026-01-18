package songver.music.menus;

import songver.music.forms.Form;
import songver.music.utils.Utils;

import java.util.HashMap;
import java.util.Scanner;

public abstract class Menu extends Utils {
    protected Form currentForm;
    public abstract HashMap<String, Integer> displayMenu();

    public void farewell() {
        System.out.println("Thanks for listen to us, Bye :)");
    }

    public void userFarewell(String name) {
        System.out.println("Thanks " + name + ". See you later!\n");
        getDivider();
    }

    public void handleNonExistOption() {
        String nonExistOptionMsg = "⚠️Invalid number option. Please read de list option below and try again.\n";
        throw new Error(nonExistOptionMsg);
    }

    public void setCurrentForm(Form form) {
        this.currentForm = form;
    }
}
