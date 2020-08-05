<#import "partials/main.ftlh" as main>
<@main.renderWith>
    <div class="mx-auto mt-3 w-50">
        <form class="box-1" action="/tasks" method="post">
            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
            </#if>
            <h3 class="text-center">Добавить события</h3>
            <div class="form-group">
                <input class="form-control" type="text" name="title" placeholder="Тема" autofocus>
                <#if errors??>
                    <#list errors as fieldError>
                        <#if fieldError.field == 'title'>
                            <div class="alert alert-warning mt-1" role="alert">${fieldError.defaultMessage!'-- no message --'}</div>
                        </#if>
                    </#list>
                </#if>
            </div>
            <div class="form-group">
                <input class="form-control" type="text" name="description" placeholder="Описание">
                <#if errors??>
                    <#list errors as fieldError>
                        <#if fieldError.field == 'description'>
                            <div class="alert alert-warning mt-1" role="alert">${fieldError.defaultMessage!'-- no message --'}</div>
                        </#if>
                    </#list>
                </#if>
            </div>
            <div class="form-group">
                <input class="form-control" type="datetime-local" name="dateTime" placeholder="Дедлайн">
                <#if errors??>
                    <#list errors as fieldError>
                        <#if fieldError.field == 'dateTime'>
                            <div class="alert alert-warning mt-1" role="alert">${fieldError.defaultMessage!'-- no message --'}</div>
                        </#if>
                    </#list>
                </#if>
            </div>
            <p><button type="submit" class="btn btn-primary w-100">Добавить</button></p>
        </form>
    </div>
</@main.renderWith>