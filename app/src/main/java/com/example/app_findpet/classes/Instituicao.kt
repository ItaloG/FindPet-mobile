package com.example.app_findpet.classes

class Instituicao {
    var id: Int = 0
    var nome: String = ""
    var tipoEstabelecimento: Int = 0
    var cnpj: String = ""
    var email: String = ""
    var senha: String = ""
    var telefone: String = ""
    var celular: String = ""
    var logradouro: String = ""
    var cep: String = ""
    var url_foto_perfil: String = ""
    var url_foto_banner: String = ""
    var numero: Int = 0
    var complemento: String = ""
    var descricao: String = ""
    var token: String = ""


    override fun toString(): String {
        return "Instituicao(id='$id', " +
                "nome='$nome', " +
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
                "descricao='$descricao', " +
                "token='$token')"
    }
}
