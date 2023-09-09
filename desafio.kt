// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel(val descricao: String) {
    BASICO("Básico"),
    INTERMEDIARIO("Intermediário"),
    DIFICIL("Difícil")
}

class Usuario(val nome: String, val email: String, val nivel: Nivel) {}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    override fun toString(): String {
        return "Formacao(nome='$nome', conteudos=$conteudos, inscritos=$inscritos)"
    }
}

fun main() {
    // Simule cenários de teste
    val usuario1 = Usuario("João", "joao@example.com", Nivel.BASICO)
    val usuario2 = Usuario("Maria", "maria@example.com", Nivel.INTERMEDIARIO)

    val conteudo1 = ConteudoEducacional("Introdução à Kotlin", 120, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 90, Nivel.INTERMEDIARIO)

    val formacao1 = Formacao("Desenvolvimento Android", listOf(conteudo1, conteudo2))

    println("Antes da matrícula:")
    println(formacao1)

    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)

    println("Após a matrícula:")
    println(formacao1)
}