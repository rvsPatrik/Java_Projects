/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package project_java;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Revesz
 */
public class DirListing {
    
    
    public static String findRelativePath(File Directory,File file){
        
        Path base = Directory.toPath().toAbsolutePath();
        
        Path filePath = file.toPath().toAbsolutePath();
        
        Path relative = base.relativize(filePath);
        
        return relative.toString();
        
        // működjön ha a mappának megváltozik a path-je 
        
    }
    
    public static List<File> getDirectoriesListed(File baseDir){
        
        List <File> directories = new ArrayList<>();
        
        if(baseDir.isDirectory()){
            File[] files = baseDir.listFiles();
            
            for (File file: files) {
                if ( file.isDirectory()){
                    String relativepath = findRelativePath(baseDir,file);
                    File relativeFile = new File(relativepath);
                    
                    
                    directories.add(relativeFile);
                }
            }
        }
        
        return directories;
    }    
}