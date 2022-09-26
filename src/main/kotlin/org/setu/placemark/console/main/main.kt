package org.setu.placemark.console.main

import mu.KotlinLogging
import org.setu.placemark.console.models.PlacemarkModel

private val logger = KotlinLogging.logger{}
var placemark = PlacemarkModel()
fun main(args: Array<String>){
    logger.info { "Launching Placemark Console App" }
    println("Placemark Kotlin App Version 1.0")

    var input: Int
    do {
        input = menu()
        when (input) {
            1 -> addPlacemark()
            2 -> updatePlacemark()
            3 -> listPlacemarks()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
    logger.info("Shutting down Placemark Console App")
    }


fun menu() : Int {

    var option : Int
    var input : String? = null

    println("Main Menu")
    println("1. Add Placemark")
    println("2. Update Placemark")
    println("1. List All Placemark")
    println("-1. Exit")
    println()
    println("Enter an integer : ")
    input = readLine()!!
    option = if(input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9

    return option
}

fun addPlacemark(){

    println("Add Placemark")
    println()
    println("Enter a title : ")
    placemark.title = readLine()!!
    println("Enter a description: ")
    placemark.description = readLine()!!
    println("You entered ${placemark.title} for title with a description of ${placemark.description}")
}

fun updatePlacemark(){
    println("Update Placemark")
    println()
    println("Enter a new title for [ $placemark.title ]: ")
    placemark.title = readLine()!!
    println("Enter a new description instead of [ ${placemark.description} ]: ")
    placemark.description = readLine()!!
    println("You updated with ${placemark.title} for title and a new description of ${placemark.description}")
}

fun listPlacemarks(){
    println("You Chose to List All Placemarks")
}

