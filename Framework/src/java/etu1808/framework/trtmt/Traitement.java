package etu1808.framework.trtmt;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Vector;

public class Traitement{
    
    public static Object getValModelView(String classname, String methodname){
        Object val = new Object();
        try{
            Class classe = Class.forName(classname);
            Object call = classe.newInstance();
            Method methode = classe.getDeclaredMethod(methodname);
            val = methode.invoke(call);
        }catch(Exception e){
            e.getMessage();
        }
        return val;
    } 
    public static Class[] getAllClass() throws Exception{
        String path = Traitement.class.getClassLoader().getResource("").getPath();
        Vector<String> str = getClassesName(new File(path));
        Class[] valiny = new Class[str.size()];
        for (int i = 0; i < valiny.length; i++) {
                   
            valiny[i] = Class.forName(str.get(i));
        }
        return valiny;
    }   
    
    public static Vector<String> getClassesName(File dir) throws Exception{
        Vector<String> all = new Vector<>();
        try {
            File[] files = dir.listFiles();
            for (File file : files) {
                    if (file.isDirectory() == true) {
                        Vector<String> rec = Traitement.getClassesName(file);
                        for(int i = 0;i < rec.size();i++){
                            all.add(file.getName()+"."+rec.get(i));
                        }
                    } else {
                        if(file.getName().endsWith(".class")){
                            all.add((file.getName()).substring(0,file.getName().length()-6));
                        }
                    }
            }
        } catch (Exception e) {
            throw e;
        }
        return all;
    }
    


    public static Class[] getClassesWithAnnotation(Class[] all,Class annotation) throws Exception{

        Vector<Class> valiny = new Vector<>();
        for (int i = 0; i < all.length; i++) {
            if(all[i].isAnnotationPresent(annotation) == true){
                valiny.add(all[i]);
            }
        }

        Object[] rep = valiny.toArray();

        Class[] fin = Arrays.copyOf(rep, rep.length,Class[].class);

        return fin;
    }

    public static Field[] getFieldsWithAnnotation(Class toCheck,Class annotation) throws Exception{
        Field[] allFields = toCheck.getDeclaredFields();
        Vector<Field> valiny = new Vector<>();
        for (int i = 0; i < allFields.length; i++) {
            if(allFields[i].isAnnotationPresent(annotation) == true){
                valiny.add(allFields[i]);
            }
        }

        Object[] rep = valiny.toArray();

        Field[] fin = Arrays.copyOf(rep, rep.length,Field[].class);

        return fin;
    }

    public static Method[] getAllMethodWithAnnotation(Class toCheck,Class annotation) throws Exception{
        Method[] allMethods = toCheck.getDeclaredMethods();

        Vector<Method> valiny = new Vector<>();
        for (int i = 0; i < allMethods.length; i++) {
            if(allMethods[i].isAnnotationPresent(annotation) == true){
                valiny.add(allMethods[i]);
            }
        }

        Object[] rep = valiny.toArray();

        Method[] fin = Arrays.copyOf(rep, rep.length,Method[].class);

        return fin;
    }
}