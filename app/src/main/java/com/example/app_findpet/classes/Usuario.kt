package com.example.app_findpet.classes

class Usuario {
    var id: Int = 0
    var nome: String = ""
    var email: String = ""
    var senha: String = ""
    var cpf: String = ""
    var telefone: String = ""
    var celular: String = ""
    var logradouro: String = ""
    var numero: Int = 0
    var complemento: String = ""
    var cep: String = ""
    var tipo_usuario: String = ""
    var token: String = ""

    override fun toString(): String {
        return "Usuario(id='$id', " +
                "nome='$nome', " +
                "cpf='$cpf', " +
                "email='$email', " +
                "senha='$senha', " +
                "telefone='$telefone', " +
                "celular='$celular', " +
                "logradouro='$logradouro', " +
                "cep='$cep', " +
                "numero='$numero', " +
                "complemento='$complemento'," +
                "token='$token')"
    }
}