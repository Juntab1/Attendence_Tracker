class Person(private val nameFirst : String?, private val nameLast : String?, private val userName : Int?) {
    // maybe add a getter and setter later since it is all private
    private val firstName: String? = nameFirst
    private val lastInitial: String? = nameLast
    private val age : Int? = null
    // lateinit under the hood gives the variables a null later to be initialized
    private lateinit var activity : MutableList<String>
    // the key is the index num. of activity in activity and value is comment
    private lateinit var comments : MutableMap<String, String>

    fun intro_display(): String {
        return "Hello $firstName ${lastInitial}!"
    }

    fun first_last_name() : String {
        return "$nameFirst $nameLast"
    }


    fun display_info(): String {
        // way of returning the usual display for the user
        return ""
    }



    // able to add activity name and comment about that activity
    fun add_activity() {
        print("What is the activity name? ")
        val actName = readln()
        activity.add(actName)
        print("What is your comment for the activity? ")
        val actComment = readln()
        comments[actName] = actComment
    }

    // remove the activity and comments connected to it
    fun remove_activity() {
        val actName = find_activity_name()
        activity.remove(actName)
        comments.remove(actName)
    }


    // access the map to get the comment
    fun read_comment(): String? {
        val actName = find_activity_name()
        return comments[actName]
    }

    fun find_activity_name(): String{
        print("What is the name of the activity? ")
        var actName = readln()
        while (!activity.contains(actName)){
            print("Wrong name! What is the name of the activity? ")
            actName = readln()
        }
        return actName
    }



}