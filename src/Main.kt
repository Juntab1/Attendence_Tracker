import java.util.Scanner
import java.util.concurrent.TimeUnit

fun main() {
    // instance of community class
    val community = Community()

    intro(community)

}

// create the current user
fun intro(community: Community){
    println("Welcome to Attendence Tracker! You will be able to " +
            "track information about people like a note book!")
    // maybe add a sleep function here

    print("What is your first name? ")
    val firstName = readln()

    print("What is your last name Initial? ")
    var lastName = readln()

    while (lastName.length > 1){
        print("What is your last name Initial? ")
        lastName = readln()
    }

    val reader = Scanner(System.`in`)
    print("What is your age? ")
    val age = reader.nextInt()

    // create the person instance
    val currPerson = Person(firstName, lastName, age)

    // add the person to community instance
    community.add(currPerson)

    // give user options for what they can do
    options(community)
}

fun intro(tempName: Person): String{
    println("What would you like to do for ${tempName.first_last_name()}?")
    println("(A) Would you like to add an activity?")
    println("(B) Would you like to read a comment for an activity?")
    println("(C) Would you like to remove an activity?")
    print("Choice: ")
    val userChoice = readln()
    return userChoice
}

fun options(community: Community) {
    // the person we want to access
    val tempName = choose_user(community)

    var userChoice = intro(tempName)

    while (userChoice != "Q"){
        // choices for user
        if (userChoice == "A"){
            tempName.add_activity()
        }
        else if (userChoice == "B"){
            tempName.read_comment()
        }
        else if (userChoice == "C"){
            tempName.remove_activity()
        }

        // ask user again
        userChoice = intro(tempName)
    }


}

// choose the person the user would like to add the notes to
fun choose_user(community: Community) : Person {
    val reader = Scanner(System.`in`)
    val currNames = community.get()
    if (currNames.size == 1){
        return currNames[0]
    }
    var nameNumber = 1
    while (nameNumber < 1 || nameNumber > currNames.size){
        println("Which person would you like to access? ")
        println("1 - ${currNames.size}")
        nameNumber = reader.nextInt()
    }
    return currNames[nameNumber - 1]
}



// A note keeping app focused on keeping track of people information
//      features:
//          - able to enter date and keep log of people information within it
//              ex: Jun
//                      12/15/2023
//          - able to select a user and date to be prompted a list of options to choose from to add in
//              activity, mood, etc.
// Steps to achieve
//      create a class of person to keep user info within it
//      do formatting in main to start out with
