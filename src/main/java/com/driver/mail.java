package com.driver;

import java.util.*;

public class mail {

    String sender;

    Date date;

    String message;

    public mail(Date date,String sender,String message)
    {
        this.date=date;
        this.sender=sender;
        this.message=message;
    }

    public String getMessage(){
        return this.message;
    }



    public Date getDate(){
        return this.date;
    }

}
