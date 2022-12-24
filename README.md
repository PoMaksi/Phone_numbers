Sonet
========

Для запуска проекта необходимо:

В файле keycloak/conf/keycloak.conf указать настройки базы данных для Keycloak:

`db= mysql / postgres / mongodb`

`db-username= USERNAME`

`db-password= PASSWORD`

`db-url= URL`

В файле src/main/resources/application.yml указать настроки базы данных для Spring Boot приложения (отличается от БД Keycloak):

`url: URL`

`username: USERNAME`

`password: PASSWORD`

Для старат Keycloak по адресу: http://localhost:8080 необходимо выполнить команду:

on Linux/Unix/MacOS:

    $ sh keycloak/bin/kc.sh start-dev

on Windows:

    $ keycloak\bin\kc.bat start-dev

Для старта приложения, необходимо его запустить (после запуска Keycloak)