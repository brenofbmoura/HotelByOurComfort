package Hotel

data class Hospede(
    val nome: String,
    val dataCadastro: String
    )

data class Reserva (
    val nomeHospede: String,
    val numeroQuarto: Int,
    val tipoQuarto: String,
    val quantidadeDiarias: Int,
    val totalPago: Double
)

data class Evento(
    val empresa: String,
    val auditorio: String,
    val dia: String,
    val horaInicio: Int,
    val duracao: Int,
    val convidados: Int,
    val garcons: Int,
    val custoGarcon: Double,
    val custoBuffet: Double,
    val totalGeral: Double
)
data class OrcamentoAR(
    val empresa: String,
    val valorAparelho: Double,
    val quantidade: Int,
    val desconto: Double,
    val minimoDesconto: Int,
    val deslocamento: Double,
    val totalFinal: Double
)