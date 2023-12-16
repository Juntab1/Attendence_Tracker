class Person(private val nameFirst : String?, private val nameLast : String?, private val userName : Int?) {
    // maybe add a getter and setter later since it is all private
    private val firstName: String? = nameFirst
    private val lastInitial: String? = nameLast
    private val age : Int? = null
    // lateinit under the hood gives the variables a null later to be initialized
    private lateinit var activity : MutableList<String>
    // the key is the index num. of activity in activity and value is comment
    private lateinit var comments : Map<Int, String>

    fun add_activity(activityName : String) {
        // able to add activity name
        activity.add(activityName)
        // able to add comment about that activity
    }

    fun remove_activity() {
        // remove the activity and comments connected to it
    }

    fun read_comment() {
        // access the map to get the comment
    }


}