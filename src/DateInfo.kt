// new variable to keep track of the info needed for each day entry by user, activities and comments that correspond
class DateInfo(activity : String, comment : String) {

    // maybe later change the field variables to a lateinit to save space, but currently not a big deal

    // contain list of activities
    var activities : MutableList<String> = if (activity == ""){
        mutableListOf()
    } else{
        mutableListOf(activity)
    }

    // contain comments that correspond with the activities
    var comments : MutableMap<String, String> = if (comment == ""){
        mutableMapOf()
    } else{
        mutableMapOf(activity to comment)
    }

}