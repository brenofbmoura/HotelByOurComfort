package Hotel

import kotlin.system.exitProcess
val nomeHotel = "ByOurComfort"
var nomeUsuario: String = ""
val senha = 2678
var tentativas = 0

fun lerSenha() {
    var senhaDigitada: Int?
    do {
        println("Digite sua senha: ")
        senhaDigitada = readLine()?.toIntOrNull()
        if (senhaDigitada != senha) {
            tentativas++
            println("Senha incorreta!")
            if (tentativas >= 3) {
                println("Limite excedido!")
                exitProcess(0)
            }
        }
    } while (senhaDigitada != senha)
    println("Bem-vindo ao Hotel $nomeHotel, $nomeUsuario. É um imenso prazer ter você por aqui!")
}

fun main() {
    inicio()
}

fun inicio() {
    print("Bem vindo ao Hotel $nomeHotel \n")
    println("Olá! Digite seu nome: ")
    nomeUsuario = readLine()!!
    lerSenha()
    escolhas()
}

fun escolhas() {
    var opcao: Int?
    do {
        println("========== OPÇÕES ==========")

        println("1-Cadastrar Quartos")
        println("2-Cadastrar Hospedes")
        println("3-Eventos")
        println("4-Ar-Condicionado")
        println("5-Abastecimento")
        println("6-Relatórios Operacionais")
        println("7-Sair do Hotel")
        opcao = readLine()?.toIntOrNull()
        when (opcao) {
            1 -> reservaQuartos()
            2 -> cadastrarHospedes()
            3 -> principalEventos()
            4 -> principalAR()
            5 -> principalAbastecimento()
            6 -> relatoriosOperacionais()
            7 -> sairDoHotel()
            else -> {
                println ("Opção inválida!")
                null
            }
        }
    } while (opcao != 7)
}

fun erro() {
    println("Por favor, informe um número entre 1 e 4.")
}

fun sairDoHotel() {
    println("Você deseja sair? (SIM/S para confirmar)")
    val confirma = readln().uppercase()
    if (confirma == "SIM" || confirma == "S") {
        println("Muito obrigado e até logo, $nomeUsuario.")
        exitProcess(0)
    }
}