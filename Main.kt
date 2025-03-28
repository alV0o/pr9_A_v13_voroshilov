fun main(){
    try{
        println("Введите название, Введите цену, Введите единицу измерения, Введите количество товаров")
        val product1 = GroceryProduct(readLine()!!.toString(), readLine()!!.toDouble(), readLine()!!.toString(), readLine()!!.toInt())

        when{
            (product1.price < 0) -> println("Неверная цена")
            (product1.count < 0) -> println("Неверное количество товаров")
            else ->{
                println("Введите дату изготовления (одного месяца)")
                product1.dayOfManufacture = readLine()!!.toInt()
                println("Введите сегодняшнюю дату (одного месяца)")
                product1.today = readLine()!!.toInt()

                when{
                    (product1.dayOfManufacture < 1 || product1.today < 1 || product1.today > 31 || product1.dayOfManufacture > 31) -> println("Неверные даты")
                    (product1.today - product1.dayOfManufacture < 0) -> println("Сегодняшняя дата не может быть меньше предыдущей")
                    else -> {
                        product1.GetInfo()
                        product1.PriceOfOneProduct()
                        product1.CountBoxes()
                        product1.Delivery()
                    }
                }
            }
        }

        println("---------------")

        println("Введите название, Введите цену, Введите единицу измерения, Введите количество товаров")
        val product2 = HouseholdProduct(readLine()!!.toString(), readLine()!!.toDouble(), readLine()!!.toString(), readLine()!!.toInt())

        when{
            (product2.price < 0) -> println("Неверная цена")
            (product2.count < 0) -> println("Неверное количество товаров")
            else -> {
                product2.TypeOfHHProduct()
                product2.PriceOfOneProduct()
                product2.CountBoxes()
                product2.Delivery()
            }
        }

        println("----------------")

        println("Введите название, Введите цену, Введите единицу измерения, Введите количество товаров")
        val product3 = Tovar(readLine()!!.toString(), readLine()!!.toDouble(), readLine()!!.toString(), readLine()!!.toInt())

        when{
            (product3.price < 0) -> println("Неверная цена")
            (product3.count < 0) -> println("Неверное количество товаров")
            else ->{
                product3.GetInfo()
                product3.PriceOfOneProduct()
                product3.CountBoxes()
                product3.Delivery()
            }
        }
    }
    catch (e:Exception){
        println("Неверный формат")
    }
}
