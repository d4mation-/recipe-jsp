/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    private Array ingredientArray;
    private String recipeInstructions;
    
    public recipe() {
        recipeName = "";
        recipeAuthor = "";
        ingredientArray = null;
        recipeInstructions = "";
    }
    
    public recipe(String recipeName, String recipeAuthor, Array ingredientArray, String recipeInstructions) {
        this.recipeName = recipeName;
        this.recipeAuthor = recipeAuthor;
        this.ingredientArray = ingredientArray;
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
    
    public Array getIngredientArray() {
        return ingredientArray;
    }
    
    public void setIngredientArray(Array ingredientArray) {
        this.ingredientArray = ingredientArray;
    }
    
    public String getRecipeInstructions() {
        return recipeInstructions;
    }
    
    public void setRecipeInstructions(String recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }
    
}
