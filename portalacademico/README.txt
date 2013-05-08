Demonstra��o da tecnologia FUSE ESB.

Este projeto � uma demonstra��o que apresenta exemplos de uso da tecnologia simulando casos de uso de um sistema distribu�do que 
possui uma camada web (Portal do Aluno), o FUSE ESB para integrar com o sistema legado da universidade.

Trabalho desenvolvido para a disciplina de Padr�es de projeto da p�s-gradua��o em Arquitetura de Software Distribu�do - PUC Minas
Desenvolvido por Douglas Patroc�nio, Eduardo Costa Ribeiro, Fabr�cio Cond�, Fernando Pac�fico e Marinete Andrade.

Aconselhamos usar a ferramenta de desenvolvimento FUSE IDE.


integrador
----------
Integrador criado para executar o papel de intermedi�rio entre o portal e o sistema Legado.
Foram criadas rotas que utilizam filas JMS para integrar os endpoints.

Voc� dever� executar o comando maven abaixo para instalar a aplica��o. A execu��o do comando baixar� as depend�ncias necess�rias 
para executar a aplica��o.

mvn install

Em seguida, usando a ferramenta FUSE IDE voc� pode iniciar o integrador clicando com o bot�o 
direito sobre o arquivo Integrador.xml e rodar como Local Camel Context

1o: bot�o direito sobre o arquivo Integrador.xml (integrador\src\main\resources\META-INF\spring\Integrador.xml)
2o: Clicar e "Run As" 
3o: Escolher a op��o "Local Camel Context"  


portalacademico
---------------
Aplica��o desenvolvida em Java SE com funcionalidades que acionam o integrador. � poss�vel realizar as opera��es s�ncronas (consultar 
hist�rico e consultar notas por disciplina) e tamb�m � poss�vel ver o funcionamento de uma opera��o ass�ncrona de trancamento de disciplina.
   
Voc� dever� executar o comando maven abaixo para instalar a aplica��o. A execu��o do comando baixar� as depend�ncias necess�rias para 
executar a aplica��o.

mvn install

Em seguida, pode-se iniciar o portalacademico clicando com o bot�o direito sobre o arquivo InvocadorPortalAluno e rodar como Java Application

1o: bot�o direito sobre o arquivo InvocadorPortalAluno.java (portalacademico\src\main\java\puc\pp\portalacademico\InvocadorPortalAluno.java)
2o: Clicar e "Run As" 
3o: Escolher a op��o "Java Application" 

----------------

Para mais ajuda, voc� pode consultar a documenta��o do FUSE ESB e do Apache Camel. Segue alguns sites que servir�o de ajuda.

	http://www.jboss.org/products/fuse
	http://fusesource.com/documentation/fuse-esb-documentation/
	http://camel.apache.org/
