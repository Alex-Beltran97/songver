package songver.music.forms;

import songver.music.utils.Utils;

import java.util.Objects;

public abstract class Form extends Utils {
    public abstract void showForm();
    public abstract void successMessage();

    public void fieldValidator(String field, String value) {
        if (isEmpty(value)) {
            throw new Error(emptyMsg(field));
        }

        switch (field) {
            case "Name":
                if (!isValidName(value)) throw new Error(invalidNameMsg(field));
                break;
            case "Email":
                if (!isValidEmail(value)) throw new Error(invalidEmailMsg(field));
                break;
            case "Password":
                if (!isValidPassword(value)) throw new Error(invalidPasswordMsg(field));
                break;
        }
    }

    public void fieldValidator(String field, String value, String password) {
        if (!isValidConfirmedPassword(password, value)) throw new Error(invalidConfirmedPasswordMsg(field));
    }

    private String emptyMsg(String fieldName) {
        return "The field \"" + fieldName +"\" is empty. Please try again.\n";
    }

    private String invalidNameMsg(String fieldName) {
        return "The field \"" + fieldName +"\" is not valid. Field must not have numbers or special characters. Please try again.\n";
    }

    private String invalidEmailMsg(String fieldName) {
        return "The field \"" + fieldName +"\" is not valid. Field must not have numbers or special characters. Please try again.\n";
    }

    private String invalidPasswordMsg(String fieldName) {
        return "The field \"" + fieldName +"\" is not valid.\n" + """
        The password must meet the following requirements:
        
        - It must contain at least one uppercase letter
        - It must contain at least one lowercase letter
        - It must contain at least one number
        - It must contain at least one symbol
        - It must be between 8 and 10 characters long\n       
        """ + "Please try again.";
    }

    private String invalidConfirmedPasswordMsg(String fieldName) {
        return "The field \"" + fieldName +"\" is not valid.\n" +
            "Password is not matching. Please try again.";
    }
}
