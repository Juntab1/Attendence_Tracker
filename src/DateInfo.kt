class DateInfo(activity : String, comment : String) {
    // maybe later change the field variables to a lateinit to save space, but currently not a big deal

    // contain list of activities
    var activities : MutableList<String> = mutableListOf(activity)
    // contain comments that correspond with the activities
    var comments : MutableMap<String, String> = mutableMapOf(activity to comment)

}