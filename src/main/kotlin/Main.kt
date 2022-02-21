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
        valor = Random.nextInt(0,6)
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
    println(amarillo+"Problema 105")
    println(amarillo+"Problema 105")



}