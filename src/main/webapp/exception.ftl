<html lang="en">
<#include "base.ftl">

<#macro  title>Main page</#macro>

<#macro content>
    Exception Details
</#macro>

<#macro content>
    <h1>Exception details:</h1>
    <strong> Reaquest uri: ${uri}</strong>
    <strong> Status code: ${statusCode}</strong>
    <#if message??> <strong> Message: ${message}</strong> </#if>
</#macro>

</html>