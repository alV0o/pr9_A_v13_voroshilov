open class Tovar(var name:String, var price:Double, var unitsOfMeasuring:String, var count:Int) {
    open var typeOfTovar = ""

    open fun SetType(){
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
        println("Цена за 1 товар: ${String.format("%.2f", price/count!!.toDouble())}")
    }

    fun CountBoxes(){
        println("Введите объем упаковки 1 товара")
        val volumeTovar = readLine()!!.toInt()
        when{
            (volumeTovar<=0) -> {
                println("Неверный объем. Введите заново")
                CountBoxes()
            }
            else -> {
                val volumeBox = 500
                
                when{
                    (volumeTovar>volumeBox) -> println("Потребуется ${count} индивидуальных коробок")
                    else->{
                        val countInOneBox = Math.floor(volumeBox/volumeTovar!!.toDouble())//сколько
                        println("Потребуется ${Math.ceil(count/countInOneBox)} стандартных коробок")
                    }
                }
            }
        }
    }

    fun Delivery(){
        var extraPrice = 0.0 //наценка

        println("Товар является хрупким?")
        println("[1] - Да")
        println("[2] - Нет")
        val answer = readLine()!!.toInt()

        when{
            (answer == 1) -> extraPrice+=0.5
            (answer != 2) ->{
                println("Неверный вариант. Выберите заново")
                Delivery()
            }
        }
        println("----------")

        println("Введите расстояние между пунктами назначения")
        val range = readLine()!!.toInt()

        when {
            (range >= 10 && range < 50) -> extraPrice += 0.2
            (range >= 50 && range < 100) -> extraPrice += 0.3
            (range > 100) -> extraPrice += 0.5
            else -> {
                println("Неверное расстояние. Введите заново")
                Delivery()
            }
        }

        val defPrice = 1000

        println("Доставка будет стоить: ${defPrice + defPrice*extraPrice}p")
    }
}
