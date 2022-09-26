package org.setu.placemark.console.main

import mu.KotlinLogging
import org.setu.placemark.console.models.PlacemarkModel

private val logger = KotlinLogging.logger{}
var placemark = PlacemarkModel()
val placemarks = ArrayList<PlacemarkModel>()
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
    println("3. List All Placemark")
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

    if (placemark.title.isNotEmpty() && placemark.description.isNotEmpty()){
        placemarks.add(placemark.copy())
        logger.info("Placemark added: [$placemark]")
    }
    else
        logger.info("Placemark not added")
}

fun updatePlacemark(){
    println("Update Placemark")
    println()
    print("Enter a new Title for [ " + placemark.title + " ] : ")
    placemark.title = readLine()!!
    print("Enter a new Description for [ " + placemark.description + " ] : ")
    placemark.description = readLine()!!
    println("You updated [ " + placemark.title + "] for title " + "and [ " + placemark.description + " ] for description ")
}

fun listPlacemarks() {
    println("List all placemarks")
    println()
    placemarks.forEach { logger.info("$it") }
}

