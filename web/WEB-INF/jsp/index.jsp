<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url = "/assets/header.jsp" />
        
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
                            <div class = "col-lg-8 col-md-8 col-sm-12 col-xs-12">
                                <label for = "recipe_name">Recipe Name</label>
                                <input required class = "form-control" name = "recipe_name" />
                            </div>
                            <div class = "col-lg-4 col-md-4 col-sm-12 col-xs-12">
                                <label for = "recipe_author">Creator</label>&nbsp;<input type = "checkbox" class = "remember-me" name = "remember_me" <c:if test="${not empty cookie.recipe_author.value}">checked</c:if> />&nbsp;Remember Me
                                <input required class = "form-control" name = "recipe_author" value = "${cookie.recipe_author.value}" />
                            </div>
                        </div>
                        <br />

                        <div class = "row">
                            <div class = "col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <label for = "ingredient_number">Number of Ingredients</label>
                                <input required class = "form-control numbers-only" id = "number_of_ingredients" name = "ingredient_number" type = "number" value = "${recipe.ingredientNumber}" min = 1 /> <br />
                            </div>
                        </div>

                        <div class = "ingredient-repeater">
                            <div class = "ingredient-template">
                                <div class = "row">
                                    
                                    <div class = "col-lg-6 col-md-6 col-sm-12 col-xs-12">
                                        
                                        <label for = "ingredient_name">Name of Ingredient</label>
                                        <input required class = "form-control ingredient-name" name = "ingredient_name" />
                                        
                                    </div>
                                    
                                    <div class = "col-lg-3 col-md-3 col-sm-12 col-xs-12">

                                        <label for = "ingredient_size">Size of Ingredient</label>
                                        <select required class = "form-control ingredient-size" name = "ingredient_size">
                                            <option selected value = "">Select Size of Ingredient</option>
                                            <option value = "0.10">Pinch</option>
                                            <option value = "0.25">1/4</option>
                                            <option value = "0.50">1/2</option>
                                            <option value = "0.75">3/4</option>
                                            <option value = "1">1</option>
                                        </select>

                                    </div>

                                    <div class = "col-lg-3 col-md-3 col-sm-12 col-xs-12">

                                        <label class = "unit-label">Ingredient Unit</label><br />
                                        <div class = "unit radio">
                                            <label for = "ingredient_unit">
                                                <input class = "ingredient-unit" type = "radio" name = "ingredient_unit" value = "TSP" />
                                                TSP
                                            </label>
                                        </div>
                                        <div class = "unit radio">
                                            <label for = "ingredient_unit">
                                                <input class = "ingredient-unit" type = "radio" name = "ingredient_unit" value = "TBSP" />
                                                TBSP
                                            </label>
                                        </div>
                                        <div class = "unit radio">
                                            <label for = "ingredient_unit">
                                                <input class = "ingredient-unit" type = "radio" name = "ingredient_unit" value = "CUP" />
                                                CUP
                                            </label>
                                        </div>
                                        <div class = "unit radio">
                                            <label for = "ingredient_unit">
                                                <input class = "ingredient-unit" type = "radio" name = "ingredient_unit" value = "GALLON" />
                                                GALLON
                                            </label>
                                        </div>

                                    </div>

                                </div> <!-- End Row -->
                                <br />
      <!-- End Template --> </div>
                        </div> <!-- End Container -->
                        
                        <div class = "row">
                            <div class = "col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <label for = "recipe_instructions">Recipe Instructions</label>
                                <textarea class = "form-control" name = "recipe_instructions"></textarea>
                            </div>
                        </div>

                        <div class = "row">
                            <div class = "col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <br />
                                <input type = "submit" value = "Submit" class = "btn btn-success pull-right" />
                            </div>
                        </div>

                    </form>
                        
                </div> <!-- End Offset -->
            </div>
        </div>
                                    
<c:import url = "/assets/footer.jsp" />
