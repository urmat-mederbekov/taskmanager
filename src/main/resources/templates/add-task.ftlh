<#import "partials/main.ftlh" as main>
<@main.renderWith>
    <div class="mx-auto mt-3 w-50">
        <form class="box-1" action="/tasks" method="post">
            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
            </#if>
            <#if errors??>
                <#assign fieldNames = errors?map(fieldError -> fieldError.field)>
            </#if>
            <h3 class="text-center">Добавить события</h3>
            <div class="form-group">
                <#assign fieldName = "title">
                <#assign input ='<input class="form-control" type="text" name="title" placeholder="Тема" autofocus>'>
                <#if errors?? && !fieldNames?seq_contains(fieldName)>
                    <#assign inputWithValue = '<input class="form-control" type="text" name="title" value="${taskForm.title}" placeholder="Тема" autofocus>'>
                </#if>
                <#include "partials/inputErrors.ftlh">
            </div>
            <div class="form-group">
                <#assign fieldName = "description">
                <#assign input ='<input class="form-control" type="text" name="description" placeholder="Описание">'>
                <#if errors?? && !fieldNames?seq_contains(fieldName)>
                    <#assign inputWithValue = '<input class="form-control" type="text" name="description" value="${taskForm.description}"placeholder="Описание">'>
                </#if>
                <#include "partials/inputErrors.ftlh">
            </div>
            <div class="form-group">
                <#assign fieldName = "dateTime">
                <#assign input ='<input class="form-control" type="datetime-local" name="dateTime" placeholder="Дедлайн">'>
                <#if errors?? && !fieldNames?seq_contains(fieldName)>
                    <#assign inputWithValue = '<input class="form-control" type="datetime-local" name="dateTime" value="${taskForm.dateTime}" placeholder="Дедлайн">'>
                </#if>
                <#include "partials/inputErrors.ftlh">
            </div>
            <p><button type="submit" class="btn btn-primary w-100">Добавить</button></p>
        </form>
    </div>
</@main.renderWith>