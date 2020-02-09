package MyAlarm;

import com.company.Clock;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


/**
      2: An alarm clock should include a time to sound the alarm as well as methods
      3: to set the alarm.
      4: */
public class AlarmClk {
    public int alarmHour;
    public int alarmMinute;
    public int alarmSecond;

    public AlarmClk() {
        alarmHour = 0;
        alarmMinute = 0;
        alarmSecond = 0;
    }

    public AlarmClk(int alarmH, int alarmM, int alarmS) {
        setAlarmHour(alarmH);
        setAlarmMinute(alarmM);
        setAlarmSecond(alarmS);
    }

    //Accessors
    public void setAlarmHour(int alarmH) {
        if ((alarmH >= 0) && (alarmH <= 24))
            alarmHour = alarmH;
        else
            System.out.println("Fatal error: invalid alarm hour");
    }


    public void setAlarmMinute(int alarmM) {
        if ((alarmM >= 0) && (alarmM <= 59))
            alarmMinute = alarmM;
        else
            System.out.println("Fatal error: invalid alarm minute");
    }

    public void setAlarmSecond(int alarmS) {
        if ((alarmS >= 0) && (alarmS <= 59))
            alarmSecond = alarmS;
        else
            System.out.println("Fatal error: invalid alarm second");
    }

    //Mutators
    public int getAlarmHour() {
        return alarmHour;
    }

    public int getAlarmMinute() {
        return alarmMinute;
    }

    public int getAlarmSecond() {
        return alarmSecond;
    }

    public String getCurrentAlarmTime() {
        return "The alarm is set to " + alarmHour + ":" + alarmMinute + ":" + alarmSecond;
    }

    //Facilitators
    public String toString() {
        return "The current time is " + getHour() + ":" + getMinute() + ":" +
                getSecond() + "\nThe alarm is set to " + getAlarmHour() + ":" + getAlarmMinute() + ":" + getAlarmSecond();
    }

    public boolean equals(Object o) {
        if (o == null)
            return false;
        else if (getClass() != o.getClass())
            return false;
        else {
            AlarmClk otherClock = (AlarmClk) o;
            System.out.println("show");
            return ((getHour() == otherClock.alarmHour) && (getMinute() == otherClock.alarmMinute));
        }
    }

    Calendar calobj = Calendar.getInstance();

    private int getSecond() {
        return(calobj.get(Calendar.SECOND));

    }

    private int getMinute() {

       return(calobj.get(Calendar.MINUTE));

    }

    private int getHour() {
        return(calobj.get(Calendar.HOUR_OF_DAY));
    }

    public void setAlarm(int a, int b){
        setAlarmHour(a);
        setAlarmMinute(b);
    }

    public void changeFormat(int format) {
        //Input date in String format
//        String input = calobj.getTime().toString();
//        //Date/time pattern of input date
//        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        //Date/time pattern of desired output date
//        DateFormat outputformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aa");
//        Date date = null;
//        String output = null;

        if (format == 12) {
            try {
                String now = new SimpleDateFormat("hh:mm").format(new java.util.Date().getTime());
                System.out.println("time in 24 hour format : " + now);
                SimpleDateFormat inFormat = new SimpleDateFormat("hh:mm");
                SimpleDateFormat outFormat = new SimpleDateFormat("HH:mm aa");
                String time12 = outFormat.format(inFormat.parse(now));
                System.out.println("time in 12 hour format : " + time12);
            } catch (Exception e) {
                System.out.println("Exception : " + e.getMessage());
            }
        }

//            try {
//                //Conversion of input String to date
//                date = df.parse(input);
//                //old date format to new date format
//                output = outputformat.format(date);
//                System.out.println(output);
//            } catch (ParseException pe) {
//                pe.printStackTrace();
//            }
//        }
        else if (format == 24) {

            try {
                String now = new SimpleDateFormat("hh:mm aa").format(new java.util.Date().getTime());
                System.out.println("time in 12 hour format : " + now);
                SimpleDateFormat inFormat = new SimpleDateFormat("hh:mm aa");
                SimpleDateFormat outFormat = new SimpleDateFormat("HH:mm");
                String time24 = outFormat.format(inFormat.parse(now));
                System.out.println("time in 24 hour format : " + time24);
            } catch (Exception e) {
                System.out.println("Exception : " + e.getMessage());
            }
        }

//            try{
//                //Converting the input String to Date
//                date= df.parse(now);
//                //Changing the format of date and storing it in String
//                output = outputformat.format(date);
//                //Displaying the date
//                System.out.println(output);
//            }catch(ParseException pe){
//                pe.printStackTrace();
//            }
//        }
        else {
            System.out.println("Fatal error: invalid alarm second");
        }
    }



    public static void main (String args[]) {
        Calendar calobj = Calendar.getInstance();
        System.out.println(calobj.getTime());
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the hour: ");
        int alarmH=input.nextInt();
        System.out.print("Enter the minutes: ");
        int alarmM=input.nextInt();
        AlarmClk alarmClk = new AlarmClk(calobj.get(Calendar.HOUR_OF_DAY), calobj.get(Calendar.MINUTE), calobj.get(Calendar.SECOND));
        if (alarmH==calobj.get(Calendar.HOUR_OF_DAY) && alarmM==calobj.get(Calendar.MINUTE)) {
            System.out.println("It's time!");
        }
        alarmClk.changeFormat(24);
    }


}


