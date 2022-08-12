# T1_DSW1

Nesse projeto estamos implementando a aplicação web do documento de requisitos B, Sistema para compra/venda de pacotes turísticos, proposto pelo professor Dr. Alan Demétrius Baria Valejo na disciplina Desenvolvimento de Software para Web 1 no primeiro semestre de 2022.

## Participantes

- André Souza Santos - RA: 769809
- Gabriel Penajo Machado - RA: 769712
- Isabela Vieira Magalhães - RA: 769755
- João Victor Bueno de Caldas - RA: 769657 
- Matheus Teixeira Mattioli - RA: 769783

## Execução do Código

É necessário estar com o servidor tomcat no ar para isso, deve encontrar sua pasta do apache-tomcat/bin e executar ./catalina.sh run

Dentro da pasta raíz do trabalho executar.
Para rodar o banco de dados:

- mysql -uroot -p
- senha: 123456
- source db/MySQL/create.sql
- exit 

Para rodar o programa:

- mvn tomcat7:redeploy

## Requisitos
1. CRUD (Create, Read, Update e Delete) de clientes (requer login de administrador). O sistema deve possuir um cadastro de clientes, com os seguintes dados: e-mail, senha, CPF, nome, telefone, sexo e data de nascimento ✅
2. CRUD de agências de turismo (requer login de administrador). O sistema deve possuir um cadastro das agências com os seguintes dados: e-mail, senha, CNPJ, nome e descrição. ✅
3. Cadastro de pacotes turísticos para venda (requer login da agência via e-mail e senha). Depois de fazer login, a agência de turismo pode cadastrar um pacote turístico para venda. O cadastro de pacotes turísticos deve possuir os seguintes dados: CNPJ da agência de turismo, destinos (cidade/estado/país), data de partida, duração em dias, valor, fotos (no máximo 10 imagens) dos locais turísticos a serem visitados e descrição. (Parcialmente feito, falta upload de imagens)
4. Listagem de todos os pacotes turísticos em uma única página (não requer login). O sistema deve prover a funcionalidade de filtrar os pacotes turísticos por destino, por agência de turismo ou por data de partida. ✅
5. Compra de pacote turístico (requer login do cliente via e-mail e senha). Ao clicar em um pacote turístico (requisito 4), o cliente pode efetuar a compra do pacote. A compra será efetuada mediante uma proposta de compra inserindo um valor. ✅
6. Listagem de todos os pacotes turísticos de um cliente (requer login do cliente via e-mail e senha). Depois de fazer login, o cliente pode visualizar todos os seus pacotes turísticos adquiridos ✅
7. Listagem de todos os pacotes turísticos de uma agência de turismo (requer login da agência via e-mail e senha). Depois de fazer login, a agência pode visualizar todos os seus pacotes turísticos cadastrados. O sistema apenas deve prover a funcionalidade de filtrar apenas os pacotes “vigentes” -- com a data de partida posterior a data atual do sistema. ✅
8. O cliente poderá cancelar seu pacote turístico. A lista de pacotes turísticos do clientes deverá ser atualizada e os pacotes cancelados deverão aparecer nessa lista. Pacotes turísticos só poderão ser cancelados com no mínimo 5 dias de antecedência. Para fazer os testes, o grupo poderá rodar scripts para alterar o banco de dados na hora da apresentação ou deixar compras previamente cadastradas. ✅
9. O sistema deve tratar todos os erros possíveis (cadastros duplicados, problema técnicos etc.) mostrando uma página de erros amigável ao usuário e registrando o erro no console. ✅
