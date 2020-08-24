<#import "partials/main.ftlh" as main>
<@main.renderWith>
    <div class="row">
        <div class="col">Тема</div>
        <div class="col">Описание</div>
        <div class="col">Дата</div>
        <div class="col">Действия</div>
    </div>
    <div class="row">
        <div class="col">${task.title}</div>
        <div class="col">${task.description}</div>
        <div class="col">${task.dateTime.toLocalDate()} ${task.dateTime.toLocalTime()}</div>
        <div class="col">
            <a href="/tasks/task/${task.id?c}/delete" class="btn btn-danger">Удалить</a>
            <a href="/tasks/task/${task.id?c}/edit" class="btn btn-secondary">Редактировать</a>
            <#if task.state == "COMPLETED">
                <a href="/tasks/task/${task.id?c}/state" class="btn btn-success">Выполнено</a>
            <#elseif task.state == "NOT_COMPLETED">
                <a href="/tasks/task/${task.id?c}/state" class="btn btn-warning">Не выполнено</a>
            </#if>
        </div>
    </div>
</@main.renderWith>