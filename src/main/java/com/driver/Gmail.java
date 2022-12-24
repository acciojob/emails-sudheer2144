package com.driver;

import java.util.*;
import java.util.Date;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    int currentCapacity=0;

    ArrayList<mail> gmails;

    ArrayList<mail> trash;


    public Gmail(String emailId, int inboxCapacity) {
        this.inboxCapacity=inboxCapacity;
        this.gmails=new ArrayList<>();
        this.trash=new ArrayList<>();
    }

    public Gmail(){}

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        mail mail=new mail(date,sender,message);
        if(this.currentCapacity<this.inboxCapacity)
        {
            gmails.add(mail);
            this.currentCapacity++;
        }
        else
        {
            this.trash.add(this.gmails.get(0));
            this.gmails.remove(0);
            this.gmails.add(mail);
        }
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        for(int i=0;i<this.gmails.size();i++)
        {
            mail tmp=gmails.get(i);
            if(tmp.getMessage().equals(message))
            {
                gmails.remove(i);
                trash.add(tmp);
                this.currentCapacity--;
            }
        }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(!this.gmails.isEmpty())
        {
            return gmails.get(gmails.size()-1).getMessage();
        }
        return null;
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(!this.gmails.isEmpty())
        {
            return gmails.get(0).getMessage();
        }
        return null;
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int count=0;
        for(mail mail:gmails)
        {
            Date tmp=mail.getDate();
            if(end.equals(tmp)||start.equals(tmp)||start.after(tmp)&&end.before(tmp))
            {
                count++;
            }
        }
        return count;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return this.gmails.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return this.trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        this.trash=new ArrayList<>();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return this.inboxCapacity;
    }
}