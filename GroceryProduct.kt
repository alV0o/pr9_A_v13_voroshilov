class GroceryProduct(var empName:String, var empPrice:Double, var empUnitsOfMeasuring:String, var empCount:Int): Tovar(empName, empPrice, empUnitsOfMeasuring, empCount) {
    override var typeOfTovar = "Продуктовый"

    var dayOfManufacture = 0 //день изготовления (одного месяца)
    var today = 0 //сегодняшний день (одного месяца)
    var bestBefDay = "" //срок годности

    override fun SetType(){
        println("Вид товара - ${typeOfTovar}")
    }


    fun BestBeforeDay(){//определение срока годности
        println("Выберите срок годности:")
        println("[1] - Меньше 1 дня")
        println("[2] - 7 дней")
        println("[3] - 15 дней")

        val answer = readLine()!!.toInt()
        when(answer){
            1 -> {
                when{
                    (today - dayOfManufacture == 0) -> bestBefDay = "Товар годен"
                    else -> bestBefDay = "Срок годности истек"
                }
            }
            2 -> {
                when{
                    (today - dayOfManufacture <= 7) -> bestBefDay = "Товар годен"
                    else -> bestBefDay = "Срок годности истек"
                }
            }
            3 -> {
                when{
                    (today - dayOfManufacture <= 15) -> bestBefDay = "Товар годен"
                    else -> bestBefDay = "Срок годности истек"
                }
            }
            else -> {
                println("Неверный выбор")
                println("Выберите заново")
                BestBeforeDay()
            }
        }
    }

    override fun GetInfo(){
        BestBeforeDay()
        println("Вид товара: ${typeOfTovar}")
        println("Название товара: ${name}")
        println("Срок годности: ${bestBefDay}")
        println("Единицы измерения: ${unitsOfMeasuring}")
        println("Количество: ${count}")
        println("Цена: ${price}")
    }

}
