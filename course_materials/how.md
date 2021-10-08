## OM
как подключить модуль

тут лежит нужен нам класс - >>

    <parent>
        <artifactId>job4j_design</artifactId>
        <groupId>org.example</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>chapter_003</artifactId>
    

вот так добавляем его ->>

        <dependency>
        <groupId>org.example</groupId>
        <version>1.0-SNAPSHOT</version>
        <artifactId>chapter_003</artifactId>
        </dependency>
        
        И так, для удаления папки .idea из git-репозитория необходимо:

Добавить папку в .gitignore
Это можно сделать как вручную, так и про помощи консольной команды

echo '.idea' >> .gitignore
Удалить папку .idea из стейджинга
Стейджинг (staging area) — файл в котором содержиться информация данных, которые войдут в следующий коммит. Без удаления папки из стейджинга, git будет будет игнорировать изменения внутри папки .idea.

git rm -r --cached .idea
Добавить обновленный файл .gitignore и запушить изменения
Эти команды не нуждаются в описании, просто по очереди выполняем их.

git add .gitignore
git commit -m 'Удалена папка .idea'
git push
