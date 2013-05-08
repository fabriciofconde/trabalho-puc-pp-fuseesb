Demonstração da tecnologia FUSE ESB.

Este projeto é uma demonstração que apresenta exemplos de uso da tecnologia simulando casos de uso de um sistema distribuído que 
possui uma camada web (Portal do Aluno), o FUSE ESB para integrar com o sistema legado da universidade.

Trabalho desenvolvido para a disciplina de Padrões de projeto da pós-graduação em Arquitetura de Software Distribuído - PUC Minas
Desenvolvido por Douglas Patrocínio, Eduardo Costa Ribeiro, Fabrício Condé, Fernando Pacífico e Marinete Andrade.

Aconselhamos usar a ferramenta de desenvolvimento FUSE IDE.


integrador
----------
Integrador criado para executar o papel de intermediário entre o portal e o sistema Legado.
Foram criadas rotas que utilizam filas JMS para integrar os endpoints.

Você deverá executar o comando maven abaixo para instalar a aplicação. A execução do comando baixará as dependências necessárias 
para executar a aplicação.

mvn install

Em seguida, usando a ferramenta FUSE IDE você pode iniciar o integrador clicando com o botão 
direito sobre o arquivo Integrador.xml e rodar como Local Camel Context

1o: botão direito sobre o arquivo Integrador.xml (integrador\src\main\resources\META-INF\spring\Integrador.xml)
2o: Clicar e "Run As" 
3o: Escolher a opção "Local Camel Context"  


portalacademico
---------------
Aplicação desenvolvida em Java SE com funcionalidades que acionam o integrador. É possível realizar as operações síncronas (consultar 
histórico e consultar notas por disciplina) e também é possível ver o funcionamento de uma operação assíncrona de trancamento de disciplina.
   
Você deverá executar o comando maven abaixo para instalar a aplicação. A execução do comando baixará as dependências necessárias para 
executar a aplicação.

mvn install

Em seguida, pode-se iniciar o portalacademico clicando com o botão direito sobre o arquivo InvocadorPortalAluno e rodar como Java Application

1o: botão direito sobre o arquivo InvocadorPortalAluno.java (portalacademico\src\main\java\puc\pp\portalacademico\InvocadorPortalAluno.java)
2o: Clicar e "Run As" 
3o: Escolher a opção "Java Application" 

----------------

Para mais ajuda, você pode consultar a documentação do FUSE ESB e do Apache Camel. Segue alguns sites que servirão de ajuda.

	http://www.jboss.org/products/fuse
	http://fusesource.com/documentation/fuse-esb-documentation/
	http://camel.apache.org/
