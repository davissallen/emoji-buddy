package io.michaelcruz.b1_http_server.person

class Person(val name: String, var age: Int) {
// by adding val and var to the parameters of the class we don't need to initialize
//    val name: String
//    var age: Int
//
//    init {
//        this.name = name
//        this.age = age
//        println("Object was created.")
//    }

    fun speak() {
        println("hello")
    }

    fun greet(name: String) {
        println("Hello $name!")
    }

//    fun getYearOfBirth(): Int {
//        return 2018 - age
//    }
//    same function above just more concise here
    fun getYearOfBirth() = 2016 - age
}

fun main(args: Array<String>) {
    val person = Person("Jack", 17)

    person.speak()
    person.greet("world")
    println(person.getYearOfBirth())
    println(person.name)
}