/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 * Simple Class to Hold Recipe Object
 */
package recipe;

/**
 *
 * @author edefore
 */

import java.io.Serializable;
import java.sql.Array;

public class recipe implements Serializable{
    
    private String recipeName;
    private String recipeAuthor;
    private String recipeInstructions;
    
    public recipe() {
        recipeName = "";
        recipeAuthor = "";
        recipeInstructions = "";
    }
    
    public recipe(String recipeName, String recipeAuthor, String recipeInstructions) {
        this.recipeName = recipeName;
        this.recipeAuthor = recipeAuthor;
        this.recipeInstructions = recipeInstructions;
    }
    
    public String getRecipeName() {
        return recipeName;
    }
    
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    
    public String getRecipeAuthor() {
        return recipeAuthor;
    }
    
    public void setRecipeAuthor(String recipeAuthor) {
        this.recipeAuthor = recipeAuthor;
    }
    
    public String getRecipeInstructions() {
        return recipeInstructions;
    }
    
    public void setRecipeInstructions(String recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }
    
}
