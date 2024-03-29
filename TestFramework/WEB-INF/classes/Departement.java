package modele;
import etu1808.framework.*;
@Scope
public class Departement{
    String nomDeDepartement;
    Integer nombreEmploye;
    @Url(method = "dept-jsp.gg")
    public ModelView myJsp(){
        ModelView modelView = new ModelView("departement.jsp");
        return modelView;
    }
    @Url(method = "add-dept.gg")
    public ModelView addDepartement(){
        ModelView modelView = new ModelView("sprint70.jsp");
        return modelView;
    }
    
    @Url(method = "add-with-arguments.gg")
    @Arguments(arguments = {"nomDeDepartement", "nombreEmploye"})
    public ModelView addDepartementWithArguments(String nomDeDepartement, Integer nombreEmploye){
        ModelView modelView = new ModelView("sprint70.jsp");
        modelView.addItem("nomDeDepartement", nomDeDepartement);
        modelView.addItem("nombreEmploye", nombreEmploye);
        return modelView;
    }
    
    public String getNomDeDepartement() {
        return nomDeDepartement;
    }
    public void setNomDeDepartement(String nomDeDepartement) {
        this.nomDeDepartement = nomDeDepartement;
    }
    public Integer getNombreEmploye() {
        return nombreEmploye;
    }
    public void setNombreEmploye(Integer nombreEmploye) {
        this.nombreEmploye = nombreEmploye;
    }
}