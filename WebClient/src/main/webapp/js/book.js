$(document).ready(function () {

    $("#find-book").on("click", function () {
        var bookId = $("#found-book-id").val();
        $.ajax({
            url: '/book/' + bookId,
            type: "GET"
        }).done(function (data) {
            console.log(data);
            if (data != "") {
                $("#table").css('visibility', 'visible');
                $("#book-id").val(data.id);
                $("#book-name").val(data.name);
                $("#book-author").val(data.author);
                $("#book-description").val(data.description);
                $("#book-pictureOfCover").val(data.pictureOfCover);
            } else {
                $("#table").css('visibility', 'hidden');
                alert("Book not found");
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
            window.location.href = '/book/list';
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
            window.location.href = '/book/list';
        });
    });

});

