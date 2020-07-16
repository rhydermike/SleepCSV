/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleepcsv;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author killermike
 */
public class SleepCSV {
    static ArrayList<Integer> elements = new ArrayList<Integer>();
    static ArrayList<Integer> entryLineCharNos = new ArrayList<Integer>();
    static ArrayList<String> entryLines = new ArrayList<String>();
    static BufferedReader br;
    static File inputCSVFile;
    static File outputCSVFile;
    static String outputString;
    
    static String EOL = "\n";
    static String inputFile;
    static ArrayList<EntryRecord> sleep = new ArrayList<EntryRecord>();
    
    static String mode = "Single";
    static String dateFormat = "US";
    static boolean Ready = false;
    static boolean showTotalMins = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SleepGUI gui = new SleepGUI();
        
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        /*FileLoader fl = new FileLoader();
        fl.loadFile();
        fl.parseFile);
        fl.parseEntries();        
        fl.saveCSV();*/
    }
    
}
