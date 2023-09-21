enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }
data class Usuario(val nome: String)
data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    @Throws
    fun matricular(vararg usuarios: Usuario) {
        try {
            for(usuario in usuarios) {
                inscritos.add(usuario) }
            }
        catch (e: Throwable) {
            e.printStackTrace()
        }

    }
}

fun main() {
    val disciplinas = ArrayList<ConteudoEducacional>()
    disciplinas.add(ConteudoEducacional("Introdução ao kotlin"))
    disciplinas.add(ConteudoEducacional("kotlin Intermediário"))
    val curso = Formacao("Curso basico de lotlin", Nivel.BASICO, disciplinas)


    curso.run {
        matricular(Usuario("cleitinho"), Usuario("Ronaldo"))
    }

    print(curso.inscritos)


}