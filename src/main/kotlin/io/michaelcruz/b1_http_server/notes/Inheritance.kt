package io.michaelcruz.b1_http_server.notes

// Using "open" in front of class declaration you enable inheritance, but using abstract disables Person instantiations.
abstract class Person(open val name: String, open var age: Int) {
// by adding val and var to the parameters of the class we don't need to initialize
//    val name: String
//    var age: Int
//
    init {
//        this.name = name
//        this.age = age
        println("Object was created.")
    }

    abstract fun speak()

    fun greet(name: String) {
        println("Hello $name!")
    }

//    fun getYearOfBirth(): Int {
//        return 2018 - age
//    }
//    same function above just more concise here
    fun getYearOfBirth() = 2018 - age
}

class Student(override val name: String, override var age: Int, val studentId: Int): Person(name, age) {
    fun isIntelligent() = true
    override fun speak() {
        println("Hi there. I'm a student.")
    }
}

class Employee(override val name: String, override var age: Int): Person(name, age) {
    fun receivePayment() {
        println(message = "Received payment.")
    }

    override fun speak() {
        println("Hi there. I'm an employee.")
    }
}

fun main(args: Array<String>) {
    val student = Student("Mick", 17, 42424242)
    val employee = Employee("Mrs. Smith", 47)

    println(student.isIntelligent())
    println(student.getYearOfBirth())
    employee.receivePayment()
    student.speak()
}