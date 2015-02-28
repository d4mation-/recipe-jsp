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
    private ingredient[] ingredientArray;
    
    public recipe() {
        recipeName = "";
        ingredientArray = null;
    }
    
    public recipe(String recipeName, ingredient[] ingredientArray) {
        this.recipeName = recipeName;
        this.ingredientArray = ingredientArray;
    }
    
    public String getRecipeName() {
        return recipeName;
    }
    
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    
    public Array getIngredientArray() {
        return ingredientArray;
    }
    
}
