import java.util.*

class Person(private val nameFirst : String?, private val nameLast : String?, private val userName : Int?) {
    // maybe add a getter and setter later since it is all private
    private val firstName: String? = nameFirst
    private val lastInitial: String? = nameLast
    private val age : Int? = null
    // lateinit under the hood gives the variables a null later to be initialized
    private lateinit var activities : MutableList<String>
    // the key is the index num. of activity in activity and value is comment
    private lateinit var comments : MutableMap<String, String>

    fun intro_display(): String {
        return "Hello $firstName ${lastInitial}!"
    }

    fun first_last_name() : String {
        return "$nameFirst $nameLast"
    }


    fun display_info() {
        // way of returning the usual display for the user
        println("Activities:")
        val iterate = activities.listIterator()
        var numberOfAct = 1;
        if (!iterate.hasNext()){
            println("  No activities")
        }
        else{
            while (iterate.hasNext()){
                val currActivity = iterate.next()
                println("  ${numberOfAct}. $currActivity")
                numberOfAct++;
            }
        }
    }



    // able to add activity name and comment about that activity
    fun add_activity() {
        if (!::activities.isInitialized && !::comments.isInitialized){
            activities = mutableListOf<String>()
            comments = mutableMapOf<String, String>()
        }
        print("What is the activity name? ")
        val actName = readln().lowercase(Locale.getDefault())
        activities.add(actName)
        print("What is your comment for the activity? ")
        val actComment = readln().lowercase(Locale.getDefault())
        comments[actName] = actComment
    }

    // remove the activity and comments connected to it
    fun remove_activity() {
        if (::activities.isInitialized){
            val actName = find_activity_name().lowercase(Locale.getDefault())
            activities.remove(actName)
            comments.remove(actName)
            println("$actName removed!")
        }
        else{
            println("No activities Available!")
        }
    }


    // access the map to get the comment
    fun read_comment() {
        if (::comments.isInitialized){
            if (!comments.isEmpty()){
                val actName = find_activity_name().lowercase(Locale.getDefault())
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

    fun find_activity_name(): String{
        print("What is the name of the activity? ")
        var actName = readln().lowercase(Locale.getDefault())
        while (!activities.contains(actName)){
            print("Wrong name! What is the name of the activity? ")
            actName = readln().lowercase(Locale.getDefault())
        }
        return actName
    }

}