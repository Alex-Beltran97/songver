package songver.music.menus;

import songver.music.forms.Form;
import songver.music.utils.Utils;

import java.util.Scanner;

public abstract class Menu extends Utils {
    protected Form currentForm;
    public abstract int displayMenu();

    public void farewell() {
        System.out.println("Thanks for listen to us, Bye :)");
    }

    public void setCurrentForm(Form form) {
        this.currentForm = form;
    }
}
