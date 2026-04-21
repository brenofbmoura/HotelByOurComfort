package Hotel
val listaDeReservas: MutableList<Reserva> = mutableListOf()
val quartos = BooleanArray (20) { false }

fun valorDiaria(): Double {
    var valor: Double?
    do {
        println ("Informe o valor da diária: ")
        valor = readLine()?.toDoubleOrNull()
        if (valor == null || (valor ?: 0.0)<= 0.0){
            println ("Valor inválido!!")
        }
    } while (valor == null || (valor ?: 0.0) <= 0.0)
    return valor!!
}
fun quantidadeDiarias(): Int {
    var quantidade: Int?
    do {
        println ("Informe a quantidade de diárias (1-30): ")
        quantidade = readLine()?.toIntOrNull()
        if (quantidade == null || quantidade <= 0 || quantidade > 30){
            println ("Número inválido!")
        }
    } while (quantidade == null || quantidade <= 0 || quantidade > 30)
    return quantidade!!
}
fun nomeHospede(): String {
    var nome: String?
    do {
        println ("Informe o nome completo do hóspede: ")
        nome = readLine()
        if (nome == null || nome.isBlank()){
            println ("Nome inválido!")
        }
    } while (nome == null || nome.isBlank())
    return nome!!
}
fun tipoQuarto(): Pair<String, Double> {
    var escolha: Pair<String, Double>?
    do {
        println ("Informe o tipo do quarto (S/E/L): ")
        var quarto = readLine()
        escolha = when (quarto?.uppercase()){
            "S" -> Pair("Standard", 1.00)
            "E" -> Pair("Executivo", 1.35)
            "L" -> Pair ("Luxo", 1.65)
            else -> {
                println ("Tipo inválido!")
                null
            }
        }
    } while (escolha == null)
    return escolha!!
}
fun opcaoQuarto(): Int {
    var quarto: Int?
    do {
        mapaQuartos()
        println ("Digite o número do seu quarto (1-20): ")
        quarto = readLine()?.toIntOrNull()
        if (quarto == null || quarto <= 0 || quarto > 20) {
            println ("Quarto inválido!")
        } else if (quartos[quarto - 1]) {
            println ("Quarto ocupado!")
            println ("Quartos dísponiveis: ")
            for (i in quartos.indices){
                if (!quartos[i]) print (" ${i + 1} ")
            }
            println()
        }
    } while (quarto == null || quarto <= 0 || quarto > 20 || quartos[quarto - 1])
    return quarto!!
}
fun resumo(
    nome: String,
    quarto: Int,
    nomeTipo: String,
    diaria: Double,
    diarias: Int,
    fator: Double
): Double {
    val subtotal = diaria * diarias * fator
    val taxa = subtotal * 0.10
    val total = subtotal + taxa
    println("========== RESUMO ==========")
    println("Hóspede: $nome")
    println("Quarto: $quarto ($nomeTipo)")
    println("Subtotal: R$ %.2f".format(subtotal))
    println("Taxa de serviço (10%%): R$ %.2f".format(taxa))
    println("Total: R$ %.2f".format(total))
    return total
}
fun confirmarReserva(quarto: Int,
                     nome: String,
                     tipo: String,
                     diarias: Int,
                     total: Double ){
   var resposta: String?
   do {
       println ("Deseja confirmar a reserva ? (S/N): ")
       resposta = readLine()?.uppercase()
       when (resposta){
           "S" -> {
               quartos[quarto - 1] = true
               val reserva = Reserva(nome, quarto, tipo, diarias, total)
               listaDeReservas.add(reserva)
               mapaQuartos()
               println ("Quarto reservado com sucesso!")
               println ("Reserva salva: $reserva")
           }
           "N" -> {
               println ("Reserva cancelada!")
               escolhas()
           }
       else -> {
           println ("Opção inválida!")
       }
       }
   } while (resposta != "S" && resposta != "N")
}
fun mapaQuartos() {
    println ("========== MAPA DE QUARTOS ==========")
    for (i in quartos.indices){
        if (quartos[i]) print(" O ") else print(" L ")
        if ((i + 1)% 5 == 0) println()
    }
}
fun reservaQuartos(){
    println("========== RESERVAS ==========")
    val diaria = valorDiaria()
    val diarias = quantidadeDiarias()
    val nomeHospede = nomeHospede()
    val (nomeTipo, fator) = tipoQuarto()
    val numeroQuarto = opcaoQuarto()
    val total = resumo(nomeHospede, numeroQuarto, nomeTipo, diaria, diarias, fator)
    confirmarReserva(numeroQuarto, nomeHospede, nomeTipo, diarias, total)
}