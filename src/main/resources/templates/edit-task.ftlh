<#import "partials/main.ftlh" as main>
<@main.renderWith>
    <form class="box-1" action="/tasks/task/${task.id}/edit" method="post">
    <#if _csrf??>
        <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
    </#if>
    <div class="form-group">
        <label class="col-form-label">Тема</label>
        <input class="form-control" type="text" name="title" value="${task.title}" placeholder="Тема" autofocus>
        <#if errors??>
            <#list errors as fieldError>
                <#if fieldError.field == 'title'>
                    <div class="alert alert-warning mt-1" role="alert">${fieldError.defaultMessage!'-- no message --'}</div>
                </#if>
            </#list>
        </#if>
    </div>
    <div class="form-group">
        <label class="col-form-label">Описание</label>
        <input class="form-control" type="text" name="description" value="${task.description}" placeholder="Описание">
        <#if errors??>
            <#list errors as fieldError>
                <#if fieldError.field == 'description'>
                    <div class="alert alert-warning mt-1" role="alert">${fieldError.defaultMessage!'-- no message --'}</div>
                </#if>
            </#list>
        </#if>
    </div>
    <div class="form-group">
        <label class="col-form-label">Дедлайн</label>
        <input class="form-control" type="datetime-local" name="dateTime" value="${task.dateTime}" placeholder="Дедлайн">
        <#if errors??>
            <#list errors as fieldError>
                <#if fieldError.field == 'dateTime'>
                    <div class="alert alert-warning mt-1" role="alert">${fieldError.defaultMessage!'-- no message --'}</div>
                </#if>
            </#list>
        </#if>
    </div>
    <p><button type="submit" class="btn btn-primary w-100">Добавить</button></p>
</@main.renderWith>