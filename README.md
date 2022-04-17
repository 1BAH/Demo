# Демо сайт
*Автор: Иван Калинин*

[Сайт на котором ранится проект](http://localhost:2003)

> ***Если вам понравился данный репозиторий не забудьте его застарить!!!!***

Для работы на компе нужен локальный сервер базы данных MySQL

> Сделано под Windows (для MacOS будет написано ниже, что надо поменять) 
>
> Для Linux адаптации пока нет (Надо самостоятельно скачать phpMyAdmin и его настроить

### Как сделать его?

Скачиваем приложуху MAMP

Запускаем, нажимаем `start server`

Далее переходим по [ссылке](http://localhost/phpMyAdmin/sql.php)

> Для пользователей MacOS надо зайти на WebStart с MAMP там найти снизу строчку MySQL на нее нажать и там нажать на ссылку phpMyAdmin

В нем создаем новую базу данных **Название: banksystem** (*если поставите другое - за исправность не ручаюсь*)

Запускаем в Idea приложение - УРА!

> Если вы пользователь MacOS:
> Заходим в `application.properties` и меняем весь код на:
>
>```properties
>server.port=2003
>
>spring.jpa.hibernate.ddl-auto=update
>spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:8889/banksystem
>spring.datasource.username=root
>spring.datasource.password=root
>spring.datasource.driver-class-name =com.mysql.jdbc.Driver
>#spring.jpa.show-sql: true
>
>management.endpoint.restart.enabled=true
>```

---

##### По всем вопросам, касающимся проблем с запуском, писать мне в лс (все остально - мимо)
