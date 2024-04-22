function analise() {
    var login = input_login.value;
    var senha = input_senha.value;
    var codigo = Number(input_cod.value);

    if (login == 'SPTech' && senha == 'digital' && codigo == 123) {
        alert('Usuário autenticado com sucesso')
    }
    else{
        alert('Falha na autenticação')
    }
}