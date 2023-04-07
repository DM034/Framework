/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilitaire;
import etu1808.framework.trtmt.Traitement;
/**
 *
 * @author dm
 */
public class Utilitaire {
    public static String[] getUrl(String Url) throws Exception{
            String[] reg = Url.split("/");
            System.out.println(reg.length);
            if(reg.length >= 5){
                return reg;
            }else{
                throw new Exception("tsy misy");
            }
            
        
    }

    public String[] lien(String url) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
