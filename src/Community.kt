class Community {
    private lateinit var nameList : MutableList<Person>

    // set called "add"
    fun add(name : Person) {
        if (!::nameList.isInitialized){
            nameList = mutableListOf<Person>()
        }

        nameList.add(name)
    }

    // get
    fun get() : MutableList<Person> {
        return nameList
    }

    // need to return in string version
    fun to_string() : String {
        var names : String = "Names: "
        nameList.forEach(){
            names += "$it,"
        }
        return names
    }
}