package Hotel

fun relatoriosOperacionais() {
    println("========== RELATÓRIOS OPERACIONAIS ==========")
    val opcoes = listOf(
        "Total de reservas de quartos confirmadas",
        "Taxa de ocupação atual",
        "Quantidade de hóspedes cadastrados",
        "Quantidade de eventos confirmados",
        "Receita acumulada"
    )
    opcoes.forEachIndexed { index, opcao ->
        println("${index + 1}. $opcao")
    }

    val resposta = readLine()?.toIntOrNull()
    when (resposta) {
        1 -> relatorioReservas()
        2 -> relatorioOcupacao()
        3 -> relatorioHospedes()
        4 -> relatorioEventos()
        5 -> relatorioReceita()
        else -> println("Opção inválida!")
    }
}

fun relatorioReservas() {
    println("\n╔══════════════════════════════════════════╗")
    println(  "║           RESERVAS CONFIRMADAS           ║")
    println(  "╠══════════════════════════════════════════╣")
    println(  "║ Total de reservas : %-20d║".format(listaDeReservas.size))
    println(  "╚══════════════════════════════════════════╝")
}

fun relatorioOcupacao() {
    val ocupados = quartos.count { it }
    val taxa = (ocupados.toDouble() / 20.0) * 100
    println("\n╔══════════════════════════════════════════╗")
    println(  "║             TAXA DE OCUPAÇÃO             ║")
    println(  "╠══════════════════════════════════════════╣")
    println(  "║ Quartos ocupados  : %-2d de 20           ║".format(ocupados))
    println(  "║ Taxa de ocupação  : %-6.1f%%             ║".format(taxa))
    println(  "╚══════════════════════════════════════════╝")
}

fun relatorioHospedes() {
    println("\n╔══════════════════════════════════════════╗")
    println(  "║           HÓSPEDES CADASTRADOS           ║")
    println(  "╠══════════════════════════════════════════╣")
    println(  "║ Total de hóspedes : %-20d║".format(listaHospedes.size))
    println(  "╚══════════════════════════════════════════╝")
}

fun relatorioEventos() {
    println("\n╔══════════════════════════════════════════╗")
    println(  "║           EVENTOS CONFIRMADOS            ║")
    println(  "╠══════════════════════════════════════════╣")
    println(  "║ Total de eventos  : %-20d║" .format(listaDeEventos.size))
    println(  "╚══════════════════════════════════════════╝")
}

fun relatorioReceita() {
    val receitaHosp    = listaDeReservas.sumOf { it.totalPago }
    val receitaEventos = listaDeEventos.sumOf { it.totalGeral }
    val receitaTotal   = receitaHosp + receitaEventos
    println("\n╔══════════════════════════════════════════╗")
    println(  "║             RECEITA ACUMULADA            ║")
    println(  "╠══════════════════════════════════════════╣")
    println(  "║ Hospedagem  : R$ %-24.2f║".format(receitaHosp))
    println(  "║ Eventos     : R$ %-24.2f║".format(receitaEventos))
    println(  "╠══════════════════════════════════════════╣")
    println(  "║ Total Geral : R$ %-24.2f║".format(receitaTotal))
    println(  "╚══════════════════════════════════════════╝")
}