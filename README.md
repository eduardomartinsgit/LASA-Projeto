## LASA-Projeto
> **Desenvolvedor:** Eduardo Martins - [LinkedIn
](https://www.linkedin.com/in/eduardo-martins-849534110/)

<br>
<br>
Projeto para avaliação no processo seletivo da empresa TO Brasil. <br>
A ideia do projeto é processar determinadas vendas a partir de uma base de dados ou WebService, transformar alguns dados específicos e extraí-los em forma de um arquivo TXT posicional. <br>
Similar ao processo de ETL.
<br>
<br>
<br>

|                  
|Tecnologias Utilizadas                          |
|-------------------------------------------|-------------------------------|
|Linguagem de Programação:  |`Java`            |
|Framework MVC              |`Spring MVC`            |
|RESTful Web Services        |`Jersey`|
|Scheduler Framework        |`Quartz Job Scheduler`|
|Manuseio do Banco de Dados |`Spring JDBC`|
|Criação de Arquivos de Log           |`Log4J`|
|Ferramenta de Automação de Compilação      |`Apache Maven`|
|Framework Front-End      |`AngularJS`|
|Framework Front-End      |`BootStrap`|
|Container de Servlet/Servidor de Aplicação |`Apache TomCat`|
|Banco de Dados                             |`MySQL`|
|Desenvolvimento de componente de Interface |`BootStrap`|
|Ambiente de Desenvolvimento(IDE)           |`Eclipse`|




# Diagrama de Estados - Simplificado
> **Diagrama de Estados - Simplificado:** É uma representação do **estado** ou situação em que um objeto pode se encontrar no decorrer da execução de processos de um sistema.

Segue abaixo a disponibilização de um diagrama de estados simplificado para melhor entendimento da solução utilizada para o problema.


![Diagrama de Estados](https://image.ibb.co/nxUA67/Diagrama.png)


# Configurações Necessárias

Abaixo, um tutorial rápido de como inicializar a aplicação LASA-Projeto em sem ambiente de desenvolvimento.


#### Dependencias do Maven

```xml 
<dependencies>
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>4.3.2.RELEASE</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
			<version>3.0.5.RELEASE</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
		<dependency>
		    <groupId>mysql</groupId>
		    <artifactId>mysql-connector-java</artifactId>
		    <version>5.1.21</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-lang3 -->
		<dependency>
		    <groupId>org.apache.commons</groupId>
		    <artifactId>commons-lang3</artifactId>
		    <version>3.7</version>
		</dependency>
		<dependency>
		    <groupId>org.springframework</groupId>
		    <artifactId>spring-context-support</artifactId>
		    <version>4.3.2.RELEASE</version>
		</dependency>
		<dependency>
		    <groupId>org.quartz-scheduler</groupId>
		    <artifactId>quartz</artifactId>
		    <version>2.2.1</version>
		</dependency>
		<dependency>
		    <groupId>org.glassfish.jersey.containers</groupId>
		    <artifactId>jersey-container-servlet</artifactId>
		    <version>2.22.1</version>
		</dependency>	
		<dependency>
		    <groupId>org.glassfish.jersey.media</groupId>
		    <artifactId>jersey-media-moxy</artifactId>
		    <version>2.22.1</version>
		</dependency>
		<dependency>
		    <groupId>org.glassfish.jersey.core</groupId>
		    <artifactId>jersey-server</artifactId>
		    <version>2.22.1</version>
		</dependency>
		<dependency>
		    <groupId>commons-codec</groupId>
		    <artifactId>commons-codec</artifactId>
		    <version>1.10</version>
		</dependency>
	    <!-- Jersey extension module providing support for Spring 3 integration -->
	    <dependency>
	        <groupId>org.glassfish.jersey.ext</groupId>
	        <artifactId>jersey-spring3</artifactId>
	        <version>2.22.1</version>
	        <exclusions>
	            <exclusion>
	                <groupId>org.springframework</groupId>
	                <artifactId>spring-core</artifactId>
	            </exclusion>
	            <exclusion>
	                <groupId>org.springframework</groupId>
	                <artifactId>spring-web</artifactId>
	            </exclusion>
	            <exclusion>
	                <groupId>org.springframework</groupId>
	                <artifactId>spring-beans</artifactId>
	            </exclusion>
	        </exclusions>
	    </dependency>		
	    <!-- https://mvnrepository.com/artifact/javax.servlet/jstl -->
		<dependency>
		    <groupId>javax.servlet</groupId>
		    <artifactId>jstl</artifactId>
		    <version>1.2</version>
		</dependency>
		<!-- Log4j -->
		<dependency>
			<groupId>log4j</groupId>
			<artifactId>log4j</artifactId>
			<version>1.2.17</version>
		</dependency>		
	</dependencies>
```

#### Servlet Container/Servidor de Aplicação

    Apache TomCat 7.0

#### Ambiente de Desenvolvimento(IDE)

    Eclipse JEE Oxygen
    
#### Banco de Dados

    MySQL Community Server 5.5
```sql
CREATE DATABASE vendas;
use vendas;

CREATE TABLE tb_venda (
	id_venda int not null,
	data timestamp,
    loja int,
    pdv int,
    status VARCHAR(100)
);

CREATE TABLE tb_item_venda (
    id_venda int,
    id_item_venda int,
    produto VARCHAR(256),
	preco_unitario DECIMAL(4,2),
    desconto DECIMAL(4,2)
);

CREATE TABLE tb_processamento (
	id_processamento int not null auto_increment,
    data timestamp,
    loja int,
    pdv int,
    nome_arquivo VARCHAR(256),
    status VARCHAR(100),
    PRIMARY KEY (id_processamento)
);

SELECT * FROM tb_venda;
SELECT * FROM tb_item_venda;
SELECT * FROM tb_processamento;
```
#### WebServices

    @POST
    http://localhost:[PORTA]/LASA-Projeto/rest/processamento/inserirVenda  - Endpoint referente a inserção de uma nova venda.
    
    @GET
    http://localhost:[PORTA]/LASA-Projeto/rest/relatorio/obterVendas - Serviço utilizado para recuperar as vendas exibidas no relatório.


##### Exemplo do JSON de entrada para o serviço [POST] inserirVenda
```json 
{
    "id_venda": 90,
    "data": "2017-06-26T10:17:48-03:00",
    "loja": 545,
    "pdv": 4,
    "itens": [
        {
        	"id_item_venda": 1,
            "produto": "0112348576",
            "preco_unitario": 1.99,
            "desconto": 1.00
        },
        {
        	"id_item_venda": 1,
            "produto": "0980987654",
            "preco_unitario": 9.99,
            "desconto": 1.99
        },
        {
            "id_item_venda": 2,
            "produto": "9182909878",
            "preco_unitario": 1.00,
            "desconto": 0.00
        },
        {
        	"id_item_venda": 2,
            "produto": "098712312",
            "preco_unitario": 6.99,
            "desconto": 2.00
        }                        
    ]
}
```