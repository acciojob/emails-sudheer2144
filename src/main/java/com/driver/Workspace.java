package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings
    private int inboxCapacity;
    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        this.calendar=new ArrayList<>();
        this.inboxCapacity=Integer.MAX_VALUE;
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        this.calendar.add(meeting);
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
        int count=1;
        LocalTime start=calendar.get(0).getStartTime();
        LocalTime end=calendar.get(0).getEndTime();
        for(Meeting meeting:this.calendar)
        {
            if(meeting.getStartTime().isAfter(end)||meeting.getEndTime().isBefore(start))
            {
                start=meeting.getStartTime();
                end=meeting.getEndTime();
                count++;
            }
        }
        return count;
    }


    public int getInboxCapacity() {
        return inboxCapacity;
    }
}
