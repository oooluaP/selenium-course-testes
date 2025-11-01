Fui desafiado pelo professor Matheus Cruz a desenvolver testes para esta aplicação que cumprisse os requisítos abaixo.

(Finalizado, todos os testes desenvolvidos)

# Requisitos

Aqui vivem todos os requisitos da aplicação Developers. A aplicação deve atender e seguir todos os requisitos definidos abaixo.

## REQ001

Ao entrar na aplicação o título `<title>` deve ser `Developers - Selenium Labs`.

## REQ002

Ao entrar na página de login da aplicação `/login`, o usuário deve visualizar um link para cadastro contendo o texto `Register here`.

## REQ003

Ao entrar na página de login da aplicação `/login`, quando o usuário clicar no link `Register here` ele deve ser redirecionado para a página de cadastro.

## REQ004 (Deve cadastrar um usuário com sucesso)

Ao entrar na página de cadastro o usuário pode preencher o formulário de cadastro, quando o usuário preencher todos os campos corretamente (Ver [REQ005](#req005-deve-validar-o-formulário-de-cadastro)), deve aparecer uma mensagem na tela com o texto `Registered with success!` e um link para voltar para a página de login com o texto `Back to login`.

## REQ005 (Deve validar o formulário de cadastro)

Ao entrar na página de cadastro o usuário pode preencher o formulário de cadastro, o formulário de cadastro do usuário contém algumas regras:

1. O campo `First name` deve ter no mínimo 2 caracteres.
2. O campo `Last name` deve ter no mínimo 2 caracteres.
3. O campo `Email` deve ser um endereço de e-mail válido.
4. O campo `Username` deve ter no mínimo 2 caracteres.
5. O campo `Password` deve ter no mínimo 8 caracteres e não pode ficar em branco.
6. Ao submeter o formulário de cadastro com dados inválidos, o usuário deve visualizar mensagens de erro correspondentes a cada campo inválido.

## REQ006 (Cadastro de um usuário que já existe)

Ao cadastrar um usuário no sistema que já existe, não deve redirecionar para a página de cadastrado com sucesso, deve aparecer uma mensagem `That username is taken. Try another.`.

### REQ007 (Login)

Ao realizar login com credenciais erradas, deve aparecer uma mensagem de erro na tela e não deve permitir o usuário acessar a aplicação.

