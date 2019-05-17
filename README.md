# PAYMENTSLIP
Sistema de Boletos para a empresa ebaotech

# RESUMO
O PaymentSlip foi criado para um teste para a empresa eBaoTech seguindo os requisitos descritos no link https://gitlab.com/ebaoInterview/boleto

O sistema é muito simples, assim procurei demonstrar algumas técnicas de programação que costumo utilizar adequadas a sua estruturas. 

Conforme solicitado, o sistema pouquissimos frameworks, basicamente Maven e JUnit. Além disso utiliza o banco de dados MySQL.

Dentro da pasta resources do projeto existem dois arquivos: 
1) script de criação do banco de dados.
2) a captura do resultado gerado.

# AMBIENTE DESENVOLVIMENTO
* Java SE 1.8
* MySql 14.14
* Eclipse Photon
* Maven
* JUnit
* Ubuntu 18.04 LTS

# CONFIGURAÇÃO INICIAL
* Executar o script de criação e carga inicial no MySQL
* Configurar a classe ConnectionMySQL com as informações do Banco
* Atualizar o projeto com os comandos "Maven Update" e "Maven Install"

# UTILIZAÇÃO
* Executar a aplicação
* Fornecer uma data de criação de um boleto cancelado no formato "DD/MM/AAAA" (ex: 12/02/2019)
* Fornecer um ID de um boleto que possui ajustes (ex: 5 ou 6)
