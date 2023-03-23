/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import etu1808.framework.annotation.Url;
/**
 *
 * @author dm
 */

public class Emp {
    String name;
    String fname;

    public Emp(String name, String fname) {
        this.name = name;
        this.fname = fname;
    }

    @Url(url = "emp-all")
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