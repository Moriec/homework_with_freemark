<html lang="en">
<#include "base.ftl">

<head>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

    <script>
        $(document).ready(function () {
            $("#login-field").on("input", function () {
                var loginValue = $(this).val();
                $.get("/ajax/check-login", {login: loginValue}, function (response) {
                    $("#ajax-response").text(response);
                    if (response.includes("Логин алреду экзизт")) {
                        $("#submit-button").prop("disabled", true);
                    } else {
                        $("#submit-button").prop("disabled", false);
                    }
                });

            });
        });
    </script>
</head>



<body>
<#macro  title>Sign Up</#macro>

<div id="ajax-response"></div>

<#macro content>
    <h1>Registration</h1>
    <form method="post" action="sign_up" enctype="multipart/form-data">
        Name: <input type="text" name="name" placeholder="name">
        <br>
        Lastname: <input type="text" name="lastname" placeholder="lastname">
        <br>
        Login: <input type="text" name="login" placeholder="login" id="login-field"/>
        <br>
        Password: <input type="password" name="password" placeholder="password"/>
        <br>
        Photo: <input type="file" name = "file">
        <br><br>
        <input type="submit" value="Sign Up" id="submit-button" disabled/>
    </form>
    <br>
    <a href="login">Already have an account? Login here</a>
</#macro>

</body>


</html>
