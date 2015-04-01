package recipe;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 * Servlet class
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author edefore
 */
public class inputRecipe extends HttpServlet {
    
    String recipeName;
    String recipeAuthor;
    String ingredientName;
    String ingredientSize;
    String ingredientUnit;
    String recipeInstructions;
    String rememberMe;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet inputRecipe</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet inputRecipe at " + request.getContextPath() + "</h1>");
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
        
        //processRequest(request, response);
        
        doPost(request, response);
        
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

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try{
                request.getRequestDispatcher("/assets/header.jsp").include(request, response);
                
                out.println("<div class = \"row\">");
                    out.println("<div class = \"container-fluid\">");
                        out.println("<div class = \"col-lg-8 col-md-8 col-sm-10 col-xs-10 col-lg-offset-2 col-md-offset-2 col-sm-offset-1 col-xs-offset-1\">");
                
                            int ingredientCount = Integer.parseInt( request.getParameter("ingredient_number") );
                            ingredientCount = ingredientCount - 1; // Everything is indexed at 0;

                            recipeName = request.getParameter("recipe_name");
                            recipeAuthor = request.getParameter("recipe_author");
                            recipeInstructions = request.getParameter("recipe_instructions");
                            
                            if (request.getParameter("remember_me") != null ){
                                rememberMe = request.getParameter("remember_me");
                            }
                            else{
                                rememberMe = "";
                            }
                            
                            recipe newRecipe = new recipe(recipeName, recipeAuthor, recipeInstructions);
                            ingredient newIngredient;
                            
                            if ( rememberMe.equals("on") ){
                                Cookie c = new Cookie("recipe_author", newRecipe.getRecipeAuthor() );
                                c.setMaxAge(24*60*60);
                                response.addCookie(c); 
                            }
                            else{
                                Cookie eatCookie = new Cookie("recipe_author", "nom");
                                eatCookie.setMaxAge(0);
                                response.addCookie(eatCookie);
                            }

                            out.println("<div class = \"list-group\">");
                            
                                out.println("<div class = \"list-group-item active col-lg-12 col-md-12 col-sm-12 col-xs-12\">");
                                    out.println("<div class = \"col-lg-7 col-md-7 col-sm-12 col-xs-12\">" + newRecipe.getRecipeName() + "</div>");
                                    out.println("<div class = \"col-lg-5 col-md-5 col-sm-12 col-xs-12 text-right\">By: " + newRecipe.getRecipeAuthor() + "</div>");
                                out.println("</div>");

                                for(int index = 0; index <= ingredientCount; index++){
                                    ingredientName = request.getParameter("ingredient_name[" + index + "]");
                                    ingredientSize = request.getParameter("ingredient_size[" + index + "]");
                                    ingredientUnit = request.getParameter("ingredient_unit[" + index + "]");
                                    
                                    newIngredient = new ingredient(ingredientName, ingredientSize, ingredientUnit);
                                    
                                    if (Double.parseDouble(newIngredient.getIngredientSize()) == 0.10){
                                        newIngredient.setIngredientSize("Pinch");
                                    }
                                    if (newIngredient.getIngredientUnit() == null){
                                        newIngredient.setIngredientUnit(""); // When something is a Pinch, it makes no sense to specify it as a Pinch Gallon
                                    }
                                    out.println("<div class = \"list-group-item col-lg-12 col-md-12 col-sm-12 col-xs-12\">");
                                        out.println("<div class = \"col-lg-6 col-md-6 col-sm-12 col-xs-12\">" + newIngredient.getIngredientName() + "</div>");
                                        out.println("<div class = \"col-lg-6 col-md-6 col-sm-12 col-xs-12 text-right\">" + newIngredient.getIngredientSize() + " " + newIngredient.getIngredientUnit() + "</div>");
                                    out.println("</div>");
                                }
                                
                                if (newRecipe.getRecipeInstructions() != null && !newRecipe.getRecipeInstructions().equals("")){ 
                                    
                                    out.println("<div class = \"list-group-item col-lg-12 col-md-12 col-sm-12 col-xs-12\">");
                                        out.println("<div class = \"col-lg-12 col-md-12 col-sm-12 col-xs-12\">Instructions: " + newRecipe.getRecipeInstructions() + "</div>");
                                    out.println("</div>");
                                    
                                }
                                
                            out.println("</div>");
                        
                        out.println("</div>");
                    out.println("</div>");
                out.println("</div>");
                
                request.getRequestDispatcher("/assets/footer.jsp").include(request, response);
            }
            finally {
                out.close();
            }
            
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
