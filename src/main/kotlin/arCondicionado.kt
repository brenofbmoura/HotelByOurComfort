package Hotel

val listaEmpresas: MutableList<OrcamentoAR> = mutableListOf()

fun solicitarEmpresa(): String{
    var nome: String?
    do{
        println("Informe o nome da empresa: ")
        nome = readLine()
        if (nome.isNullOrBlank()){
            println("Nome inválido")
        }
    } while (nome.isNullOrBlank())
    return nome!!
}
fun solicitarValor(): Double{
    var valor: Double?
    do {
        println ("Digite o valor do aparelho (R$): ")
        valor = readLine()?.toDoubleOrNull()
        if (valor == null || valor <= 0){
            println ("Valor inválido!")
        }
    } while (valor == null || valor <= 0)
    return valor!!
}
fun solicitarQuantidade(): Int{
    var quantidade: Int?
    do{
        println ("Informe a quantidade de aparelhos: ")
        quantidade = readLine()?.toIntOrNull()
        if (quantidade == null || quantidade <= 0){
            println ("Quantidade inválida!")
        }
    } while (quantidade == null || quantidade <= 0)
    return quantidade!!
}
fun solicitarDesconto(): Double{
    var desconto: Double?
    do{
        println ("Informe o porcentual de desconto (0 se não houver): ")
        desconto = readLine()?.toDoubleOrNull()
        if (desconto == null || desconto < 0 ||desconto > 100){
            println ("Porcentual inválido! (0 a 100)")
        }
    } while (desconto == null || desconto < 0 ||desconto > 100)
    return desconto!!
}
fun solicitarMinimoDesconto(): Int{
    var minimoDesconto: Int?
    do{
        println ("Informe a quantidade mínima de aparelhos para desconto: ")
        minimoDesconto = readLine()?.toIntOrNull()
        if (minimoDesconto == null || minimoDesconto <= 0){
            println ("Quantidade inválida!")
        }
    } while (minimoDesconto == null || minimoDesconto <= 0)
    return minimoDesconto!!
}
fun solicitarDeslocamento(): Double{
    var deslocamento: Double?
    do{
        println ("Informe o valor fixo de deslocamento (R$): ")
        deslocamento = readLine()?.toDoubleOrNull()
        if (deslocamento == null || deslocamento < 0){
            println ("Valor inválido!")
        }
    } while (deslocamento == null || deslocamento < 0)
    return deslocamento!!
}
fun calcularTotal(
    valorAparelho: Double,
    quantidade: Int,
    desconto: Double,
    minimoDesconto: Int,
    deslocamento: Double
): Double{
    val bruto = valorAparelho * quantidade
    val valorDesconto = if (quantidade >= minimoDesconto){
        bruto * (desconto / 100)
    } else {
        0.0
    }
    return bruto - valorDesconto + deslocamento
}
fun exibirCalculo(
    valorAparelho: Double,
    quantidade: Int,
    desconto: Double,
    minimoDesconto: Int,
    deslocamento: Double,
    nome: String){
    println ("O serviço de $nome custará R$ %.2f".format(calcularTotal(valorAparelho,
        quantidade,
        desconto,
        minimoDesconto,
        deslocamento)))
}
fun exibirResumoFinal(orcamento: MutableList<OrcamentoAR>){
    val menor = orcamento.minByOrNull { it.totalFinal }!!
    val maior = orcamento.maxByOrNull { it.totalFinal }!!
    val difPerc = ((maior.totalFinal - menor.totalFinal) / menor.totalFinal) * 100

    println ("O orçamento de menor valor é ${menor.empresa} por R$ %.2f".format(menor.totalFinal))
    println ("O orçamento de maior valor é ${maior.empresa} por R$ %.2f".format(maior.totalFinal))
    println ("Diferença porcentual: %.1f%%".format(difPerc))
}
fun principalAR(){
    var continuar = true

    while (continuar) {
        val nome = solicitarEmpresa()
        val valor = solicitarValor()
        val quantidade = solicitarQuantidade()
        val desconto = solicitarDesconto()
        val minimo = solicitarMinimoDesconto()
        val deslocamento = solicitarDeslocamento()
        val total = calcularTotal(valor,
            quantidade,
            desconto,
            minimo,
            deslocamento)

        val orcamento = OrcamentoAR(
            empresa        = nome,
            valorAparelho  = valor,
            quantidade     = quantidade,
            desconto       = desconto,
            minimoDesconto = minimo,
            deslocamento   = deslocamento,
            totalFinal     = total
        )
        listaEmpresas.add(orcamento)
        exibirCalculo(valor,
            quantidade,
            desconto,
            minimo,
            deslocamento,
            nome)

        var resposta: String?
        do{
            println ("Deseja informar novos dados? (S/N)")
            resposta = readLine()?.uppercase()
            if (resposta != "S" && resposta != "N") {
                println("Opção inválida!")
            }
        } while (resposta != "S" && resposta != "N")

        continuar = resposta == "S"
    }
    exibirResumoFinal(listaEmpresas)
}