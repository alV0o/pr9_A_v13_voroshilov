open class Tovar(var name:String, var price:Int, var unitsOfMeasuring:String, var count:Int) {
    open var typeOfTovar = ""

    fun SetType(){
        println("Выберите тип товара")
        println("[1] - Бытовой")
        println("[2] - Продуктовый")
        println("[3] - Строительный")
        println("[4] - Для гигиены")

        val answer = readLine()!!.toInt()

        when(answer){
            1 -> typeOfTovar = "Бытовой"
            2 -> typeOfTovar = "Продуктовый"
            3 -> typeOfTovar = "Строительный"
            4 -> typeOfTovar = "Для гигиены"
            else ->{
                println("Неверный тип товара")
                SetType()
            }
        }
    }

    open fun GetInfo(){
        SetType()
        println("Вид товара: ${typeOfTovar}")
        println("Название товара: ${name}")
        println("Единицы измерения: ${unitsOfMeasuring}")
        println("Количество: ${count}")
        println("Цена: ${price}")
    }

    open fun PriceOfOneProduct(){
        println("Цена за 1 товар: ${price!!.toDouble()/count!!.toDouble()}")
    }

}