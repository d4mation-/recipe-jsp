function repeatIngredients(ingredientTemplate, keycode) {
    var ingredientsNumber = $('#number_of_ingredients').val();
    var currentIngredients = $('.ingredient-template').length; // Finds all occurences of class
    
    if(currentIngredients < ingredientsNumber) { 
        // Appends new Ingredients to reflect value in Input Box
    
        for(var index = currentIngredients; index < ingredientsNumber; index++) {
            var template = ingredientTemplate.clone(true); // JavaScript is very picky about duplicating DOM Elements
            template.find('select').attr('name', 'ingredient_size[' + index + ']');
            template.find('.ingredient-unit').each( function() {
                $(this).attr('name', 'ingredient_unit[' + index + ']');
            });
            $('.ingredient-repeater').append(template);
        }
        
    }
    
    if(currentIngredients > ingredientsNumber){
        // Remove all Ingredients over what is reflected in the Input Box
        
        for(var index = currentIngredients; index >= ingredientsNumber; index--) {
            $('select[name="ingredient_size[' + index + ']"').parent().parent().parent().remove();
        }
        
    }
    
    
    
}

$(document).ready( function() {
   
    var good = '';
    $(document).on('keyup', '.numbers-only', function(event) {
        
        var input = $(this);
        
        if(event.which !== 8){ // If not backspace
            var matchedPosition = input.val().search(/[a-z@#!$%,-^&*()_+|~=`{}\[\]:";'<>?.\/\\]/i);
            if(matchedPosition === -1) {
                input.val(good);
            }else{
                good = input.val();
            }
        }
        
        if(input.val() === ''){
            input.val(1);
        }
        
    });
 
    var ingredientTemplate = $('.ingredient-repeater').contents().clone(true);
    $('.ingredient-repeater').contents().remove();
    
    $(document).on('change', '#number_of_ingredients', function(event) {
       repeatIngredients(ingredientTemplate, event.which); 
    });
    
    $(document).on('keyup', '#number_of_ingredients', function(event) {
       repeatIngredients(ingredientTemplate, event.which); 
    });
    
    $( "form" ).submit(function( event ) {
        event.preventDefault();
        
        var fields = $('select').serializeArray();
        
        var ingredientSizes = new Array();
        var ingredientUnits = new Array();
        
        for(i = 0; i < fields.length; i++){
            ingredientSizes.push(fields[i].value);
        }
        
        fields = new Array();
        fields = $('.ingredient-unit').serializeArray();
        
        for(i = 0; i < fields.length; i++){
            ingredientUnits.push(fields[i].value);
        }
        
        $.post("input-recipe", {
                ingredientSize: ingredientSizes,
                ingredientUnit: ingredientUnits,
                mode: "Insert"
            }, function(data) {
                alert("Data Loaded: " + data);
            }
        );
    });
    
});