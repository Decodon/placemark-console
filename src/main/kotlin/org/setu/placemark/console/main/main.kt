package org.setu.placemark.console.main

import mu.KotlinLogging
import org.setu.placemark.console.models.PlacemarkModel

private val logger = KotlinLogging.logger{}

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
            4 -> searchPlacemarks()
            -99 -> dummyData()
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
    println("4. Search Placemarks")
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
    var aPlacemark = PlacemarkModel()
    println("Add Placemark")
    println()
    println("Enter a title : ")
    aPlacemark.title = readLine()!!
    println("Enter a description: ")
    aPlacemark.description = readLine()!!

    if (aPlacemark.title.isNotEmpty() && aPlacemark.description.isNotEmpty()){
        aPlacemark.id = placemarks.size.toLong()
        placemarks.add(aPlacemark.copy())
        logger.info("Placemark added: [ $aPlacemark ]")
    }
    else
        logger.info("Placemark not added")
}

fun updatePlacemark(){
    println("Update Placemark")
    println()
    listPlacemarks()
    var searchId = getId()
    val aPlacemark = search(searchId)
    var tempTitle : String?
    var tempDescription: String?

    if (aPlacemark !=null) {
        print("Enter a new Title for [ " + aPlacemark.title + " ] : ")
        tempTitle = readLine()!!
        print("Enter a new Description for [ " + aPlacemark.description + " ] : ")
        tempDescription = readLine()!!

        if (!tempTitle.isNullOrEmpty() && !tempDescription.isNullOrEmpty()) {
            aPlacemark.title = tempTitle
            aPlacemark.description = tempDescription
            println(
                "You updated [ " + aPlacemark.title + " ] for title " +
                        "and [ " + aPlacemark.description + " ] for description"
            )
            logger.info("Placemark Updated : [ $aPlacemark ]")
        } else
            logger.info("Placemark Not Updated")
    }
    else
        println("Placemark Not Update")
}

fun listPlacemarks() {
    println("List all placemarks")
    println()
    placemarks.forEach { logger.info("$it") }
    println()
}

fun getId(): Long {
    var strId : String? //String to hold user unput
    var searchId : Long //Long to hold converted if
    println("Enter id to search / update : ")
    strId = readLine()!!
    searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
        strId.toLong()
    else
        -9
    return searchId
}


fun search(id: Long) : PlacemarkModel? {
    var foundPlacemark: PlacemarkModel? = placemarks.find{ p -> p.id == id}
        return foundPlacemark
}


fun searchPlacemarks() {
    var searchId = getId()
    val aPlacemark = search(searchId)

    if (aPlacemark !=null)
        println("Placemark Details [ $aPlacemark ]")
    else
        println("Placemark Not Found...")
}

fun dummyData() {
    placemarks.add(PlacemarkModel(1, "New York New York", "So Good They Named It Twice"))
    placemarks.add(PlacemarkModel(2, "Ring of Kerry", "Some place in the Kingdom"))
    placemarks.add(PlacemarkModel(3, "Waterford City", "You get great Blaas Here!!"))
}