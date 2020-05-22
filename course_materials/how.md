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