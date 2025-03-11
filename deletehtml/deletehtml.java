/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package deletehtml;

import java.io.File;


/**
 *
 * @author Revesz
 */

public class deletehtml {

    public static void main(String[] args) {
        
        deleteAllHtmlFiles(new File("C:\\Users\\rvspa\\Desktop\\New folder"));
        
        
    }

    private static void deleteAllHtmlFiles(File folder) {
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    deleteAllHtmlFiles(file);
                }
            }
        } else {
            if (folder.getName().endsWith(".html")) {
                if (folder.delete()) {
                    System.out.println(folder.getName() + " torolve.");
                } else {
                    System.out.println("Nem sikerult torolni a filet: " + folder.getName());
                }
            }
        }
    }
}