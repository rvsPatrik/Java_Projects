/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_java;

import java.io.File;

/**
 *
 * @author Revesz
 */
public class main {
    public static void main(String[] args) throws Exception {
        
        //String paths = args[0];
        String paths = "C:\\Users\\rvspa\\Desktop\\New folder";
        
        
        if (!FilePathChecker.isPathValid(paths)){
            System.out.println("\nA megadott string nem egy directory path!\n");
            System.exit(1);
        }
        
        File root = new File(paths);
        
        File startp = new File(root.getPath()+ "\\index.html");
        loopDir.loopDir(root,startp);
        
        
        
        
        
        System.out.println("\n- - - - -\n");
        System.out.println("fileok elkeszultek");
        System.out.println("\n- - - - -\n");
        
        
        
    }
    
}
