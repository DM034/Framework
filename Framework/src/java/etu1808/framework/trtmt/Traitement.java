package etu1808.framework.trtmt;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Vector;

public class Traitement{

        public Class[] getAllClass(String packageName) throws Exception{
        File dir = new File(packageName);
        Class[] result = null;
        if(dir.exists()==true){
            String[] classes = dir.list();
            result = new Class[classes.length];
            for (int i = 0; i < classes.length; i++) {
              result[i] = Class.forName(packageName+"."+classes[i].substring(0, classes[i].lastIndexOf(".class")));
                
            }
        }
        return result;
    }
    public Class[] getAllClassWithAnnotation(String packageName,Class annotation) throws Exception{
       Class[] classes = getAllClass(packageName);
    
       Class[] result = new Class[1];
    
     
        Vector<Class> v;
        v = new Vector<>();
        for (Class classe : classes) {
            if (classe.isAnnotationPresent(annotation) == true) {
                v.add(classe);
            }
        }
        result = new Class[v.size()];
        for (int i = 0; i < v.size(); i++) {
            result[i] = v.get(i);
            
        }
       
       return result;
    }
    public Field[] getAllFieldWithAnnotation(Class object,Class annotation)throws Exception{
        Field[] champs = object.getDeclaredFields();
        Field[] result = new Field[1];
        
        Vector<Field> v = new Vector<>();
        
        for (Field champ : champs) {
            if (champ.isAnnotationPresent(annotation) == true) {
                v.add(champ);
            }
        }
        result = new Field[v.size()];
        for (int i = 0; i < v.size(); i++) {
            result[i] = v.get(i);
            
        }
        return result;
    }
 
    public Method[] getAllMethodWithAnnotation(Class object,Class annotation)throws Exception{
        Method[] champs = object.getDeclaredMethods();
        Method[] result = new Method[1];
        
        Vector<Method> v = new Vector<>();
        
        for (Method champ : champs) {
            if (champ.isAnnotationPresent(annotation) == true) {
                v.add(champ);
            }
        }
        result = new Method[v.size()];
        for (int i = 0; i < v.size(); i++) {
            result[i] = v.get(i);
            
        }
        return result;
    }
}