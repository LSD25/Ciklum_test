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
            url: '/book/' + bookId,
            type: "GET"
        }).done(function (data) {
            console.log(data);
//            if(isEmpty(data)) {
                $("#table").css('visibility', 'visible');
                $("#id").text(data.id);
                $("#name").text(data.name);
                $("#author").text(data.author);
                $("#description").text(data.description);
                $("#pictureOfCover").append("<a target='_blank' href = " + data.pictureOfCover + ">link</a>");
//            } else {
//                $("#table").css('visibility', 'hidden');
//            }
        });
    });

    function isEmpty(obj) {
        var name;
        for (name in obj) {
            return false;
        }
        return true;
    }

});

