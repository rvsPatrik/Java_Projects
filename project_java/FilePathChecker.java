/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_java;



import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 *
 * @author Revesz
 */
public class FilePathChecker {
    
    
    public static boolean isPathValid(String paths){
        try{
            Path path = Paths.get(paths);
            return Files.isDirectory(path);      
        }catch(InvalidPathException e){
            return false;
        }
    } 
}