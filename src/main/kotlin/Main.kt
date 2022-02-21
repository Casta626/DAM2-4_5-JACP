import kotlin.random.Random

val reset = "\u001B[0m"
val rojo = "\u001B[31m"
val azul = "\u001B[34m"
val cian = "\u001B[36m"
val verde = "\u001B[32m"
val amarillo = "\u001B[33m"
val purpura = "\u001B[35m"

data class Articulo(val codigo: Int, val descripcion: String, var precio: Float){
    fun imprimir(){
        println(verde+"Código: $azul$codigo$verde, Descripción: $azul$descripcion$verde, Precio: $azul$precio$verde")
    }
    fun aumentarPrecio(){
        precio= (precio*1.1).toFloat()
    }
}

data class Dado(var valor: Int){
    fun imprimir(){
        println(azul+valor)
    }
    fun tirarDado(){
        println(verde+"*Lanzo un dado*")
        valor = Random.nextInt(0,7)
    }
}

data class Empleado(var nombre: String,var sueldo: Float){
    fun imprimir(){
        println("${amarillo}Nombre: $purpura$nombre$amarillo, Sueldo: $purpura$sueldo$amarillo")
    }

}

fun main(args: Array<String>) {



    println(rojo+"  Arrays1")
    println(rojo+"Problema 103")

    var array1= IntArray(8)
    var valor_total = 0
    for (i in 0..array1.size-1){
        println("$verde Escriba un número entero"+reset)
        array1[i] = readLine()!!.toInt()
        valor_total += array1[i]
    }
    var mayor36 = 0
    var mayor50 = 0
    for(i in 0..array1.size-1){
        if (array1[i] in 36..50){
            mayor36++
        }
        else if (array1[i]>50){
            mayor50++
        }
    }

    println("$verde Todos los elementos suman $azul $valor_total $verde, hay $azul $mayor36 $verde elementos mayor/es a 36 y " +
            "$azul $mayor50 $verde mayor/es de 50")

    println()
    println(rojo+"Problema 104")
    var array2 = IntArray(4)
    var array3 = IntArray(4)
    var array4 = IntArray(4)

    for (i in 0..array2.size-1){
        println(verde+"Escribe un número para el primer array (4 veces)"+reset)
        array2[i] = readLine()!!.toInt()
    }

    for (i in 0..array3.size-1){
        println(verde+"Escribe un número para el segundo array (4 veces)"+reset)
        array3[i] = readLine()!!.toInt()
    }

    println(verde+"Los valores del tercer array son:")
    for (i in 0..array4.size-1){
        array4[i]= array2[i] + array3[i]
        print(azul+array4[i])
        print(", ")

    }

    println()

    println(rojo+"  Arrays2")
    println(rojo+"Problema 105")
    val articulos: Array<Articulo> = arrayOf(Articulo(1,"Revista",1.0f), Articulo(2,"Gorra",6.5f),
        Articulo(3,"Ratón",15.99f), Articulo(4,"Bolígrafo",0.40f))
    for (i in 0..articulos.size-1){
        articulos[i].imprimir()

    }
    for (i in 0..articulos.size-1){
        articulos[i].aumentarPrecio()

    }
    println(verde+"Los precios han subido un 10%")
    for (i in 0..articulos.size-1){
        articulos[i].imprimir()

    }

    println()
    println(rojo+"Problema 105")
    val dados : Array<Dado> = arrayOf(Dado(0),Dado(0),Dado(0),Dado(0),Dado(0))
    for (i in 0..dados.size-1){
        dados[i].tirarDado()
        dados[i].imprimir()
    }

    println()
    println(cian+"Colecciones : MutableList")
    println(cian+"Problema 178")
    val lista: List<Int> = List(100) { (Random.nextInt(0,21)) }
    println(amarillo+"Imprimimos la lista de numeros:")
    print("$purpura$lista, ")
    println()
    var n1_4 = lista.count{ it in 1..4 }
    println("$amarillo Hay $purpura$n1_4$amarillo valores entre el 1 y el 4")
    var n5_8 = lista.count{ it in 5..8 }
    println("$amarillo Hay $purpura$n5_8$amarillo valores entre el 5 y el 8")
    var n10_13 = lista.count{ it in 10..13 }
    println("$amarillo Hay $purpura$n10_13$amarillo valores entre el 10 y el 13")
    var n20 = lista.count{ it == 20 }
    if (n20 >= 1){
        println(purpura+"Existe el valor '20'")
    }else{println(purpura+"No existe el valor '20'")}

    println()
    println(cian+"Problema 179")
    var cuenta_total :Float = 0f
    var empleados : MutableList<Empleado>
    empleados = mutableListOf(Empleado("Pepe",  1200f),Empleado("Paco",  1500f),Empleado("Manolo",  1800f) )
    empleados.forEach { it.imprimir() }
    empleados.forEach { cuenta_total += it.sueldo }
    println(amarillo+"La empresa gasta $purpura$cuenta_total$amarillo en sus empleados")
    println("Añadimos una persona mas")
    empleados.add(Empleado("Antonio",2100f))
    cuenta_total = 0f
    empleados.forEach { it.imprimir() }
    empleados.forEach { cuenta_total += it.sueldo }
    println(amarillo+"La empresa gasta $purpura$cuenta_total$amarillo en sus empleados")

    println()
    println(cian+"Problema 180")
    println(amarillo+"Introduce la altura de 5 personas")
    val lista_alturas : List<Float> = List(5) { (readLine()!!.toFloat()) }
    var media_alturas=lista_alturas.average()
    println("La altura promedio es de $purpura$media_alturas$amarillo m")
    var mayor_media = lista_alturas.count{ it > media_alturas}
    println(amarillo+"Hay $purpura$mayor_media$amarillo personas con altura mayor al promedio")
    var menor_media = lista_alturas.count{ it < media_alturas}
    println(amarillo+"Hay $purpura$menor_media$amarillo personas con altura mayor al promedio")

    println()
    println(cian+"Colecciones : Set MutableSet")
    println(cian+"Problema 189")


    println(cian+"Colecciones : Map MutableMap")
    println(cian+"Problema 186")
    val fechas: MutableMap<String, Fecha> = mutableMapOf()
    cargar(fechas)
    listadoCompleto(fechas)
    consultaFechas(fechas)



}

data class Fecha(val dia: Int, val mes: Int, val año: Int)
fun cargar(fechas: MutableMap<String, Fecha>){
    println(amarillo+"¿Cuantas fechas quiere cargar?")
    val cant = readLine()!!.toInt()
    for (i in 1.. cant){
        println("Escriba un titulo para la fecha")
        val titulo = readLine()!!.toString()
        val lista_fechas = mutableListOf<Fecha>()

            println("Escriba el día")
            val dia = readLine()!!.toInt()
            println("Escriba el día")
            val mes = readLine()!!.toInt()
            println("Escriba el día")
            val año = readLine()!!.toInt()
            lista_fechas.add(Fecha(dia, mes, año))
    }
}
fun listadoCompleto(fechas :MutableMap<String,Fecha>){
    println("Listado de las fechas:")
    for ((titulos,fecha) in fechas){
        println(amarillo+"Título: $purpura$titulos$amarillo es para el $purpura${fecha.dia}$amarillo de $purpura${fecha.mes}$amarillo del $purpura${fecha.año}$amarillo")
        println()
    }
}

fun consultaFechas(fechas: MutableMap<String, Fecha>){
    println(amarillo+"Introduce el titulo del evento")
    val titulo = readLine()!!.toString()
    if (titulo in fechas){
        println(amarillo+"$purpura${fechas[titulo]?.dia}$amarillo/$purpura${fechas[titulo]?.mes}$amarillo/$purpura${fechas[titulo]?.año}$amarillo")
    }
}