import java.util.Scanner

fun main() {
    // instance of community class
    val community = Community()

    intro(community)

}

// create the current user
fun intro(community: Community){

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
    println(community.to_string())
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
