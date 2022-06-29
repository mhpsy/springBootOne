<html lang="en">
<body>
<h2>Hello World!</h2>
<h2>${name}</h2>
<#if sex='0'>
    女
    <#elseif sex=='1'>
    <#else>
    其他
</#if>

<#if age gte 18>
    成年了
<#else>
    未成年
</#if>
<#list list as name>
    ${name}<br>
</#list>
</body>
</html>