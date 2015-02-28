$(document).ready( function() {
   
    var good = '';
    $(document).on('keyup', '.numbers-only', function() {
        var input = $(this);
        var matchedPosition = input.val().search(/[a-z@#!$%,-^&*()_+|~=`{}\[\]:";'<>?.\/\\]/i);
        if(matchedPosition == -1) {
            input.val(good);
        }else{
            good = input.val();
        }
    });
    
});