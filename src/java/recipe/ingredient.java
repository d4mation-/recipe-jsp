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

public class ingredient implements Serializable{
    
    private String ingredientName;
    private float ingredientSize;
    private String ingredientUnit;
    
    public ingredient() {
        ingredientName = "";
        ingredientSize = 0;
        ingredientUnit = "";
    }
    
    public ingredient(String ingredientName, float ingredientSize, String ingredientUnit) {
        this.ingredientName = ingredientName;
        this.ingredientSize = ingredientSize;
    }
    
    public String getIngredientName() {
        return ingredientName;
    }
    
    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
    
    public float getIngredientSize() {
        return ingredientSize;
    }
    
    public void setIngredientSize(float ingredientSize) {
        this.ingredientSize = ingredientSize;
    }
    
    public String getIngredientUnit() {
        return ingredientUnit;
    }
    
    public void setIngredientUnit(String ingredientUnit) {
        this.ingredientUnit = ingredientUnit;
    }
    
}
