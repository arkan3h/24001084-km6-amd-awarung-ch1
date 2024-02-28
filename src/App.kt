class Header {
    fun printHeader() {
        println("=============================================")
        println("Selamat Datang di Warung Arkan !")
        println("=============================================")
    }
}

class ListFood {
    fun listFood() {
        println("\nDaftar Menu Makanan :")
        listFood.forEachIndexed { index, foodData ->
            println("${index+1}. ${foodData.foodName}")
        }
    }
}

class SelectFood {
    fun selectFood() {
        println("\nPilih Menu Makanan : ")
        inputFood()
    }

    private fun inputFood() {
        try {
            selectedIndexFood = readln().toInt()
            if (selectedIndexFood in 1..listFood.size) {
                selectedFood = listFood[selectedIndexFood - 1]
                printSelectedFood()

            } else {
                println("Maaf, pilihanmu tidak ada dalam menu")
                selectFood()
            }
        } catch (e : NumberFormatException) {
            println("Mohon masukkan angka")
            selectFood()
        }
    }

    private fun printSelectedFood() {
        println("\n=============================================")
        println("Kamu memilih menu $selectedIndexFood")
        println("Nama menu : ${selectedFood?.foodName}")
        println("Harga     : ${selectedFood?.foodPrice}")
        println("=============================================")
    }
}

class Payment {
    fun payment() {
        println("\nMasukkan Pembayaran :")
        inputPayment()
    }

    private fun inputPayment() {
        try {
            inputPayment = readln().toInt()
            if (inputPayment == (selectedFood?.foodPrice ?: -1)) {
                resultPayment()
//                amountFruit()
            } else if (inputPayment > (selectedFood?.foodPrice ?: -1)) {
                resultPayment()
                change()
            } else {
                println("Maaf, pembayaran Anda gagal!")
                println("Uang anda kurang")
                payment() //recursive
            }
        } catch (e : NumberFormatException) {
            println("Maaf, pembayaran Anda gagal!")
            println("Mohon masukkan angka")
            payment()
        }
    }

    private fun change() {
        change = inputPayment - (selectedFood?.foodPrice ?: -1)
        println("Kamu mendapatkan kembalian : $change")
    }

    private fun resultPayment() {
        println("\n=============================================")
        println("Terima kasih, Anda berhasil memesan makanan")
    }
}

class ListDelivery {
    fun listDelivery() {
        println("=============================================")
        println("\nMetode pengiriman makanan :")
        listDelivery.forEachIndexed { index, deliveryData ->
            println("${index+1}. $deliveryData")
        }
    }
}

class Delivery {
    fun selectDelivery() {
        println("\nPilih metode pengiriman makanan : ")
        inputDelivery()
    }

    private fun inputDelivery() {
        try {
            selectedDelivery = readln().toInt()
            when (selectedDelivery) {
                1 -> {
                    takeAway()
                }
                2 -> {
                    delivery()
                }
                else -> {
                    println("Maaf, metode pengiriman tidak tersedia")
                    selectDelivery()
                }
            }
        } catch (e : NumberFormatException) {
            println("Mohon masukkan angka")
            selectDelivery()
        }
    }

    private fun delivery() {
        println("\n=============================================")
        println("Masakanmu sedang dimasak (5 detik) .....")
        Thread.sleep(5000)
        println("Masakanmu sudah siap! Driver segera menuju tempatmu! (5 detik) .....")
        Thread.sleep(5000)
        println("Driver sampai! Pesanan selesai! (3 detik) ...")
        Thread.sleep(3000)
        println("=============================================")
    }

    private fun takeAway() {
        println("\n=============================================")
        println("Masakanmu sedang dimasak (5 detik) .....")
        Thread.sleep(5000)
        println("Masakanmu sudah siap! Silahkan ambil di resto ya! (5 detik) .....")
        Thread.sleep(5000)
        println("Pesanan selesai! (3 detik) ...")
        Thread.sleep(3000)
        println("=============================================")
    }
}