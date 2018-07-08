## LASA-Projeto
> **Desenvolvedor:** Eduardo Martins - [LinkedIn
](https://www.linkedin.com/in/eduardo-martins-849534110/)

<br>
<br>
A ideia do projeto � processar determinadas vendas a partir de uma base de dados ou WebService, 
<br>transformar alguns dados espec�ficos e extra�-los em forma de um arquivo TXT posicional. Similar ao processo de ETL.
<br>
<br>
<br>

|                  
|Tecnologias Utilizadas                          |
|-------------------------------------------|-------------------------------|
|Linguagem de Programa��o:  |`Java`            |
|Framework MVC              |`Spring MVC`            |
|RESTful Web Services        |`Jersey`|
|Scheduler Framework        |`Quartz Job Scheduler`|
|Manuseio do Banco de Dados |`Spring JDBC`|
|Cria��o de Arquivos de Log           |`Log4J`|
|Ferramenta de Automa��o de Compila��o      |`Apache Maven`|
|Framework Front-End      |`AngularJS`|
|Framework Front-End      |`BootStrap`|
|Container de Servlet/Servidor de Aplica��o |`Apache TomCat`|
|Banco de Dados                             |`MySQL`|
|Desenvolvimento de componente de Interface |`BootStrap`|
|Ambiente de Desenvolvimento(IDE)           |`Eclipse`|


#### Threads

    Os Jobs est�o configurados para inicializarem as opera��es de processamento
    30 segundos ap�s o start do servidor de aplica��o e executando a cada 1 min


# Diagrama de Estados - Simplificado
> **Diagrama de Estados - Simplificado:** � uma representa��o do **estado** ou situa��o em que um objeto pode se encontrar no decorrer da execu��o de processos de um sistema.

Segue abaixo a disponibiliza��o de um diagrama de estados simplificado para melhor entendimento da solu��o utilizada para o problema.


![Diagrama de Estados](https://image.ibb.co/nxUA67/Diagrama.png)


# Configura��es Necess�rias

Abaixo, um tutorial r�pido de como inicializar a aplica��o LASA-Projeto em sem ambiente de desenvolvimento.


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

#### Servlet Container/Servidor de Aplica��o

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

#### P�gina de Relat�rio - URL
    
    http://localhost:8080/LASA-Projeto/ 

#### WebServices

    @POST
    http://localhost:8080/LASA-Projeto/rest/processamento/inserirVenda  - Endpoint referente a inser��o de uma nova venda.
    
    @GET
    http://localhost:8080/LASA-Projeto/rest/relatorio/obterVendas - Servi�o utilizado para recuperar as vendas exibidas no relat�rio.


##### Exemplo do JSON de entrada para o servi�o [POST] inserirVenda
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

#### Configura��o da Aplica��o no Eclipse

    Ap�s realizar o download do projeto compactado em um arquivo.zip, 
    extraia o arquivo no local de sua prefer�ncia.
     
    Na aba Project Explorer do Eclipse, clique com o bot�o direto e selecione
    as op��es conforme as imagens abaixo.
   
![Etapa 1](https://image.ibb.co/cHueYn/Etapa_1.png)

![Etapa 2](https://image.ibb.co/mt1F67/Etapa_2.png)

![Etapa 3](https://image.ibb.co/btnNm7/Etapa_3.png)

    Pressione Finish e o projeto ser� inclu�do na aba Project Explorer.
     
    Em seguida, ser� necess�rio atualizar as dependencias que 
    ser�o utilizadas na aplica��o atrav�s do Maven.
    Siga os passos abaixo conforme as imagens.

![Etapa 4](https://image.ibb.co/jbWRDn/Etapa_4.png)

    Ap�s a realiza��o do download de todas as dependencias utilizadas,
    o projeto est� pronto para ser inicializado atrav�s do Apache Tomcat.
     
    Para isso, precisamos criar um servidor conforme as imagens abaixo.
    
*Obs: Nesta etapa, � necessario realizar o download das bibliotecas do Apache Tomcat 7.0 e extrair o arquivo .zip no local de sua prefer�ncia. [Apache Tomcat 7.0 Download](https://tomcat.apache.org/download-70.cgi)

![Etapa 5](https://image.ibb.co/bwsYtn/Etapa_5.png)

![Etapa 6](https://image.ibb.co/h04PzS/Etapa_6.png)

![Etapa 8](https://image.ibb.co/eSJjzS/Etapa_7.png)

    Pressione Finish e ser� criado um servidor do Apache Tomcat 7.0 e o mesmo
    aparecer� na aba Servers.
     
    Agora, � necess�rio incluir o projeto no servidor do Tomcat mas antes 
    � preciso configurar a Server Library do projeto referenciando as
    bibliotecas do tomcat.
     
    Clique com o bot�o direito no projeto -> Build Path -> Configure BuildPath
    Clique em ADD e em seguida clique em Server Runtime, selecione o
    Apache Tomcat 7.0 e de OK.
     
    Agora sim podemos incluir o projeto no servidor Tomcat, 
    Para isso, clique com o bot�o direito no servidor Tomcat, selecione
    a op��o Add and Remove. Clique na seta passando o projeto da esquerda para
    direita e clique em FINISH.

![ETAPA 8](https://image.ibb.co/f7iTR7/Etapa_8.png)
    
        Para finalizar, clique com o bot�o direito em cima do servidor Tomcat
        e selecione a op��o START.

![Etapa 9](https://image.ibb.co/cCmMeS/Etapa_9.png)

