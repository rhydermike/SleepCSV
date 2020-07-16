/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleepcsv;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author killermike
 */
public class FileLoader {

    String delim = ",";
    String timeSep = ":";
    String dateSep = "/";
    String space = " ";
    String lb = "\r\n";
    int prevDay = 0;

    ArrayList<String> SleepBeginStrings = new ArrayList<String>();
    ArrayList<String> SleepEndStrings = new ArrayList<String>();
    //ArrayList<EntryRecord> sleep = new ArrayList<EntryRecord>();
    StringBuilder sb = new StringBuilder();
    int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    boolean loadFile() {
        try {
            //SleepCSV.inputFile = new String(Files.readAllBytes(Paths.get("sleep-export.csv")));

            String myFilePath = SleepCSV.inputCSVFile.getAbsolutePath();
            SleepCSV.inputFile = new String(Files.readAllBytes(SleepCSV.inputCSVFile.toPath()));
            System.out.print(SleepCSV.inputCSVFile);
        } catch (IOException ex) {
            Logger.getLogger(FileLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (SleepCSV.inputFile == null) {
            System.out.println("file not read");
            return (false);

        } else {
            return (true);
        }

    }

    void parseFile() {
        sb.setLength(0);
        System.out.println("Starting parsefile..");
        int lineCounter = 0;
        String currChar = "";
        int fileLength = SleepCSV.inputFile.length();
        for (int i = 0; i < fileLength; i++) {
            currChar = SleepCSV.inputFile.substring(i, i + 1);
            if (currChar.equals(SleepCSV.EOL)) {
                SleepCSV.entryLineCharNos.add(i + 1);
                // System.out.println(i);
            }
        }

        String WholeLine;

        //System.out.print("Size" + SleepCSV.entryLineCharNos.size());
        int numberOfEntries = SleepCSV.entryLineCharNos.size();
        //System.out.println("number of entries" + numberOfEntries);

        //add content of every other line to list
        for (int j = 0; j < (numberOfEntries - 1); j++) {
            int start = SleepCSV.entryLineCharNos.get(j);
            start = start;
            int end = SleepCSV.entryLineCharNos.get(j + 1);

            if (j % 2 == 0) {
                WholeLine = SleepCSV.inputFile.substring(start, end);
                SleepCSV.entryLines.add(WholeLine);
                //System.out.print(WholeLine);
            }

        }

        int firstStart = 2;
        int firstEnd = 3;
        int secondStart = 3;
        int secondEnd = 4;

        int quoteCounter = 0;
        for (int record = 0; record < SleepCSV.entryLines.size(); record++) {
            int commaCounter = 0;
            int S1Start = 0;
            int S1End = 0;
            int S2Start = 0;
            int S2End = 0;
            for (int CCharNo = 0; CCharNo < SleepCSV.entryLines.get(record).length(); CCharNo++) {
                currChar = SleepCSV.entryLines.get(record).substring(CCharNo, CCharNo + 1);
                if (currChar.equals(delim)) {
                    commaCounter++;
                    if (commaCounter == firstStart) {
                        S1Start = CCharNo + 2;
                    }
                    if (commaCounter == firstEnd) {
                        S1End = CCharNo - 1;
                    }
                    if (commaCounter == secondStart) {
                        S2Start = CCharNo + 2;
                    }
                    if (commaCounter == secondEnd) {
                        S2End = CCharNo - 1;
                    }
                }
            }
            String SBS = SleepCSV.entryLines.get(record).substring(S1Start, S1End);
            String SBE = SleepCSV.entryLines.get(record).substring(S2Start, S2End);
            SleepBeginStrings.add(SBS);
            SleepEndStrings.add(SBE);
        }

        Collections.reverse(SleepBeginStrings);
        Collections.reverse(SleepEndStrings);
    }

    void parseEntries() {

        int dayS = 0;
        int dayL = 2;
        int monthS = 4;
        int monthL = 2;
        int yearS = 8;
        int yearL = 4;
        int timeS = 13;
        int timeL = 5;

        for (int i = 0; i < SleepBeginStrings.size(); i++) {
            //parse start sleep

            //System.out.println("attempting record: " +i);
            //System.out.println("Input string (start)" + SleepBeginStrings.get(i));
            EntryRecord cr = new EntryRecord();

            cr.SDay = Integer.parseInt(SleepBeginStrings.get(i).substring(dayS, dayS + dayL));
            cr.SMonth = Integer.parseInt(SleepBeginStrings.get(i).substring(monthS, monthS + monthL));
            cr.SYear = Integer.parseInt(SleepBeginStrings.get(i).substring(yearS, yearS + yearL));

            int hourS;
            int hourL;
            int minS;
            int minL;

            if (SleepBeginStrings.get(i).length() == 18) {
                hourS = 13;
                hourL = 2;
                minS = 16;
                minL = 2;
            } else {
                hourS = 13;
                hourL = 1;
                minS = 15;
                minL = 2;
            }
            cr.SHour = Integer.parseInt(SleepBeginStrings.get(i).substring(hourS, hourS + hourL));
            cr.SMinute = Integer.parseInt(SleepBeginStrings.get(i).substring(minS, minS + minL));

            //parse end sleep            
            cr.EDay = Integer.parseInt(SleepEndStrings.get(i).substring(dayS, dayS + dayL));
            cr.EMonth = Integer.parseInt(SleepEndStrings.get(i).substring(monthS, monthS + monthL));
            cr.EYear = Integer.parseInt(SleepEndStrings.get(i).substring(yearS, yearS + yearL));

            boolean longtime = false;

            if (SleepEndStrings.get(i).length() == 18) {
                longtime = true;
                hourS = 13;
                hourL = 2;
                minS = 16;
                minL = 2;
            }
            if (SleepEndStrings.get(i).length() == 17) {
                longtime = false;
                hourS = 13;
                hourL = 1;
                minS = 15;
                minL = 2;
            }
            //System.out.println("String len:  " +SleepEndStrings.get(0).length() + " Longtime (end): " + longtime);
            cr.EHour = Integer.parseInt(SleepEndStrings.get(i).substring(hourS, hourS + hourL));
            cr.EMinute = Integer.parseInt(SleepEndStrings.get(i).substring(minS, minS + minL));
            cr.STotalMins = totalMins(cr.SMonth, cr.SDay, cr.SHour, cr.SDay);
            cr.ETotalMins = totalMins(cr.EMonth, cr.EDay, cr.EHour, cr.EDay);

            /*System.out.println("Starts");
            System.out.println("Day:" + cr.SDay);
            System.out.println("Month:" + cr.SMonth);
            System.out.println("Year:" + cr.SYear);
            System.out.println("Hour:" + cr.SHour);
            System.out.println("Min:" + cr.SMinute);
            //
            System.out.println("Ends");
            System.out.println("Day:" + cr.EDay);
            System.out.println("Month:" + cr.EMonth);
            System.out.println("Year:" + cr.EYear);
            System.out.println("Hour:" + cr.EHour);
            System.out.println("Min:" + cr.EMinute);*/
            SleepCSV.sleep.add(cr);
        }
    }

    int totalMins(int month, int day, int hour, int min) {

        int totalDays = 0;
        for (int i = 0; i < month; i++) {
            totalDays = totalDays + months[i];
        }

        int minM = totalDays * 24 * 60;
        int dayM = day * 24 * 60;
        int hourM = hour * 60;

        int outMins = minM + dayM + hourM + min;

        return (outMins);
    }

    String createCSV() {        
        //String outputString;
        if (SleepCSV.showTotalMins && SleepCSV.mode.equals("Single")) {
            sb.append("Start Date, Start Time, Total Mins, End Time, Total Mins" + lb);
        } 
        
        if (!SleepCSV.showTotalMins && SleepCSV.mode.equals("Multiple")) {
        sb.append("Date, Start Time, End Time, Start Time 2, End Time 2, Start Time 3, End Time 3, Start Time 4, End Time 4, Start Time 5, End Time 5" + lb);
        } 
        
        if (!SleepCSV.showTotalMins && SleepCSV.mode.equals("Single"))
        {
            sb.append("Start Date, Start Time, End Time" + lb);
        }
        //sb.append("Start Date, Start Time, End Time" + lb);

        //US format
        System.out.print("sleep size list: " + SleepCSV.sleep.size());
        boolean extrasleep = false;
        int prevSTime = 0;
        for (int record = 0; record < SleepCSV.sleep.size(); record++) {
            

            if (SleepCSV.mode.equals("Multiple"))
            {
            if (prevDay == SleepCSV.sleep.get(record).SDay) {
                extrasleep = true;
            } else {
                extrasleep = false;
            }
            }
            
            
                        
            if (!extrasleep) {
                sb.append(lb);
                if (SleepCSV.dateFormat.equals("US")) {
                    sb.append(SleepCSV.sleep.get(record).SMonth);
                    sb.append(dateSep);
                    sb.append(SleepCSV.sleep.get(record).SDay);
                    sb.append(dateSep);
                    sb.append(SleepCSV.sleep.get(record).SYear);
                    sb.append(delim);
                }
                else
                {
                    sb.append(SleepCSV.sleep.get(record).SDay);
                    sb.append(dateSep);
                    sb.append(SleepCSV.sleep.get(record).SMonth);
                    sb.append(dateSep);
                    
                    sb.append(SleepCSV.sleep.get(record).SYear);
                    sb.append(delim);
                }
            }
            if (extrasleep)
            {
                sb.append(delim);
            }
            
            sb.append(SleepCSV.sleep.get(record).SHour);
            sb.append(timeSep);
            sb.append(SleepCSV.sleep.get(record).SMinute);
            sb.append(delim);
            
            if (SleepCSV.showTotalMins) {
                sb.append(SleepCSV.sleep.get(record).STotalMins);
                sb.append(delim);
            }
            
            sb.append(SleepCSV.sleep.get(record).EHour);
            sb.append(timeSep);
            sb.append(SleepCSV.sleep.get(record).EMinute);
            
            if (SleepCSV.showTotalMins) {
                sb.append(delim);
                sb.append(SleepCSV.sleep.get(record).ETotalMins);
                sb.append(delim);
            } 
            
            
            
            
            prevDay = SleepCSV.sleep.get(record).SDay;
        }
        SleepCSV.outputString = sb.toString();
        return (SleepCSV.outputString);

    }

    

    void saveCSV() {
        String saveString = createCSV();
        Writer fi = null;
        try {
            fi = new FileWriter("./outputsleeps.csv", false);

            fi.write(saveString);
            fi.close();
        } catch (IOException ex) {
            Logger.getLogger(FileLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
