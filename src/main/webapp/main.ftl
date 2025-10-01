<html lang="en">
<#include "base.ftl">

<#macro  title>Main page</#macro>

<#macro content>
    <h1>Hello, ${sessionUser}! Login successful</h1>
    <p>Session ID = ${sessionId}</p>
    <p>Cookie user = ${cookieUser}</p>
</#macro>
</html>
