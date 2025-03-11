/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_java;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Revesz
 */
public class ImageCollector {
    
    
    private static boolean isImageFile(File file){
        String fname = file.getName().toLowerCase();
        return fname.endsWith(".gif ") || fname.endsWith(".jpg") || fname.endsWith(".jpeg") || fname.endsWith(".png");
    }
    
    public static List<ImageStats> getImages(File directory, File page){
        File[] files = directory.listFiles();
        
        List<ImageStats> images = new ArrayList<>();
        
        
        for( File file:files){
            if (isImageFile(file)){
                ImageStats image = new ImageStats(file,page);
                images.add(image);
            }
        }
        images.sort(Comparator.comparing(ImageStats::getNev,String.CASE_INSENSITIVE_ORDER));
        
        
        return images;
    }
}
