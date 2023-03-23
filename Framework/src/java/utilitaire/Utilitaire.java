/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilitaire;
import trtmt.Traitement;
/**
 *
 * @author dm
 */
public class Utilitaire {
    public static String getUrl(String Url, String contextpath){
            String result;
            String[] val = Url.split(contextpath);
            if(val.length==1){
                result = "/";
            }else{
                result = val[1];
            }
            return result;
            
        
    }

    public String[] lien(String url) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
