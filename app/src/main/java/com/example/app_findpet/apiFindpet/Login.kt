package com.example.app_findpet.apiFindpet

class Login {

    var id: Int = 0
    var nome: String = ""
    var cpf: String = ""
    var cnpj: String = ""
    var tipoEstabelecimento: Int = 0
    var url_foto_perfil: String = ""
    var url_foto_banner: String = ""
    var email: String = ""
    var senha: String = ""
    var telefone: String = ""
    var celular: String = ""
    var logradouro: String = ""
    var cep: String = ""
    var numero: Int = 0
    var complemento: String = ""
    var token: String = ""

    override fun toString(): String {
        return "Login(id='$id', " +
                "nome='$nome', " +
                "cpf='$cpf', " +
                "url_foto_perfil='$url_foto_perfil', " +
                "url_foto_banner='$url_foto_banner', " +
                "tipoEstabelecimento='$tipoEstabelecimento', " +
                "cnpj='$cnpj', " +
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