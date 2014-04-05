$(document).ready(function () {

    $("#delete-book").on("click", function () {
        var bookId = $(this).parents().eq(1).find("td").html();
        $.ajax({
            url: bookId,
            type: "DELETE"
        }).done(function (data) {
            alert(data.message);
        });
    });

    $("#find-book").on("click", function () {
        var bookId = $("#book-id").val();
        $.ajax({
            url: bookId,
            type: "GET"
        }).done(function (data) {
            console.log(data);
            if(data != "") {
                $("#table").css('visibility', 'visible');
                $("#id").text(data.id);
                $("#name").text(data.name);
                $("#author").text(data.author);
                $("#description").text(data.description);
                $("#pictureOfCover").empty();
                $("#pictureOfCover").append("<a target='_blank' href = " + data.pictureOfCover + ">link</a>");
            } else {
                $("#table").css('visibility', 'hidden');
            }
        });
    });

});

