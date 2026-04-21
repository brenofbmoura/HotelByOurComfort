package Hotel

import kotlin.math.ceil
import kotlin.math.floor

val listaDeEventos: MutableList<Evento> = mutableListOf()

fun selecionarConvidados(): Int {
    var convidados: Int?
    do {
        println("Informe o número de convidados: ")
        convidados = readLine()?.toIntOrNull()
        if (convidados == null || convidados <= 0 || convidados > 350) {
            println ("Número de convidados inválido!")
        }
    } while (convidados == null || convidados <= 0 || convidados > 350)

    return convidados!!
}
fun selecionarAuditorio(convidados: Int): String {
    return if (convidados <= 220) {
        "Laranja"
    } else {
        "Colorado"
    }
}
fun cadeirasExtras(convidados: Int): Int{
    return if (convidados > 150 ){
        convidados - 150
    } else {
        0
    }
}
fun escolherDia(): String{
    var dia: String?
    do {
        println ("Informe o dia que acontecerá o evento: ")
        var diasValidos = listOf<String>("Segunda", "Terça", "Quarta",
                                         "Quinta", "Sexta", "Sábado")
        dia = readLine()
        if (dia == null|| dia !in diasValidos) {
            println ("Dia inválido!")
        }
    } while (dia == null|| dia !in diasValidos)
    return dia!!
}
fun escolherHora(): Int{
    var horaInicio: Int?
    do {
        println ("Informe a hora: ")
        horaInicio = readLine()?.toIntOrNull()
        if (horaInicio == null || horaInicio < 8 || horaInicio > 22) {
            println ("Hórario inválido")
        }
    } while (horaInicio == null || horaInicio < 8 || horaInicio > 22)
    return horaInicio!!
}
fun selecionarDuracao(): Int{
    var duracao: Int?
    do {
        println ("Informe a duração do evento: ")
        duracao = readLine()?.toIntOrNull()
        if (duracao == null|| duracao < 1 || duracao > 6) {
            println ("Número inválido")
        }
    } while (duracao == null|| duracao < 1 || duracao > 6)
    return duracao!!
}
fun calcularGarcons(convidados: Int, duracao: Int): Int{
    var base = ceil(convidados.toDouble() / 12.0).toInt()
    var reforco = floor(duracao.toDouble() / 2).toInt()
    return base + reforco
}
fun calcularCustoGarcons(garcons: Int,duracao: Int): Double{
    return garcons * duracao * 10.50
}
fun calcularBuffet(convidados: Int): Double{
    val totalCafe = (convidados * 0.2) * 0.80
    val totalAgua = (convidados * 0.5) * 0.40
    val totalSalgados = ((convidados * 7.0) / 100) * 34.00
    return totalCafe + totalAgua + totalSalgados
}
fun principalEventos(){
    val convidados = selecionarConvidados()
    val auditorio = selecionarAuditorio(convidados)
    val cadeiras = cadeirasExtras(convidados)
    val dia = escolherDia()
    val hora = escolherHora()
    val duracao = selecionarDuracao()
    print ("Informe o nome da empresa: ")
    val empresa = readln() ?: ""
    val garcons = calcularGarcons(convidados, duracao)
    val custoGarcons = calcularCustoGarcons(garcons, duracao)
    val buffet = calcularBuffet(convidados)
    val total = custoGarcons + buffet
    exibirRelatorio(auditorio,
        convidados,
        cadeiras,
        dia,
        hora,
        duracao,
        empresa,
        garcons,
        custoGarcons,
        buffet,
        total)
}
fun exibirRelatorio (
    auditorio: String,
    convidados: Int,
    cadeiras: Int,
    dia: String,
    hora: Int,
    duracao: Int,
    empresa: String,
    garcons: Int,
    custoGarcons: Double,
    buffet: Double,
    total: Double
){
    println ("========== RESUMO ==========")

    println ("\nConvidados: $convidados")
    println ("Auditorio selecionado: $auditorio")
    println ("Número de cadeiras: $cadeiras")
    println ("\nDia do evento: $dia")
    println ("Hora do evento: $hora")
    println ("Duração do evento: $duracao")
    println ("Empresa responsável: $empresa")
    println ("\nGarcons: $garcons")
    println ("CustoGarcons: R$ %.2f".format(custoGarcons))
    println ("\nBuffet: R$ %.2f".format(buffet))
    println ("\nTotal do evento: R$ %.2f".format(total))
    println ("\n Deseja confirmar a reserva? (S/N)")
    var resposta = readLine()!!.uppercase()
    when (resposta){
        "S" -> {
            val evento = Evento(
                convidados = convidados,
                duracao = duracao,
                empresa = empresa,
                garcons = garcons,
                auditorio = auditorio,
                dia = dia,
                horaInicio = hora,
                custoGarcon = custoGarcons,
                custoBuffet = buffet,
                totalGeral = total
            )
            listaDeEventos.add(evento)
            println ("Reserva efetuada com sucesso!")
        }
        "N" -> {
            println("Reserva cancelada!")
        } else -> println("Opção inválida")
    }
}