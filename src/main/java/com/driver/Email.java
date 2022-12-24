package com.driver;

public class Email {

    private String emailId;
    private String password;

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
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        int len=newPassword.length();
        if(len>=8&&oldPassword.equals(this.password))
        {
            boolean hasSpecial=false;
            boolean hasUpper=false;
            boolean hasLower=false;
            boolean hasDigit=false;
            for(int i=0;i<len;i++)
            {
                int c=newPassword.charAt(i);
                if(c>=65&&c<=90)
                {
                    hasLower=true;
                }
                else if(c>=97&&c<=122)
                {
                    hasUpper=true;
                }
                else if(c>=48&&c<=57)
                {
                    hasDigit=true;
                }
                else
                {
                    hasSpecial=true;
                }
            }
            if(hasSpecial&&hasUpper&&hasLower&&hasDigit)
            {
                this.password=newPassword;
            }
        }

    }
}
