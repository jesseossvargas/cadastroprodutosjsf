    
                                      CADASTRO DE PRODUTOS COM JSF

    - Sistema com front-end e back-end que atualmente possui as funcionalidades de cadastrar
	um produto e listar todos os produtos cadastrados.
    - A fazer: Criar funcionalidade de consultar produto em específico, deletar e alterar.
                                        
    Sistema básico de cadastro e listagem de produtos desenvolvido com a motivação de melhorar o 
      conhecimento e a experiência nas tecnologias utilizadas e a forma com a qual elas interagem
      entre si para proporcionar uma solução. A motivação inicial foi desenvolver um sistema a 
      partir do arquétipo Maven Webapp Archetype versão 1.4 e entender melhor o formato em que a 
      estrutura de diretórios deste arquétipo é disposta no sentido de a mesma seguir o standard 
      directory layout do Apache Maven e também da espeficicação J2EE. Desenvolvido com a utilização
      da plataforma Java 8, atualmente também utiliza: JSF 2.2 com BootsFaces 1.5, JavaScript/jQuery,
      MySQL Community 8.0.27, Apache Tomcat 9.0.54, Lombok 1.18. O padrão de arquitetura utilizado é o
      MVC, através da utilização da implementação da especificação JSF. Também são utilizados os 
      padrões de projeto Builder, Factory e o padrão de persistência de dados DAO. Utiliza conexão 
      JNDI com o banco de dados. Utiliza a abordagem Package By Layer.
    Importe este Maven Projet para a IDE e utilize o Maven ou o plugin do Maven para baixar as 
      dependencias e instalar a aplicação. Instale o MySQL Communnity 8.0.27.1, defina a url e porta
      do seu serviço MySQL Server e inicie o servidor. Crie uma nova conexão de banco de dados para
      o serviço ativo do servidor MySQL Server e conecte-se através dela. Crie um novo SCHEMA com o nome 
      mavenwebapparchetype. Crie a seguinte tabela neste SCHEMA:
      
                                CREATE TABLE `produto` (
                                  `NOME` varchar(255) DEFAULT NULL,
                                  `QUANTIDADE` int DEFAULT NULL,
                                  `PRECO` double DEFAULT NULL,
                                  `DATA_VALIDADE` date DEFAULT NULL,
                                  `DATA_CADASTRO` date DEFAULT NULL,
                                  `ID_PRODUTO` int NOT NULL AUTO_INCREMENT,
                                  PRIMARY KEY (`ID_PRODUTO`)
                                ); 
      
    Instale o Apache Tomcat 9.0.54 no seu computador e adicione a seguinte configuração no arquivo 
      /conf/context.xml do diretório do seu Tomcat: 
      
		<Resource name="jdbc/mavenwebapparchetype" auth="Container" type="javax.sql.DataSource"
			  maxActive="100" maxIdle="100" maxWait="20000" username="<username>" password=
			  "<password>" driverClassName="com.mysql.jdbc.Driver" 
			  url="jdbc:mysql://<urlbancodados>"/>. 
					  
    Substitua <password> e <username> pela respectiva senha e usuário do seu serviço MySQL Server, 
      substitua <urlbancodados> pela url do seu servidor MySQL Server (ex: localhost/3348).
    Através da IDE adicione uma nova configuração com referência para a pasta do seu Tomcat 9.0.54
      e defina a alocação de memória RAM adequada para seu ambiente através dos argumentos da VM 
      (ex: -Xms2048M -Xmx5120M).
    Adicione o plugin do Lombok na sua IDE para que ela reconheça os métodos gerados por ele.
      
      
      
    
      
   
