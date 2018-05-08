## LASA-Projeto
> **Desenvolvedor:** Eduardo Martins - [LinkedIn
](https://www.linkedin.com/in/eduardo-martins-849534110/)

<br>
<br>
Projeto para avalia��o no processo seletivo da empresa TO Brasil. <br>
A ideia do projeto � processar determinadas vendas a partir de uma base de dados ou WebService, transformar alguns dados espec�ficos e extra�-los em forma de um arquivo TXT posicional. <br>
Similar ao processo de ETL.
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




# Diagrama de Estados - Simplificado
> **Diagrama de Estados - Simplificado:** � uma representa��o do **estado** ou situa��o em que um objeto pode se encontrar no decorrer da execu��o de processos de um sistema.

Segue abaixo a disponibiliza��o de um diagrama de estados simplificado para melhor entendimento da solu��o utilizada para o problema.


##### Primeira Etapa:

```mermaid
graph LR
A[Thread 1] -- executarProcessamentoVenda --> B((Processamento))
E[Thread 2] -- executarProcessamentoVenda --> B((Processamento))
B -- atualizarStatusVenda --> D(BD)

```

##### Segunda Etapa:

```mermaid
graph LR
A[Thread 3] -- obterProcessamentosPendentes--> B((Execu��o))
B -- criarArquivoProcessados--> C((Execu��o))
C -- atualizarStatusProcessamento --> D(BD)
C -- criarArquivoProcessados--> E{C:\\PROCESSADOS}
```


# Configura��es Necess�rias

Abaixo, um tutorial r�pido de como inicializar a aplica��o LASA-Projeto em sem ambiente de desenvolvimento.

##### Dependencias do Maven




```xml 
<myxml>
   <someElement />  
</myxml>
```mermaid


```



###### Tabela: tb_venda
| id_venda_item |   |   |   |   |
|:-------------:|:-:|---|---|---|
|       1       |   |   |   |   |
|       1       |   |   |   |   |
|       1       |   |   |   |   |

