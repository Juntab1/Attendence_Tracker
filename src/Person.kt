class Person(private val nameFirst : String?, private val nameLast : String?, private val userName : Int?) {
    // maybe add a getter and setter later since it is all private
    private val firstName: String? = nameFirst
    private val lastInitial: String? = nameLast
    private val age : Int? = null
    // lateinit under the hood gives the variables a null later to be initialized
    private lateinit var activity : MutableList<String>
    // the key is the index num. of activity in activity and value is comment
    private lateinit var comments : MutableMap<String, String>


    // able to add activity name and comment about that activity
    fun add_activity(activityName : String, comment : String?) {
        activity.add(activityName)
        if (comment != null){
            comments[activityName] = comment
        }

    }

    // remove the activity and comments connected to it
    fun remove_activity(activityName: String) {
        activity.remove(activityName)
        comments.remove(activityName)
    }

    fun read_comment() {
        // access the map to get the comment
    }


}