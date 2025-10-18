<html lang="en">
<#include "base.ftl">

<#macro  title>Main page</#macro>

<#macro content>
    <h1>Hello, ${name}! Login successful</h1>
    <p>Lastname = ${lastname}</p>
    <p>Login = ${login}</p>
    <#if imagePath??><img src="${imagePath}" alt="User image" width="200" height="200"></#if>
</#macro>
</html>
