package com.example.androidlab

enum class Grade{A,B,C,D,E,F}

class MyAccount(var name:String, var cash: Int, var grade : Grade, var stop:Int){
    fun Deposit(money : Int){
        cash = cash + money
        if(stop == 1){
            if (cash > 0){
                stop = 0
                println("동결계좌가 열렸습니다.")
                grade = upGrade(grade)
            }
        }
        else{
            grade = upGrade(grade)

        };
        println("${money.toInt()} 원을 입금하셨습니다. 잔액 : $cash")

    }
    fun Withdraw(money : Int){
        if(cash - money < -1000){
            println("Error");
        }
        else if(grade == Grade.F){
            println("최저 등급의 신용을 가지고 있습니다.")
            println("계좌가 동결됩니다.")
            stop = 1;
            cash = cash - money
            println("계좌가 마이너스 되었습니다.")
            println("${money}원을 출금하였습니다. 잔액 $cash")
        }
        else{
            cash = cash - money
            println("계좌가 마이너스 되었습니다.")
            if( -1000 <= cash &&  cash < 0){
                grade = dowGrade(grade)
            }
            println("${money}원을 출금하였습니다. 잔액 $cash")
        }
    }

    fun dowGrade(grade: Grade):Grade{
        var cur_grade = grade
        if(grade == Grade.A){
            print("신용등급이 'A->B'로 한단계 떨어집니다.")
            cur_grade = Grade.B
        }
        else if(grade == Grade.B){
            print("신용등급이 'B->C'로 한단계 떨어집니다.")
            cur_grade = Grade.C
        }
        else if(grade == Grade.C){
            print("신용등급이 'C->D'로 한단계 떨어집니다.")
            cur_grade = Grade.D
        }
        else if(grade == Grade.D){
            print("신용등급이 'D->E'로 한단계 떨어집니다.")
            cur_grade = Grade.E
        }
        else if(grade == Grade.E){
            print("신용등급이 'E->F'로 한단계 떨어집니다.")
            cur_grade = Grade.F
        }
        return cur_grade
    }

    fun upGrade(grade: Grade):Grade{
        var cur_grade = grade
        if(grade == Grade.B){
            println("신용등급이 'C->A'로 한단계 상승합니다.")
            cur_grade = Grade.A
        }
        else if(grade == Grade.C){
            println("신용등급이 'C->B'로 한단계 상승합니다.")
            cur_grade = Grade.B
        }
        else if(grade == Grade.D){
            println("신용등급이 'D->C'로 한단계 상승합니다.")
            cur_grade = Grade.C
        }
        else if(grade == Grade.E){
            println("신용등급이 'E->D'로 한단계 상승합니다.")
            cur_grade = Grade.D
        }
        else if(grade == Grade.F){
            println("신용등급이 'F->E'로 한단계 상승합니다.")
            cur_grade = Grade.E
        }
        return cur_grade
    }
    fun print_information(){
        println("계좌정보는 다음과 같습니다.")
        println("|이름:    $name      |")
        println("|계좌잔액: $cash       |")
        println("|신용등급:  $grade      |")
        println("-------------------")
        println()
    }
}

fun main() {
    val kim = MyAccount("kim", 0, Grade.C , 0)
    while (true){
        println("-----선택하세요-----")
        println("|(I) 계좌정보      |")
        println("|(D) 입금         |")
        println("|(W) 출금         |")
        println("|(E) 종료         |")
        println("-----------------")

        var cmd = readln()
        if(cmd == "I"){
            kim.print_information()
        }
        else if(cmd == "W"){
            if (kim.stop == 1){
                println("동결된 계좌에서는 출금하실 수 없습니다.")
            }
            else{
                println("출금하실 금액을 말하세요.")
                var new_cash = readln()
                kim.Withdraw(new_cash.toInt())
            }

        }
        else if(cmd == "D"){
            println("입금하실 금액을 말하세요.")
            var new_cash = readln()
            kim.Deposit(new_cash.toInt())
        }
        else{
            break
        }

    }
}