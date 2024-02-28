val listFood = listOf(
    FoodData("Ayam Bakar", 50000),
    FoodData("Ayam Goreng", 40000),
    FoodData("Ayam Geprek", 40000),
    FoodData("Kulit Ayam Crispy", 15000),
    FoodData("Sate Usus Ayam", 5000),
)
val listDelivery = listOf("Take Away", "Delivery")
var selectedFood : FoodData? = null
var selectedIndexFood : Int = -1
var inputPayment : Int = -1
var change : Int = -1
var selectedDelivery : Int = -1

fun main() {
    Header().printHeader()
    ListFood().listFood()
    SelectFood().selectFood()
    Payment().payment()
    ListDelivery().listDelivery()
    Delivery().selectDelivery()
}