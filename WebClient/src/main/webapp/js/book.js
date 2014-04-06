$(document).ready(function () {

    $("#delete-book").on("click", function () {
        var bookId = $(this).parents().eq(1).find("td").html();
        $.ajax({
            url: bookId,
            type: "DELETE"
        }).done(function (data) {
            if (data.message == null) {
                alert("Fail operation");
            } else {
                alert(data.message);
            }
            location.reload();
        });
    });

    $("#find-book").on("click", function () {
        var bookId = $("#book-id").val();
        $.ajax({
            url: '/book/' + bookId,
            type: "GET"
        }).done(function (data) {
            console.log(data);
            if (data != "") {
                $("#table").css('visibility', 'visible');
                $("#id").html('<input value=' + data.id + '>');
                $("#name").html('<input value=' + data.name + '>');
                $("#author").html('<input value=' + data.author + '>');
                $("#description").html('<input value=' + data.description + '>');
                $("#pictureOfCover").html('<input value=' + data.pictureOfCover + '>');
            } else {
                $("#table").css('visibility', 'hidden');
            }
        });
    });

    $("#create-book").on("click", function () {
        var bookObject = new Object();
        bookObject.name = $("#book-name").val();
        bookObject.author = $("#book-author").val();
        bookObject.description = $("#book-description").val();
        bookObject.pictureOfCover = $("#book-pict-of-cover").val();
        var bookJson = JSON.stringify(bookObject);
        $.ajax({
            url: '',
            type: "POST",
            dataType: 'json',
            contentType: "application/json;charset=UTF-8",
            data: bookJson
        }).done(function (data) {
            if (data.message == null) {
                alert("Fail operation");
            } else {
                alert(data.message);
            }
            location.reload();
        });
    });

    $("#update-book").on("click", function () {
        var bookObject = new Object();
        bookObject.id = $("#book-id").val();
        bookObject.name = $("#book-name").val();
        bookObject.author = $("#book-author").val();
        bookObject.description = $("#book-description").val();
        bookObject.pictureOfCover = $("#book-pictureOfCover").val();
        var bookJson = JSON.stringify(bookObject);
        $.ajax({
            url: '/book/update',
            type: "PUT",
            dataType: 'json',
            contentType: "application/json;charset=UTF-8",
            data: bookJson
        }).done(function (data) {
            if (data.message == null) {
                alert("Fail operation");
            } else {
                alert(data.message);
            }
//            location.reload();
        });
    });

});

