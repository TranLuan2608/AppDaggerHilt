
package com.example.application_dagger_hilt_retrofit.data.model
//tai sao no lai la open, tai sao lai tao la open tai sao lai tao la data, object la gi
//tiem hieu ve interface , abstract , class
//doc them ve .let, .apply, .run ?de lam gi
// tiem hieu ve ?,!
open class Animal(typeFood: String ="", timeToSleep: String="",whereSleep: String="")
{
    var eat: String = typeFood
    var sleep: String = timeToSleep
    var whereSleep = whereSleep

}

class Dog(bark: String,typeFood: String, timeToSleep: String) : Animal(typeFood,timeToSleep) {

    var bark = bark

}
class Cat(whereSleep: String,typeFood: String,timeToSleep: String): Animal(typeFood,timeToSleep,whereSleep)
class Bear(typeFood: String,timeToSleep: String,whereSleep: String): Animal(typeFood,timeToSleep,whereSleep)
class Rat(typeFood: String,timeToSleep: String,whereSleep: String):Animal(typeFood,timeToSleep,whereSleep)


 class Person(
    var name: String,
    var gender: String = "Male",
    var country: String = "VN",
    var address: String? = null
)

//cach khoi tao object
//cach dung
//dung o dau, dung khi nao
