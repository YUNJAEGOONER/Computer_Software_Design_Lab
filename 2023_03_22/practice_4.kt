package com.example.androidlab230321

//class NonealphabetExeption(message: String):Exception(message)

fun chage(word:String):String {
    var check_alphabet = 0;
    var check_Big = 0;
    var returnseting = ""

    for (i in 0..word.length - 1) {
        if ((97 <= word[i].toInt() && word[i].toInt() <= 122)) {
            check_alphabet++
        }
    }

    //모두 소문자
    if(check_alphabet == word.length){
        for (i in 0..word.length - 1) {
            if (97 <= word[i].toInt() && word[i].toInt() <= 122) {
                var mychar = (word[i].toInt() - 32).toChar()
                returnseting = returnseting + mychar
            }
        }
        return returnseting
    }
    else{
        for (i in 0..word.length - 1) {
            if (97 > word[i].toInt() || word[i].toInt() > 122) {
                returnseting = returnseting + word[i]
            }
        }
        return "error with = ${returnseting}"
    }

}


fun main(){
    var a = "abcd"
    println(chage(a))

    var b = "EfgH"
    println(chage(b))

    var c = "!@%$"
    println(chage(c))
}