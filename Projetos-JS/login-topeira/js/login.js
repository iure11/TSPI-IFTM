function validar() {
    user = document.getElementById("user");
    pwd = document.getElementById("pwd");

    if (!user.value) {
        alertWifi("Usuário em branco", false, 0, "../img/toupeira.gif", 100);
        user.focus();
    }
    else if (!pwd.value) {
        alertWifi("Senha em branco", false, 0, "../img/toupeira.gif", 100);
        pw.focus()
    }
    else {
        readJSON(user.value, pwd.value);
    }

}

function readJSON(usuario, senha) {
    file = ('../json/users.json')
    fetch(file)
        .then(response => response.json())
        .then(content => checkUser(content, usuario, senha))
        .catch(err => console.log("erro na leitura do JSON"));
}
function checkUser(content, usuario, senha) {
    var achou = false;
    for (i = 0; i < content.usuarios.length; i++) {
        if ((content.usuarios[i].user == usuario) && (content.usuarios[i].pwd == senha)) {
            achou = true;
            break;
        }
    }
    if (achou)
        alertWifi("Usuário Valido!", false, 0, "../img/9.gif", 80);
    else
        alertWifi("Usuário inválido!", false, 0, "../img/toupeira.gif", 30);
}