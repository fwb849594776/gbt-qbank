<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>劳动关系协调师模拟题</title>
</head>
<body>
<form id="exerciseForm" name="exerciseForm" method="post">
    <h3>单选题</h3>
    <ul>
    <#list radioList as item>
        <li>
        ${item_index + 1}. ${item.question}
            <br>

            <label><input type="radio" name="userAnswer"> A: ${item.optionA} </label>&nbsp;&nbsp;
            <label><input type="radio" name="userAnswer"> B: ${item.optionB} </label>&nbsp;&nbsp;
            <br>
            <label><input type="radio" name="userAnswer"> C: ${item.optionC} </label>&nbsp;&nbsp;
            <label><input type="radio" name="userAnswer"> D: ${item.optionD} </label>&nbsp;&nbsp;
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

    <h3>多选题</h3>
    <ul>
    <#list multiList as item>
        <li>
        ${item_index + 1}. ${item.question}
            <br>
            <label><input type="checkbox" name="userAnswer"> A: ${item.optionA} </label>&nbsp;&nbsp;
            <label><input type="checkbox" name="userAnswer"> B: ${item.optionB} </label>&nbsp;&nbsp;
            <br>
            <label><input type="checkbox" name="userAnswer"> C: ${item.optionC} </label>&nbsp;&nbsp;
            <label><input type="checkbox" name="userAnswer"> D: ${item.optionD} </label>&nbsp;&nbsp;
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

    <h3>简答题</h3>
    <ul>
    <#list shortList as item>
        <li>
        ${item_index + 1} . ${item.question}
            <br>

            <input type="text" name="userAnswer">
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

    <h3>案例题</h3>
    <ul>
    <#list caseList as item>
        <li>
        ${item_index + 1} . ${item.question}
            <br>

            <textarea type="text" name="userAnswer"> A: ${item.optionA} &nbsp;&nbsp;
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
    <input type="submit" value="提交试卷">
</form>
</body>
</html>