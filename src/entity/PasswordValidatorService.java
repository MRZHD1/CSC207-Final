package src.entity;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PasswordValidatorService {
    /** It contains atleast 8 characters and max 20
        It contains one special character and one digit
        it does not contain any whitespaces
    **/

    public boolean passwordIsValid(String password){
        String regex ="^(?=.*[0-9])" + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        Pattern p = Pattern.compile(regex);

        if (password == null) {
            return false;

        }
        Matcher m = p.matcher(password);

        return m.matches();


    }

}
