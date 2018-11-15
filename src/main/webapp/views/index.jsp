<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CRUD BOOK</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <style>
        .peren {
            white-space: pre-wrap;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <h5 class="navbar-brand">CRUD APPLICATION WITH THE BOOK</h5>
    </div>
</nav>
<br>
<%--/////////////////////////////////////////////--%>
<form id="form" name="form" action="" class="">
    <p>Enter name:&nbsp; &nbsp; &nbsp;&nbsp;<input name="name" id="name" type="text"></p>
    <p>Enter autor:&nbsp; &nbsp; &nbsp;&nbsp;<input name="autor" id="autor" type="text"></p>
    <p>Enter id:&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<input name="id" id="id" type="text"></p>
    <div>
        <p class="text-white bg-light">
            <button name="create" type="button" id="create" class="btn btn-dark  m-auto">Create</button>
            <button name="read" type="button" id="read" class="btn btn-dark  m-auto">Read</button>
            <button name="readall" id="readall" type="button" class="btn btn-dark  m-auto">Read All</button>
            <button name="update" id="update" type="button" class="btn btn-dark  m-auto">Update</button>
            <button name="delete" id="delete" type="button" class="btn btn-dark  m-auto">Delete</button>
        </p>
        <div id="Help" class="bg-info text-warning">
            <p face="Times New Roman, Times, serif" size="4">If you want to create book, enter name, autor and click
                &quot;Create&quot;.</p>
            <p face="Times New Roman, Times, serif" size="4">If you want to read or delete book, enter id and click
                needed button.</p>
            <p face="Times New Roman, Times, serif" size="4">If you want to read all books, click &quot;Read
                All&quot;.</p>
            <p face="Times New Roman, Times, serif" size="4">If you want to update data about book, enter name, autor,
                id and click &quot;Update&quot;.</p>
        </div>
    </div>
</form>
<br>
<div id="res" class="bg-success peren ">Your result will be there.</div>


<script>
    let $res = $("#res");
    let $create = $("#create");
    let $update = $("#update");
    let $read = $("#read");
    let $delete = $("#delete");
    let $readall = $("#readall");

    $create.click(function () {
        $res.empty();
        let $name = $("#name").val();
        let $autor = $("#autor").val();
        let dat = {
            name: $name,
            autor: $autor
        };
        let datas = JSON.stringify(dat);

        $.ajax({
            url: '/book',
            type: 'POST',
            data: datas,
            contentType: 'application/json',
            error: function (err) {
                console.log(err);
            },
            success: function (result) {
                let $divk = $('<div/>', {text: result});
                $res.append($divk);
            }
        })
    })
    $update.click(function () {
        $res.empty();
        let $name = $("#name").val();
        let $autor = $("#autor").val();
        let $id = +$("#id").val();
        let dat = {
            name: $name,
            autor: $autor
        };
        let datas = JSON.stringify(dat);

        $.ajax({
            url: '/book/' + $id,
            type: 'PUT',
            data: datas,
            contentType: 'application/json',
            error: function (err) {
                console.log(err);
            },
            success: function (result) {
                let $divk = $('<div/>', {text: result});
                $res.append($divk);
            }
        })
    })
    $read.click(function () {
        $res.empty();
        let $id = +$("#id").val();
        $.ajax({
            url: '/book/' + $id,
            type: 'GET',
            contentType: 'application/json',
            error: function (err) {
                console.log(err);
            },
            success: function (result) {
                let $divk = $('<div/>', {text: result});
                $res.append($divk);
            }
        })
    })
    $delete.click(function () {
        $res.empty();
        let $id = +$("#id").val();
        $.ajax({
            url: '/book/' + $id,
            type: 'DELETE',
            contentType: 'application/json',
            error: function (err) {
                console.log(err);
            },
            success: function (result) {
                let $divk = $('<div/>', {text: result});
                $res.append($divk);
            }
        })
    })
    $readall.click(function () {
        $res.empty();
        $.ajax({
            url: '/book',
            type: 'GET',
            contentType: 'application/json',
            error: function (err) {
                console.log(err);
            },
            success: function (result) {
                let $divk = $('<div/>', {text: result});
                $res.append($divk);
            }
        })
    })
</script>

</body>
</html>