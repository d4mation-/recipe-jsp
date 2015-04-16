<%-- 
    Document   : response
    Created on : Mar 23, 2015, 7:54:36 PM
    Author     : edefore
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url = "/assets/header.jsp" />
        
        <div class = "row">
            <div class = "container-fluid">
                <div class = "col-lg-8 col-md-8 col-sm-10 col-xs-10 col-lg-offset-2 col-md-offset-2 col-sm-offset-1 col-xs-offset-1">
                    
                    <div class = "list-group">
			
                        <div class = "list-group-item active col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class = "col-lg-7 col-md-7 col-sm-12 col-xs-12">${recipe.getRecipeAuthor()}</div>
				<div class = "col-lg-5 col-md-5 col-sm-12 col-xs-12 text-right">${recipe.getRecipeAuthor()}</div>
                        </div>
                    
                    <c:forEach items="${ingredients}" var="ingredient">
                        <div class = "list-group-item col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class = "col-lg-6 col-md-6 col-sm-12 col-xs-12">${ingredient.getIngredientName()}</div>
                            <div class = "col-lg-6 col-md-6 col-sm-12 col-xs-12 text-right">${ingredient.getIngredientSize()}&nbsp;${ingredient.getIngredientUnit()}</div>
                        </div>
                    </c:forEach>
                        
                        <c:if test="${recipe.getRecipeInstructions().length() > 0}">
                            <div class = "list-group-item col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <div class = "col-lg-12 col-md-12 col-sm-12 col-xs-12">Instructions: ${recipe.getRecipeInstructions()}</div>
                            </div>
                        </c:if>
                            
                    </div>
                    
                </div>
            </div>
        </div>

<c:import url = "/assets/footer.jsp" />