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

    // maybe at some point can merge this function into another
    public fun introDisplay(): String {
        return "Hello $firstName ${lastInitial}!"
    }

    public fun fullNameDisplay() : String {
        return "$nameFirst $nameLast"
    }


    public fun displayInfo() {
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
    public fun addActivity() {
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
    public fun removeActivity() {
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
    public fun readComment() {
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