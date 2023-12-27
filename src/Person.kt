import java.util.*

class Person(nameFirst : String?, nameLast : String?, personAge : Int, todayDate : String) {
    // maybe add a getter and setter later since it is all private
    private val firstName: String? = nameFirst
    private val lastInitial: String? = nameLast
    private val age : Int = personAge
    // key is date and value is list of activities
    private lateinit var dates : MutableMap<String, DateInfo>
//    // late-init under the hood gives the variables a null later to be initialized
//    private lateinit var activities : MutableList<String>
//    // key =  index num. of activity in activity
//    // value = comment
//    private lateinit var comments : MutableMap<String, String>


    fun fullNameDisplay() : String {
        return "$firstName $lastInitial"
    }

    fun getDates() : MutableList<String> {
        val listOfDates = mutableListOf<String>()
        dates.keys.forEach{
            listOfDates.add(it)
        }
        return listOfDates;
    }

    // comment out for now when working on add function and using lateinit
//    fun setDate(currDate : String) : Boolean {
////        if (dates.contains(currDate)){
////            return false
////        }
////        dates[currDate] = null
////        return true
//    }

    // need to return in string version
    fun getDatesString(){
        var currDates = "Dates: "
        dates.keys.forEach{
            currDates += "${it}, "
        }
        println(currDates.removeRange(currDates.length - 2, currDates.length))
    }

    // Might be returning null not a MutableList
    fun getActivities(date : String): MutableList<String>? {
        return dates[date]?.activities
    }

    // able to add activity name and comment about that activity
    fun addActivity(currDate : String) {
        print("What is the activity name? ")
        val actName = readln().lowercase(Locale.getDefault())
        print("What is your comment for the activity? ")
        val actComment = readln().lowercase(Locale.getDefault())
        if (!::dates.isInitialized){
            dates = mutableMapOf<String, DateInfo>((currDate to DateInfo(actName, actComment)))
        }
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

    // more of a helper function of finding the name of the activity
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