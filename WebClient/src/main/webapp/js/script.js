$(document).ready(function(){
    $("#delete-book").on( "click", function() {
       var bookId = $( this ).parents().eq(1).find("td").html();
        $.ajax({
          url: bookId + '/delete',
          type: "DELETE"
        }).done(function() {
            alert('success')
        });
    });
});

