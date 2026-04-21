package Hotel


import kotlin.system.exitProcess
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

val listaHospedes: MutableList<Hospede> = mutableListOf()

fun cadastrarHospedes() {
    listaHospedes.forEachIndexed { index, listaHospedes ->
        println("${index+1}. ${listaHospedes}")
    }

    while (true) {
        println("========== CADASTRO DE HÓSPEDES ==========")

        println("1-Cadastrar")
        println("2-Pesquisar por nome exato")
        println("3-Pesquisar por prefixo")
        println("4-Lista ordenada (A-Z)")
        println("5-Atualizar cadastro")
        println("6-Remover cadastro")
        println("7-Voltar")

        val escolha = readln().toIntOrNull()

        when (escolha) {
            1 -> cadastrarHospede(listaHospedes)
            2 -> pesquisarHospede(listaHospedes)
            3 -> pesquisarLetraHospedes(listaHospedes)
            4 -> listaHospedes(listaHospedes)
            5 -> atualizarPagina(listaHospedes)
            6 -> removerHospede(listaHospedes)
            7 -> escolhas()
            else -> erroCadastroDeHospedes()
        }
    }
}
fun atualizarPagina(listaHospedes: MutableList<Hospede>) {
    println ("Página atualizada com sucesso!")
    listaHospedes.forEachIndexed { index, hospede ->
        println ("${index + 1}. ${hospede.nome} - ${hospede.dataCadastro}")
    }
}

fun cadastrarHospede(listaHospedes: MutableList<Hospede>) {
    println("Cadastro de Hóspedes.\nPor favor, informe o nome da Hóspede:")
    val nome = readLine()!!
    val data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
    listaHospedes.add(Hospede(nome, data))

    println("Hóspede cadastrado com sucesso!")
    println("Nome: $nome")
    println("Data: $data")
    println("Lista de hóspedes atuais: " + listaHospedes)

}
fun pesquisarHospede(listaHospedes: MutableList<Hospede>) {
    println("Pesquisa de Hóspedes.\nPor favor, informe o nome do Hóspede:")
    var nome = readln()!!

    if (listaHospedes.any { it.nome.contains(nome, ignoreCase = true) }) {
        println("\nEncontramos a(s) hóspede(s):")
        listaHospedes.filter { it.nome.contains(nome, ignoreCase = true) }
            .forEach { println(it) }
    } else {
        println("Não encontramos nenhuma hóspede com esse nome.")
    }
}
fun pesquisarLetraHospedes(listaHospedes: MutableList<Hospede>) {
    println ("Pesquisar Hóspedes pela primeira letra.\nPor favor, informe a primeira letra do nome do Hóspede: ")
    val nomeHospede = readln()

    if (listaHospedes.any { it.nome.contains(nomeHospede, ignoreCase = true) }) {
        println ("Hóspede(s) encontrado(s):")
        listaHospedes.filter { it.nome.startsWith(nomeHospede, ignoreCase = true) }
        .forEach { println(it) }
    } else {
        println ("Hóspede(s) não encontrado(s).")
    }
}
fun listaHospedes(listaHospedes: MutableList<Hospede>) {
    listaHospedes.sortedBy{it.nome}.forEachIndexed { index, hospede ->
        println("${index+1}. ${hospede.nome} - ${hospede.dataCadastro}")
    }
}

fun removerHospede (listaHospedes: MutableList<Hospede>) {
    println("Informe o números do hóspede que deseja remover: ")
    val indice = readLine()?.toIntOrNull()
    if (indice != null && indice > 0 && indice <= listaHospedes.size) {
        listaHospedes.removeAt(indice - 1)
        println("Hóspede removido!")
    } else {
        println("Hóspede não encontrado.")
    }
}

fun sairCadastroDeHospedes() {
    println("Você deseja voltar? S/N")
    val escolha = readln()

    when (escolha.uppercase()) {
        // uppercase fará o que for digitado ser convertido para maiúsculo por exemplpo x -> X
        "S" -> {
            println("Ok.")
            escolhas()
        }
        "N" -> {
            println("Ok, voltando ao início.")
            cadastrarHospedes()
        }
        else -> {
            println("Desculpe, mas não compreendi.")
            sairCadastroDeHospedes()
        }
    }
}

fun erroCadastroDeHospedes() {
    println("Por favor, informe um número entre 1 e 3.")
}