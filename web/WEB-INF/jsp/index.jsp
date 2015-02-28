<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
        <title>Recipe Database</title>
        <link href = "<c:url value = "/assets/bootstrap-3.3.2/css/bootstrap.min.css" />" rel = "stylesheet" />
        <link href = "<c:url value = "/assets/css/style.css" />" rel = "stylesheet" />
    </head>

    <body>
        
        <div class = "row">
            <div class = "container-fluid">
                <div class = "col-lg-8 col-md-8 col-sm-10 col-xs-10 col-lg-offset-2 col-md-offset-2 col-sm-offset-1 col-xs-offset-1">
                    
                    <div class = "row">
                        <div class = "col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <h1>Enter Recipe</h1>
                        </div>
                    </div>

                    <form action = "input-recipe" method = "post">

                        <div class = "row">
                            <div class = "col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <label for = "ingredient_number">Number of Ingredients</label>
                                <input class = "form-control" type = "number" value = "${recipe.ingredientNumber}" min = 1 /> <br />
                            </div>
                        </div>

                        <div class = "row">
                            <div class = "col-lg-6 col-md-6 col-sm-12 col-xs-12">

                                <label for = "ingredient_size">Size of Ingredient</label>
                                <select class = "form-control" name = "ingredient_size" value = "${recipe.ingredientSize}">
                                    <option value = "" selected>Select Size of Ingredient</option>
                                    <option value = "0.10">Pinch<option>
                                    <option value = "0.25">1/4</option>
                                    <option value = "0.50">1/2</option>
                                    <option value = "0.75">3/4</option>
                                    <option value = "1">1</option>
                                </select>

                            </div>

                            <div class = "col-lg-6 col-md-6 col-sm-12 col-xs-12">
                                
                                <label class = "unit-label">Ingredient Unit</label><br />
                                <div class = "unit radio">
                                    <label for = "ingredient_unit">
                                        <input type = "radio" name = "ingredient_unit" value = "TSP" required />
                                        TSP
                                    </label>
                                </div>
                                <div class = "unit radio">
                                    <label for = "ingredient_unit">
                                        <input type = "radio" name = "ingredient_unit" value = "TBSP" required />
                                        TBSP
                                    </label>
                                </div>
                                <div class = "unit radio">
                                    <label for = "ingredient_unit">
                                        <input type = "radio" name = "ingredient_unit" value = "CUP" required />
                                        CUP
                                    </label>
                                </div>
                                <div class = "unit radio">
                                    <label for = "ingredient_unit">
                                        <input type = "radio" name = "ingredient_unit" value = "GALLON" required />
                                        GALLON
                                    </label>
                                </div>
                                
                            </div>

                        </div> <!-- End Row -->

                        <div class = "row">
                            <div class = "col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <br />
                                <input type = "submit" value = "Submit" class = "btn btn-success" />
                            </div>
                        </div>

                    </form>
                        
                </div> <!-- End Offset -->
            </div>
        </div>
                        
    </body>
