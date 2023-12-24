import java.util.Scanner

fun main() {
    // instance of community class
    val community = Community()

    initialIntro(community)

}

// create the current user
private fun initialIntro(community: Community){
    println("Welcome to Attendance Tracker! You will be able to " +
            "track information about people like a note book!")

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

private fun addUser(community : Community) {
    print("What is the first name? ")
    val firstName = readln()

    print("What is the last name Initial? ")
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

}

private fun intro(tempName: Person): String{
    println("What would you like to do for ${tempName.fullNameDisplay()}?")
    println("(A) Would you like to add an activity?")
    println("(B) Would you like to read a comment for an activity?")
    println("(C) Would you like to remove an activity?")
    println("(D) Would you like to add a new user?")
    println("(E) Would you like to change the user?")
    println("(Q) Quit")
    print("Choice: ")
    val userChoice = readln()
    return userChoice
}

// choose the person the user would like to add the notes to
private fun chooseUser(community: Community) : Person {
    val reader = Scanner(System.`in`)
    val currNames = community.get()
    if (currNames.size == 1){
        return currNames[0]
    }
    var nameNumber = 1
    while (nameNumber >= 1 && nameNumber < currNames.size){
        println("Which person would you like to access? ")
        println("1 - ${currNames.size}")
        nameNumber = reader.nextInt()
    }
    return currNames[nameNumber - 1]
}

private fun displayInfo(currUser: Person) {
    // way of returning the usual display for the user
    println("Activities:")
    val iterate = currUser.getActivities().listIterator()
    var numberOfAct = 1
    if (!iterate.hasNext()){
        println("  No activities")
    }
    else{
        while (iterate.hasNext()){
            val currActivity = iterate.next()
            println("  ${numberOfAct}. $currActivity")
            numberOfAct++
        }
    }
}

private fun options(community: Community) {
    // the person we want to access
    var tempName = chooseUser(community)

    var userChoice = intro(tempName).replaceFirstChar { it.uppercaseChar() }

    while (userChoice != "Q"){
        userChoice = userChoice.replaceFirstChar { it.uppercaseChar() }
        // choices for user
        when (userChoice){
            "A" -> tempName.addActivity()
            "B" -> tempName.readComment()
            "C" -> tempName.removeActivity()
            "D" -> addUser(community)
            "E" -> tempName = chooseUser(community)
        }

        displayInfo(tempName)
        // ask user again
        userChoice = intro(tempName).replaceFirstChar { it.uppercaseChar() }
    }
    println("Have a nice day!")
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

// Comments after creating single user interface:
//      Need to have the option to change to another user, accessing using community class, Person class will not need to change
//      Need to access activities based on date, this will change a great amount of the Person class and interface
