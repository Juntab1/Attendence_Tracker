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

    addUser(community)

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

    print("What is the current day, format xx/xx/xxxx: ")
    val todayDate = readln()

    // create the person instance
    val currPerson = Person(firstName, lastName, age, todayDate)

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

private fun accessDate(person : Person): String{
    println("Which date would you like to access?");
    // get list of dates
    println(person.getDates())
    val chosenDate = readln()
    return chosenDate
}

// choose the person the user would like to add the notes to
private fun chooseUser(community: Community) : Person {
    val reader = Scanner(System.`in`)
    val currNames = community.get()
    if (currNames.size == 1){
        return currNames[0]
    }
    var nameNumber = -1
    while (nameNumber == -1 || (nameNumber > 1 && nameNumber < currNames.size)){
        println("Which person would you like to access, enter the user number (1-${currNames.size})? ")
        community.allNamesDisplay()
        nameNumber = reader.nextInt()
    }
    return currNames[nameNumber - 1]
}

private fun chooseDate(currPerson : Person) : String {
    val reader = Scanner(System.`in`)
    val currDates = currPerson.getDates()
    if (currDates.size == 1){
        return currDates[0]
    }
    var nameNumber = -1
    while (nameNumber == -1 || (nameNumber > 1 && nameNumber < currDates.size)){
        println("Which person would you like to access, enter the user number (1-${currDates.size})? ")
        currPerson.getDatesString()
        nameNumber = reader.nextInt()
    }
    return currDates[nameNumber - 1]
}

private fun displayInfo(currUser: Person) {
    // way of returning the usual display for the user
    println("Activities:")
    val iterate = currUser.getActivities()?.listIterator()
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

    var tempDate =

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
//      Need to access activities based on date, this will change a great amount of the Person class and interface of console
