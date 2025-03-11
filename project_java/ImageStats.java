/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_java;

import java.io.File;
import static project_java.DirListing.findRelativePath;

/**
 *
 * @author Revesz
 */
public class ImageStats {
    
    
    private String nev;
    
    
    private String hely;
    
    private String url;
    
    
    
    public ImageStats ( File image, File Page ){
        
        this.nev = image.getName();
        this.hely = image.getParent();
        
        this.url = findRelativePath(Page,image);
        
    }

    public String getFullNev() {
        return nev;
    }
    
    public String getHely() {
        return hely;
    }

    public String getUrl() {
        return url;
    }
        
    public String getNev(){
        return this.nev.split("\\.")[0];
    }
}
