import java.util.Objects
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

    print("What is the current date? format xx/xx/xxxx: ")
    val todayDate = readln()

    // create the person instance
    val currPerson = Person(firstName, lastName, age, todayDate)

    // add the person to community instance
    community.add(currPerson)

}

private fun addDate(currPerson : Person) {
    print("What is the date you would like to add? format xx/xx/xxxx: ")
    var todayDate = readln()
    var dateAdded = currPerson.setDate(todayDate)
    while (!dateAdded){
        print("Date already exists? Please enter a new date. format xx/xx/xxxx: ")
        todayDate = readln()
        dateAdded = currPerson.setDate(todayDate)
    }
}


private fun intro(tempName: Person, tempDate : String): String{
    println("What would you like to do?")
    println("(A) Would you like to add an activity?")
    println("(B) Would you like to read a comment for an activity?")
    println("(C) Would you like to remove an activity?")
    println("(D) Would you like to add a new date?")
    println("(E) Would you like to change the date?")
    println("(F) Would you like to add a new user?")
    println("(G) Would you like to change the user?")
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
    var nameNumber = -1
    while (nameNumber == -1 || (nameNumber > 1 && nameNumber < currNames.size)){
        println("Which person would you like to access, enter the user number (1-${currNames.size})? ")
        println(community.allNamesDisplay())
        nameNumber = reader.nextInt()
    }
    return currNames[nameNumber - 1]
}

private fun displayDate(currPerson : Person) : String {
    val currDates = currPerson.getDates()
    return choiceInfo("date", currDates, null, currPerson.getDatesString()).toString()
}

// helper method
private fun choiceInfo(info : String, infoHolderDates : MutableList<String>?,infoHolderUsers : MutableList<Person>?, choices : String) : Any? {
    val currInfoType = infoHolderDates ?: infoHolderUsers
    val reader = Scanner(System.`in`)
    if (currInfoType != null) {
        if (currInfoType.size == 1){
            return currInfoType[0]
        }
    }
    var objectNumber = -1
    if (currInfoType != null) {
        while (objectNumber == -1 || (objectNumber > 1 && objectNumber < currInfoType.size)){
            println("Which $info would you like to access, enter the number (1-${currInfoType.size})? ")
            println(choices)
            objectNumber = reader.nextInt()
        }
    }
    return currInfoType?.get(objectNumber - 1)
}

// method returning the usual display for the user
private fun displayInfo(currUser: Person, currDate: String, community: Community) {
    println()
    println("Activities for ${currUser.fullNameDisplay()}, ${currDate}:")
    val iterate = currUser.getActivities(currDate)?.listIterator()
    var numberOfAct = 1
    if (iterate != null) {
        if (!iterate.hasNext()){
            println("  No activities")
        } else{
            while (iterate.hasNext()){
                val currActivity = iterate.next()
                println("  ${numberOfAct}. $currActivity")
                numberOfAct++
            }
        }
    }
    println(currUser.getDatesString())
    println(community.allNamesDisplay())
    println()
}

private fun options(community: Community) {
    // the person we want to access
    var tempName = chooseUser(community)

    var tempDate = displayDate(tempName)

    var userChoice = intro(tempName, tempDate).replaceFirstChar { it.uppercaseChar() }

    while (userChoice != "Q"){
        userChoice = userChoice.replaceFirstChar { it.uppercaseChar() }
        // choices for user
        when (userChoice){
            "A" -> tempName.addActivity(tempDate)
            "B" -> tempName.readComment(tempDate)
            "C" -> tempName.removeActivity(tempDate)
            "D" -> addDate(tempName)
            "E" -> tempDate = displayDate(tempName)
            "F" -> addUser(community)
            "G" -> {tempName = chooseUser(community)
                tempDate = displayDate(tempName)}

        }

        displayInfo(tempName, tempDate, community)
        // ask user again
        userChoice = intro(tempName, tempDate).replaceFirstChar { it.uppercaseChar() }
    }
    println("Have a nice day!")
}


