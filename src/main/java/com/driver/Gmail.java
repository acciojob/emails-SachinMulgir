package com.driver;

import java.util.*;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    List<Mail> inbox = new ArrayList<>();
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    List<Mail> trash = new ArrayList<>();

    public Gmail(String emailId, int inboxCapacity) {
        super.emailId = emailId;
        this.inboxCapacity = inboxCapacity;
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        if( inbox.size() == inboxCapacity ){
            Mail mail = inbox.remove(0);
            trash.add(mail);
        }
        inbox.add(new Mail(date, sender, message));
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.

    }

    public void deleteMail(String message){
        // Each message is distinct
        for( Mail mail : inbox ){
            if( mail.message.equals(message)){
                inbox.remove(message);
                trash.add(mail);
            }
        }
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing

    }

    public String findLatestMessage(){
        int n = inbox.size();
        // If the inbox is empty, return null
        if( n == 0 )return null;
        // Else, return the message of the latest mail present in the inbox
        return inbox.get(n-1).message;

    }

    public String findOldestMessage(){
        int n = inbox.size();
        // If the inbox is empty, return null
        if( n == 0 )return null;
        // Else, return the message of the oldest mail present in the inbox
        return inbox.get(0).message;
    }

    public int findMailsBetweenDates(Date start, Date end){
        int cnt = 0;
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        for( Mail mail : inbox ){
            if( (mail.date.compareTo(start) > 0) && (mail.date.compareTo(end) < 0) ){
                cnt++;
            }
        }
        return cnt;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return inbox.size();

    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        trash.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }
}
