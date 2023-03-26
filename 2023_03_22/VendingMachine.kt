package com.example.androidlab230321

import java.util.*
enum class MyMenu{참깨라면, 햄버거, 콜라, 핫바, 초코우유}

class VendingMachine{
    var balance = 0

    //금액이 부족할 시, null을 반환한다.
    fun get_Change(price:Int):Int?{
        val change = balance - price
        if(change >= 0){
            balance = 0
            return change
            //println("감사합니다. 잔돈반환:${change}")
        }
        else{
            return null
        }
    }
    
    //inset_coin->잘못된 선택시 ->null 반환
    fun get_Coin():Boolean?{
        try{
            val sc: Scanner = Scanner(System.`in`)
            val inputString = sc.nextLine();
            val coin = inputString.toInt()
            if(coin <= 0){
                return null
            }
            else{
                balance = coin
                println("${coin} 원을 넣었습니다.")
                return true
            }
        }
        catch(e:java.lang.NumberFormatException){
            return null
        }
    }
    
    //잘못된 선택시-> null을 반환
    fun get_Menu():MyMenu?{
        try {
            val sc: Scanner = Scanner(System.`in`)
            val inputString = sc.nextLine();
            val choice = inputString.toInt()
            if(1 > choice || choice > 5){
                return null
            }
            else{
                when(choice){
                    1->return MyMenu.참깨라면
                    2->return MyMenu.햄버거
                    3->return MyMenu.콜라
                    4->return MyMenu.핫바
                    else->return MyMenu.초코우유
                }
            }
        }
        catch(e:NumberFormatException){
            return null
        }
    }
    
    fun get_Price(menu : MyMenu):Int{
        when(menu){
            MyMenu.참깨라면->return 1000
            MyMenu.햄버거->return 1500
            MyMenu.콜라->return 800
            MyMenu.핫바->return 1200
            else->return 1500
        }
    }
}

fun main(){
    val my_VM = VendingMachine()
    while(true){
        println("============== MENU ==============")
        println("| (1) 참깨라면   - 1,000원   |      ")
        println("| (2) 햄버거     - 1,500원   |      ")
        println("| (3) 콜라      -   800원   |      ")
        println("| (4) 핫바      - 1,200원   |      ")
        println("| (5) 초코우유   - 1,500원   |      ")
        println("Choose menu:")
        val selected_menu = my_VM.get_Menu()
        if(selected_menu != null){
            when(selected_menu){
                MyMenu.참깨라면-> println("${selected_menu}이 선택되었습니다.")
                else->println("${selected_menu}가 선택되었습니다.")
            }
            while(true){
                println("Insert coin")
                val inserted_coin = my_VM.get_Coin()
                if(inserted_coin != null){
                    val vending_result = my_VM.get_Change(my_VM.get_Price(selected_menu))
                    if(vending_result != null){
                        println("감사합니다. 잔돈반환:${vending_result}")
                    }
                    else{
                        println("현금이 부족합니다.")
                    }
                    break
                }
                else{
                    println("돈을 넣지 않았습니다.\n다시 돈을 넣어주세요")
                }
            }
            break
        }
        else{
            println("아무것도 선택하지 않았습니다.\n다시 선택해주세요.")
        }
    }

}

