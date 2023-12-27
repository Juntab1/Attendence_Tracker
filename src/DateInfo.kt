// new variable to keep track of the info needed for each day entry by user, activities and comments that correspond
class DateInfo(activity : String, comment : String) {

    // maybe later change the field variables to a lateinit to save space, but currently not a big deal

    // contain list of activities
    lateinit var activities : MutableList<String>
    // contain comments that correspond with the activities
    lateinit var comments : MutableMap<String, String>

    init{
        if (activity == ""){
            activities = mutableListOf()
        }
        else{
            activities = mutableListOf(activity)
        }
        if (comment == ""){
            comments = mutableMapOf()
        }
        else{
            comments = mutableMapOf(activity to comment)
        }
    }


}