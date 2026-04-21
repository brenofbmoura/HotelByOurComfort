<h1 align="center">🏨 ByOurComfort Hotel System</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white"/>
  <img src="https://img.shields.io/badge/Status-Concluído-success?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Versão-1.0.0-blue?style=for-the-badge"/>
</p>

<!-- GIF do sistema -->
<p align="center">
  <img src="https://github.com/user-attachments/assets/4e1a72ba-7abb-4ddb-a520-eed809ab2b8a" 
       alt="Demo do Sistema" 
       width="600"/>
</p>

<p align="center">
  Sistema desenvolvido em Kotlin com múltiplos módulos integrados para gerenciamento completo de um hotel.
</p>

---

## 📋 Índice

- [Sobre o Projeto](#-sobre-o-projeto)
- [Funcionalidades](#-funcionalidades)
- [Tecnologias](#-tecnologias)
- [Como Executar](#-como-executar)
- [Módulos](#-módulos)
- [Aprendizados](#-aprendizados)
- [Autor](#-autor)

---

## 🏨 Sobre o Projeto

O **ByOurComfort Hotel System** é um sistema de 
gestão hoteleira desenvolvido inteiramente em **Kotlin**,
com foco em boas práticas de programação e organização
modular de código.

O sistema permite gerenciar hóspedes, reservas, eventos,
orçamentos de ar-condicionado e abastecimento de veículos,
tudo integrado em um menu principal intuitivo.

---

## ⚙️ Funcionalidades

| Módulo | Descrição |
|--------|-----------|
| 🔐 Login | Autenticação com controle de tentativas |
| 🛏️ Quartos | Cadastro e gestão de reservas |
| 👥 Hóspedes | Cadastro completo de hóspedes |
| 🎉 Eventos | Controle e gestão de eventos |
| ❄️ Ar-Condicionado | Orçamento entre empresas |
| 🚗 Abastecimento | Comparativo de postos e combustíveis |
| 📊 Relatórios | Relatórios operacionais completos |
| 🚪 Saída | Logout seguro com confirmação |

---

## 🚀 Tecnologias

- [Kotlin](https://kotlinlang.org/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)

---

## 💻 Como Executar

### Pré-requisitos:
- [JDK 11+](https://www.oracle.com/java/technologies/downloads/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)

### Passos:

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/byourcomfort-hotel-system.git

# Abra no IntelliJ IDEA
File > Open > selecione a pasta do projeto

# Execute o arquivo principal
src/Hotel/Main.kt
```

---

## 📦 Módulos

### 🔐 Login
```kotlin
- Autenticação por senha numérica
- Limite de 3 tentativas
- Bloqueio automático por segurança
```

### 🛏️ Quartos e Reservas
```kotlin
- Cadastro de quartos
- Gestão de reservas
- Controle de disponibilidade
```

### 👥 Hóspedes
```kotlin
- Cadastro completo de hóspedes
- Listagem e consulta
```

### 🎉 Eventos
```kotlin
- Cadastro de eventos
- Controle de capacidade
- Cálculo de custos
```

### ❄️ Ar-Condicionado
```kotlin
- Comparativo entre empresas
- Cálculo de descontos por quantidade
- Inclusão de custos de deslocamento
- Ranking de orçamentos
```

### 🚗 Abastecimento
```kotlin
- Comparativo entre postos (Wayne Oil e Stark Petrol)
- Cálculo do combustível ideal (Álcool x Gasolina)
- Regra dos 70% para escolha do combustível
- Tanque fixo de 42 litros
- Ranking de menor para maior custo
```

### 📊 Relatórios
```kotlin
- Relatórios operacionais completos
- Visão geral do hotel
```

---

## 📚 Aprendizados

Durante o desenvolvimento deste projeto, pude
praticar e consolidar os seguintes conceitos:

```kotlin
✅ Data Classes para modelagem de dados
✅ Funções com retorno de valores
✅ Loops do/while para validação de entradas
✅ Tratamento e validação de inputs do usuário
✅ MutableList e coleções
✅ Funções de coleções (minByOrNull, maxByOrNull)
✅ Formatação de strings (%.2f)
✅ Organização de código em módulos
✅ Integração de múltiplos módulos
✅ Boas práticas de programação
```

---

## 🗂️ Estrutura do Projeto
byourcomfort-hotel-system/ │ ├── src/ │ └── Hotel/ │ ├── Main.kt │ ├── Login.kt │ ├── Hospedes.kt │ ├── Reservas.kt │ ├── Eventos.kt │ ├── ArCondicionado.kt │ ├── Abastecimento.kt │ └── Relatorios.kt │ ├── README.md └── .gitignore

---

## 👨‍💻 Autor

<p align="center">
  Feito com ❤️ e muito Kotlin!
</p>

<p align="center">
  <a href="https://www.linkedin.com/in/brenofariabarbosa/">
    <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white"/>
  </a>
  <a href="https://github.com/brenofbmoura">
    <img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white"/>
  </a>
</p>

---

<p align="center">
  ⭐ Se este projeto te ajudou, deixa uma estrela!
</p>
