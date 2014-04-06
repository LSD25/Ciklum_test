<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <title>Page not found</title>
</head>

<script type="text/javascript">
    var counter = 10;
    var intervalID=0;
    var timer=setInterval(function () {
        counter -= 1;
        if(counter<1){
            clearInterval(timer);
            location.replace("/book/list");
        }
        $('#seconds').text(counter);
    }, 1000);

</script>

<body>

    <img src="http://cdn.css-tricks.com/images/404.jpg" alt="Page Not Found (404)."
         style="position: absolute; left: 50%; top: 50%; margin-left: -285px; margin-top: -190px;">
    <div id="counter">After <div id="seconds"> 10 </div> seconds you are redirect on the book list or please click ont <a href="/book/list">link</a>.</div>
</body>

</html>