<#import "partials/main.ftlh" as main>
<@main.renderWith>
    <h3>Список событий</h3>

    <div class="row">
        <div class="col">#</div>
        <div class="col">Тема</div>
        <div class="col">Описание</div>
        <div class="col">Дата</div>
        <div class="col">Статус</div>
    </div>
    <#list items as task>
        <a href="/tasks/task/${task.id}">
            <div class="row">
                <div class="col">${task?counter}</div>
                <div class="col">${task.title}</div>
                <div class="col">${task.description}</div>
                <div class="col">${task.dateTime}</div>
                <#if task.state == "COMPLETED">
                    <div class="col bg-success">${task.state}</div>
                <#elseif task.state == "NOT_COMPLETED">
                    <div class="col bg-warning">${task.state}</div>
                </#if>
            </div>
        </a>
    </#list>
    <#include "partials/pagination.ftlh">
    <a type="button" class="btn btn-primary w-100" href="/tasks/add-task">
        Добавить
    </a>
</@main.renderWith>