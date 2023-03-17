/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etu1808.framework.model;
import etu1808.framework.annotation.Attribut;
import etu1808.framework.annotation.Model;
import etu1808.framework.annotation.Url;

/**
 *
 * @author dm
 */

@Model
public class Emp {
    @Attribut
    String name;
    @Attribut
    String fname;

    public Emp() {
    }

    public Emp(String name, String fname) {
        this.name = name;
        this.fname = fname;
    }
    
    public String getAll(){
        String val = "all";
        return val;
    }
    @Url(url = "/getName")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
    
    
}
