/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Revesz
 */
public class htmlCreator {
    
    public static String ImageToHtml(String cim,String page,String elozo,String kovetkezo,String kepnev,String path){
        
        
        
        
        String f = """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>%s</title>
            </head>
            <body>
                <div style="border-bottom: 5px solid; border-color: black; padding: 5px;">
                    <a href="%s" style="font-size: 50px;" >Start Page</a>
                </div>
                <a style="display: block; padding-top: 20px;" href="index.html">^^</a>
                <div style="display: flex; align-items: center; padding-top: 20px;">
                    <a href="%s"><<</a>
                    <h4 style="margin: 0 20px;">%s</h4>
                    <a href="%s">>></a>
                </div>
                <a href="%s">
                    <img style="height: 30%%; width: 30%%; padding-top: 20px;" src="%s" alt="">
                </a>
            </body>
            </html>
                """;
        
        return String.format(f, cim, page, elozo, kepnev, kovetkezo, kovetkezo, path);
    }
    
    
    public static void WriteToFile(String hely,String kimenet){
        
        
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(hely))){
            
            
            bw.write(kimenet);
        
        }catch ( IOException e ){
            System.out.println(e);
        }
    }
    
    
    public static void createImageHTML ( List<ImageStats> images, File mainpage){
        for (int i = 0; i < images.size(); i++) {
            ImageStats akt = images.get(i);
            ImageStats elozo = (i == 0 ) ? akt:images.get(i-1);
            ImageStats kovetkezo = (i == images.size()-1) ? akt:images.get(i+1);
            
            
            String home = DirListing.findRelativePath(new File(akt.getHely()),mainpage);
                                   
            String htmlContent = ImageToHtml(akt.getNev(), home, elozo.getNev()+ ".html", kovetkezo.getNev()+ ".html", akt.getNev(), akt.getUrl());
            
            String path = String.format("%s\\%s.html",akt.getHely(),akt.getNev());
            
            WriteToFile(path,htmlContent);
        }
    }
    
    
    
    public static String DirToHtml(String cim,String page,String mappa,String images){
       
        
        String f = """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>%s</title>
            </head>
            <body>
                <div style="border-bottom: 5px solid; border-color: black; padding: 5px;">
                    <a href="%s" style="font-size: 40px;" >Start Page</a>
                </div>
                <div  style="border-bottom: 5px solid;">
                    <h1 style="font-size: 20px;">Directories:</h1>
                    <ul>
                        %s
                    </ul>
                </div>
                <div>
                    <h1 style="font-size: 20px;">Images:</h1>
                    <ul>
                        %s
                    </ul>
                </div>
            </body>
            </html>
             """;

        
        
        
        return String.format(f, cim, page, mappa, images);
    }
    
    
    public static String listDirs(List<File> directories, File root, File curr){
        StringBuilder sb = new StringBuilder();
        
        if ( directories.isEmpty()){
            sb.append("<li>\n");
            sb.append("\t<a href=\"../index.html\"> << </a>\n");
            sb.append("</li>\n");
            
            
        }
        else if((root.getParent().compareTo(curr.getPath().toString()) != 0)){
            sb.append("<li>");
            sb.append("\t<a href=\"../index.html\"> << </a>\n");
            sb.append("</li>\n");
            
            
        }
        
        for ( File dir:directories  ){
            
            
            
            
            
            
             String f = """
                        <li>
                            <a href="%s/index.html">%s</a>
                        </li>
                
                """;
             
            sb.append(String.format(f,dir,dir.getName()));
        }
        
        return sb.toString();
        
        
    }
    
    
    public static void createIndexHTMLForDirectories(File container, List<File> directories, List<ImageStats> pictures, File startPage)
    {
        String dirListAsHtml = listDirs(directories, startPage, container);
        String picsListAsHtml = PicturesListing(pictures);
        String title = container.getName();
        String backToHome = DirListing.findRelativePath(container, startPage);
        String html = DirToHtml(title, backToHome, dirListAsHtml, picsListAsHtml);
        String pathFile = String.format("%s\\index.html", container);

        WriteToFile(pathFile, html);
    }
    
    
    public static String PicturesListing(List<ImageStats> images){
        StringBuilder sb = new StringBuilder();
     
        for(ImageStats image:images){
            
            
           
            
            
            String f = """
                        <li>
                            <a href="%s.html">%s</a>
                        </li>
                
                """;
            
            sb.append(String.format(f.toString(),image.getNev(),image.getFullNev()));
        }
        
        return sb.toString();
    }
    
}