<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8"/>
    <title>Home</title>
</head>
<body>
<span>${name}</span>
<ul>
<#list dataList as item>
    <li>
    ${item_index + 1} . ${item.question}
        <br>

        <input type="radio" name="userAnswer"> A: ${item.optionA} &nbsp;&nbsp;
        <input type="radio" name="userAnswer"> B: ${item.optionB} &nbsp;&nbsp;
        <br>
        <input type="radio" name="userAnswer"> C: ${item.optionC} &nbsp;&nbsp;
        <input type="radio" name="userAnswer"> D: ${item.optionD} &nbsp;&nbsp;
        <br>

        参考答案:
        <#if item.answerSingle??>
        ${item.answerSingle}
        <#else>
        ${item.answerShort}
        </#if>
    </li>
    <br>
</#list>
</ul>
</body>
</html>