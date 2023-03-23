/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package etu1808.framework.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilitaire.Utilitaire;
import etu1808.framework.Mapping;
import etu1808.framework.annotation.Url;
import etu1808.framework.trtmt.Traitement;
import java.lang.reflect.Method;
import java.util.Map;

/**
 *
 * @author dm
 */
public class FrontServlet extends HttpServlet {
    HashMap<String, Mapping> mappingUrls;
    
    public void init()throws ServletException{
        Traitement trtmt = new Traitement();
        try {
            Class[] allClass = trtmt.getAllClass("etu1808.framework.model");
            
            for (Class allClas : allClass) {
                Method[] method = trtmt.getAllMethodWithAnnotation(allClas, Url.class);
                if (method == null) {
                    for (Method method1 : method) {
                        Url url = (Url) method1.getAnnotation(Url.class);
                        this.mappingUrls.put(url.url(), new Mapping(allClas.getName(), method1.getName()));
                    }
                }
            }
            
        } catch (Exception e) {
            
        }
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String url)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FrontServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FrontServlet at " + request.getContextPath() + "</h1>");
            
            String links =  new Utilitaire().getUrl(url,request.getContextPath().toString());

//
//            for (String url1 : links) {
//            }

            try {
                for (Map.Entry<String, Mapping> entry : mappingUrls.entrySet()) {
                    out.print(entry.getKey());
                    out.print(entry.getValue().getClassName());
                    out.print(entry.getValue().getMethod());
                    
//                    Object key = entry.getKey();
//                    Object val = entry.getValue();
                    
                }
            } catch (Exception e) {
            }
            out.println(links);
        
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response, request.getRequestURL().toString());
        init();
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response, request.getRequestURL().toString());
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
