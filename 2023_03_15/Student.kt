package com.example.androidlab

enum class Year{Freshman, Sophomore, Junior, Senior}
class Student(var year:Year, var name : String, var id :Int){
    fun print_information(){
        println("YEAR : ${year}, NAME : $name. ID : $id")
    }
}


fun main(){
    var students : MutableList<Student> = mutableListOf()
    students.add(Student(Year.Freshman, "Kim", 2020))
    students.add(Student(Year.Freshman, "Wang", 2020))
    students.add(Student(Year.Sophomore, "Kim", 2020))
    students.add(Student(Year.Junior, "Lee", 2020))
    students.add(Student(Year.Senior, "Hwangbo", 2020))

    var freshman_students = students.filter{it.year == Year.Freshman}

    for(student in freshman_students){
        student.print_information()
    }
}