# 小说网站项目

## 项目简介

这是一个简单的小说网站项目，使用Spring Boot框架进行开发，提供小说的管理和展示功能。该项目包含基本的CRUD操作，前后端分离，前端使用HTML、CSS和JavaScript，后端使用Spring Boot和MyBatis。

## 项目结构


### 目录说明

- `HELP.md`：项目帮助文档。
- `README.md`：项目的介绍和使用说明。
- `mvnw` 和 `mvnw.cmd`：Maven Wrapper，用于在没有安装Maven的环境中运行Maven。
- `pom.xml`：Maven项目的配置文件，包含项目的依赖和插件配置。
- `src`：项目的源码目录，包含 `main` 和 `test` 两个子目录。
    - `main`：包含主代码和资源文件。
    - `test`：包含测试代码和资源文件。
- `target`：Maven编译后生成的目录，包含编译后的类文件和生成的源码。

## 快速开始

### 环境要求

- JDK 17
- Maven 3.9.6
- MySQL 数据库

### 配置数据库

1. 创建数据库：
    ```sql
    CREATE DATABASE novel_website;
    ```

2. 配置 `application.properties` 文件：

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/novel_website?useSSL=false&serverTimezone=UTC
    spring.datasource.username=root
    spring.datasource.password=root
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

### 运行项目

1. 使用Maven
