/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_java;

import java.io.File;
import java.util.List;





/**
 *
 * @author Revesz
 */
public class loopDir {
    public static void loopDir(File file, File page){
        if ( file.isDirectory()){
            System.out.println("Mappa: "+file.getName() + " feldolgozva.");
            File files[] = file.listFiles();
            
            List<ImageStats> images = ImageCollector.getImages(file, file);
            
            List<File> directories = DirListing.getDirectoriesListed(file);
            
            htmlCreator.createIndexHTMLForDirectories(file, directories, images, page);
            htmlCreator.createImageHTML(images, page);
            
            for(File t : files ){
                if(t.isDirectory()){
                    loopDir(t,page);
                }
            }
        }
    }
}