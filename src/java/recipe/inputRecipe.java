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
import javax.servlet.RequestDispatcher;
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
    ingredient newIngredient;

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
        
        int ingredientCount = Integer.parseInt( request.getParameter("ingredient_number") );
        
        recipe newRecipe = createRecipe( request, response );
        ingredient[] newIngredients = createIngredients( request, response, ingredientCount );
        
        request.setAttribute( "recipe", newRecipe );
        request.setAttribute( "ingredientCount", ingredientCount );
        request.setAttribute( "ingredients", newIngredients );
        
        if (request.getParameter("remember_me") != null ){
                rememberMe = request.getParameter("remember_me");
        }
        else{
                rememberMe = "";
        }

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
        
        // PrintWriter out = response.getWriter();
        try {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher( "/WEB-INF/jsp/response.jsp" );
            dispatcher.forward(request, response);
        } catch ( ServletException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch ( IOException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    protected recipe createRecipe(HttpServletRequest request, HttpServletResponse response)
    {
            recipeName = request.getParameter("recipe_name");
            recipeAuthor = request.getParameter("recipe_author");
            recipeInstructions = request.getParameter("recipe_instructions");
            
            recipe newRecipe = new recipe(recipeName, recipeAuthor, recipeInstructions);
            
            return newRecipe;
    }
    
    protected ingredient[] createIngredients(HttpServletRequest request, HttpServletResponse response, int ingredientCount)
    {
        
        ingredient[] newIngredients = new ingredient[ingredientCount];
        
        for( int index = 0; index < ingredientCount; index++ ){
                ingredientName = request.getParameter("ingredient_name[" + index + "]");
                ingredientSize = request.getParameter("ingredient_size[" + index + "]");
                ingredientUnit = request.getParameter("ingredient_unit[" + index + "]");

                newIngredient = new ingredient(ingredientName, ingredientSize, ingredientUnit);

                if ( Double.parseDouble(newIngredient.getIngredientSize()) == 0.10 ){
                    newIngredient.setIngredientSize("Pinch");
                }
                if (newIngredient.getIngredientUnit() == null){
                    newIngredient.setIngredientUnit(""); // When something is a Pinch, it makes no sense to specify it as a Pinch Gallon
                }
                
                newIngredients[index] = newIngredient;
        }
            
        return newIngredients;
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
