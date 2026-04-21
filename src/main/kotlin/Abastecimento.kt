package Hotel

data class PostoCombustivel(
    val nome: String,
    val precoAlcool: Double,
    val precoGasolina: Double,
    val combustivelIdeal: String,
    val precoIdeal: Double,
    val custoTotal: Double
)

fun solicitarPreco(posto: String, combustivel: String): Double {
    var preco: Double?
    do {
        println("Informe o preço do $combustivel no $posto (R$): ")
        preco = readLine()?.toDoubleOrNull()
        if (preco == null || preco <= 0) {
            println("Preço inválido!")
        }
    } while (preco == null || preco <= 0)
    return preco!!
}

fun definirCombustivelIdeal(precoAlcool: Double, precoGasolina: Double): String {
    // Álcool é vantajoso se precoAlcool <= 70% do precoGasolina
    return if (precoAlcool <= 0.70 * precoGasolina) {
        "Álcool"
    } else {
        "Gasolina"
    }
}

fun calcularCusto(preco: Double, litros: Int): Double {
    return preco * litros
}

fun exibirResultadoPosto(posto: PostoCombustivel) {
    println("\n--- ${posto.nome} ---")
    println("Preço do Álcool  : R$ %.2f".format(posto.precoAlcool))
    println("Preço da Gasolina: R$ %.2f".format(posto.precoGasolina))
    println("Combustível ideal: ${posto.combustivelIdeal}")
    println("Custo para 42L   : R$ %.2f".format(posto.custoTotal))
}

fun exibirRanking(postos: List<PostoCombustivel>) {
    val ranking = postos.sortedBy { it.custoTotal }

    println("\n╔══════════════════════════════════════════╗")
    println(  "║         RANKING DE ABASTECIMENTO         ║")
    println(  "╠══════════════════════════════════════════╣")

    ranking.forEachIndexed { index, posto ->
        println("║ ${index + 1}º - ${posto.nome.padEnd(20)} R$ %.2f  ║".format(posto.custoTotal))
        println("║     Combustível: ${posto.combustivelIdeal.padEnd(24)}║")
        println("╠══════════════════════════════════════════╣")
    }

    val melhor = ranking.first()
    println(  "║ ✅ MELHOR OPÇÃO:                          ║")
    println(  "║ ${melhor.nome.padEnd(42)}║")
    println(  "║ ${melhor.combustivelIdeal.padEnd(15)} por R$ %.2f          ║".format(melhor.custoTotal))
    println(  "╚══════════════════════════════════════════╝")
}

fun principalAbastecimento() {
    val tanque = 42
    val nomesPostos = listOf("Wayne Oil", "Stark Petrol")
    val postos = mutableListOf<PostoCombustivel>()

    println("╔══════════════════════════════════════════╗")
    println("║         SISTEMA DE ABASTECIMENTO         ║")
    println("╚══════════════════════════════════════════╝")

    for (nome in nomesPostos) {
        println("\n=== $nome ===")
        val precoAlcool   = solicitarPreco(nome, "Álcool")
        val precoGasolina = solicitarPreco(nome, "Gasolina")

        val combustivelIdeal = definirCombustivelIdeal(precoAlcool, precoGasolina)

        val precoIdeal = if (combustivelIdeal == "Álcool") precoAlcool else precoGasolina

        val custoTotal = calcularCusto(precoIdeal, tanque)

        val posto = PostoCombustivel(
            nome             = nome,
            precoAlcool      = precoAlcool,
            precoGasolina    = precoGasolina,
            combustivelIdeal = combustivelIdeal,
            precoIdeal       = precoIdeal,
            custoTotal       = custoTotal
        )

        postos.add(posto)
        exibirResultadoPosto(posto)
    }

    exibirRanking(postos)
}