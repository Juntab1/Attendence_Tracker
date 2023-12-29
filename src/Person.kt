import java.util.*

class Person(nameFirst : String?, nameLast : String?, todayDate : String) {

    // first name of the user
    private val firstName: String? = nameFirst

    // last initial of the user
    private val lastInitial: String? = nameLast


    // key is date and value is list of activities
    private var dates : MutableMap<String, DateInfo> = mutableMapOf(todayDate to DateInfo("",""))

    // display the person's full name
    fun fullNameDisplay() : String {
        return "$firstName $lastInitial"
    }

    // return list of all dates for the person
    fun getDates() : MutableList<String> {
        val listOfDates = mutableListOf<String>()

        dates.keys.forEach{
            listOfDates.add(it)
        }

        return listOfDates;
    }

    // add to the map variable the new date
    fun setDate(currDate : String) : Boolean {
        if (dates.contains(currDate)){
            return false
        }

        dates[currDate] = DateInfo("", "")

        return true
    }

    // need to return dates in string version
    fun getDatesString(): String{
        var currDates = "Dates: "

        dates.keys.forEach{
            currDates += "${it}, "
        }

        return currDates.removeRange(currDates.length - 2, currDates.length)
    }

    // returning a list of all the activities of the current date
    fun getActivities(date : String): MutableList<String>? {
        return dates[date]?.activities
    }

    // able to add activity name and comment about that activity
    fun addActivity(currDate : String) {
        print("What is the activity name? ")
        val actName = readln().lowercase(Locale.getDefault())

        print("What is your comment for the activity? ")
        val actComment = readln().lowercase(Locale.getDefault())

        if (dates[currDate]?.activities == null){
            dates[currDate]?.activities = mutableListOf(actName)
        }
        else{
            dates[currDate]?.activities?.add(actName)
        }

        dates[currDate]?.comments?.set(actName, actComment)
    }

    // remove the activity and comments connected to it
    fun removeActivity(currDate : String) {
        if (dates[currDate]?.activities != null){
            val actName = findActivityName(currDate).lowercase(Locale.getDefault())
            dates[currDate]?.activities?.remove(actName)
            dates[currDate]?.comments?.remove(actName)
            println("$actName removed!")
        }
        else{
            println("No activities Available!")
        }
    }

    // access the map to get the comment
    fun readComment(currDate : String) {
        if (dates[currDate]?.comments?.isNotEmpty() == true){
            val actName = findActivityName(currDate).lowercase(Locale.getDefault())
            println("Comment for ${actName}: " + dates[currDate]?.comments?.get(actName))
        }
        else{
            println("No activities available to read comments from!")
        }
    }

    // helper method of finding the name of the activity
    private fun findActivityName(currDate : String): String{
        print("What is the name of the activity? ")

        var actName = readln().lowercase(Locale.getDefault())

        while (!dates[currDate]?.activities?.contains(actName)!!){
            print("Wrong name! What is the name of the activity? ")
            actName = readln().lowercase(Locale.getDefault())
        }

        return actName
    }

}