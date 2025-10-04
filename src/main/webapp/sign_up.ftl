<html lang="en">
<#include "base.ftl">

<#macro  title>Sign Up</#macro>

<#macro content>
    <h1>Registration</h1>
    <form method="post" action="sign_up">
        Name: <input type="text" name="name" placeholder="name">
        <br>
        Lastname: <input type="text" name="lastname" placeholder="lastname">
        <br>
        Login: <input type="text" name="login" placeholder="login"/>
        <br>
        Password: <input type="password" name="password" placeholder="password"/>
        <br><br>
        <input type="submit" value="Sign Up" />
    </form>
    <br>
    <a href="login">Already have an account? Login here</a>
</#macro>
</html>
