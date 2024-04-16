<html>
<head>
    <title>Mystery Men</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<%@include file="navbar.jsp"%>


<main>
<%-- TODO add documentation --%>
    <div class="container-sm">
        <div class="p-3 mb-2 bg-primary text-white">
            GET /theater/[movies|theaters]
        </div>
        <p>retrieves all of either movies or theaters</p>
    </div>
    <div class="container-sm">
        <div class="p-3 mb-2 bg-primary text-white">
            GET /theater/[movies|theaters]/{id}
        </div>
        <p>retrieves a movie or theater, based on given id number</p>
    </div>
    <div class="container-sm">
        <div class="p-3 mb-2 bg-primary text-white">
            GET /theater/theaters/name/{name}
        </div>
        <p>retrieves a list of theaters that have like names</p>
    </div>
    <div class="container-sm">
        <div class="p-3 mb-2 bg-primary text-white">
            GET /theater/movies/title/{title}
        </div>
        <p>retrieves a list of movies that have like titles</p>
    </div>
    <div class="container-sm">
        <div class="p-3 mb-2 bg-success text-white">
            POST /theater/[movies|theaters]
        </div>
        <p>adds a new movie or theater</p>
    </div>
    <div class="container-sm">
        <div class="p-3 mb-2 bg-danger text-white">
            DELETE /theater/[movies|theaters]
        </div>
        <p>adds a new movie or theater</p>
    </div>
</main>

</body>
</html>
