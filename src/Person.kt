import java.util.*

class Person(nameFirst : String?, nameLast : String?, personAge : Int, todayDate : String) {
    // maybe add a getter and setter later since it is all private
    private val firstName: String? = nameFirst
    private val lastInitial: String? = nameLast
    private val age : Int = personAge
    // key is date and value is list of activities
    private var dates : MutableMap<String, DateInfo?> = mutableMapOf(todayDate to null)
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

    // need to return in string version
    fun getDatesString(){
        var currDates = "Dates: "
        dates.keys.forEach{
            currDates += "${it}, "
        }
        println(currDates.removeRange(currDates.length - 2, currDates.length))
    }

    fun getActivities(date: String): MutableList<String>? {
        if (!::dates.isInitialized){
            return mutableListOf()
        }
        return dates[date]?.activities
    }

    // able to add activity name and comment about that activity
    fun addActivity() {
        if (!::dates.isInitialized){
            activities = mutableListOf()
            comments = mutableMapOf()
        }
        print("What is the activity name? ")
        val actName = readln().lowercase(Locale.getDefault())
        activities.add(actName)
        print("What is your comment for the activity? ")
        val actComment = readln().lowercase(Locale.getDefault())
        comments[actName] = actComment
    }

    // remove the activity and comments connected to it
    fun removeActivity() {
        if (::activities.isInitialized){
            val actName = findActivityName().lowercase(Locale.getDefault())
            activities.remove(actName)
            comments.remove(actName)
            println("$actName removed!")
        }
        else{
            println("No activities Available!")
        }
    }


    // access the map to get the comment
    fun readComment() {
        if (::comments.isInitialized){
            if (comments.isNotEmpty()){
                val actName = findActivityName().lowercase(Locale.getDefault())
                println("Comment for ${actName}: " + comments[actName])
            }
            else{
                println("No activities available!")
            }
        }
        else{
            println("No activities available to read comments from!")
        }
    }

    // more of a helper function of finding the name of the activity
    private fun findActivityName(): String{
        print("What is the name of the activity? ")
        var actName = readln().lowercase(Locale.getDefault())
        while (!activities.contains(actName)){
            print("Wrong name! What is the name of the activity? ")
            actName = readln().lowercase(Locale.getDefault())
        }
        return actName
    }

}