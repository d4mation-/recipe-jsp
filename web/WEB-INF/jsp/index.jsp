<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <h1>Enter Recipe</h1>
        <form action = "input-recipe" method = "post">
            
            <label for = "ingredient_number">Number of Ingredients</label>
            <input type = "number" value = "${recipe.ingredientNumber}" min = 1 /> <br />
            
            <label for = "ingredient_size">Size of Ingredient</label>
            <select name = "ingredient_size" value = "${recipe.ingredientSize}">
                <option value = "" selected>Select Size of Ingredient</option>
                <option value = "0.10">Pinch<option>
                <option value = "0.25">1/4</option>
                <option value = "0.50">1/2</option>
                <option value = "0.75">3/4</option>
                <option value = "1">1</option>
            </select>
            
            <label for = "ingredient_unit">Ingredient Unit</label>
            <input type = "radio" name = "ingredient_unit" value = "TSP" required />TSP
            <input type = "radio" name = "ingredient_unit" value = "TBSP" required />TBSP
            <input type = "radio" name = "ingredient_unit" value = "CUP" required />CUP
            <input type = "radio" name = "ingredient_unit" value = "GALLON" required />GALLON
            
            <br />
            <input type = "submit" value = "Submit" />
            
        </form>
    </body>
</html>
