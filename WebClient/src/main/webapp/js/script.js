$(document).ready(function () {
    $("#delete-book").on("click", function () {
        var bookId = $(this).parents().eq(1).find("td").html();
        $.ajax({
            url: bookId,
            type: "DELETE"
        }).done(function (data) {
            alert(data);
        });
    });
});

