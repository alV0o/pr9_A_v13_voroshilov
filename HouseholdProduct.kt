import kotlin.reflect.typeOf

class HouseholdProduct(var empName:String, var empPrice:Double, var empUnitsOfMeasuring:String, var empCount:Int): Tovar(empName, empPrice, empUnitsOfMeasuring, empCount){
    override var typeOfTovar = "Бытовой"
    var secondTypeOfTovar = "" //подвид товара
    var markupForSecType = 0.0 //наценка за подвид
    var newPrice = price //цена с наценкой

    override fun SetType() { //требуется т.к. вид товара уже указан
        println("Вид товара - ${typeOfTovar}")
    }

    override fun GetInfo(){
        println("Вид товара: ${typeOfTovar}")
        println("Подвид товара: ${secondTypeOfTovar}")
        println("Название товара: ${name}")
        println("Единицы измерения: ${unitsOfMeasuring}")
        println("Количество: ${count}")
        println("Цена с наценкой: ${newPrice}")
    }

   fun TypeOfHHProduct(){ //определение подвида
        println("[1] - Косметика")
        println("[2] - Бытовая техника")
        println("[3] - Кухонная техника")
        println("[4] - Сантехника")

        val answer = readLine()!!.toInt()

        when(answer){
            1 -> {
                secondTypeOfTovar = "Косметика"
                markupForSecType = 0.5
                newPrice += price*markupForSecType
                GetInfo()
            }

            2 -> {
                secondTypeOfTovar = "Бытовая техника"
                markupForSecType = 0.2
                newPrice += price*markupForSecType
                GetInfo()
            }

            3 -> {
                secondTypeOfTovar = "Кухонная техника"
                markupForSecType = 0.3
                newPrice += price*markupForSecType
                GetInfo()
            }

            4 -> {
                secondTypeOfTovar = "Сантехника"
                markupForSecType = 0.7
                newPrice += price*markupForSecType
                GetInfo()
            }

            else -> {
                println("Неверный ответ")
                println("Введите заново")
                TypeOfHHProduct()
            }

        }
    }

    override fun PriceOfOneProduct(){
        println("Цена за 1 товар: ${String.format("%.2f",newPrice/count!!.toDouble())}")
    }


}
