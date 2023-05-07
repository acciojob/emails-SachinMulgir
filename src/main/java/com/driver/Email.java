package com.driver;

public class Email {

    public String emailId;
    private String password;

    public Email() {
    }

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        if( oldPassword.equals(password) ){
            // 1. It contains at least 8 characters
            if( newPassword.length() >= 8 ){
                boolean upper = false, lower = false, digit = false, symbol = false;
                for( int i = 0 ; i < newPassword.length() ; i++ ){
                    char ch = newPassword.charAt(i);
                    // 2. It contains at least one uppercase letter
                    if( ch >= 'A' && ch <= 'Z' )upper = true;

                    // 3. It contains at least one lowercase letter
                    if( ch >= 'a' && ch <= 'z' )lower = true;

                    // 4. It contains at least one digit
                    if( ch >= '0' && ch <= '9' )digit = true;

                    // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
                    if (!Character.isDigit(ch)
                            && !Character.isLetter(ch)
                            && !Character.isWhitespace(ch))symbol = true;
                }
                if( upper && lower && digit && symbol ){
                    password = newPassword;
                }
            }

        }
    }


}
