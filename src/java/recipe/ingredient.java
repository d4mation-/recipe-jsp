/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 * Simple class to hold the Ingredient Object
 */
package recipe;

/**
 *
 * @author edefore
 */

import java.io.Serializable;

public class ingredient implements Serializable{
    
    private String ingredientName;
    private String ingredientSize;
    private String ingredientUnit;
    
    public ingredient() {
        ingredientName = "";
        ingredientSize = "";
        ingredientUnit = "";
    }
    
    public ingredient(String ingredientName, String ingredientSize, String ingredientUnit) {
        this.ingredientName = ingredientName;
        this.ingredientSize = ingredientSize;
        this.ingredientUnit = ingredientUnit;
    }
    
    public String getIngredientName() {
        return ingredientName;
    }
    
    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
    
    public String getIngredientSize() {
        return ingredientSize;
    }
    
    public void setIngredientSize(String ingredientSize) {
        this.ingredientSize = ingredientSize;
    }
    
    public String getIngredientUnit() {
        return ingredientUnit;
    }
    
    public void setIngredientUnit(String ingredientUnit) {
        this.ingredientUnit = ingredientUnit;
    }
    
    @Override
    public String toString() {
        
        String ret = getIngredientName() + " " + getIngredientSize() + " " + getIngredientUnit();
        
        return ret;
        
    }
    
}
