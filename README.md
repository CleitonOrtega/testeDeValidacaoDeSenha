# Teste Itau Unibanco
<img src="https://1bilhao.com.br/wp-content/uploads/2020/08/ITUB4.jpg" alt="Itau Unibanco">
> Aplicativo desenvolvido para o teste do itau unibanco o foco do desafio era criar uma senha personalizada.

## :computador: Pré-requisitos
Antes de começar, verifique se você atendeu aos seguintes requisitos:
* Você instalou a versão mais recente do `<Xampp / Spring Tools / MySQL Workbench /GitHub>`

## 🚀 Instalando Teste Itau Unibanco
Para instalar o <Teste Itau Unibanco>, siga estas etapas:

1-Copie o link: https://github.com/CleitonOrtega/testeDeValidacaoDeSenha.git
2-Na sua maquina entre no Git e de o comando:
git clone https://github.com/CleitonOrtega/testeDeValidacaoDeSenha.git
2.1-Se preferir entre no link https://github.com/CleitonOrtega/testeDeValidacaoDeSenha.git Clique no botão verde Code e baixe o arquivo em ZIP
3-Entre no Spring Tools e faça os seguintes passos: File > import... > Maven > Existing Maven Projects > Next > Browse > (Selecione a pasta do arquivo) > Finish
4-Pronto aplicativo instalado

## :café: Usando Teste Itau Unibanco
Para usar <Teste Itau Unibanco>, siga estas etapas:

1-Abra o Xampp e de start no Apache e no MySQL
1.1-Com o aplicativo instalado e o Xampp ligado Clique com o botão direito do mouse na pasta do aplicativo e vai em Run As > Spring Boot App
2-Logo em seguida Abra a pasta no Spring e entre na pasta src/main/resources > static > index.html clique no index.html com o botão direito e clique no Open With > Web Browser
3-Com isso abrira uma pagina no Spring la você faz o cadastro do usuario e se a senha tiver os requisitos minimos ele vai para o banco caso contrario retornara mensagem de erro
4-Caso a senha tenha os requisitos minimos e entre no banco de dados abra o Workbench e clique no + do lado do MySQL Connections vai abrir uma pagina e no primeiro campo digite
"Itau Unibanco" Depois clique em OK
5-Entre no novo banco de dados criados e clique em continue anyway entrando no MySQL Digite ou copie os comandos(separados de preferencia um em cada linha):
USE db_testeitau;
SELECT * FROM tb_usuario;
6-Depois de digitar os comandos Clique no raio ao lado do botão de salvar e ira abrir uma tabela com os dados cadastrados

##Lógica do aplicativo
No desafio tinha que desenvolvedor uma API que só aceitasse uma senha que tinha pré requisitos que são:
Nove ou mais caracteres
Ao menos 1 dígito
Ao menos 1 letra minúscula
Ao menos 1 letra maiúscula
Ao menos 1 caractere especial
Considere como especial os seguintes caracteres: !@#$%^&*()-+
Não possuir caracteres repetidos dentro do conjunto
Para cada requisito eu voltei um valor boleano de verdadeiro ou falso e para cada resolução o conceito foi o mesmo que foi basicamente fazer um if para cada caso e fazer as comparações
necessarias por exemplo se tem uma letra maiuscula se caso tinha alguma letra maiúscula uma variavel recebia o valor verdadeiro onde no final eu fiz uma verificação para ver se os resultados eram os esperados
e para ver se iria guardar os dados no banco ou não e para fazer a verificação eu precisei transformar a senha que era uma string em uma array de caracteres ai eu consegui ver letra por letra e 
consegui fazer as verificações necessarias e para ver se alguma caracter se repetia eu fiz um laço for dentro de outro laço for onde eu comparava a array de vetor X com a array de vetor Y
e via se as arrays eram iguais se fossem retornaria um valor boleano onde seria verificado depois para ver se era o esperado

## Agradecimento
Obrigado por utilizar o aplicativo <Teste Itau Unibanco> caso tenha alguma duvida entrar em contato comigo atraves do email: c.ortega200935@gmail.com